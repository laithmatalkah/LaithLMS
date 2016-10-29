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

import com.gcit.laithproject.dao.AuthorBookDAO;
import com.gcit.laithproject.dao.AuthorDAO;
import com.gcit.laithproject.dao.BookDAO;
import com.gcit.laithproject.dao.BorrowerDAO;
import com.gcit.laithproject.dao.BranchDAO;
import com.gcit.laithproject.dao.GenreBookDAO;
import com.gcit.laithproject.dao.GenreDAO;
import com.gcit.laithproject.dao.PublisherDAO;
import com.gcit.laithproject.domain.Author;
import com.gcit.laithproject.domain.Book;
import com.gcit.laithproject.domain.Borrower;
import com.gcit.laithproject.domain.Branch;
import com.gcit.laithproject.domain.Genre;
import com.gcit.laithproject.domain.Publisher;


/**
 * Handles requests for the application administrator page.
 */
@RestController
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	
	@Autowired
	AuthorDAO adao;
	
	@Autowired
	AuthorBookDAO abdao;
	
	@Autowired
	BookDAO bdao;

	@Autowired
	PublisherDAO pdao;
	
	@Autowired
	BranchDAO brdao;
	
	@Autowired
	GenreDAO gdao;
	
	@Autowired
	BorrowerDAO borrodao;
	
	@Autowired
	GenreBookDAO gbdao;
	
	
	
	@RequestMapping(value = "/viewAuthors",method = {RequestMethod.GET,RequestMethod.POST}, produces="application/json")
	public List<Author> viewAuthors() throws ClassNotFoundException, SQLException{
		return adao.readAll();
	}
	
	@RequestMapping(value = "/viewPublishers",method = {RequestMethod.GET,RequestMethod.POST}, produces="application/json")
	public List<Publisher> viewPublishers() throws ClassNotFoundException, SQLException {
		
		return pdao.readAll(1);
		
	}
	
	@RequestMapping(value = "/viewGenres",method = {RequestMethod.GET,RequestMethod.POST}, produces="application/json")
	public List<Genre> viewGenres() throws ClassNotFoundException, SQLException {
		return gdao.readAll();
		
	}
	
	@RequestMapping(value = "/viewBranches",method = {RequestMethod.GET,RequestMethod.POST}, produces="application/json")
	public List<Branch> viewBranches() throws ClassNotFoundException, SQLException {
		
		return brdao.readAll();
	}
	
	@RequestMapping(value = "/viewBooks",method = {RequestMethod.GET,RequestMethod.POST}, produces="application/json")
	public List<Book> viewBooks() throws ClassNotFoundException, SQLException {
		return bdao.readAll();
	}
	
	
	@RequestMapping(value = "/viewBorrowers",method = {RequestMethod.GET,RequestMethod.POST}, produces="application/json")
	public List<Borrower> viewBorrowers() throws ClassNotFoundException, SQLException {
		return borrodao.readAll();
	}
	
	@RequestMapping(value = "/addAuthor", method = RequestMethod.POST, consumes="application/json")
	public String addAuthor(@RequestBody Author author) throws ClassNotFoundException, SQLException {
		adao.insertAuthor(author);
		return "Author Added sucessfully";
	}

	@RequestMapping(value = "/editAuthor", method = RequestMethod.PUT, consumes="application/json")
	public Author updateAuthor(@RequestBody Author author) throws ClassNotFoundException, SQLException {
		adao.updateAuthor(author);
		return adao.readOne(author);
	}
	
//	@RequestMapping(value = "/authorEdited", method = RequestMethod.POST)
//	public String authorEdited(@RequestParam("authorId") Integer authorId,@RequestParam("authorName") String authorName ,Model model) throws ClassNotFoundException, SQLException {
//	Author author=new Author();
//	author.setAuthorId(authorId);
//	author.setAuthorName(authorName);
//	admService.editAuthor(author);
//	String message="Author Edited Successfully";
//	model.addAttribute("message",message);
//	model.addAttribute("admService", admService);
//	return "authors";
//}
	
	@RequestMapping(value = "/delAuthor", method = RequestMethod.PUT, consumes="application/json")
	public String delAuthor(@RequestBody Author author) throws ClassNotFoundException, SQLException {
		adao.deleteAuthor(author);
		return "Author deleted sucessfully";
	}
	
	@RequestMapping(value = "/addBorrower", method = RequestMethod.POST, consumes="application/json")
	public String addBorrower(@RequestBody Borrower borrower) throws ClassNotFoundException, SQLException {
		borrodao.insertBorrower(borrower);
		return "Borrower Added sucessfully";
	}
	@RequestMapping(value = "/editborrower", method = RequestMethod.PUT, consumes="application/json")
	public Borrower updateBorrower(@RequestBody Borrower borrower) throws ClassNotFoundException, SQLException {
borrodao.updateBorrower(borrower);
return borrodao.readOne(borrower);
	}
	
