<%@ include file="include.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.gcit.laithproject.service.AdministrativeService" %>
    <%@ page import="com.gcit.laithproject.domain.Publisher"%>
    <%@ page import="com.gcit.laithproject.domain.Author"%>
    <%@ page import="com.gcit.laithproject.domain.Genre" %>
    <%@ page import="com.gcit.laithproject.domain.Book" %>
    <%AdministrativeService service = (AdministrativeService) request.getAttribute("admService");
    List<Author> authors = new ArrayList<Author>();
    List<Publisher> publishers = new ArrayList<Publisher>();
    List<Genre> genres = new ArrayList<Genre>();
    authors=service.viewAuthors(1);
    publishers=service.viewPublishers(1);
    genres=service.viewGenres();
    String publisher;
	Integer count = service.getBooksCount();
	Integer pageCount = 0;
	if(count!=null && count >0){
		int rem = count % 10;
		if(rem == 0){
			pageCount = count/10;
		}else{
			pageCount = count/10+1;
		}
	}
	List<Book> books = new ArrayList<Book>();
	if(request.getAttribute("books")!=null){
		books = (List<Book>)request.getAttribute("books");	
	}else{
		books = service.viewBooks(1);
	}
    %>
  <script>
  setTimeout(function() {
	  $('#msg').fadeOut(3000);
	 });
</script>
<script>
function deleteBook(aid) {
    var answer = confirm("Are you sure you want to delete Book?");
    if (answer == true) {
        location.href = "delBook?bookId=".concat(aid);
    }

}
</script>
<script>
	function pageBooks(val){
		$.ajax({url: "pageBooks",data: { pageNo: val},
			})
			  .done(function( data ) {
			    $('#booksTable').html(data);
			  });
	}
	function searchBooks(){
		$.ajax({url: "searchString",data: {search : $('#searchString').val()},
			})
			  .done(function( data ) {
			    $('#booksTable').html(data);
			  });
	}
</script>
<title>Books</title>
<style>
body {
    margin-left: 2cm;
    margin-right: 2cm;
}
.table th {
   text-align: center;   
   background-color :#428bca;
   color :white;
}
.message {
   font-weight: bold;
   color :green;
}
</style>
</head>
<h2 align="center"> Welcome to Books Page</h2>
<body>
<a href="admin">Back</a><br/><br/>
<p id="msg" class="message">${message} </p>
<form action="addBooks" method="post">
<h4>Enter Book Title:</h4> <input type="text" name="bookTitle">
<button type="submit" name="btn" value="addBook" class="btn btn-primary">Add Book</button><br/>
<h4> Select authors :-</h4>
<select multiple name="selectAuthors" class="form-control">
<%for(Author a: authors){ %>
		<option value=<%=a.getAuthorId() %>><%=a.getAuthorName() %></option>
	<%} %>
</select >
<h4> Select publisher :-</h4>
<select  name="selectPublisher" class="form-control">

<%for(Publisher p: publishers){ %>
		<option value=<%=p.getPublisherId()%>><%=p.getPublisherName()%></option>
	<%} %>
</select>
<h4> Select genre :-</h4>
<select name="selectGenre" multiple class="form-control">
<%for(Genre g: genres){ %>
		<option value=<%=g.getGenreId()%>><%=g.getGenreName()%></option>
	<%} %>
</select>
</form>

<h4>View Books</h4>
<nav>
  <ul class="pagination">
    <%for(int i=1; i<=pageCount;i++){ %>
    <li><a id="pageNo" onclick='pageBooks(<%=i%>)'><%=i%></a></li>
	<%} %>
  </ul>
</nav>
<table class="table" id="booksTable">
<thead>
	<tr>
	<th>Title</th>
	<th>Author</th>
	<th>Publisher</th>
	<th>Genre</th>
	<th>Edit Book</th>
	<th>Delete Book</th>
	</tr>
	</thead>
	<tbody>
	<%
					for (Book b : books) {
						b.setGenres(service.getBookGenres(b));
						b.setAuthors(service.getBookAuthors(b));
						authors=b.getAuthors();
						genres=b.getGenres();
					publisher =b.getPublisher().getPublisherName();
					String genreList = "";
					String authorList = "";
					if (genres != null) {
						for (Genre g : genres) {
							genreList += g.getGenreName() + " , ";
						}
					}
					
					if (authors != null) {
						for (Author a : authors) {
							authorList += a.getAuthorName() + " , ";
						}
					}
			%>
				<tr>
			
					<td align="center"><%=b.getTitle()  %></td> 
					<td ><%=authorList %></td> 
					<td align="center"><%=publisher %></td> 
					<td ><%=genreList %></td> 
					<td align="center"><button   type="button" class="btn btn-warning" data-toggle="modal" data-target="#bookModal" 
			href='editbook?bookId=<%=b.getBookId() %>'>EDIT</button></td>
			 <td align="center"><a type="button" class="btn btn-sm btn-danger"
				onclick="deleteBook(<%=b.getBookId() %>)">DELETE</a></td>
					
			</tr>
			
			<%} %>
	</tbody>
</table>
<div id="bookModal" class="modal fade" tabindex="-1" role="dialog" 
aria-labelledby="myLargeModalLabel">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
    </div>
  </div>
</div>
</body>
</html>