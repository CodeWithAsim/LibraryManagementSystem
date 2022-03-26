<%@ page session = "true"%>

<%	
	String role;
	
	if(session.getAttribute("idfs")==null && session.getAttribute("rolefs")==null)
	{
		response.sendRedirect("login.jsp?direct=Direct_Access_Error");
	}	
	
	if(session.getAttribute("rolefs")!=null)
	{
		role=(String)session.getAttribute("rolefs");
		if(role.equals("member"))
		{
			response.sendRedirect("login.jsp?msg=Invalid_Access");
		}	
	}
%>


<html>
<head>
    <title>DeleteMember</title>
	<head>
	<style>
		form{border:2px solid black;
			 position:absolute;
			 left:40.4%
			}
		body{background-color:gray}
	</style> 
<script language="JavaScript" type="text/javaScript">

function validate()
{	

	if ( document.deletembr.fname.value == "" )
	    {
			alert(" His/Her First name is empty!");
			document.deletembr.fname.focus();			
			return false;
	    }
		
	if ( document.deletembr.lname.value == "" )
	    {
			alert("His/Her Last name is empty!");
			document.deletembr.lname.focus();			
			return false;
	    }
		
				
	if ( document.deletembr.id.value == "" )		
        {
		alert("Please enter his unique ID!")
		document.deletembr.id.focus();
		return false;
		}	
		

	if(document.deletembr.semester.value == "")	
	   {
			alert("Whats his Semester!");
			document.deletembr.semester.focus();
			return false;
	   }	
	   
	if (!document.deletembr.confirm.checked)
		{
			alert(" Please Confirm it to remove as member ! ");
			return false;
		}	

	return true;

}
</script>
    
</head>

<body>
<br>
<p align="center"><font color=black size=6><b>DELETE MEMBER</b></font></p>
<form name=deletembr action="controller" method=post onsubmit="return validate()">
    <table>
    <tr><td align="right">First Name:</td>
    <td><input type=text name="fname" ></td>
    </tr>

<br>
	
    <tr><td align="right"></td>
    <td></td>
    </tr>
	
    <tr><td align="right">Last Name:</td>
    <td><input type=text name="lname" ></td>
    </tr>
	
    <tr><td align="right"></td>
    <td></td>
    </tr>
	
    <tr>
    <td align="right">ID:</td>
    <td><input typ=text name=id></td>
    </tr>
	
    <tr><td align="right"></td>
    <td></td>
    </tr>
				
    <tr>
    <td align="right">Semester:</td>
    <td><input type=text name="semester"></td>
    </tr>
	
    <tr><td align="right"></td>
    <td></td>
    </tr>

	<tr>
	<td align="right"><input type="checkbox" name="confirm" ></td> <td> Confirm !.</td>
	<tr>

    <tr><td align="right"></td>
    <td></td>
    </tr>
			
    <tr><td align="right"></td>
    <td></td>
    </tr>
	
    <tr>
    <td></td>
    <td><input type=submit value='Delete It' name="action"></td>
    </tr>
	
    <tr><td align="right"></td>
    <td></td>
    </tr>
	
    <tr><td align="right"></td>
    <td></td>
    </tr>
	
    <tr><td align="right"></td>
    <td></td>
    </tr>

    </table>

</form>
</body>

</html>