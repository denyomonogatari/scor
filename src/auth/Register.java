package auth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/auth/Register"}, loadOnStartup=1)
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		
    		
    		// Set the content type to HTML
    		response.setContentType("text/html");
    		
    		// Get a Print Writer
    		PrintWriter out = response.getWriter();
    		
    		out.println("<!DOCTYPE html>");		
    		out.println("<html lang=\"en\">");
    		out.println("<head>");
    		out.println("    <meta charset=\"UTF-8\">");
    		out.println("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
    		out.println("        <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">");
    		out.println("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">");
    		out.println("        <title>Register</title>");
    		out.println("</head>");
    		out.println("<body>");
    		out.println("<div class=\"container\">");
    		
    		out.println("<h1 class=\"display-1\">Register</h1>");
    		
    		out.println("<form action=\"Register\" method=\"post\">");
    		out.println("    <div class=\"form-group\">");
    		out.println("        <label for=\"name\">Full Name</label>");
    		out.println("        <input class=\"form-control\" type=\"text\" value=\"\" name=\"name\" id=\"name\" placeholder=\"Enter your first and last names\">");
    		
    		out.println("    </div>");
    		out.println("    <div class=\"form-group\">");
    		out.println("        <label for=\"email\">E-mail Address</label>");
    		out.println("        <input class=\"form-control\" value=\"\" type=\"email\" name=\"email\" id=\"email\" placeholder=\"Enter your e-mail address\">");
    		
    		out.println("    </div>");
    		out.println("    <div class=\"form-group\">");
    		out.println("        <label for=\"password\">Password</label>");
    		out.println("        <input class=\"form-control\" value=\"\" type=\"password\" name=\"password1\" id=\"password1\" placeholder=\"Enter your password\">");
    		
    		out.println("    </div>");
    		out.println("    <div class=\"form-group\">");
    		out.println("        <label for=\"password\">Re-Enter Password</label>");
    		out.println("        <input class=\"form-control\" value=\"\" type=\"password\" name=\"password2\" id=\"password2\" placeholder=\"Re-enter your password\">");
    		out.println("    </div>");
    		out.println("    <div class=\"form-group\">");
    		out.println("        <button type=\"submit\" class=\"btn btn-primary\">Register</button>");
    		out.println("    </div>");
    		out.println("</form>");
    		out.println("<p>Already have an account? <a href=\"Login\">Login</a></p>");
    		
    		
    		out.println("</div>");
    		out.println("</body>");
    		out.println("</html>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
