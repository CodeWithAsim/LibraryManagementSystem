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
    <title>Return_Book</title>
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

	if ( document.returnbk.bname.value == "" )
	    {
			alert(" Book_Title is empty!");
			document.returnbk.bname.focus();			
			return false;
	    }
		
	if ( document.returnbk.aname.value == "" )
	    {
			alert("Author name is missing!");
			document.returnbk.aname.focus();			
			return false;
	    }
		
	if ( document.returnbk.category.value == "" )		
        {
		alert("Choose Category!")
		return false;
		}	
			
		
	if ( document.returnbk.mname.value == "" )		
        {
		alert(" To whom it was issued !")
		document.returnbk.mname.focus();
		return false;
		}	
		
	if ( document.returnbk.id.value == "" )		
        {
		alert("His/Her ID field is empty!")
		document.returnbk.id.focus();
		return false;
		}	
		
	if ( document.returnbk.ringdate.value == "")		
        {
		alert("Returning Date is missing , Add it by pressing Current Date button !")
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
	
	document.returnbk.ringdate.value = sdt+"/"+sp1m+"/"+sy;

}




</script>
    
</head>

<body>
<br>
<p align="center"><font color=black size=6><b>RETURN BOOK</b></font></p>
<form name=returnbk action="controller" method=post onsubmit="return validate()">
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
    <td align="right">Member_Name:</td>
    <td><input type=text name="mname"></td>
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
    <td align="right">Returning Date:</td>
    <td><input type=text name="ringdate"></td>
    </tr>
	
    <tr><td align="right"></td>
    <td></td>
    </tr>
		
	<tr>
    <td></td>
    <td><button type="button" name="b" onclick="dates()" >Current Date</button></td>
    </tr>
			
    <tr><td align="right"></td>
    <td></td>
    </tr>
	
    <tr>
    <td></td>
    <td><input type=submit value='Return Book' name="action"></td>
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