<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.gcit.laithproject.service.AdministrativeService"%>
<%@ page import="com.gcit.laithproject.domain.Book"%>
<%@ page import="com.gcit.laithproject.domain.Author"%>
<%@ page import="com.gcit.laithproject.domain.Publisher"%>
<%@ page import="com.gcit.laithproject.domain.Genre"%>
<%
	Integer bookId = Integer.parseInt(request.getParameter("bookId"));
AdministrativeService service = (AdministrativeService) request.getAttribute("admService");
	Book b = new Book();
	b.setBookId(bookId);
	b=service.viewBookID(b);
	List<Author> authors = new ArrayList<Author>();
	List<Author> bookAuthors = new ArrayList<Author>();
	List<Publisher> publishers = new ArrayList<Publisher>();
	List<Genre> genres = new ArrayList<Genre>();
	List<Genre> bookGenres = new ArrayList<Genre>();
	Publisher bookPublisher = new Publisher();
	authors = service.viewAuthors(1);
	publishers = service.viewPublishers(1);
	genres = service.viewGenres();
	b.setGenres(service.getBookGenres(b));
	b.setAuthors(service.getBookAuthors(b));
	bookAuthors = b.getAuthors();
	bookPublisher = b.getPublisher();
	bookGenres = b.getGenres();

%>
<!DOCTYPE html>
<h3 align="center">Edit Books details</h3>
<br />
<style>
form {
	margin-left: 1cm;
	margin-right: 1cm;
	margin-bottom: 2cm;
}
</style>
<form action="bookEdited" method="post">
	<Label><font size=4> Update Book Title: </font></Label>&nbsp; <input
		type="text" name="bookTitle" value='<%=b.getTitle()%>'><br />
	<input type="hidden" name="bookId" value=<%=b.getBookId()%>><br />
	<Label><font size=4> Update Author: </font></Label> <select multiple
		name="selectAuthors" class="form-control">
		<%
			for (Author a : authors) {
		%>
		<%
			if (bookAuthors.contains(a)) {
		%>
		<option value=<%=a.getAuthorId()%> selected><%=a.getAuthorName()%></option>
		<%
			} else {
		%>
		<option value=<%=a.getAuthorId()%>><%=a.getAuthorName()%></option>
		<%
			}
		%>
		<%
			}
		%>
		
	</select><br />
	
		<Label><font size=4> Update Publisher : </font></Label><br/> 
	 <select name="selectPublisher" class="form-control">
		<%
			for (Publisher p : publishers) {
		%>
		<%
			if (bookPublisher.getPublisherId() == p.getPublisherId()) {
		%>
		<option value=<%=p.getPublisherId()%> selected><%=p.getPublisherName()%></option>
		<%
			} else {
		%>
		<option value=<%=p.getPublisherId()%>><%=p.getPublisherName()%></option>
		<%
			}
		%>
		<%
			}
		%>
	</select><br /> 
			<Label><font size=4> Update Genre : </font></Label><br/> 
	<select multiple name="selectGenre" class="form-control">
		<%
			for (Genre g : genres) {
		%>
		<%
			if (bookGenres.contains(g)) {
		%>
		<option value=<%=g.getGenreId()%> selected ><%=g.getGenreName()%></option>
		<%
			} else {
		%>
		<option value=<%=g.getGenreId()%>><%=g.getGenreName()%></option>
		<%
			}
		%>
		<%
			}
		%>
	</select><br />
	<button type="submit" name="btn" value="bookEdited"
		class="btn btn-primary">Save</button>
	<button data-dismiss="modal" class="btn btn-default">Cancel</button>
</form>


<script>
	$(document).ready(function() {
		$('.modal').on('hidden.bs.modal', function(e) {
			$(this).removeData();
		});
	});
</script>