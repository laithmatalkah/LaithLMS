package com.gcit.laithproject.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.gcit.laithproject.domain.Branch;


public class BranchDAO extends BaseDAO implements ResultSetExtractor<List<Branch>>{

	@Autowired
	BookDAO bdao;
		public void insertBranch(Branch branch) throws ClassNotFoundException, SQLException{
			template.update("insert into tbl_library_branch (branchName,branchAddress) values (?,?)", new Object[] {branch.getBranchName(),branch.getBranchAddress()});
		}
		
		public void deleteBranch(Branch branch) throws ClassNotFoundException, SQLException{
			template.update("delete from tbl_library_branch where branchId=?", new Object[] {branch.getBranchId()});
		}
		
		public void deleteAll() throws ClassNotFoundException, SQLException{
			template.update("delete * from tbl_library_branch",this);
		}
		
		public void updateBranch(Branch branch) throws ClassNotFoundException, SQLException{
			template.update("update  tbl_library_branch set branchName = ?,branchAddress = ? where branchId = ?", new Object[] 
					{branch.getBranchName(),branch.getBranchAddress(),branch.getBranchId()});
		}
		
		
		public List<Branch> readAll() throws ClassNotFoundException, SQLException{
			return template.query("select * from tbl_library_branch", this);
		}
		
		public Branch readOne(Branch branch) throws ClassNotFoundException, SQLException{
			List <Branch> branches=template.query("select * from tbl_library_branch where branchId = ?", new Object[] {branch.getBranchId()},this);
			for(Branch br: branches){
				return br;
			}
			return null;
		}

		@Override
		public List<Branch> extractData(ResultSet rs) throws SQLException {
			List<Branch> branches = new ArrayList<Branch>();
			while(rs.next()){
				Branch br = new Branch();
				br.setBranchId(rs.getInt("branchId"));
				br.setBranchName(rs.getString("branchName"));
				br.setBranchAddress(rs.getString("branchAddress"));
				br.setBooks( bdao.template.query("select * from tbl_book where bookId IN(select bookId from tbl_book_copies where branchId = ?)", new Object[]{br.getBranchId()},bdao));
				branches.add(br);
			}
			return branches;
		}

	}
