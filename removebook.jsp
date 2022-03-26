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
    <title>Remove_Book</title>
	<head>
	<style>
		form{border:2px solid black;
			 position:absolute;
			 left:39.5%
			}
		body{background-color:gray}
	</style> 
<script language="JavaScript" type="text/javaScript">

function validate()
{	

	if ( document.removebk.bname.value == "" )
	    {
			alert("Title is empty!");
			document.remove.bname.focus();			
			return false;
	    }
		
	if ( document.removebk.aname.value == "" )
	    {
			alert("Author name is missing!");
			document.removebk.aname.focus();			
			return false;
	    }
		
		
	if ( document.removebk.count.value == "" && !document.removebk.row.checked )		
        {
		alert("Please choose Delete Status!")
		document.removebk.count.focus();
		return false;
		}	
		
	return true;

}
</script>
    
</head>

<body>
<br>
<p align="center"><font color=black size=6><b>REMOVE BOOK</b></font></p>
<form name="removebk" action="controller" method=post onsubmit="return validate()">
    <table>
    <tr><td align="right">Book Name:</td>
    <td><input type=text name="bname" ></td>
    </tr>

<br>
	
    <tr><td align="right"></td>
    <td></td>
    </tr>
	
    <tr><td align="right">Author Name:</td>
    <td><input type=text name="aname" ></td>
    </tr>
	
    <tr><td align="right"></td>
    <td></td>
    </tr>
	
	
    <tr>
    <td align="right">Count:</td>
    <td><input type=text name="count"></td>
    </tr>
	
    <tr><td align="right"></td>
    <td></td>
    </tr>
	
	<tr>
	<td align="right"><input type="checkbox" name="row" value="all" ></td> <td> Delete Complete Record ! </td>
	<tr>

	
    <tr><td align="right"></td>
    <td></td>
    </tr>
			
    <tr><td align="right"></td>
    <td></td>
    </tr>
	
    <tr>
    <td></td>
    <td><input type=submit value='Confirm' name="action"></td>
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