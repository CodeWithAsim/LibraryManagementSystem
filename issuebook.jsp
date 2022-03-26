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
    <title>Issue_Book</title>
	<head>
	<style>
		form{border:2px solid black;
			 position:absolute;
			 left:39%
			}
		body{background-color:gray}
	</style> 
<script language="JavaScript" type="text/javaScript">

function validate()
{	

	if ( document.issuebk.bname.value == "" )
	    {
			alert("Title is empty!");
			document.issuebk.bname.focus();			
			return false;
	    }
		
	if ( document.issuebk.aname.value == "" )
	    {
			alert("Author name is missing!");
			document.issuebk.aname.focus();			
			return false;
	    }
		
	if ( document.issuebk.category.value == "" )		
        {
		alert("Choose Category!")
		return false;
		}	
			
		
	if ( document.issuebk.toname.value == "" )		
        {
		alert(" To whom it being issue !")
		document.issuebk.toname.focus();
		return false;
		}	
		
	if ( document.issuebk.id.value == "" )		
        {
		alert("His/Her ID field is empty!")
		document.issuebk.id.focus();
		return false;
		}	
		
	if ( document.issuebk.idate.value == "" || document.issuebk.rdate.value == "" )		
        {
		alert("Issue and Return Dates are missing , press Add Dates button!")
		return false;
		}	
		
		
		
	return true;

}

function dates()
{

	var d = new Date();
	
	var dt = d.getDate();
	var sdt = dt.toString();
	
	var m = d.getMonth();
	var p1m = m+1;
	var sp1m = p1m.toString();
	
	var y = d.getFullYear();
	var sy = y.toString();
	
	document.issuebk.idate.value = sdt+"/"+sp1m+"/"+sy;

}




</script>
    
</head>

<body>
<br>
<p align="center"><font color=black size=6><b>ISSUE BOOK</b></font></p>
<form name=issuebk action="controller" method=post onsubmit="return validate()">
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
    <td align="right">To (Name) :</td>
    <td><input type=text name="toname"></td>
    </tr>
	
    <tr><td align="right"></td>
    <td></td>
    </tr>
	
    <tr>
    <td align="right">His/Her ID:</td>
    <td><input type=text name="id"></td>
    </tr>
	
	<tr><td align="right"></td>
    <td></td>
    </tr>
	
    <tr>
    <td align="right">Issue Date:</td>
    <td><input type=text name="idate"></td>
    </tr>
	
    <tr><td align="right"></td>
    <td></td>
    </tr>
	
	<tr><th colspan="2">Give him/her Due Date (format:dd/mm/yyyy)</th></tr>
	
	<tr>
    <td align="right">Return Date * :</td>
    <td><input type=text name="rdate"></td>
    </tr>

	
    <tr><td align="right"></td>
    <td></td>
    </tr>
	
	<tr>
    <td></td>
    <td><button type="button" name="b" onclick="dates()" >Add Dates!</button></td>
    </tr>
			
    <tr><td align="right"></td>
    <td></td>
    </tr>
	
    <tr>
    <td></td>
    <td><input type=submit value='Issue Book' name="action"></td>
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