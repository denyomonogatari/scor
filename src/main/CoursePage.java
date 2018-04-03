package main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.User;

@WebServlet("/main/CoursePage")
public class CoursePage extends HttpServlet {
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
		out.println("        <title>Course Page</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		out.println("<p class=\"text-right\"><a href=\"../auth/Logout\">Logout</a></p>");
		out.println("<h1 class=\"display-2\">Hello, " + user.getFirst() + "</h1>");
		out.println("<div class=\"row\">");
		out.println("	<div class=\"col-12\">");
		
		int semesterId = Integer.parseInt(request.getParameter("semesterId"));
		int courseId = Integer.parseInt(request.getParameter("courseId"));
		
		out.println("		<h2>" + user.getSemesters().get(semesterId).getCourses().get(courseId).getName() + "</h2>");
		out.println("		<h2>Percent: <strong>" + String.format("%.2f", user.getSemesters().get(semesterId).getCourses().get(courseId).getPercentEarned()) + "%</strong></h2>");
		out.println("		<h2>Grade: <strong>" + user.getSemesters().get(semesterId).getCourses().get(courseId).getGrade() + "</strong></h2>");

		for (int i = 0; i < user.getSemesters().get(semesterId).getCourses().get(courseId).getAssessments().size(); i++) {
			out.println("<h3>" + user.getSemesters().get(semesterId).getCourses().get(courseId).getAssessments().get(i).getType() + " " + String.format("%.2f %%", user.getSemesters().get(semesterId).getCourses().get(courseId).getAssessments().get(i).getScore()) + " out of " + user.getSemesters().get(semesterId).getCourses().get(courseId).getAssessments().get(i).getWorth() + "%</h3>");
			out.println("	<table class=\"table\">");
			out.println("<tr>");
			out.println("<th>Name</th>");
			out.println("<th>Score</th>");
			out.println("<th>Worth</th>");
			out.println("<th>Options</th>");
			out.println("</tr>");
			for (int j = 0; j <  user.getSemesters().get(semesterId).getCourses().get(courseId).getAssessments().get(i).getAssignments().size(); j++) {
				out.println("	<tr>");
				out.println("		<td>" + user.getSemesters().get(semesterId).getCourses().get(courseId).getAssessments().get(i).getAssignments().get(j).getName() + "</td>");
				out.println("		<td>" + user.getSemesters().get(semesterId).getCourses().get(courseId).getAssessments().get(i).getAssignments().get(j).getScore() + "</td>");
				out.println("		<td>" + user.getSemesters().get(semesterId).getCourses().get(courseId).getAssessments().get(i).getAssignments().get(j).getTotal() + "</td>");
				out.println("		<td>");
				out.println("			<a class=\"btn btn-primary btn-secondary\" href=\"#\" role=\"button\">Edit</a> <a class=\"btn btn-primary btn-danger\" href=\"#\" role=\"button\">Delete</a>");
				out.println("		</td>");
				out.println("	</tr>");
			}
			out.println("<tr>");
			out.println("	<td><input type=\"text\" class=\"form-control\" name=\"name\" placeholder=\"Name of Assignment\"></td>");
			out.println("	<td><input type=\"text\" class=\"form-control\" name=\"score\" placeholder=\"Your Score\"></td>");
			out.println("	<td><input type=\"text\" class=\"form-control\" name=\"worth\" placeholder=\"Worth\"></td>");
			out.println("	<td><a class=\"btn btn-primary\" href=\"#\" role=\"button\">Add</a></td>");
			out.println("</tr>");
			out.println("	</table>");
			
		}

		out.println("</div>");

		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}