//	@RequestMapping(value = "/borrowerEdited", method = RequestMethod.POST)
//	public String borrowerEdited(@RequestParam("cardNo") Integer cardNo,@RequestParam("borroName") String borroName ,
//			@RequestParam("borroAddress") String borroAddress ,@RequestParam("borroPhone") String borroPhone ,
//			Model model) throws ClassNotFoundException, SQLException {
//		Borrower br=new Borrower();
//		br.setCardNo(cardNo);
//		br.setBorroName(borroName);
//		br.setBorroAddress(borroAddress);
//		br.setBorroPhone(borroPhone);
//		admService.editBorrower(br);
//		String message="Borrower Edited Successfully";
//		model.addAttribute("message",message);
//		model.addAttribute("admService", admService);
//		return "borrowers";
//	}
	
	@RequestMapping(value = "/delBorrower", method = RequestMethod.PUT, consumes="application/json")
	public String delBorrower(@RequestBody Borrower borrower) throws ClassNotFoundException, SQLException {
		borrodao.deleteBorrower(borrower);
		return "Borrower deleted sucessfully";
	}
	@RequestMapping(value = "/addBranch", method = RequestMethod.POST, consumes="application/json")
	public String addBranch(@RequestBody Branch branch) throws ClassNotFoundException, SQLException {
		brdao.insertBranch(branch);
		return "Branch Added sucessfully";
	}
	@RequestMapping(value = "/editbranch", method = RequestMethod.PUT, consumes="application/json")
	public Branch updateBranch(@RequestBody Branch branch) throws ClassNotFoundException, SQLException {
		brdao.updateBranch(branch);
return  brdao.readOne(branch);
	}
	
//	@RequestMapping(value = "/branchEdited", method = RequestMethod.POST)
//	public String branchEdited(@RequestParam("branchId") Integer branchId,@RequestParam("branchName") String branchName ,
//			@RequestParam("branchAddress") String branchAddress ,
//			Model model) throws ClassNotFoundException, SQLException {
//		Branch branch=new Branch();
//		branch.setBranchId(branchId);
//		branch.setBranchName(branchName);
//		branch.setBranchAddress(branchAddress);
//		admService.editBranch(branch);
//		String message="Branch Edited Successfully";
//		model.addAttribute("message",message);
//		model.addAttribute("admService", admService);
//		return "branches";
//	}
	
	@RequestMapping(value = "/delBranch", method = RequestMethod.PUT, consumes="application/json")
	public String delBranch(@RequestBody Branch branch) throws ClassNotFoundException, SQLException {
		brdao.deleteBranch(branch);
		return "Branch deleted sucessfully";
	}
	
	
	@RequestMapping(value = "/addGenre", method = RequestMethod.POST,consumes="application/json")
	public String addGenre(@RequestBody Genre genre)throws ClassNotFoundException, SQLException {
	gdao.insertGenre(genre);
	return "Genre added sucessfully";
	}
	@RequestMapping(value = "/editgenre",  method = RequestMethod.PUT,consumes="application/json")
	public Genre updateGenre(@RequestBody Genre genre)throws ClassNotFoundException, SQLException {
		gdao.updateGenre(genre);
		return gdao.readOne(genre);
		}
	
//	@RequestMapping(value = "/genreEdited", method = RequestMethod.POST)
//	public String genreEdited(@RequestParam("genreId") Integer genreId,@RequestParam("genreName") String genreName,
//			Model model) throws ClassNotFoundException, SQLException {
//		Genre genre=new Genre();
//		genre.setGenreId(genreId);
//		genre.setGenreName(genreName);
//		
//		String message="Genre Edited Successfully";
//		model.addAttribute("message",message);
//	
//		return "genres";
//	}
	
	@RequestMapping(value = "/delGenre", method = RequestMethod.PUT, consumes="application/json")
	public String delGenre(@RequestBody Genre genre) throws ClassNotFoundException, SQLException {
		gdao.deleteGenre(genre);
		return "Genre deleted sucessfully";
	}
	
	@RequestMapping(value = "/addPublisher", method = RequestMethod.POST,consumes="application/json")
	public String addPublisher(@RequestBody Publisher publisher)throws ClassNotFoundException, SQLException {
		pdao.insertPublisher(publisher);
		return "Publisher added sucessfully";
	}
	
	@RequestMapping(value = "/editPublisher",  method = RequestMethod.PUT,consumes="application/json")
	public Publisher updatePublisher(@RequestBody Publisher publisher)throws ClassNotFoundException, SQLException {
		pdao.updatePublisher(publisher);
		return pdao.readOne(publisher);
		}
	
