<%@ page session = "true"%>

<%	
	String role;
	
	if(session.getAttribute("idfs")==null && session.getAttribute("rolefs")==null)
	{
		response.sendRedirect("login.jsp?direct=Direct_Access_Error");
	}	
	
%>


<Html>     
<Head>      
<Title>     
Member_Page 
</Title>  
<style type=text/css>  

div.first{position:fixed ; right:3% ; color:white  ; padding:0 ; top:0.9%}
div.second{position:fixed ; right:1% ; color:white ; padding:0 ; top:0.7%}

form{width:800px; margin:180px 100px 400px 250px; position:fixed } 
body   
{    
margin-top: 80px;  
padding: 30px;  
background-size: cover;  
font-family: sans-serif;  
background-image:url("l2.jpg");
background-size:cover
}  
header {  
background-color: gray;  
position: fixed;  
left: 0;  
right: 0;  
top: 0;  
height: 30px;  
display: flex;  
align-items: center;  
box-shadow: 0 0 25px 0 black;  
}  
header * {  
display: inline;  
}  
header li {  
margin: 20px;  
}  
header li a {  
color: white;  
text-decoration: none;  
}  
</style>   
</Head>  
<Body>   
<header>  
<nav>  
<ul>  
<li>  
<a href="#"> Home </a>  
</li>  
<li>  
<a href="controller?action=viewbooks"> View Books </a>  
</li>  
<li>  
<a href="controller?action=viewreceipt"> View Receipt </a>  
</li>  


<li>
<div class="first">
<a href="controller?action=serout">Logout&nbsp
<div class="second" ><img src="piclog.png" width="19"></div>
</a>
</div>
</li> 


</ul>  
</nav>  
</header>  
<form>
<p><h1><font face="san-serif" color=black> WELCOME TO LIBRARY MANAGEMENT SYSTEM </font></h1><p>
</form>   
</Body>   
</Html>  