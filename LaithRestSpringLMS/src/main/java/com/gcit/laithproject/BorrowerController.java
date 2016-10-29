package com.gcit.laithproject;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.junit.runners.model.FrameworkMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gcit.laithproject.domain.Book;
import com.gcit.laithproject.domain.Borrower;
import com.gcit.laithproject.domain.Branch;
import com.gcit.laithproject.domain.Copies;



/**
 * Handles requests for the application home page.
 * 
 * 
 */


@Controller
public class BorrowerController {
	
	private static final Logger logger = LoggerFactory.getLogger(BorrowerController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	
	
	@RequestMapping(value = "/booksearch", method = RequestMethod.POST)
	public String libPage(@RequestParam("cardNumber") Integer cardNumber, Model model) throws ClassNotFoundException, SQLException {
		Borrower borrower= new Borrower();
		if(borrower==null){
			String message="Invalid card Number";
			model.addAttribute("message",message);
			return "borrowerlogin";
		}
		else {
			return "booksearch";
		}
	
	}
	
	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public String copiesPage(@RequestParam("bookId") Integer bookId, Model model) {
		model.addAttribute("bookId", bookId);
		
		return "checkout";
	}
	
//	@RequestMapping(value = "/AddOneBook", method = RequestMethod.POST)
//	public String addBooks(@RequestParam("selectBookCopies") String[] selectBookCopies,
//			@RequestParam("selectBranch") Integer selectBranch,Model model) throws ClassNotFoundException, SQLException {
//		
//		List<Book> bookList=new ArrayList<Book>();
//		for (String b : selectBookCopies) {
//			Book book = new Book();
//			book.setBookId(Integer.parseInt(b));
//			bookList.add(book);
//		}
//		Branch branch= new Branch();
//		branch.setBranchId(selectBranch);
//		branch.setBooks(bookList);
//		service2.addCopy(branch);
//		String message="Copies Added Successfully";
//		model.addAttribute("message",message);
//		model.addAttribute("service2", service2);
//		model.addAttribute("service", service);
//		model.addAttribute("selectBranch", selectBranch);
//		return "copies";
//	}
//	@RequestMapping(value = "/editcopies", method = RequestMethod.GET)
//	public String editcopies(@RequestParam("branchId") Integer selectBranch,
//			@RequestParam("bookId") Integer bookId,Model model) throws ClassNotFoundException, SQLException {
//		model.addAttribute("service2", service2);
//		model.addAttribute("service", service);
//		model.addAttribute("branchId", selectBranch);
//		model.addAttribute("bookId", bookId);
//		return "editcopies";
//	}
//	@RequestMapping(value = "/copiesEdited", method = RequestMethod.POST)
//	public String addBooks(@RequestParam("branchId") Integer selectBranch,@RequestParam("numOfCopies") Integer numOfCopies,
//			@RequestParam("bookId") Integer bookId,Model model) throws ClassNotFoundException, SQLException {
//	Copies cp = new Copies();
//	
//	cp.setBookId(bookId);
//	cp.setBranchId(selectBranch);
//	cp.setNoOfcopies(numOfCopies);
//	service2.editCopies(cp);
//	String message="Copies Updated Successfully";
//	System.out.println("from copies Edited"+selectBranch);
//	model.addAttribute("message",message);
//	model.addAttribute("service2", service2);
//	model.addAttribute("service", service);
//	model.addAttribute("selectBranch", selectBranch);
//	model.addAttribute("numOfCopies", numOfCopies);
//	model.addAttribute("bookId", bookId);
//	
//		return "copies";
//	}
//	
//	@RequestMapping(value = "/removeBook", method = RequestMethod.GET)
//	public String addBooks(@RequestParam("selectBranch") Integer selectBranch,
//		@RequestParam("bookId") Integer bookId,Model model) throws ClassNotFoundException, SQLException {
//	Copies cp = new Copies();
//	cp.setBookId(bookId);
//	cp.setBranchId(selectBranch);
//	service2.removeAllCopies(cp);
//	String message="Book Removed Successfully";
//	model.addAttribute("message",message);
//	model.addAttribute("service2", service2);
//	model.addAttribute("service", service);
//	model.addAttribute("selectBranch", selectBranch);
//	model.addAttribute("bookId", bookId);
//		return "copies";
//	}
}
