package com.gcit.laithproject;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gcit.laithproject.dao.CopiesDAO;
import com.gcit.laithproject.dao.GenreBookDAO;
import com.gcit.laithproject.domain.Book;
import com.gcit.laithproject.domain.Branch;
import com.gcit.laithproject.domain.Copies;



/**
 * Handles requests for the application home page.
 * 
 * 
 */


@RestController
public class LibrarianController {
	
	private static final Logger logger = LoggerFactory.getLogger(LibrarianController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@Autowired
	CopiesDAO cpdao;
	
	@RequestMapping(value = "/librarian", method = RequestMethod.GET)
	public String libPage(Locale locale, Model model) {
		return "librarian";
	}
	
	@RequestMapping(value = "/copies", method = RequestMethod.GET,produces="application/json")
	public List<Copies> copiesPage() throws ClassNotFoundException, SQLException {
		
	
		return cpdao.getAllCopies();
	}
	
	@RequestMapping(value = "/AddOneBook", method = RequestMethod.POST,consumes="application/json")
	public String addBooks(@RequestBody Branch branch) throws ClassNotFoundException, SQLException {
		branch.setBranchId(branch.getBranchId());
		cpdao.insertCopies(branch);
		return "Book ";
	}
	@RequestMapping(value = "/editcopies", method = RequestMethod.PUT,consumes="application/json")
	public Copies editcopies(@RequestBody Copies copies) throws ClassNotFoundException, SQLException {
		
		cpdao.updateCopies(copies);
		return cpdao.getOneCopyNum(copies);
	}
//	@RequestMapping(value = "/copiesEdited", method = RequestMethod.POST)
//	public String addBooks(@RequestParam("branchId") Integer selectBranch,@RequestParam("numOfCopies") Integer numOfCopies,
//			@RequestParam("bookId") Integer bookId,Model model) throws ClassNotFoundException, SQLException {
//	Copies cp = new Copies();
//	
//	cp.setBookId(bookId);
//	cp.setBranchId(selectBranch);
//	cp.setNoOfcopies(numOfCopies);
	
//	String message="Copies Updated Successfully";
//	System.out.println("from copies Edited"+selectBranch);
//	model.addAttribute("message",message);
//	
//	model.addAttribute("selectBranch", selectBranch);
//	model.addAttribute("numOfCopies", numOfCopies);
//	model.addAttribute("bookId", bookId);
//	
//		return "copies";
//	}
	
	@RequestMapping(value = "/removeBook",  method = RequestMethod.PUT,consumes="application/json")
	public String addBooks(@RequestBody Copies copies) throws ClassNotFoundException, SQLException {
	cpdao.removeCopies(copies);
		return "copies removed";
	}
}
