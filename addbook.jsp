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
    <title>Add_Book</title>
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

	if ( document.addbk.bname.value == "" )
	    {
			alert("Title is empty!");
			document.addbk.bname.focus();			
			return false;
	    }
		
	if ( document.addbk.aname.value == "" )
	    {
			alert("Author name is missing!");
			document.addbk.aname.focus();			
			return false;
	    }
		
	if ( document.addbk.category.value == "" )		
        {
		alert("Choose Category!")
		return false;
		}	
			
		
	if ( document.addbk.price.value == "" )		
        {
		alert("Price of book is empty!")
		document.addbk.price.focus();
		return false;
		}	
		
	if ( document.addbk.count.value == "" )		
        {
		alert("Number of count is empty!")
		document.addbk.count.focus();
		return false;
		}	
		
	return true;

}
</script>
    
</head>

<body>
<br>
<p align="center"><font color=black size=6><b>ADD BOOK</b></font></p>
<form name=addbk action="controller" method=post onsubmit="return validate()">
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
	    <td  align="right">Category:</td> 
	    <td >
		<select name="category">
		<option value=""></option>		
		<option value="science">Science</option>
		<option value="gk">GK</option>
		<option value="islamic">Islamic</option>
		<option value="stories">Stories</option>
		<option value="novel">Novel</option>
		</select>
	    </td> 
	</tr> 
	
	
    <tr>
    <td align="right">Price:</td>
    <td><input type=text name=price></td>
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

	
    <tr><td align="right"></td>
    <td></td>
    </tr>
			
    <tr><td align="right"></td>
    <td></td>
    </tr>
	
    <tr>
    <td></td>
    <td><input type=submit value='Add Record' name="action"></td>
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