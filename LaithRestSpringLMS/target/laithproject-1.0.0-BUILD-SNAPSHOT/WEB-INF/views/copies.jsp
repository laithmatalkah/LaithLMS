<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.gcit.laithproject.service.LibrarianService"%>
    <%@ page import="java.util.List" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.gcit.laithproject.service.AdministrativeService" %>
    <%@ page import="com.gcit.laithproject.service.LibrarianService" %>
    <%@ page import="com.gcit.laithproject.domain.Book" %>
    <%@ page import="com.gcit.laithproject.domain.Branch" %>
    <%@ page import="com.gcit.laithproject.domain.Copies" %>
    <%@ page import="com.gcit.laithproject.domain.Author" %>
    <%
    AdministrativeService service = (AdministrativeService) request.getAttribute("admService");
    LibrarianService service2 = (LibrarianService) request.getAttribute("libService");
   Branch branch=new Branch();
    List<Book> books = new ArrayList<Book>();
    List<Book> branchCopies= new ArrayList<Book>();
    books=service.viewBooks(1);
String br=request.getAttribute("selectBranch").toString();
branch.setBranchId(Integer.parseInt(br));
branch=service2.viewBranchByID(branch);
branchCopies=service2.viewCopies(branch);
    %>
<%@ include file="include.jsp" %>
<script>
function removeBook(bid,brid) {
    var answer = confirm("Are you sure you want to delete Author?");
    if (answer == true) {
        location.href = "removeBook?bookId="+bid+"&selectBranch="+brid;    
    }
}
</script>
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
<h2 align="center"> Welcome to <%= branch.getBranchName()%></h2>
<h4 align="center"> You can add new books and update the number of copies</h4>
<a href="librarian">Back</a><br/><br/>
<div id="msg" class="message">${message}</div>
<body>
<form action="AddOneBook"  method="post">
<label><font size=4>Whole Book List :</font></label>
<select multiple name="selectBookCopies" class="form-control">
<%for(Book b: books){ %>
		<option value=<%=b.getBookId() %>><%=b.getTitle() %></option>
	<%} %>
</select ><br/>
  <input type="hidden" name="selectBranch" value=<%=branch.getBranchId() %>></input>

<button type="submit" name="btn" value="AddOneBook" class="btn btn-primary">Add book copy</button><br/><br/>
<label><font size=4><%= branch.getBranchName()%> Book List :</font></label>
<table class="table  table-hover table-condensed"  border="1">
	<tr>
	<th>Book Title</th>
	<th>Author</th>
	<th>Number of Copies</th>
	<th>Edit copies</th>
	<th>Remove book</th>
	</tr>
	<%for(Book b: branchCopies){
		Copies cp= new Copies();
		cp.setBookId(b.getBookId());
		cp.setBranchId(branch.getBranchId());
		cp=service2.getNoOfCopies(cp);
	List<Author> aList = service.getBookAuthors(b);
	String authorList = "";
	if(!aList.isEmpty()) {
		for(Author a : aList) {
			authorList += a.getAuthorName() + ",";
		}
	}
	%>
		<tr>
			<td ><%=b.getTitle() %></td>
			<td ><%= authorList %></td>
			<td ><%= cp.getNoOfcopies() %></td>
			<td align="center"><button   type="button" class="btn btn-warning" data-toggle="modal" data-target="#cpModal" 
			href='editcopies?bookId=<%=b.getBookId()%>&branchId=<%=br%>' >EDIT</button></td>
 <td align="center"><a type="button" class="btn btn-sm btn-danger" onclick='removeBook("<%=b.getBookId()%>+","+<%=branch.getBranchId()%>")'>DELETE</a></td></tr>
	<%} %>
	
</table>
<div id="cpModal" class="modal fade" tabindex="-1" role="dialog" 
aria-labelledby="myLargeModalLabel">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
    </div>
  </div>
</div>
</form>
</body>
</html>