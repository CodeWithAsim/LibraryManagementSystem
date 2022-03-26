package pk;

import pk.*;
import java.io.*;
import java.sql.*;
import java.util.*; 
import javax.servlet.*;
import javax.servlet.http.*;


public class controller extends HttpServlet 
{ 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException 
	{ 
		processRequest(request, response); 
	} 


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException 
	{ 
		processRequest(request, response); 
	} 

	protected void processRequest(HttpServletRequest request, 
	HttpServletResponse response) throws ServletException, IOException 
	{
		String Action = request.getParameter("action"); 

		if (Action.equals("LogIn") ) 
		{ 
			try
			{
				String id = request.getParameter("id");
				String pwd = request.getParameter("password");
						
				projectdao pdao = new projectdao();
				String role = pdao.getrole(id,pwd);
					
				if (role.equals("admin"))
				{ 
					HttpSession session = request.getSession();
					
					session.setAttribute( "idfs" , id );
					session.setAttribute("rolefs",role);
					

					response.sendRedirect("admin_page.jsp");

				}
				else if(role.equals("member"))
				{
					HttpSession session = request.getSession();
					
					session.setAttribute( "idfs" , id );
					session.setAttribute("rolefs",role);
					
					response.sendRedirect("member_page.jsp");
					
				}
				else
				{
					response.sendRedirect("koiaur.jsp");
				}
			}
			catch (SQLException sqlex){ 

			// setting SQLException instance 
			request.setAttribute("javax.servlet.jsp.JspException" , sqlex);
			RequestDispatcher rd = request.getRequestDispatcher("addbookerror.jsp"); 
			rd.forward(request, response); } 

			catch (ClassNotFoundException cnfe){ 

			 // setting ClassNotFoundException instance 
			request.setAttribute("javax.servlet.jsp.JspException" , cnfe); 
			RequestDispatcher rd = request.getRequestDispatcher("addbokerror.jsp");
			rd.forward(request,response); 
			} 
			
		}
		
		else if (Action.equals("signup")) 
		{ 
			response.sendRedirect("signup.html"); 
		}
		
		else if (Action.equals("login")) 
		{ 
			response.sendRedirect("login.jsp"); 
		}
		
		else if (Action.equals("Add Record") ) 
		{ 
			try
			{
			
				HttpSession session = request.getSession(false);
				String role = session.getAttribute("rolefs").toString();

				String bookname = request.getParameter("bname");
				String authorname = request.getParameter("aname");
				String Category = request.getParameter("category");
				String Price= request.getParameter("price");
				String Count = request.getParameter("count");
				
				if(role.equals("admin"))
				{
					
					projectdao pdao = new projectdao();
					//bookinfo bi = pdao.addbook(bookname,authorname,Category,Price,Count);
					
					String display = pdao.addbook(bookname,authorname,Category,Price,Count);
					
					if (display != null)
					{ 
						request.setAttribute("dekhao", display); 
						RequestDispatcher rd = request.getRequestDispatcher("dekhao.jsp"); 
						rd.forward(request, response); 
					}
					else
					{ 
						response.sendRedirect("nihua.jsp");
					}
					
				}
				else
				{
					response.sendRedirect("koiaur.jsp");
				}

			}
			catch (SQLException sqlex){ 

			// setting SQLException instance 
			request.setAttribute("javax.servlet.jsp.JspException" , sqlex);
			RequestDispatcher rd = request.getRequestDispatcher("addbookerror.jsp"); 
			rd.forward(request, response); } 

			catch (ClassNotFoundException cnfe){ 

			 // setting ClassNotFoundException instance 
			request.setAttribute("javax.servlet.jsp.JspException" , cnfe); 
			RequestDispatcher rd = request.getRequestDispatcher("addbokerror.jsp");
			rd.forward(request,response); 
			} 
					
		}
				
		else if (Action.equals("Add") ) 
		{ 
			try
			{
		
				HttpSession session = request.getSession(false);
				String role = session.getAttribute("rolefs").toString();

				String firstname = request.getParameter("fname");
				String lastname = request.getParameter("lname");
				String gndr = request.getParameter("gender");
				String ID= request.getParameter("id");
				String sem = request.getParameter("semester");
				
				
				String type = request.getParameter("role");
				String pwd = request.getParameter("password");
				
				
				if(role.equals("admin"))
				{
				
					projectdao pdao = new projectdao();
					String display = pdao.addmember(firstname,lastname,gndr,ID,sem,type,pwd);
					
					if (display != null)
					{ 
						request.setAttribute("dekhao", display); 
						RequestDispatcher rd = request.getRequestDispatcher("dekhao.jsp"); 
						rd.forward(request, response); 
					}
					else
					{ 
						response.sendRedirect("nihua.jsp");
					}
					
				}
				else
				{
					response.sendRedirect("koiaur.jsp");
				}
		
			}
			catch (SQLException sqlex){ 

			// setting SQLException instance 
			request.setAttribute("javax.servlet.jsp.JspException" , sqlex);
			RequestDispatcher rd = request.getRequestDispatcher("addbookerror.jsp"); 
			rd.forward(request, response); } 

			catch (ClassNotFoundException cnfe){ 

			 // setting ClassNotFoundException instance 
			request.setAttribute("javax.servlet.jsp.JspException" , cnfe); 
			RequestDispatcher rd = request.getRequestDispatcher("addbokerror.jsp");
			rd.forward(request,response); 
			} 
						
			
		}
		
		else if (Action.equals("Delete It") ) 
		{ 
			try
			{
				
				HttpSession session = request.getSession(false);
				String role = session.getAttribute("rolefs").toString();

				String firstname = request.getParameter("fname");
				String lastname = request.getParameter("lname");
				String ID= request.getParameter("id");
				String sem = request.getParameter("semester");
				
				if(role.equals("admin"))
				{
					projectdao pdao = new projectdao();
					String display = pdao.deletemember(firstname,lastname,ID,sem);
					
					
					request.setAttribute("dekhao", display); 
					RequestDispatcher rd = request.getRequestDispatcher("dekhao.jsp"); 
					rd.forward(request, response); 
				
				}
				else
				{
					response.sendRedirect("koiaur.jsp");
				}
				
				
				
			}
			catch (SQLException sqlex){ 

			// setting SQLException instance 
			request.setAttribute("javax.servlet.jsp.JspException" , sqlex);
			RequestDispatcher rd = request.getRequestDispatcher("addbookerror.jsp"); 
			rd.forward(request, response); } 

			catch (ClassNotFoundException cnfe){ 

			 // setting ClassNotFoundException instance 
			request.setAttribute("javax.servlet.jsp.JspException" , cnfe); 
			RequestDispatcher rd = request.getRequestDispatcher("addbokerror.jsp");
			rd.forward(request,response); 
			} 
			
		}			
				
		else if (Action.equals("Issue Book") ) 
		{ 
			try
			{
				
				HttpSession session = request.getSession(false);
				String role = session.getAttribute("rolefs").toString();

				String bookname = request.getParameter("bname");
				String authorname = request.getParameter("aname");
				String Category = request.getParameter("category");
				String pname= request.getParameter("toname");
				String ID = request.getParameter("id");
				String issuedate = request.getParameter("idate");
				String returndate = request.getParameter("rdate");
				
				if(role.equals("admin"))
				{
					projectdao pdao = new projectdao();
					String display = pdao.issuebook(bookname,authorname,Category,pname,ID,issuedate,returndate);
					
					if (display != null)
					{ 
						request.setAttribute("dekhao", display); 
						RequestDispatcher rd = request.getRequestDispatcher("dekhao.jsp"); 
						rd.forward(request, response); 
					}
					else
					{ 
						response.sendRedirect("rissue.jsp");
					}
					
				}
				else
				{
					response.sendRedirect("koiaur.jsp");
				}
				
				
				
			}
			catch (SQLException sqlex){ 

			// setting SQLException instance 
			request.setAttribute("javax.servlet.jsp.JspException" , sqlex);
			RequestDispatcher rd = request.getRequestDispatcher("addbookerror.jsp"); 
			rd.forward(request, response); } 

			catch (ClassNotFoundException cnfe){ 

			 // setting ClassNotFoundException instance 
			request.setAttribute("javax.servlet.jsp.JspException" , cnfe); 
			RequestDispatcher rd = request.getRequestDispatcher("addbokerror.jsp");
			rd.forward(request,response); 
			} 
					
		}
		
		else if (Action.equals("addbook")) 
		{ 
			response.sendRedirect("addbook.jsp"); 
		}
		
		else if (Action.equals("removebook")) 
		{ 
			response.sendRedirect("removebook.jsp"); 
		}
		
		else if (Action.equals("addmember")) 
		{ 
			response.sendRedirect("addmember.jsp"); 
		}
		
		else if (Action.equals("deletemember")) 
		{ 
			response.sendRedirect("deletemember.jsp"); 
		}
		
		else if (Action.equals("issuebook")) 
		{ 
			response.sendRedirect("issuebook.jsp"); 
		}
		
		else if (Action.equals("viewissuebk")) 
		{ 
			try
			{
							
				HttpSession session = request.getSession(false);
				String role = session.getAttribute("rolefs").toString();
				
				if(role.equals("admin"))
				{
					projectdao pdao = new projectdao();
					ArrayList<projectbean> al=null;
					al = pdao.viewissuebk();

					//out.println("<html><body><center><table border=5><th>LIST OF ISSUED BOOKS TO MEMBERS WITH COMPLETE BIO-DATA</th></table></center></br></br></br></br>");

					if (al.size()>0)
					{ 
						request.setAttribute("bks", al); 

						RequestDispatcher rd = request.getRequestDispatcher("rviewissuebk.jsp"); 
						rd.forward(request, response); 
						
					}
					else
					{ 
						response.sendRedirect("nobooks.jsp");
						//out.println("<h3 align=center>Error : No books in issue book list ! No one has issued any book in past ! </h3>"); 
					}
								
				}
				else
				{
					response.sendRedirect("koiaur.jsp");
				}
		
			}
			catch (SQLException sqlex){ 

			// setting SQLException instance 
			request.setAttribute("javax.servlet.jsp.JspException" , sqlex);
			RequestDispatcher rd = request.getRequestDispatcher("addbookerror.jsp"); 
			rd.forward(request, response); } 

			catch (ClassNotFoundException cnfe){ 

			 // setting ClassNotFoundException instance 
			request.setAttribute("javax.servlet.jsp.JspException" , cnfe); 
			RequestDispatcher rd = request.getRequestDispatcher("addbokerror.jsp");
			rd.forward(request,response); 
			} 
		
		}
		
		else if (Action.equals("returnbook")) 
		{ 
			response.sendRedirect("returnbook.jsp"); 
		}		
			
		else if (Action.equals("serout")) 
		{ 
			
				HttpSession session = request.getSession(false);
		
				String role = session.getAttribute("rolefs").toString();
				String id = session.getAttribute("idfs").toString();
				
				System.out.println(id);
				System.out.println(role);
					
				session.invalidate();
				
				response.sendRedirect("login.jsp");
					
		
		}
		
		else if (Action.equals("member_page")) 
		{ 
			response.sendRedirect("member_page.jsp"); 
		}	
		
		else if (Action.equals("viewbooks")) 
		{ 
			try
			{		
				HttpSession session = request.getSession(false);
				String role = session.getAttribute("rolefs").toString();
				
				String bookname ;
				String authorname ;
				String Category ;
				String Cost ;
				String Count ;
				
										   // admin bhi accesss kr sakta hai aur member bhi ... lakin direct ni by url
														
				if(role.equals("admin") || role.equals("member"))
				{		
					projectdao pdao = new projectdao();
					ArrayList<projectbean> al=null;
					al = pdao.viewbooks();
					
					if (al.size()>0)
					{ 
						request.setAttribute("bks", al); 

						RequestDispatcher rd = request.getRequestDispatcher("rviewbooks.jsp"); 
						rd.forward(request, response); 
						
					}
					else
					{ 
						response.sendRedirect("nobooks.jsp");
						//out.println("<h3 align=center>Error : No books in issue book list ! No one has issued any book in past ! </h3>"); 
					}
								
				}
				
				else
				{
					response.sendRedirect("koiaur.jsp");
				}						
	
			}
			catch (SQLException sqlex){ 

			// setting SQLException instance 
			request.setAttribute("javax.servlet.jsp.JspException" , sqlex);
			RequestDispatcher rd = request.getRequestDispatcher("addbookerror.jsp"); 
			rd.forward(request, response); } 

			catch (ClassNotFoundException cnfe){ 

			 // setting ClassNotFoundException instance 
			request.setAttribute("javax.servlet.jsp.JspException" , cnfe); 
			RequestDispatcher rd = request.getRequestDispatcher("addbokerror.jsp");
			rd.forward(request,response); 
			} 
		
		}
		
		else if (Action.equals("viewreceipt")) 
		{ 
			try
			{
		
				HttpSession session = request.getSession(false);
	
				String identifier = session.getAttribute("idfs").toString();
				String role = session.getAttribute("rolefs").toString();
				
				if(role.equals("member"))
				{
					projectdao pdao = new projectdao();
					ArrayList<String> al = null;
					al = pdao.viewreceipt(identifier);

					//out.println("<html><body></br></br></br></br><center><table border=5><th>RECEIPT</th></table></center></br></br></br></br>");

					if (al.size()>0)
					{ 
						//out.println("<hr>");
						request.setAttribute("rec", al); 

						RequestDispatcher rd = request.getRequestDispatcher("rviewreceipt.jsp"); 
						rd.forward(request, response); 
						
					}
					else
					{ 
						response.sendRedirect("noreceipt.jsp");
						//out.println("<h3 align=center>Error : You have issued no book yet . No record found with your identity ! </h3>"); 
					}
					
				}
				else
				{
					response.sendRedirect("koiaur.jsp");
				}
			
			}
			catch (SQLException sqlex){ 

			// setting SQLException instance 
			request.setAttribute("javax.servlet.jsp.JspException" , sqlex);
			RequestDispatcher rd = request.getRequestDispatcher("addbookerror.jsp"); 
			rd.forward(request, response); } 

			catch (ClassNotFoundException cnfe){ 

			 // setting ClassNotFoundException instance 
			request.setAttribute("javax.servlet.jsp.JspException" , cnfe); 
			RequestDispatcher rd = request.getRequestDispatcher("addbokerror.jsp");
			rd.forward(request,response); 
			} 
		
		}
		
		else if (Action.equals("Confirm")) 
		{ 
			try
			{		
				String bookname = request.getParameter("bname");
				String authorname = request.getParameter("aname");
				String Count = request.getParameter("count");
				
				//int ncount=Integer.parseInt(Count);              //count of books in decimal
				
				String Row= request.getParameter("row");           //if check box
				
				HttpSession session = request.getSession(false);
				String role = session.getAttribute("rolefs").toString();
				
				//jo bhi kam krna is mai krna 
				if(role.equals("admin"))
				{
					projectdao pdao = new projectdao();
					String display = pdao.removebook(bookname,authorname,Count,Row);
					
					//out.println("<html><body><center><table border=5><th>Remove Book Status</th></table></center>");
					
					if (display != null)
					{ 
						request.setAttribute("dekhao", display); 
						RequestDispatcher rd = request.getRequestDispatcher("dekhao.jsp"); 
						rd.forward(request, response); 
						
						//out.println("<h3 align=center>"+ bi.removebooksuccess() +"</h3>" );
					}
					else
					{
						response.sendRedirect("rrmvbk.jsp");
						//out.println("<h3 align=center>Book of this name and by author is already not a part of Library ! </h3>" );
					}
					
				}
				else
				{
					response.sendRedirect("koiaur.jsp");
				}
						
			}
			catch (SQLException sqlex){ 

			// setting SQLException instance 
			request.setAttribute("javax.servlet.jsp.JspException" , sqlex);
			RequestDispatcher rd = request.getRequestDispatcher("addbookerror.jsp"); 
			rd.forward(request, response); } 

			catch (ClassNotFoundException cnfe){ 

			 // setting ClassNotFoundException instance 
			request.setAttribute("javax.servlet.jsp.JspException" , cnfe); 
			RequestDispatcher rd = request.getRequestDispatcher("addbokerror.jsp");
			rd.forward(request,response); 
			} 
		
		}
		else if (Action.equals("Return Book")) 
		{ 
			try
			{
				HttpSession session = request.getSession(false);
				String role = session.getAttribute("rolefs").toString();

				String bookname = request.getParameter("bname");
				String authorname = request.getParameter("aname");
				String Category = request.getParameter("category");
				String mem_name= request.getParameter("mname");
				String ID = request.getParameter("id");
				String rtning_date = request.getParameter("ringdate");

				if(role.equals("admin"))
				{					
					projectdao pdao = new projectdao();
					String display = pdao.returnbook(bookname,authorname,Category,mem_name,ID,rtning_date);
					
					if (display != null)
					{ 
						request.setAttribute("dekhao", display); 
						RequestDispatcher rd = request.getRequestDispatcher("dekhao.jsp"); 
						rd.forward(request, response); 
						
					}
					else
					{
						response.sendRedirect("nihua.jsp");			
					}

				}
				else
				{
					response.sendRedirect("koiaur.jsp");
				}		
		
			}
			catch (SQLException sqlex){ 

			// setting SQLException instance 
			request.setAttribute("javax.servlet.jsp.JspException" , sqlex);
			RequestDispatcher rd = request.getRequestDispatcher("addbookerror.jsp"); 
			rd.forward(request, response); } 

			catch (ClassNotFoundException cnfe){ 

			 // setting ClassNotFoundException instance 
			request.setAttribute("javax.servlet.jsp.JspException" , cnfe); 
			RequestDispatcher rd = request.getRequestDispatcher("addbokerror.jsp");
			rd.forward(request,response); 
			} 
		
		}
		
		else if (Action.equals("Signup")) 
		{ 
			try
			{	
				String firstname = request.getParameter("fname");
				String lastname = request.getParameter("lname");
				String gndr = request.getParameter("gender");
				String ID= request.getParameter("id");
				String role = request.getParameter("role");
				String pwd= request.getParameter("password");
				
				projectdao pdao = new projectdao();
				String display = pdao.sersign(firstname,lastname,gndr,ID,role,pwd);
					
				request.setAttribute("dekhao", display); 
				RequestDispatcher rd = request.getRequestDispatcher("dekhao.jsp"); 
				rd.forward(request, response); 
		
			}
			catch (SQLException sqlex){ 

			// setting SQLException instance 
			request.setAttribute("javax.servlet.jsp.JspException" , sqlex);
			RequestDispatcher rd = request.getRequestDispatcher("addbookerror.jsp"); 
			rd.forward(request, response); } 

			catch (ClassNotFoundException cnfe){ 

			 // setting ClassNotFoundException instance 
			request.setAttribute("javax.servlet.jsp.JspException" , cnfe); 
			RequestDispatcher rd = request.getRequestDispatcher("addbokerror.jsp");
			rd.forward(request,response); 
			} 
		
		}	
		
		
		
		
	}
	
}