//	@RequestMapping(value = "/publisherEdited", method = RequestMethod.POST)
//	public String publisherEdited(@RequestParam("publisherId") Integer publisherId,@RequestParam("publisherName") String publisherName,
//			@RequestParam("publisherAddress") String publisherAddress,@RequestParam("publisherPhone") String publisherPhone,Model model) throws ClassNotFoundException, SQLException {
//		Publisher publisher=new Publisher();
//		publisher.setPublisherId(publisherId);
//		publisher.setPublisherName(publisherName);
//		publisher.setPublisherAddress(publisherAddress);
//		publisher.setPublisherPhone(publisherPhone);
//		
//		String message="Publisher Updated Successfully";
//		model.addAttribute("message",message);
//	
//		return "publishers";
//	}
	
	@RequestMapping(value = "/delPublisher", method = RequestMethod.PUT, consumes="application/json")
	public String delPublisher(@RequestBody Publisher publisher) throws ClassNotFoundException, SQLException {
		pdao.deletePublisher(publisher);
		return "Publisher deleted sucessfully";
	}
	
	@RequestMapping(value = "/addBooks", method = RequestMethod.POST)
	public String addBook(@RequestBody Book book) throws ClassNotFoundException, SQLException {
		 Integer bookId= bdao.insertBook(book);
		 book.setBookId(bookId);
			for (Author a : book.getAuthors()) {
					abdao.insertBookAuthor(book);
				}
					for (Genre g : book.getGenres()) {
							gbdao.insertBookGenre(book);
						}
return "Book Added Successfully";
	}
		
	
	@RequestMapping(value = "/editbook", method = RequestMethod.PUT,consumes="application/json")
	public Book editBook(@RequestBody Book book) throws ClassNotFoundException, SQLException {
		book.setTitle(book.getTitle());
		book.setBookId(book.getBookId());
	
		Publisher publisher=new Publisher();
		
		List<Author> authorList = new ArrayList<>();
		List<Genre> genreList = new ArrayList<>();
		book.setPublisher(book.getPublisher());		
		for (Genre g : book.getGenres()) {
			Genre genre = new Genre();
			genre.setGenreId(g.getGenreId());
			genreList.add(genre);
		}
		
		for (Author a : book.getAuthors()) {
			Author author = new Author();
			author.setAuthorId(a.getAuthorId());
			authorList.add(author);
		}
		book.setTitle(book.getTitle());
		book.setAuthors(authorList);
		book.setGenres(genreList);
		book.setPublisher(publisher);
		bdao.updateBook(book);
		abdao.deleteBookAuthor(book);
		abdao.insertBookAuthor(book);
		gbdao.deleteBookGenre(book);
		gbdao.insertBookGenre(book);
		return bdao.readOne(book);
	}
	
//	@RequestMapping(value = "/bookEdited", method = RequestMethod.POST)
//	public String bookEdited(@RequestParam("bookId") Integer bookId,@RequestParam("bookTitle") String bookTitle,
//			@RequestParam("selectPublisher") Integer selectPublisher,@RequestParam("selectAuthors")String[] selectAuthors,
//			@RequestParam("selectGenre") String[] selectGenre,Model model) throws ClassNotFoundException, SQLException {
//		Publisher publisher=new Publisher();
//		Book book=new Book();
//		List<Author> authorList = new ArrayList<>();
//		List<Genre> genreList = new ArrayList<>();
//		book.setTitle(bookTitle);
//		book.setBookId(bookId);
//		
//		publisher.setPublisherId(selectPublisher);		
//		for (String g : selectGenre) {
//			Genre genre = new Genre();
//			genre.setGenreId(Integer.parseInt(g));
//			genreList.add(genre);
//		}
//		
//		for (String a : selectAuthors) {
//			Author author = new Author();
//			author.setAuthorId(Integer.parseInt(a));
//			authorList.add(author);
//		}
//		book.setAuthors(authorList);
//		book.setGenres(genreList);
//		book.setPublisher(publisher);
//		
//		String message="Book Updated Successfully";
//		model.addAttribute("message",message);
//	
//		return "books";
//	}
	
	@RequestMapping(value = "/delBook", method = RequestMethod.PUT,consumes="application/json")
	public String delBook(@RequestBody Book book) throws ClassNotFoundException, SQLException {
		bdao.deleteBook(book);
		
		return "Book Deleted Successfully";
	}
}
