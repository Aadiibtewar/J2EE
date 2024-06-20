package jsp_employee;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signUp")
public class SignUpController extends HttpServlet{

	Employee employee = new Employee();
	
	EmployeeCrud crud = new EmployeeCrud();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		employee.setId(Integer.parseInt(req.getParameter("id")));
		employee.setName(req.getParameter("name"));
		employee.setPhone(Long.parseLong(req.getParameter("phone")));
		employee.setEmail(req.getParameter("email"));
		employee.setDesignation(req.getParameter("designation"));
		employee.setSalary(Double.parseDouble(req.getParameter("salary")));
		employee.setPassword(req.getParameter("password"));
		
		try {
			int result = crud.signUpEmployee(employee);
			
			if (result!=0) {
				
				req.setAttribute("message", "beta! signup to ho gaya ab login kar");
				
				RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
				
				dispatcher.forward(req, resp);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
