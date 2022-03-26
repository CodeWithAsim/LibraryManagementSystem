<html>

<%	
	String dir=request.getParameter("direct");	
	if(dir != null)
	{
		out.println("<h3 align=center ><font color=red>"+dir+"</font></h3>");
	}
	
	String msg=request.getParameter("msg");
	if(msg != null)
	{
		out.println("<h3 align=center ><font color=red>"+msg+"</font></h3>");
	}
	
%>

<head>
    <title>Login</title>
    <style>
	form{border:2px solid black;
	     position:absolute;
	     left:41%;
			}
	 body{background-color:gray}
	 div.first{border:0;
				 right:5%;
				 top:0.9%;
				 padding:0 0 0 0;
				 position:fixed	
				}
				
		div.second{border:0;
				 right:2.6%;
				 top:3.8%;
				 padding:0 0 0 0;
				 position:fixed	
				}
		
		a { color: black;  
			text-decoration: none;  
			} 
     </style> 
<script language="JavaScript" type="text/javaScript">

function validate()
{	

	if ( document.login.id.value == "" )
	    {
			alert("ID is empty!");	
			document.login.id.focus();
			return false;
	    }
		
	if(document.login.password.value == "")	
	   {
			alert("Password is empty!");
			document.login.password.focus();
			return false;
	   }   

	return true;

}
</script>
    
</head>

<body>

<br>

<div class="first" ><h2><a href="controller?action=signup"> SIGNUP&nbsp <div class="second" ><img src="logo3.jpg" width="27"></div></a></h2></div>


<p align="center"><font color=black size=6><b>LOGIN</b></font></p>

<form name=login method=post action="controller" onsubmit="return validate()">

<br>
    
<table>

    <tr><td align="right">ID:</td>
    <td><input type=text name="id" ></td>
    </tr>

	
    <tr><td align="right"></td>
    <td></td>
    </tr>
	
    <tr><td align="right">Password:</td>
    <td><input type=password name="password" ></td>
    </tr>

    <tr><td align="right"></td>
    <td></td>
    </tr>
  
    <tr>
    <td></td>	
    <td><input type=submit value='LogIn' name="action"></td>
    </tr>


    <tr><td align="right"></td>
    <td></td>
    </tr>

</table>
</form>
</body>

</html>