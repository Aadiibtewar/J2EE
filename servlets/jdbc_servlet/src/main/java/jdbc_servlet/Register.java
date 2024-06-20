package jdbc_servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/register")

public class Register extends GenericServlet {
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Person person = new Person();
		PersonCrud crud = new PersonCrud();
		
		
		int newId=Integer.parseInt(req.getParameter("id"));
		person.setId(newId);
		
		person.setName(req.getParameter("name"));
		
		
		person.setPhone(req.getParameter("phone"));
		
		person.setAddress(req.getParameter("address"));
		
		person.setEmail(req.getParameter("email"));
		
		person.setPassword((req.getParameter("password")));
		
		
//		res.getWriter().print()
		
	
		int result = 0;
		try {
			result = crud.userSignUp(person);
			if (result!=0) {
				res.getWriter().print("Sign Up Successfully!");
				
			} else 
			{
				res.getWriter().print("SignUp Failed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			res.getWriter().print("something wrong!");
		}
	
	
	}

	
}
