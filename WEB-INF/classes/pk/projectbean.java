package pk;
import java.io.*; 

public class projectbean implements Serializable
{	
	//addbook
	private String bname;
	private String aname;
	private String category;
	private String price;
	private String count;
	
	
	//issuebook
	private String toname;
    private String id;
	private String idate; 
	private String rdate;
	
	
	//removebook
	private String row;
	private int difference;
	
	
	//returnbook
	private int fine;
	
	
	//addmember
	private String fname;
	private String lname;
	private String gender;
	private String semester;
	private String role;
	private String password;
	
	
	
	                                                // default constructor

	public projectbean() 
	{ 
		bname="";
		aname="";
		category="";
		price="";
		count="";
		toname="";
		id="";
		idate="";
		rdate="";
		row="";
		
		fname="";
		lname="";
		gender="";
		semester="";
		role="";
		password="";
	} 
	                                                     // setters 
														 
	public void setpassword(String p)
	{ 
	
		password = p; 
		
	} 
	
	public void setrole(String r)
	{ 
	
		role = r; 
		
	} 
		
	public void setsemester(String s)
	{ 
	
		semester = s; 
		
	} 													 
														 
	public void setgender(String g)
	{ 
	
		gender = g; 
		
	} 
	
	public void setlname(String ln)
	{ 
	
		lname = ln; 
		
	} 
	
	public void setfname(String fn)
	{ 
	
		fname = fn; 
		
	} 
	
	
	
	public void setbname(String bn)
	{ 
	
		bname = bn; 
		
	} 
	
	public void setaname(String an)
	{ 
	
		aname = an; 
		
	} 
	
	public void setcategory(String cat)
	{ 
	
		category = cat; 
		
	} 
	
	public void setprice(String p)
	{ 
	
		price = p; 
		
	} 
	
	public void setcount(String cn)
	{ 
	
		count = cn; 
		
	} 
	
	public void settoname(String prs)
	{ 
	
		toname = prs; 
		
	} 
	
	public void setid(String i)
	{ 
	
		id = i; 
		
	} 
	
	public void setidate(String idte)
	{ 
	
		idate = idte; 
		
	} 
	
	public void setrdate(String rdte)
	{ 
	
		rdate = rdte; 
		
	} 
	
	public void setrow(String r)
	{ 
	
		row = r; 
		
	} 
	
	
	                                              // getters
	
	
	
	public String getbname()
	{ 
	
		return bname ;
		
	} 
	
	public String getaname()
	{ 
	
		return aname ; 
		
	} 
	
	public String getcategory()
	{ 
	
		return category ; 
		
	} 
	
	public String getprice()
	{ 
	
		return price ; 
		
	} 
	
	public String getcount()
	{ 
	
		return count ; 
		
	} 
	
	public String gettoname()
	{ 
	
		return toname ; 
		
	} 
	
	public String getid()
	{ 
	
		return id; 
		
	} 
	
	public String getidate()
	{ 
	
		return idate ; 
		
	} 
	
	public String getrdate()
	{ 
	
		return rdate ;
		
	} 
	
	public String getrow()
	{ 
	
		return row ; 
		
	} 
	
	
	public String getpassword()
	{ 
	
		return password ; 
		
	} 
	
	public String getrole()
	{ 
	
		return role ; 
		
	} 
		
	public String getsemester()
	{ 
	
		return semester ; 
		
	} 													 
														 
	public String getgender()
	{ 
	
		return gender; 
		
	} 
	
	public String getlname()
	{ 
	
		return lname ; 
		
	} 
	
	public String getfname()
	{ 
	
		return fname ; 
		
	} 
	

}