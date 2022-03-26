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
    <title>AddMember</title>
	<head>
	<style>
		form{border:2px solid black;
			 position:absolute;
			 left:38.5%
			}
		body{background-color:gray}
	</style> 
<script language="JavaScript" type="text/javaScript">

function validate()
{	

	if ( document.addmbr.fname.value == "" )
	    {
			alert("First name is empty!");
			document.addmbr.fname.focus();			
			return false;
	    }
		
	if ( document.addmbr.lname.value == "" )
	    {
			alert("Last name is empty!");
			document.addmbr.lname.focus();			
			return false;
	    }
		
	if (!document.addmbr.gender[0].checked && !document.addmbr.gender[1].checked)
	{
		alert("Please choose gender");
		return false;
	}	
				
	if ( document.addmbr.id.value == "" )		
        {
		alert("Please enter your unique ID!")
		document.addmbr.id.focus();
		return false;
		}	
		

	if(document.addmbr.semester.value == "")	
	   {
			alert("Whats Semester!");
			document.addmbr.semester.focus();
			return false;
	   }


	if(document.addmbr.role.value == "")	
	   {
			alert("Member field is empty!");
			document.addmbr.role.focus();
			return false;
	   }
	   
	   
	if(document.addmbr.password.value == "")	
	   {
			alert("Take his/her desire password !");
			document.addmbr.password.focus();
			return false;
	   }   

	return true;

}
</script>
    
</head>

<body>
<br>
<p align="center"><font color=black size=6><b>ADD MEMBER</b></font></p>
<form name=addmbr action="controller" method=post onsubmit="return validate()">
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
	     <td  align="right">Gender:</td> 
	     <td ><input type="radio" name="gender" value="male"> Male </td> 
	   </tr>

	   <tr> 
	     <td  align="right"></td> 
	     <td ><input type="radio" name="gender" value="female"> Female </td> 
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
    <td align="right">Role:</td>
    <td><input type=text name="role" value="member"></td>
    </tr>
	
	
	
	<tr><td align="right"></td>
    <td></td>
    </tr>
	
			
    <tr>
    <td align="right">Password for login:</td>
    <td><input type=password name="password"></td>
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
	
    <tr>
    <td></td>
    <td><input type=submit value='Add' name="action"></td>
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