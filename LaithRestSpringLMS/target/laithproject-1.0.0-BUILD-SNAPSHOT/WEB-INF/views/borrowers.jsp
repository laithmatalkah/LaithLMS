<%@page import="com.gcit.laithproject.domain.Borrower"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.gcit.laithproject.service.AdministrativeService" %>
    <%@ page import="com.gcit.laithproject.domain.Borrower" %>
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
	List<Borrower> borrowers = new ArrayList<Borrower>();
	if(request.getAttribute("borrowers")!=null){
		borrowers = (List<Borrower>)request.getAttribute("borrowers");	
	}else{
		borrowers = service.viewBorrower(1);
	}
    %>
<%@ include file="include.jsp" %>
  <script>
  setTimeout(function() {
	  $('#msg').fadeOut(3000);
	 });
</script>
<script>
function deleteBorrower(aid) {
    var answer = confirm("Are you sure you want to delete Borrower?");
    if (answer == true) {
        location.href = "delBorrower?cardNo=".concat(aid);
    }
}
</script>
<script>
	function pageBorrowers(val){
		$.ajax({url: "pageBorrowers",data: { pageNo: val},
			})
			  .done(function( data ) {
			    $('#borrowerTable').html(data);
			  });
	}
	function searchBorrowers(){
		$.ajax({url: "searchString",data: {search : $('#searchString').val()},
			})
			  .done(function( data ) {
			    $('#borrowerTable').html(data);
			  });
	}
</script>

<title>Borrower</title>
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
<h2 align="center"> Welcome to Borrower Page</h2>
<a href="admin">Back</a><br/><br/>
<body>
<p id="msg" class="message">${message}</p>
<form action="addBorrwoer" method="post">
<Label><font size=4>Borrower card Number </font></Label>&nbsp;
<input type="text" name="borroCard">&nbsp;&nbsp;
<Label><font size=4>Borrower Name</font></Label>&nbsp;
<input type="text" name="borroName"><br/><br/>
<Label><font size=4>Borrower Address </font></Label>&nbsp;
 <input type="text" name="borroAddress">&nbsp;&nbsp;
<Label><font size=4>Borrower Phone</font></Label>&nbsp;
&nbsp;&nbsp; <input type="text" name="borroPhone"><br/>
<button type="submit" name="btn"  class="btn btn-primary">Add Borrower</button><br/>
<h4>View Borrowers</h4>
<nav>
  <ul class="pagination">
    <%for(int i=1; i<=pageCount;i++){ %>
    <li><a id="pageNo" onclick='pageBorrowers(<%=i%>)'><%=i%></a></li>
	<%} %>
  </ul>
</nav>
<table  id="borrowersTable" class="table table-hover table-condensed"  border="1">
<thead>
	<tr>
	<th>Borrower Name</th>
	<th>Borrower Address</th>
	<th>Borrower Phone</th>
	<th>Edit Borrower</th>
	<th>Delete Borrower</th>
	</tr>
	</thead>
	<tbody>
	<%for(Borrower br: borrowers){ %>
		<tr>
		<td align="center"><%=br.getCardNo()%></td>
			<td align="center"><%=br.getBorroName()%></td>
			<td align="center"><%=br.getBorroAddress() %></td>
			<td align="center"><%=br.getBorroPhone() %></td>
			<td align="center"><button type="button" class="btn btn-warning" data-toggle="modal" data-target="#BorroModal" 
			href='editborrower?cardNo=<%=br.getCardNo()%>'>EDIT</button></td>
			 <td align="center"><a type="button" class="btn btn-sm btn-danger" onclick="deleteBorrower(<%=br.getCardNo() %>)">DELETE</a></td>
			</tr>
	<%} %>	
	</tbody>
</table>
</form>
<div id="BorroModal" class="modal fade" tabindex="-1" role="dialog" 
aria-labelledby="myLargeModalLabel">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
    </div>
  </div>
</div>
</body>
