<%@ include file="include.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.gcit.laithproject.service.AdministrativeService" %>
    <%@ page import="com.gcit.laithproject.domain.Author" %>
    <% AdministrativeService service = (AdministrativeService) request.getAttribute("admService");
	Integer count = service.getAuthorsCount();
	Integer pageCount = 0;
	if(count!=null && count >0){
		int rem = count % 10;
		if(rem == 0){
			pageCount = count/10;
		}else{
			pageCount = count/10+1;
		}
	}
	List<Author> authors = new  ArrayList<Author>();
	if(request.getAttribute("authors")!=null){
		authors = (List<Author>)request.getAttribute("authors");	
	}else{
		authors = service.viewAuthors(1);	
	}
    %>

<script>
function deleteAuthor(aid) {
    var answer = confirm("Are you sure you want to delete Author?");
    if (answer == true) {
        location.href = "delAuthor?authorId=".concat(aid);    
    }
}
</script>
<script>
	function pageAuthors(val){
		$.ajax({url: "pageAuthors",data: { pageNo: val},
			})
			  .done(function( data ) {
			    $('#authorsTable').html(data);
			  });
	}
	function searchAuthors(){
		$.ajax({url: "searchString",data: {search : $('#searchString').val()},
			})
			  .done(function( data ) {
			    $('#authorsTable').html(data);
			  });
	}
</script>


<title>Authors</title>
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
<h2 align="center"> Welcome to Authors Page</h2>

<body>
<a href="admin">Back</a><br/><br/><br/>
<div id="msg" class="message">${message}</div>
<form action="addAuthor" method="post">
<h4>Enter Author Name:</h4>
 <input type="text" name="authorName">
<button type="submit" name="btn" value="addAuthor" class="btn btn-primary">Add Author</button><br/>
</form>
<h4>View Authors</h4>
<nav>
  <ul class="pagination">
    <%for(int i=1; i<=pageCount;i++){ %>
    <li><a id="pageNo" onclick='pageAuthors(<%=i%>)'><%=i%></a></li>
	<%} %>
  </ul>
</nav>
<table class="table table-hover table-condensed"  border="1" id="authorsTable">
			<thead>
				<tr>
					<th>Author Name</th>
					<th>Edit Author</th>
					<th>Delete Author</th>
				</tr>
			</thead>
			<tbody>
				<%
					for (Author a : authors) {
				%>
				<tr>
					<td ><%=a.getAuthorName()%></td>
			
			<td align="center"><button type="button" class="btn btn-warning" data-toggle="modal" data-target="#AuModal" 
			href='editauthor?authorId=<%=a.getAuthorId()%>'>EDIT</button></td>
			 <td align="center"><a type="button" class="btn btn-sm btn-danger" onclick="deleteAuthor(<%=a.getAuthorId()%>)">DELETE</a></td>
			</tr>
	<%
					}
				%>
			</tbody>
		</table>
<div id="AuModal" class="modal fade" tabindex="-1" role="dialog" 
aria-labelledby="myLargeModalLabel">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
    </div>
  </div>
</div>


</body>
</html>