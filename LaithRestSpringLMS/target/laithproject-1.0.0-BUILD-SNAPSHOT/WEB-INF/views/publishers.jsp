<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.gcit.laithproject.service.AdministrativeService" %>
    <%@ page import="com.gcit.laithproject.domain.Publisher" %>
    <% AdministrativeService service = (AdministrativeService) request.getAttribute("admService");
    List<Publisher> publishers=new ArrayList<Publisher>();
    publishers = service.viewPublishers(1);
    %>
<%@ include file="include.jsp" %>
  <script>
  
  setTimeout(function() {
	  $('#msg').fadeOut(3000);
	 });
 
</script>
<script>
function deletePublisher(aid) {
    var answer = confirm("Are you sure you want to delete Publisher?");
    if (answer == true) {
        location.href = "delPublisher?publisherId=".concat(aid);
    }
}
</script>
<script>
	function pagePublishers(val){
		$.ajax({url: "pagePublishers",data: { pageNo: val},
			})
			  .done(function( data ) {
			    $('#publishersTable').html(data);
			  });
	}
	function searchAuthors(){
		$.ajax({url: "searchString",data: {search : $('#searchString').val()},
			})
			  .done(function( data ) {
			    $('#publishersTable').html(data);
			  });
	}
</script>
<title>Publishers</title>
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
<h2 align="center"> Welcome to Publishers Page</h2>
<body>
<a href="admin">Back</a><br/><br/>
<div id="msg" class="message">${message} </div>
<h4> Add new publisher:-</h4>
<form action="addPublisher" method="post">
<Label><font size=4> Publisher Name: </font></Label>&nbsp;
<input type="text" name="publisherName">&nbsp;&nbsp;
<Label><font size=4> Publisher Address: </font></Label>&nbsp;
<input type="text" name="publisherAddress">&nbsp;&nbsp;
<Label><font size=4>Publisher Phone: </font></Label>&nbsp;
 <input type="text" name="publisherPhone"><br/><br/>
<button type="submit" name="btn" value="addPublisher" class="btn btn-primary">Add Publisher</button>
</form>
<br/>
<h4> View Publishers</h4>

<table id="publishersTable" class="table  table-hover table-condensed"  border="1">
<thead>
	<tr>
	<th>Publisher Name</th>
	<th>Publisher Address</th>
	<th>Publisher Phone</th>
	<th>Edit Publisher</th>
	<th>Delete Publisher</th>
	</tr>
	</thead>
	<tbody>
	<%for(Publisher p: publishers){ %>
		<tr>
			<td align="center"><%=p.getPublisherName() %></td>
			<td align="center"><%=p.getPublisherAddress() %></td>
			<td align="center"><%=p.getPublisherPhone() %></td>
			<td align="center"><button   type="button" class="btn btn-warning" data-toggle="modal" data-target="#PubModal" 
			href='editpublisher?publisherId=<%=p.getPublisherId()%>'">EDIT</button></td>
			 <td align="center"><a type="button" class="btn btn-sm btn-danger" onclick="deletePublisher(<%=p.getPublisherId()%>)">DELETE</a></td>
			
			</tr>
	<%} %>
	</tbody>
</table>
<div id="PubModal" class="modal fade" tabindex="-1" role="dialog" 
aria-labelledby="myLargeModalLabel">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
    </div>
  </div>
</div>

</body>
