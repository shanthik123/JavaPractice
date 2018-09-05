package emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		// take the data From UI
		
		String fullname=request.getParameter("fname");
		String username=request.getParameter("uname");
		String pass=request.getParameter("pass");
		
		Long accNo=Long.parseLong(request.getParameter("acc"));
		
		Long custid=Long.parseLong(request.getParameter("cust"));
		
		String email=request.getParameter("email");
	 Long mobile=Long.parseLong(request.getParameter("mobile"));
		String address=request.getParameter("add");

		try
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bank", "root","root");
			
			PreparedStatement ps=conn.prepareStatement("insert into customer values(?,?,?,?,?,?,?,?)");
			
			ps.setString(1,fullname);
			
			ps.setString(2, username);
			ps.setString(3, pass);
			ps.setLong(4, accNo);
			ps.setLong(5, custid);
			ps.setString(6, email);
			ps.setLong(7,mobile);
			
			ps.setString(8, address);

			
			
			
			
	 int res	=	ps.executeUpdate();

	 if(res==1)
	 {
		 out.println(custid+" You Are Registered Successfully");
		 
		 RequestDispatcher rd=request.getRequestDispatcher("CustomerRegistration.html");
		 
		 rd.include(request, response);
		 
	 }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
