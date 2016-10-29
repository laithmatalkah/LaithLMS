package com.gcit.laithproject.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.ResultSetExtractor;
import com.gcit.laithproject.domain.Borrower;

public class BorrowerDAO extends BaseDAO implements ResultSetExtractor<List<Borrower>>{

	
		public void insertBorrower(Borrower borrower) throws ClassNotFoundException, SQLException{
			template.update("insert into tbl_borrower (cardNo,name,address,phone) values (?,?,?,?)", new Object[] 
		{borrower.getCardNo(),borrower.getBorroName(),borrower.getBorroAddress(),borrower.getBorroPhone()});
		}
		
		public void deleteBorrower(Borrower borrower) throws ClassNotFoundException, SQLException{
			template.update("delete from tbl_borrower where cardNo=?", new Object[] {borrower.getCardNo()});
		}
		
		public void deleteAll() throws ClassNotFoundException, SQLException{
			template.update("delete * from tbl_borrower", this);
		}
		public Borrower readOne(Borrower borrower) throws ClassNotFoundException, SQLException{
			List<Borrower> borrowers = template.query("select * from tbl_borrower where cardNo =?", 
					new Object[] {borrower.getCardNo()},this);
			for(Borrower br: borrowers){
				return br;
			}
			return null;
		}
		public void updateBorrower(Borrower borrower) throws ClassNotFoundException, SQLException{
			template.update("update  tbl_borrower set name = ?,address= ?,phone = ? where cardNo=?", new Object[] 
			{borrower.getBorroName(),borrower.getBorroAddress(),borrower.getBorroPhone(),borrower.getCardNo()});
		}
		
		public List<Borrower> readAll() throws ClassNotFoundException, SQLException{
			return template.query("select * from tbl_borrower", this);
		}
		
		public Borrower cardExists(Integer cardNum) throws ClassNotFoundException, SQLException{
			List<Borrower> borrowers =  template.query("select * from tbl_borrower where cardNo=?", new Object[]{cardNum},this);
			return borrowers.isEmpty() ? null : borrowers.get(0);
		}

		@Override
		public List<Borrower> extractData(ResultSet rs) throws SQLException {
			List<Borrower> borrowers = new ArrayList<Borrower>();
			while(rs.next()){
				Borrower br = new Borrower();
				br.setCardNo(rs.getInt("cardNo"));
				br.setBorroName(rs.getString("name"));
				br.setBorroAddress(rs.getString("address"));
				br.setBorroPhone(rs.getString("phone"));
				borrowers.add(br);
			}
			return borrowers;
		}

	
	}
