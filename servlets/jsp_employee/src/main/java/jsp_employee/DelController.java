package jsp_employee;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/delete")
public class DelController extends HttpServlet{
	EmployeeCrud crud= new EmployeeCrud();
	
	RequestDispatcher dispatcher=new RequestDispatcher() {
		
		@Override
		public void include(ServletRequest request, ServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void forward(ServletRequest request, ServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			
		}
	};
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		
		try {
			int result=crud.delEmp(id);
			if(result!=0) {
				req.setAttribute("list", crud.getInfo());
				
				dispatcher = req.getRequestDispatcher("success.jsp");
				dispatcher.forward(req, resp);
			}
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
