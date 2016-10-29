package com.gcit.laithproject.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.ResultSetExtractor;
import com.gcit.laithproject.domain.Book;
import com.gcit.laithproject.domain.Genre;




public class GenreBookDAO extends BaseDAO implements ResultSetExtractor<List<?>>{

	
	public void insertBookGenre(Book book) throws ClassNotFoundException, SQLException{
		for (Genre genre : book.getGenres()) {
			template.update("insert into tbl_book_genres (bookId,genre_id) values (?,?)", new Object[] {book.getBookId(), genre.getGenreId()});
		}
		
	}
	public void deleteBookGenre(Book book) throws ClassNotFoundException, SQLException{
		template.update("delete from tbl_book_genres  where bookId=?", new Object[] {book.getBookId()});
	}
	
	
	

	@Override
	public List<?> extractData(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
