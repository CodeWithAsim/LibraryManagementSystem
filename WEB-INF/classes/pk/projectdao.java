package pk;

import pk.*;
import java.util.*; 
import java.sql.*; 

public class projectdao
{ 

	private Connection con; 

	public projectdao() throws ClassNotFoundException,SQLException
	{
		establishConnection(); 
	} 

	private void establishConnection() throws ClassNotFoundException,SQLException
	{ 
		Class.forName("com.mysql.jdbc.Driver"); 
		String url = "jdbc:mysql://127.0.0.1/project"; 
		con = DriverManager.getConnection(url,"root","root"); 
	} 


	public String getrole(String id,String pwd) throws SQLException
	{	
		String type = null;
				
		Statement st=con.createStatement();
			
		String query="Select * from tsignup where ID='"+id+"' AND Password ='"+pwd+"'";       
		ResultSet rs = st.executeQuery( query );
			
		if(rs.next())
		{
			String role = rs.getString(5);
			type=role;
		
		}
		else
		{
		   
			String query2="Select * from tmembers where id='"+id+"' AND password ='"+pwd+"'";       
			ResultSet rs2 = st.executeQuery( query2 );

			if(rs2.next())
			{
				String role = rs2.getString(6);
				type=role;
			}
			else
			{
					
				type= "" ;
					
			}
				
		}			
			
		con.close();

		return type;

	}//method end
	
	
	public String addbook(String bookname, String authorname, String Category, String Price, String Count) throws SQLException
	{	
		String display = null;

			Statement st = con.createStatement();
			
			String query0 = "select * from tbooks where bname ='"+bookname+"' and aname='"+authorname+"'";
			System.out.println(query0);
			ResultSet rs0 = st.executeQuery(query0);
			
			if(rs0.next())
			{				
				String num = rs0.getString(5);
				int dnum = Integer.parseInt(num);
				int paramcnt = Integer.parseInt(Count);
				int fnum = dnum + paramcnt;
								
				String query2="update tbooks set count='"+fnum+"' where bname ='"+bookname+"' and aname ='"+authorname+"'";
				System.out.println(query2);
				int rs2 = st.executeUpdate(query2);
						
				if(rs2 > 0)
				{
					
					display = "<span><i><font color=blue>"+ bookname + "</i></font></span> book is added successfully in rack !";
					
				}				
				
			}
			else
			{
						
				String query = "insert into tbooks(bname,aname,category,price,count) values('"+bookname+"', '"+authorname+"','"+Category+"','"+Price+"','"+Count+"')";
				System.out.println(query);
				int rs = st.executeUpdate(query);

				if (rs > 0) 
				{
					display = "<span><i><font color=blue>"+ bookname + "</i></font></span> book is added successfully in rack !";
					
				}
				
			}

			con.close();


		return display;

	}//addbook method end
	
	
	public String addmember(String firstname,String lastname,String gndr,String ID,String sem,String type,String pwd) throws SQLException
	{	
		String display = null;

			Statement st = con.createStatement();
			
			String query0 = "select * from tmembers where id ='"+ID+"' and semester ='"+sem+"'";
			System.out.println(query0);
			ResultSet rs0 = st.executeQuery(query0);

			if (rs0.next())
			{
				String query2="update tmembers set password='"+pwd+"' where id ='"+ID+"' and semester ='"+sem+"'";
				System.out.println(query2);
				int rs2 = st.executeUpdate(query2);
						
				if(rs2 > 0)
				{
					display = "<span><i><font color=blue>"+ firstname + " ( "+ID+" ) </i></font></span>is added as member of Library Successfully ! " ;
				}
			}
			else
			{			
				String query = "insert into tmembers(fname,lname,gender,id,semester,role,password) values('"+firstname+"', '"+lastname+"','"+gndr+"','"+ID+"','"+sem+"','"+type+"','"+pwd+"')";
				System.out.println(query);
				int rs = st.executeUpdate(query);

				if (rs > 0) 
				{
					display = "<span><i><font color=blue>"+ firstname + " ( "+ID+" ) </i></font></span>is added as member of Library Successfully ! " ;
				}
				
			}
			con.close();

		
		return display;

	}//method end
		
	
	
