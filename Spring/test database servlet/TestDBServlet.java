package testDB;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestDBServlet")
public class TestDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TestDBServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String name = "student";
		String pass = "student";
		String driver = "com.mysql.jdbc.Driver";
		
		try {
			
			PrintWriter out = response.getWriter();
			out.println("Connecting to : " + url);
			
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url, name, pass);
			
			out.println("Success !!");
			
			conn.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new ServletException(ex);
		}
		
		
	}
}
