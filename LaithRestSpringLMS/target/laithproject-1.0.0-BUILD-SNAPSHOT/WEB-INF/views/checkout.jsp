<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.gcit.laithproject.service.LibrarianService"%>
	<%@page import="com.sun.xml.internal.txw2.Document"%>
    <%@ page import="java.util.List" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.gcit.laithproject.service.AdministrativeService" %>
    <%@ page import="com.gcit.laithproject.service.LibrarianService" %>
    <%@ page import="com.gcit.laithproject.domain.Book" %>
    <%@ page import="com.gcit.laithproject.domain.Branch" %>
    <%@ page import="com.gcit.laithproject.domain.Copies" %>
    <%@ page import="com.gcit.laithproject.domain.Author" %>
    <%AdministrativeService admService = (AdministrativeService) request.getAttribute("admService"); 
    LibrarianService libService = (LibrarianService) request.getAttribute("libService"); 
    String br=request.getAttribute("bookId").toString();
    List<Branch> branches=new ArrayList<Branch>();
    branch.setBranchId(Integer.parseInt(br));
     List<Book> copies= new ArrayList<Book>();
    %>
  <script>
  
  setTimeout(function() {
	  $('#msg').fadeOut(3000);
	 });
 
</script>

<title>Branch Book List</title>
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
<h4 align="center">Please select the branch and proceed</h4>
<body>
<form action="checkout"  method="post">
<table class="table" id="booksTable">
<thead>
	<tr>
	<th>Title</th>
	<th>Author</th>
	<th>Number of Copies</th>
	<th>Borrow</th>
	</tr>
	</thead>
	<tbody>
	 <%
					
			%>
				<tr>
			
					<td align="center"><%=b.getTitle()  %></td> 
					<td ><%=authorList %></td> 
					<td align="center"><%=cp.getNoOfcopies()%></td> 
					
			</tr>
			<%} %>
			
	</tbody> 
</table>
<div id="cpModal" class="modal fade" tabindex="-1" role="dialog" 
aria-labelledby="myLargeModalLabel">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
    </div>
  </div>
</div>
</form>
<p id="msg" class="message">${message} </p>
</body>
</html>