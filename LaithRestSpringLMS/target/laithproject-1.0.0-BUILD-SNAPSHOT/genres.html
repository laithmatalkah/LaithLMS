<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.gcit.laithproject.service.AdministrativeService" %>
    <%@ page import="com.gcit.laithproject.domain.Genre" %>
    <%
    
    AdministrativeService service = (AdministrativeService) request.getAttribute("admService");
    List<Genre> genres = new ArrayList<Genre>();
    genres = service.viewGenres();
    %>
<%@ include file="include.jsp" %>
 <script> 
  setTimeout(function() {
	  $('#msg').fadeOut(3000);
	 });
</script>
<script>
function deleteGenre(aid) {
    var answer = confirm("Are you sure you want to delete Genre?");
    if (answer == true) {
        location.href = "delGenre?genreId=".concat(aid);    
    }
}
</script>
<title>Genres</title>
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
<h2 align="center"> Welcome to Genres Page</h2>

<body>
<a href="admin">Back</a><br/><br/>
<p id="msg" class="message">${message} </p>
<form action="addGenre" method="post">
<h4> Add new Genre:-</h4>
<input type="text" name="genreName">
<button type="submit" name="btn" value="addGenre" class="btn btn-primary">Add Genre</button>
</form><br/>
<h4>View Genres</h4>
<table class="table  table-hover table-condensed"  border="1">
	<tr>
	<th>Genre ID</th>
	<th>Genre Name</th>
	<th>Edit Genre</th>
	<th>Delete Genre</th>
	</tr>
	<%for(Genre g: genres){ %>
		<tr>
			<td align="center"><%=g.getGenreId()%></td>
			<td align="center"><%=g.getGenreName() %></td>
			<td align="center"><button type="button" class="btn btn-warning" data-toggle="modal" data-target="#GrModal" 
			href='editgenre?genreId=<%=g.getGenreId() %>'>EDIT</button></td>
			<td align="center"><a type="button" class="btn btn-sm btn-danger" onclick="deleteGenre(<%=g.getGenreId()%>)">DELETE</a></td>
			
			</tr>
	<%} %>
</table>
<div id="GrModal" class="modal fade" tabindex="-1" role="dialog" 
aria-labelledby="myLargeModalLabel">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
    </div>
  </div>
</div>
</body>
</html>