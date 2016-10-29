package com.gcit.laithproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.gcit.laithproject.domain.Author;
import com.gcit.laithproject.domain.Book;
import com.gcit.laithproject.domain.Branch;
import com.gcit.laithproject.domain.Publisher;

public class BookDAO extends BaseDAO implements ResultSetExtractor<List<Book>> {

	//	public Integer insertBook(Book book) {
	//		return template.update("insert into tbl_book (title, pubId) values (?,?)",
	//				new Object[] { book.getTitle(), book.getPublisher().getPublisherId() });
	//	}
	
	@Autowired
	PublisherDAO pdao;
	
	@Autowired
	AuthorDAO adao;
	
	@Autowired
	GenreDAO gdao;
	

	public Integer insertBook(Book book) {
		KeyHolder keyHolder = new GeneratedKeyHolder();

		template.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement statement = null;

				if(book.getPublisher() != null) {
					statement = con.prepareStatement("insert into tbl_book (title, pubId) values (?,?)", new String[] {"id"} );
					statement.setInt(2, book.getPublisher().getPublisherId());
				}
				else {
					statement = con.prepareStatement("insert into tbl_book (title) values (?)", new String[] {"id"} );
				}
				statement.setString(1, book.getTitle());

				return statement;
			}
		}, keyHolder);

		return keyHolder.getKey().intValue();
	}

	public Integer updateBookPublisher(Book book) {

		return template.update("update  tbl_book set pubId=?", new Object[] { book.getPublisher().getPublisherId() });
	}

	public List<Book> readAll() throws ClassNotFoundException, SQLException {
		return template.query("select * from tbl_Book", this);
	}

	public List<Book> readBookCopies(Branch branch) throws ClassNotFoundException, SQLException {
		return template.query(
				"select * from tbl_book where bookId in (select bookId from tbl_book_copies where branchId=?)",
				new Object[] { branch.getBranchId()}, this);
	}

	public void deleteBook(Book book) throws ClassNotFoundException, SQLException {
		template.update("delete from tbl_book where bookId=?", new Object[] { book.getBookId() });
	}

	public List<Book> getBookByTitle(String title) throws ClassNotFoundException, SQLException {
		return template
				.query("select * from tbl_book,tbl_library_branch where bookId in (select bookId from tbl_book_copies) and title like '%"
						+ title + "%'", this);
	}

	public Book readOne(Book book) throws ClassNotFoundException, SQLException {
		List<Book> books = template.query("select * from tbl_book where bookId =?", new Object[] { book.getBookId() },
				this);
		for (Book b : books) {
			return b;
		}
		return null;
	}

	public Integer getCount() throws ClassNotFoundException, SQLException {
		return template.queryForObject("select count(*) as count from tbl_book", Integer.class);
	}

	public void updateBook(Book book) throws ClassNotFoundException, SQLException {
		template.update("update  tbl_book set title = ? where bookId = ?",
				new Object[] { book.getTitle(), book.getBookId() });
	}

	@Override
	public List<Book> extractData(ResultSet rs) throws SQLException {
		List<Book> books = new ArrayList<Book>();
		while(rs.next()){
			Book b = new Book();
			b.setBookId(rs.getInt("bookId"));
			b.setTitle(rs.getString("title"));
			List<Publisher> publishers =template.query("select * from tbl_publisher where publisherId = ?", pdao, new Object[]{ rs.getInt("pubId")});
			if(!publishers.isEmpty()) {
		b.setPublisher(publishers.get(0));
		}
			b.setAuthors( adao.template.query("select * from tbl_author where authorId IN(select authorId from tbl_book_authors where bookId = ?)", new Object[]{b.getBookId()},adao));
			b.setGenres( gdao.template.query("select * from tbl_genre where genre_id IN(select genre_id from tbl_book_genres where bookId = ?)", new Object[]{b.getBookId()},gdao));
			books.add(b);
		}
		
		return books;
	}
}
