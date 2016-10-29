<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.gcit.laithproject.service.AdministrativeService"%>
<%@ page import="com.gcit.laithproject.domain.Publisher"%>
<%
	Integer publisherId = Integer.parseInt(request.getParameter("publisherId"));
AdministrativeService service = (AdministrativeService) request.getAttribute("admService");
Publisher p=new Publisher();
p.setPublisherId(publisherId);
	 p = service.viewPublisherByID(p);
	
%>
<!DOCTYPE html>
<h3 align="center">Edit Publisher details</h3>
<style>
form {
    margin-left: 1cm;
    margin-right: 1cm;
    margin-bottom: 1cm;
}
</style>
	<form action="publisherEdited" method="post">
		Update Publisher Name: <input type="text" name="publisherName"
			value='<%=p.getPublisherName() %>'> <br/>
			<input type="hidden" name="publisherId" value=<%=p.getPublisherId()%>>
			Edit Publisher Address: <input type="text" name="publisherAddress"
			value='<%=p.getPublisherAddress()%>'> <br/>
			Edit Publisher Phone: <input type="text" name="publisherPhone"
			value='<%=p.getPublisherPhone()%>'> 
		<button type="submit" name="btn" value="publisherEdited" class="btn btn-primary">Save</button>
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