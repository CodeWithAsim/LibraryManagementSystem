<%@page errorPage="addbookerror.jsp" %> 

<%@page import="java.util.*" %><%@page import="pk.*" %> 

<html><body><center>  
<h2>LIST OF BOOKS AVAILABLE IN LIBRARY WITH COMPLETE DATA</h2> 

<TABLE BORDER="1" > 

<TR> 
 <TH> BOOK NAME </TH> 
 <TH> AUTHOR NAME </TH> 
 <TH> CATEGORY </TH> 
 <TH> COST </TH> 
 <TH> COUNT </TH>
</TR> 

<% 
 ArrayList al = (ArrayList)request.getAttribute("bks"); 
 projectbean b = null; 

 for(int i=0; i<al.size(); i++) 
 { 
	b = (projectbean)al.get(i); %> 


<TR>
<TD> <%= b.getbname()%> </TD>
<TD> <%= b.getaname()%> </TD>
<TD> <%= b.getcategory()%> </TD> 
<TD> <%= b.getprice()%> </TD>
<TD> <%= b.getcount()%> </TD>

</TR> 

<% 
 } 
%> 

</TABLE > 
</center> </body></html> 