	public String deletemember(String firstname,String lastname,String ID,String sem) throws SQLException
	{	
		String display = null;

			Statement st = con.createStatement();
			String query = "delete from tmembers where id ='"+ID+"' and semester ='"+sem+"'";
			System.out.println(query);
			int rs = st.executeUpdate(query);

			if (rs > 0) 
			{
				display="<span><i><font color=blue>"+ firstname + " " + lastname + " ( "+ID+" ) </i></font></span>, student of <span><i><font color=blue>"+sem+"</i></font></span> semester is removed as member of Library " ;
	
			}
			else
			{
				display = "<h3 align=center>He/She is already not member of Library!</h3>";
			}

			con.close();

		return display;

	}//method end
	
	
	
	public String issuebook(String bookname,String authorname,String Category,String pname,String ID,String issuedate,String returndate) throws SQLException
	{	
		String display = null;

			Statement st = con.createStatement();			
			
			String query0="Select * from tbooks where bname ='"+bookname+"' and aname ='"+authorname+"'";
			System.out.println(query0);
  			ResultSet rs0 = st.executeQuery( query0 );
			
			if(rs0.next())
			{
				String dbcount = rs0.getString(5);
				int num=Integer.parseInt(dbcount);
				
				if(num>0)
				{

					String query="insert into tissues(bname,aname,category,person,id,issue_date,return_date) values('"+bookname+"', '"+authorname+"','"+Category+"','"+pname+"','"+ID+"','"+issuedate+"','"+returndate+"')";
					System.out.println(query);
					int rs = st.executeUpdate(query);
				   
					if(rs > 0)
					{
						
						int agnum = num-1;
						String query2="update tbooks set count='"+agnum+"' where bname ='"+bookname+"' and aname ='"+authorname+"'";
						System.out.println(query2);
						int rs2 = st.executeUpdate(query2);
								
						
						if(rs2 > 0)
						{
							display = bookname+" by "+authorname+" is removed from rack</br>And</br>"+bookname+" Book is issued to "+pname+" ( "+ID+" ) till "+returndate;
						}
						
					
					}
					
				}
				
			}
		
			con.close();

		return display;

	}//issuebook method end
	
	
	
	public ArrayList viewissuebk() throws SQLException
	{	
		projectbean b = null;
		ArrayList<projectbean>  al =new ArrayList<projectbean> ();	

		String bookname ;
		String authorname ;
		String Category ;
		String pname ;
		String ID ;
		String issuedate ;
		String returndate ;
		
			Statement st = con.createStatement();		
			
			String query="Select * from tissues ";
			System.out.println(query);
  			ResultSet rs = st.executeQuery( query );
					
			while(rs.next())
			{
				b=new projectbean();
				
				bookname = rs.getString(1);
				authorname = rs.getString(2);
				Category = rs.getString(3);
				pname = rs.getString(4);
				ID = rs.getString(5);
				issuedate = rs.getString(6);
				returndate = rs.getString(7);
				
				b.setbname(bookname);
				b.setaname(authorname);
				b.setcategory(Category);
				b.settoname(pname);
				b.setid(ID);
				b.setidate(issuedate);
				b.setrdate(returndate);
				
				al.add(b);
				
			}
			
			con.close();
			
		return al;

	}//method end
										
	
	
