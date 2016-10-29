package com.gcit.laithproject.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.ResultSetExtractor;
import com.gcit.laithproject.domain.Book;
import com.gcit.laithproject.domain.Genre;

public class GenreDAO extends BaseDAO implements ResultSetExtractor<List<Genre>>{

	public void insertGenre(Genre genre) throws ClassNotFoundException, SQLException{
		template.update("insert into tbl_genre (genre_name) values (?)", new Object[] {genre.getGenreName()});
	}
	
	public void deleteGenre(Genre genre) throws ClassNotFoundException, SQLException{
		template.update("delete from tbl_genre where genre_Id=?", new Object[] {genre.getGenreId()});
	}
	
	public void deleteAll() throws ClassNotFoundException, SQLException{
		template.update("delete * from tbl_genre", this);
	}
	
	public void updateGenre(Genre genre) throws ClassNotFoundException, SQLException{
		template.update("update  tbl_genre set genre_name = ? where genre_Id = ?", new Object[] {genre.getGenreName(),genre.getGenreId()});
	}
	
	public Genre readOne(Genre genre) throws ClassNotFoundException, SQLException{
		List <Genre> genres=template.query("select * from tbl_genre where genre_Id = ?", new Object[] {genre.getGenreId()},this);
		for(Genre g: genres){
			return g;
		}
		return null;
	}
	public List<Genre> readAll() throws ClassNotFoundException, SQLException{
		return template.query("select * from tbl_genre", this);
	}
	
	public List<Genre> getBookGenre(Book book) throws ClassNotFoundException, SQLException{
		return template.query("select * from tbl_genre where genre_id IN (select genre_id from tbl_book_genres where bookId=?)", new Object[] {book.getBookId()},this);
	}
	@Override
	public List<Genre> extractData(ResultSet rs) throws SQLException {
		List<Genre> genres = new ArrayList<Genre>();
		while(rs.next()){
			Genre g = new Genre();
			g.setGenreId(rs.getInt("genre_Id"));
			g.setGenreName(rs.getString("genre_name"));
			genres.add(g);
		}
		return genres;
	}

}
