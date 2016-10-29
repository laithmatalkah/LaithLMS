<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.gcit.laithproject.service.AdministrativeService"%>
<%@ page import="com.gcit.laithproject.domain.Author"%>
<%

Integer authorId=Integer.parseInt(request.getParameter("authorId"));
AdministrativeService service = (AdministrativeService) request.getAttribute("admService");
Author author= new Author();
author.setAuthorId(authorId);
author=service.viewAuthorByID(author);

%>
<!DOCTYPE html>
<h3 align="center">Edit Author details</h3>
<br/>
<style>
form {
    margin-left: 1cm;
    margin-right: 1cm;
    margin-bottom: 1cm;
}
</style>
	<form action="authorEdited" method="post">
		<Label><font size=4> Update Author Name : </font></Label>&nbsp; <input type="text" name="authorName"
			value='<%=author.getAuthorName()%>'> 
			<input type="hidden" name="authorId" value=<%=author.getAuthorId()%>>
		<button type="submit" name="btn" value="authorEdited" class="btn btn-primary">Save</button>
		<button  data-dismiss="modal" class="btn btn-default">Cancel</button>
	</form>
<script>
$(document).ready(function()
		{
		    $('.modal').on('hidden.bs.modal', function(e)
		    { 
		        $(this).removeData();
		    }) ;
		});
</script>