	public ArrayList viewbooks() throws SQLException
	{	
		projectbean b = null;
		ArrayList<projectbean>  al =new ArrayList<projectbean> ();
		
		String bookname ;
		String authorname ;
		String Category ;
		String Cost ;
		String Count ;
	
			Statement st = con.createStatement();		
			
			String query="Select * from tbooks ";
			System.out.println(query);
  			ResultSet rs = st.executeQuery( query );
					
			while(rs.next())
			{	
				b=new projectbean();
		
				bookname = rs.getString(1);
				authorname = rs.getString(2);
				Category = rs.getString(3);
				Cost = rs.getString(4);
				Count = rs.getString(5);
				
				
				b.setbname(bookname);
				b.setaname(authorname);
				b.setcategory(Category);
				b.setprice(Cost);
				b.setcount(Count);
				
				al.add(b);
				
			}
			
			con.close();

		return al;

	}//method end
			
							
	
	public ArrayList viewreceipt(String identifier)  throws SQLException
	{	
		String tuple = null;
		ArrayList<String>  al =new ArrayList<String> ();	

		String bookname ;
		String authorname ;
		String Category ;
		String pname ;
		String ID ;
		String issuedate ;
		String returndate ;

			Statement st = con.createStatement();		
			
			String query="Select * from tissues where id='"+identifier+"'";
			System.out.println(query);
  			ResultSet rs = st.executeQuery( query );
					
			while(rs.next())
			{
				
				bookname = rs.getString(1);
				authorname = rs.getString(2);
				Category = rs.getString(3);
				pname = rs.getString(4);
				ID = rs.getString(5);
				issuedate = rs.getString(6);
				returndate = rs.getString(7);
				
				tuple="<p><ul align=center ><li>Book_name:"+bookname+" </li>  <li>Author_name:"+authorname+" </li> <li>Category:"+Category+" </li> <li>Member_ID:"+ID+" </li> <li>Issue_Date:"+issuedate+" </li> <li>Return_Date:"+returndate+" </li></ul></p>";
				
				al.add(tuple);
				
			}
			
			con.close();

		return al;

	}//method end
	
	
	
	public String removebook(String bookname,String authorname,String Count,String Row) throws SQLException
	{	
		String display = null;

			Statement st = con.createStatement();	
			
			String query="Select * from tbooks where bname ='"+bookname+"' and aname ='"+authorname+"'";
			System.out.println(query);
  			ResultSet rs = st.executeQuery( query );
			if(rs.next())
			{
				String dbcount = rs.getString(5);
				int num=Integer.parseInt(dbcount);
				//int ncount=Integer.parseInt(Count);              //count of books in decimal
				
				//int fc=num-ncount;
				if(Count.equals("") && Row.equals("all"))
				{	
					String query2="delete from tbooks where bname ='"+bookname+"' and aname ='"+authorname+"'";
					System.out.println(query2);
					int rs2 = st.executeUpdate(query2);
	   
					if(rs2 > 0)
					{
						
						display = "All books of title "+bookname+" by author "+authorname+" is deleted!</br>";
						//bi=new bookinfo(bookname,authorname,Count,Row,2);
						
					}
					
				}
				else   //jab count negative ni aur check box bhi ni
				{			
					int ncount=Integer.parseInt(Count);
					int fc=num-ncount;
					
					if(fc>0)
					{
					
						String query3="update tbooks set count='"+fc+"' where bname ='"+bookname+"' and aname ='"+authorname+"'";
						System.out.println(query3);
						int rs3 = st.executeUpdate(query3);
				
						if(rs3 > 0)
						{
							display=Count+" books of title "+bookname+" by "+authorname+" are removed.";
							//bi=new bookinfo(bookname,authorname,Count,Row,1);
							
						}	
					
					}
					else if(fc==0)
					{			
						String query4="delete from tbooks where bname ='"+bookname+"' and aname ='"+authorname+"'";
						System.out.println(query4);
						int rs4 = st.executeUpdate(query4);
		   
						if(rs4 > 0)
						{
							display="The count you entered was equivalent to all number of this book </br>So,</br>  Deleted all count of "+bookname+" by author "+authorname+"</br>";
			
							//bi=new bookinfo(bookname,authorname,Count,Row,0);						
						}		
						
					}
					else
					{
						display="ALERT!</br>You entered the count greater than this books in the library</br >If you want to delete all books of this name, go back and repeat the process by selecting the ROW button ";
					
						//bi=new bookinfo(bookname,authorname,Count,Row,-1);
						//tuple= "You entered the count greater than this books in the library </br> Count of this books in libaray is = "+num+" </br> Try count less then this to delete it ";
												
					}
						
				}
				
			}	
			con.close();

		return display;

	}//method end	
	
	
	
