package emp;
import java.sql.*;
public class EmpDemo {

	public static void main(String[] args) {

      Connection con=null;
      
      Statement st=null;
		
		try
		{
			
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","root");
			if(con!=null)
			{
				System.out.println("Connected To Database");
			}
			st=con.createStatement();
			int res=st.executeUpdate("insert into employee values(2,'Don Jam','abc@gmail.com')");
			if(res>=1)
			{
				System.out.println("Inserted");
			}
			
	
		}catch (Exception e) {

e.printStackTrace();
		}
				
	}

}
