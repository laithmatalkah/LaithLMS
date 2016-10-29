package com.gcit.laithproject.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.ResultSetExtractor;
import com.gcit.laithproject.domain.Author;
import com.gcit.laithproject.domain.Book;
import com.gcit.laithproject.domain.Genre;

public class AuthorDAO extends BaseDAO implements ResultSetExtractor<List<Author>> {

	
	public void insertAuthor(Author author) throws ClassNotFoundException, SQLException{
		template.update("insert into tbl_author (authorName) values (?)", new Object[] {author.getAuthorName()});
	}
	
	public void deleteAuthor(Author author) throws ClassNotFoundException, SQLException{
		template.update("delete from tbl_author where authorId=?", new Object[] {author.getAuthorId()});
	}
	
	public void deleteAll() throws ClassNotFoundException, SQLException{
		template.update("delete * from tbl_author", this);
	}
	
	public Author readOne(Author author) throws ClassNotFoundException, SQLException{
		List<Author> authors = template.query("select * from tbl_author where authorId =?", new Object[] {author.getAuthorId()},this);
		for(Author a: authors){
			return a;
		}
		return null;
	}
	
	public void updateAuthor(Author author) throws ClassNotFoundException, SQLException{
		template.update("update  tbl_author set authorName = ? where authorId = ?", new Object[] {author.getAuthorName(), author.getAuthorId()});
	}
	
	
	public List<Author> readAll() throws ClassNotFoundException, SQLException{
		
		return template.query("select * from tbl_author", this);
	}
	public Integer getCount() throws ClassNotFoundException, SQLException{
		return template.queryForObject("select count(*) as count from tbl_author", Integer.class);
	}
	
	public List<Author> getBookAuthors(Book book) throws ClassNotFoundException, SQLException{
		return template.query("select * from tbl_author where authorId IN (select authorId from tbl_book_authors where bookId=?)", new Object[] {book.getBookId()},this);
	}

	@Override
	public List<Author> extractData(ResultSet rs) throws SQLException {
		List<Author> authors = new ArrayList<Author>();
		while(rs.next()){
			Author a = new Author();
			a.setAuthorId(rs.getInt("authorId"));
			a.setAuthorName(rs.getString("authorName"));
			authors.add(a);
		}
		return authors;
	}

	
}
