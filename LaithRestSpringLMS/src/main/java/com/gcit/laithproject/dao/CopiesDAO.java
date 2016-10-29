package com.gcit.laithproject.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.gcit.laithproject.domain.Book;
import com.gcit.laithproject.domain.Branch;
import com.gcit.laithproject.domain.Copies;


public class CopiesDAO extends BaseDAO implements ResultSetExtractor<List<Copies>>{

	
		public void insertCopies(Branch branch) throws ClassNotFoundException, SQLException{
			for(Book b:branch.getBooks())
			{
			template.update("insert into tbl_book_copies (bookId,branchId,noOfcopies) values (?,?,?)", new Object[] 
			{b.getBookId(),branch.getBranchId(),1});
			}
		}
		
		public Copies getBookCopies(Copies copies)throws ClassNotFoundException, SQLException{ 
			
			List<Copies> copiesList=  template.query("select * from tbl_book_copies where bookId= ? and branchId=?", 
					new Object[]{copies.getBookId(),copies.getBranchId()},this);
			for(Copies cp:copiesList){
				return cp;
			}
			return null;
			
		}
		
public List<Copies> getAllCopies()throws ClassNotFoundException, SQLException{ 
			
			return template.query("select * from tbl_book_copies",this);
			
		}
		
		public Copies getOneCopyNum(Copies copies)throws ClassNotFoundException, SQLException{ 
			return (Copies) template.query("select * from tbl_book_copies where bookId= ? and branchId=?",
					new Object[]{copies.getBookId(),copies.getBranchId()},this).get(0);
		}
		
		public void updateCopies(Copies copies) throws ClassNotFoundException, SQLException{
			template.update("update  tbl_book_copies set noOfCopies = ? where bookId = ? and branchId=?", 
					new Object[] {copies.getNoOfcopies(),copies.getBookId(),copies.getBranchId()});
			System.out.println("Copies DAO"+copies.getBranchId());
		}
		
		public void removeCopies(Copies copies) throws ClassNotFoundException, SQLException{
			template.update("delete from tbl_book_copies where bookId = ? and branchId=?", 
					new Object[] {copies.getBookId(),copies.getBranchId()});
		}
		@Override
		public List<Copies> extractData(ResultSet rs) throws SQLException {
			List<Copies> copies = new ArrayList<Copies>();
			while(rs.next()){
				Copies c = new Copies();
				c.setBookId(rs.getInt("bookId"));
				c.setBranchId(rs.getInt("branchId"));
				c.setNoOfcopies(rs.getInt("noOfcopies"));
				copies.add(c);
			}
			return copies;
		}

	}
