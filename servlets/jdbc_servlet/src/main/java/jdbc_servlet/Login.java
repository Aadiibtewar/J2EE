package jdbc_servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/login")
public class Login 	extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PersonCrud crud= new PersonCrud();
		
		String email=req.getParameter("loginEmail");
		String password=req.getParameter("loginPassword");
		
		try {
			String dbPassword=crud.getPassword(email);
			if(dbPassword!=null) {
				if(dbPassword.equals(password)) {
					res.getWriter().print("Login Successfull!");
				}
				else {
					res.getWriter().print("invalid password");
				}
			}
			else {
				res.getWriter().print("user not found!");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			res.getWriter().print("Exception Occurd!!");
		}
		
		
	}

	
}
