package actions;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Assessment;
import models.Assignment;
import models.Course;
import models.Semester;
import models.User;

@WebServlet("/actions/EditAssignment")
public class EditAssignment extends HttpServlet {
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
		out.println("	<div class=\"container\">");
		out.println("		<p class=\"text-right\"><a href=\"../auth/Logout\">Logout</a></p>");
		out.println("		<h1 class=\"display-2\">Hello, " + user.getFirst() + "</h1>");
		out.println("		<div class=\"row\">");
		out.println("			<div class=\"col-12\">");

		int semesterId = Integer.parseInt(request.getParameter("semesterId"));
		int courseId = Integer.parseInt(request.getParameter("courseId"));

		int assessmentId = Integer.parseInt(request.getParameter("assessmentId"));
		int assignmentId = Integer.parseInt(request.getParameter("assignmentId"));

		Assignment assignmentToEdit = user.getSemesters().get(semesterId).getCourses().get(courseId).getAssessments().get(assessmentId).getAssignments().get(assignmentId);

		out.println("				<table class=\"table\">");
		out.println("					<tr>");
		out.println("						<th>Name</th>");
		out.println("						<th>Score</th>");
		out.println("						<th>Worth</th>");
		out.println("						<th>Options</th>");
		out.println("					</tr>");
		out.println("					<form method=\"post\">");
		out.println("							<input type=\"hidden\" name=\"semesterId\" value=\"" + semesterId + "\">");
		out.println("							<input type=\"hidden\" name=\"courseId\" value=\"" + courseId + "\">");
		out.println("							<input type=\"hidden\" name=\"assessmentId\" value=\"" + assessmentId + "\">");
		//		out.println("<input type=\"hidden\" name=\"assignmentType\" value=\"" + assignmentType + "\">");
		out.println("					<tr>");
		out.println("						<td><input type=\"text\" class=\"form-control\" name=\"assignmentName\" value=\"" + assignmentToEdit.getName() + "\" placeholder=\"Name of Assignment\"></td>");
		out.println("						<td><input type=\"text\" class=\"form-control\" name=\"assignmentScore\" value=\"" + assignmentToEdit.getScore() + "\" placeholder=\"Score\"></td>");
		out.println("						<td><input type=\"text\" class=\"form-control\" name=\"assignmentWorth\" value=\"" + assignmentToEdit.getTotal() + "\"placeholder=\"Worth\"></td>");
		out.println("						<td><input type=\"submit\" class=\"btn btn-primary\" value=\"Save\" ></td>");
		out.println("					</tr>");
		out.println("					</form>");
		out.println("				</table>");

		out.println("		</div>");

		out.println("	</div>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Get a reference to the session
		HttpSession session = request.getSession();

		// Get a reference to the User object stored in the session
		User user = (User) session.getAttribute("user");

		// If the User doesn't exist, then they didn't login. So, kick them back to Login
		if (user == null) {
			response.sendRedirect("../auth/Login");
			return;
		}

		// Get information submitted
		String assignmentName = request.getParameter("assignmentName");
		String assignmentScore = request.getParameter("assignmentScore");
		String assignmentWorth = request.getParameter("assignmentWorth");
		
		int semesterId = Integer.parseInt(request.getParameter("semesterId"));
		int courseId = Integer.parseInt(request.getParameter("courseId"));

		int assessmentId = Integer.parseInt(request.getParameter("assessmentId"));
		int assignmentId = Integer.parseInt(request.getParameter("assignmentId"));
		
		Assignment assignmentToEdit = user.getSemesters().get(semesterId).getCourses().get(courseId).getAssessments().get(assessmentId).getAssignments().get(assignmentId);
		assignmentToEdit.setName(assignmentName);
		assignmentToEdit.setScore(Double.parseDouble(assignmentScore));
		assignmentToEdit.setTotal(Double.parseDouble(assignmentWorth));
		
		response.sendRedirect("../main/CoursePage?semesterId=" + semesterId + "&courseId=" + courseId);
	}

}
