package com.gcit.laithproject.dao;



import java.sql.SQLException;
import com.gcit.laithproject.domain.Author;
import com.gcit.laithproject.domain.Book;




public class AuthorBookDAO extends BaseDAO {

	
	public void insertBookAuthor(Book book) throws ClassNotFoundException, SQLException{
		for (Author author : book.getAuthors()) {
			 template.update("insert into tbl_book_authors (bookId,authorId) values (?,?)", new Object[] {book.getBookId(),author.getAuthorId()});
		}		
	}
	
	public void deleteBookAuthor(Book book) throws ClassNotFoundException, SQLException{
		template.update("delete from tbl_book_authors where bookId=?", new Object[] {book.getBookId()});
	}
	
	
	
	
}
