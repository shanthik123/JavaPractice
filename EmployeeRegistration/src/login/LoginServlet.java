package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// set response type
		
		
		response.setContentType("text/html");
		
		//get the input
		
		
		String name=request.getParameter("name");
		
		String pass=request.getParameter("pass");
		
	PrintWriter out=response.getWriter();
		
		//  register the driver
		try
		{
			
			Class.forName("com.mysql.cj.jdbc.Driver");

			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
			
			
			PreparedStatement ps=con.prepareStatement("select * from customer where username=? and password=?");
			ps.setString(1,name);
			ps.setString(2, pass);
		ResultSet rs=	ps.executeQuery();
		
		if(rs.next())
		{
		out.println("Welcome ,"+name.toUpperCase());
		}
		else
		{
			out.println("Invalid Username AND password");
		}
		
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