	public String returnbook(String bookname,String authorname,String Category,String mem_name,String ID,String rtning_date) throws SQLException
	{	
		String display = null;
		
		
		String token[] = rtning_date.split("/");
	
		String sringd = token[0];
		String sringm = token[1];
		String sringy = token[2];
		
		int dringd = Integer.parseInt(sringd);
		int dringm = Integer.parseInt(sringm);
		int dringy = Integer.parseInt(sringy);
		
		int dfring =dringd+dringm+dringy;
		
			Statement st = con.createStatement();
			
			String query0="Select * from tissues where bname ='"+bookname+"' and id ='"+ID+"'";
			System.out.println(query0);
  			ResultSet rs0 = st.executeQuery( query0 );
			
			if(rs0.next())
			{
				String due_date = rs0.getString(7);
				String token0[] = due_date.split("/");				
				
				String sdd = token0[0];
				String sdm = token0[1];
				String sdy = token0[2];
				
				int ddd = Integer.parseInt(sdd);
				int ddm = Integer.parseInt(sdm);
				int ddy = Integer.parseInt(sdy);
				
				int dfd = ddd+ddm+ddy;
				
				if(dfd<dfring)
				{		
					String query1="Select * from tbooks where bname ='"+bookname+"' and aname ='"+authorname+"'";
					System.out.println(query1);
					ResultSet rs1 = st.executeQuery( query1 );
					
					if(rs1.next())
					{
						String dbcount = rs1.getString(5);
						int num=Integer.parseInt(dbcount);
			
						int agnum = num+1;
						String query2="update tbooks set count='"+agnum+"' where bname ='"+bookname+"' and aname ='"+authorname+"'";
						System.out.println(query2);
						int rs2 = st.executeUpdate(query2);
						
						if(rs2 > 0)
						{							
							String query3="delete from tissues where bname ='"+bookname+"' and id ='"+ID+"'";
							System.out.println(query3);
							int rs3 = st.executeUpdate(query3);
			   
							if(rs3 > 0)
							{
								display = "YOU ARE LATE TO RETURN BOOK !</br> <center><table border=5><th>FINE STATUS</th></table></center> </br> <span><font color=red>PAY FINE : 500 PKR </font></span>!"+"</br>"+mem_name+" ( "+ID+" ) Entry is removed from ISSUE BOOK LIST </br > And </br><center><table border=5><th>BOOK STATUS</th></table></center></br>"+bookname+" by "+authorname+" is added back to collection rack.";
								//bi=new bookinfo(1,bookname,authorname,Category,mem_name,ID,rtning_date);
								
							}
											
						}
						
					}	
					else
					{
						String query4 = "insert into tbooks(bname,aname,category,count) values('"+bookname+"','"+authorname+"','"+Category+"','1')";
						System.out.println(query4);
						int rs4 = st.executeUpdate(query4);

							if (rs4 > 0) 
							{
								String query5="delete from tissues where bname ='"+bookname+"' and id ='"+ID+"'";
								System.out.println(query5);
								int rs5 = st.executeUpdate(query5);
				   
								if(rs5 > 0)
								{
									display = "YOU ARE LATE TO RETURN BOOK !</br> <center><table border=5><th>FINE STATUS</th></table></center> </br> <span><font color=red>PAY FINE : 500 PKR </font></span>!"+"</br>"+mem_name+" ( "+ID+" ) Entry is removed from ISSUE BOOK LIST </br > And </br><center><table border=5><th>BOOK STATUS</th></table></center></br>"+bookname+" by "+authorname+" is added back to collection rack.";
									//bi=new bookinfo(1,bookname,authorname,Category,mem_name,ID,rtning_date);
									
								}
								
							}
				
					}
				
				}
				else
				{					
					String query1="Select * from tbooks where bname ='"+bookname+"' and aname ='"+authorname+"'";
					System.out.println(query1);
					ResultSet rs1 = st.executeQuery( query1 );
					
					if(rs1.next())
					{
						String dbcount = rs1.getString(5);
						int num=Integer.parseInt(dbcount);
				
						int agnum = num+1;
						String query2="update tbooks set count='"+agnum+"' where bname ='"+bookname+"' and aname ='"+authorname+"'";
						System.out.println(query2);
						int rs2 = st.executeUpdate(query2);
						
						if(rs2 > 0)
						{	
							String query3="delete from tissues where bname ='"+bookname+"' and id ='"+ID+"'";
							System.out.println(query3);
							int rs3 = st.executeUpdate(query3);
			   
							if(rs3 > 0)
							{
								display = "YOU ARE ON TIME TO RETURN BOOK !</br> <center><table border=5><th>FINE STATUS</th></table></center> </br> <span><font color=red>PAY FINE : 0 PKR </font></span>!"+"</br>"+mem_name+" ( "+ID+" ) Entry is removed from ISSUE BOOK LIST </br > And </br><center><table border=5><th>BOOK STATUS</th></table></center></br>"+bookname+" by "+authorname+" is added back to collection rack.";
				
								//bi=new bookinfo(0,bookname,authorname,Category,mem_name,ID,rtning_date);
								
							}
							
						}
						
					}	
					else
					{
						String query4 = "insert into tbooks(bname,aname,category,count) values('"+bookname+"','"+authorname+"','"+Category+"','1')";
						System.out.println(query4);
						int rs4 = st.executeUpdate(query4);

						if (rs4 > 0) 
						{	
								String query5="delete from tissues where bname ='"+bookname+"' and id ='"+ID+"'";
								System.out.println(query5);
								int rs5 = st.executeUpdate(query5);
				   
								if(rs5 > 0)
								{
									display = "YOU ARE ON TIME TO RETURN BOOK !</br> <center><table border=5><th>FINE STATUS</th></table></center> </br> <span><font color=red>PAY FINE : 0 PKR </font></span>!"+"</br>"+mem_name+" ( "+ID+" ) Entry is removed from ISSUE BOOK LIST </br > And </br><center><table border=5><th>BOOK STATUS</th></table></center></br>"+bookname+" by "+authorname+" is added back to collection rack.";
				
									//bi=new bookinfo(0,bookname,authorname,Category,mem_name,ID,rtning_date);
									
								}
								
						}
						
					}
					
				} 
			}
			
			con.close();

		return display;

	}//method end
			
	
	public String sersign(String firstname,String lastname,String gndr,String ID,String role,String pwd) throws SQLException
	{	
		String display = null;

			Statement st = con.createStatement();		
			
			String query="insert into tsignup(fname,lname,gender,id,role,password) values('"+firstname+"', '"+lastname+"','"+gndr+"','"+ID+"','"+role+"','"+pwd+"')";
			System.out.println(query);
			int rs = st.executeUpdate(query);
		   
			if(rs > 0)
			{
				display =  "Successfully signed up by " + firstname + " " + lastname +" <span><font color=blue>( "+ID+" )</font></span> as a <span><i><font color= blue>"+role +"</font></i></span>";
	
			}
			else
			{
				display = "<h3 align=center>Error while adding " + firstname + " (" + ID + ") as a <span><font color=blue>"+role+"</font></span> through signup page ! " ;
			}
			
			con.close();

		return display;

	}//method end
		
	
	
	
	
	
	
}