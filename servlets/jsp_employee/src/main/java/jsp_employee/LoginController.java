package jsp_employee;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginController extends HttpServlet{

	EmployeeCrud crud = new EmployeeCrud();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		
		String password = req.getParameter("password");
		
		try {
			String pwd = crud.loginEmployee(email);
			RequestDispatcher dispatcher=null;
			
			if (pwd == null) {
				
				req.setAttribute("message", "Please register!!");
				dispatcher = req.getRequestDispatcher("signup.jsp");
				
				dispatcher.forward(req, resp);
			} else if (pwd.equals(password)) {
				
				Cookie cookie= new Cookie("usrId", email);
				resp.addCookie(cookie);
				
				Cookie cookie2=new Cookie("phone", "9876541230");
				resp.addCookie(cookie2);
				Cookie cookie3 =new Cookie("name", "Dhanu");
				resp.addCookie(cookie3);
				
				
				//Creating HttpSession 
				
				HttpSession httpSession = req.getSession();
				
				httpSession.setAttribute("session", email);
				
				req.setAttribute("list", crud.getInfo());
				//resp.getWriter().print(crud.getInfo());
			
				dispatcher = req.getRequestDispatcher("success.jsp");
				dispatcher.forward(req, resp);
				
			}else {
				req.setAttribute("message", "chutiya hai kya!!sahi sahi bhar");
				dispatcher = req.getRequestDispatcher("login.jsp");
				
				dispatcher.forward(req, resp);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
