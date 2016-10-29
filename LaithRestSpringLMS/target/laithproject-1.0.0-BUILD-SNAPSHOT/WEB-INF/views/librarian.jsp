<%@page import="com.sun.xml.internal.txw2.Document"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="com.gcit.laithproject.service.AdministrativeService" %>
    <%@ page import="com.gcit.laithproject.domain.Branch" %>
    <%AdministrativeService service = (AdministrativeService) request.getAttribute("admService");
    List<Branch> branches = new ArrayList<Branch>();
    branches=service.viewBranches();
    %>
<%@ include file="include.jsp" %>
  <script>
  function goToPage(){
	  document.location.href("branchbooklist.jsp");
  }
  
  </script>
<title>Librarian</title>
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
<h2 align="center">Librarian Page</h2><br/>
<h4 >Please choose you action</h4>
<body>
<a> select branch name you manage</a><br/>

<form method="post" action="copies">
<select  name="selectBranch" class="selectpicker" >
<%for(Branch br: branches){ %>
		<option   value=<%=br.getBranchId() %>><%=br.getBranchName() %></option>
	<%} %>
</select>

<button  name="btn" class="btn btn-primary" >Go</button><br/>

</form>
<br/>
<br/>
<a href="home">Quit</a><br/>

</body>
