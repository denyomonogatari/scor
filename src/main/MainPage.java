package main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Semester;
import models.User;

@WebServlet("/main/MainPage")
public class MainPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Get a reference to the session
		HttpSession session = request.getSession();
		
		// Get a reference to the User object stored in the session
		User user = (User) session.getAttribute("user");
		
		// If the User doesn't exist, then they didn't login. So, kick them back to Login
		if (user == null) {
			response.sendRedirect("../auth/Login");
			return;
		}
		
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
		out.println("        <title>Main Page</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		out.println("	<p class=\"text-right\"><a href=\"../auth/Logout\">Logout</a></p>");
		out.println("	<h1 class=\"display-2\">Hello, " + user.getFirst() + "</h1>");
		out.println("	<div class=\"row\">");
		out.println("		<div class=\"col-6\">");
		out.println("			<h2>Semesters</h2>");
		out.println("			<ul>");
		
		ArrayList<Semester> semesters = user.getSemesters();
		for (int i = 0; i < semesters.size(); i++)
			out.println("				<li><a href=\"SemesterPage?semesterId=" + i + "\">" + semesters.get(i).getSeason() + " " + semesters.get(i).getYear() + " " + String.format("%.2f", semesters.get(i).getGPA()) + "</a></li>");
		
		out.println("			</ul>");
		out.println("			<div class=\"row\">");
		out.println("				<div class=\"col\">");
		out.println("					<input type=\"text\" class=\"form-control\" name=\"semester\" placeholder=\"Name of Semester\"> ");
		out.println("				</div>");
		out.println("				<div class=\"col\">");
		out.println("					<input type=\"text\" maxlength=\"4\" class=\"form-control\" name=\"year\" placeholder=\"Year\"> ");
		out.println("				</div>");
		out.println("				<div class=\"col\">");
		out.println("					<a class=\"btn btn-primary\" href=\"#\" role=\"button\">Add Semester</a>");
		out.println("				</div>");
		out.println("			</div>");
		out.println("		</div>");
		out.println("		<div class=\"col-6\">");
		out.println("			<h2>Dates</h2>");
		out.println("			<p>All your upcoming events go here.</p>");
		out.println("		</div>");
		out.println("		<div class=\"col\">");
		out.println("		</div>");
		out.println("	</div>");
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
