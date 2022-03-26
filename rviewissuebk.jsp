<%@page errorPage="addbookerror.jsp" %> 

<%@page import="java.util.*" %><%@page import="pk.*" %> 

<html><body><center>  
<h2> LIST OF ISSUED BOOKS TO MEMBERS WITH COMPLETE BIO-DATA</h2> 

<TABLE BORDER="1" > 

<TR> 
 <TH> BOOK NAME </TH> 
 <TH> AUTHOR NAME </TH> 
 <TH> CATEGORY </TH> 
 <TH> PERSON </TH> 
 <TH> ID </TH>
 <TH> ISSUE DATE </TH>
 <TH> RETURN DATE </TH>  
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
<TD> <%= b.gettoname()%> </TD>
<TD> <%= b.getid()%> </TD>
<TD> <%= b.getidate()%> </TD>
<TD> <%= b.getrdate()%> </TD>
</TR> 

<% 
 } 
%> 

</TABLE > 
</center> </body></html> 

