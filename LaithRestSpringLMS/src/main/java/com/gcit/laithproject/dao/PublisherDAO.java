package com.gcit.laithproject.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.gcit.laithproject.domain.Book;
import com.gcit.laithproject.domain.Publisher;
public class PublisherDAO extends BaseDAO implements ResultSetExtractor<List<Publisher>>{

	public void insertPublisher(Publisher publisher) throws ClassNotFoundException, SQLException{
		template.update("insert into tbl_publisher (publisherName,publisherAddress,publisherPhone) values (?,?,?)", new Object[] {publisher.getPublisherName(),publisher.getPublisherAddress(),publisher.getPublisherPhone()});
	}
	
	public void deletePublisher(Publisher publisher) throws ClassNotFoundException, SQLException{
		template.update("delete from tbl_publisher where publisherId=?", new Object[] {publisher.getPublisherId()});
	}
	
	public void deleteAll() throws ClassNotFoundException, SQLException{
		template.update("delete * from tbl_publisher", this);
	}
	
	public void updatePublisher(Publisher publisher) throws ClassNotFoundException, SQLException{
		template.update("update  tbl_publisher set publisherName = ?,publisherAddress = ?,publisherPhone= ? where publisherId = ?", new Object[] {publisher.getPublisherName(),
				publisher.getPublisherAddress(),publisher.getPublisherPhone(),publisher.getPublisherId()});
	}
	
	public Publisher readOne(Publisher publisher) throws ClassNotFoundException, SQLException{
		List<Publisher> publishers = template.query("select * from tbl_publisher where publisherId =?", new Object[] {publisher.getPublisherId()},this);
		for(Publisher p: publishers){
			return p;
		}
		return null;
	}
	
	public Publisher readPubBook(Book book) throws ClassNotFoundException, SQLException{
		List<Publisher> publishers = template.query("select publisherName from tbl_publisher where publisherId IN (select pubId from tbl_book where bookId=?)", 
				new Object[] {book.getBookId()},this);
		for(Publisher p: publishers){
			return p;
		}
		return null;
	}
	public Integer getCount() throws ClassNotFoundException, SQLException{
		return template.queryForObject("select count(*) as count from tbl_publisher", Integer.class);
	}
	
	public List<Publisher> readAll(int pageNo) throws ClassNotFoundException, SQLException{
		setPageNo(pageNo);
		return template.query("select * from tbl_publisher", this);
	}

	@Override
	public List<Publisher> extractData(ResultSet rs) throws SQLException {
		List<Publisher> publishers = new ArrayList<Publisher>();
		while(rs.next()){
			Publisher p = new Publisher();
			p.setPublisherId(rs.getInt("PublisherId"));
			p.setPublisherName(rs.getString("PublisherName"));
			p.setPublisherAddress(rs.getString("publisherAddress"));
			p.setPublisherPhone(rs.getString("publisherPhone"));
			publishers.add(p);
		}
		return publishers;
	}
}
