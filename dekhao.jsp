<%@page errorPage="addbookerror.jsp" %> 

<%@page import="java.util.*" %><%@page import="pk.*" %> 

<html><body><center> 

<h1>RESULT</h1>

<%
	String display = (String)request.getAttribute("dekhao"); 
	out.println(display);
%>

</center> </body></html> 
