<%@page errorPage="addbookerror.jsp" %> 

<%@page import="java.util.*" %><%@page import="pk.*" %> 

<html><body><center>  
<h2>RECEIPT</h2> 

</br>
</br>
</br>

<hr>

<% 
 ArrayList al = (ArrayList)request.getAttribute("rec"); 
 String display = null; 

 for(int i=0; i<al.size(); i++) 
 { 
	display = (String)al.get(i); 
	out.println("<h3 align=center>"+display+"</h3>");
	out.println("<hr>");								
 } 
%> 

</center> </body></html> 

