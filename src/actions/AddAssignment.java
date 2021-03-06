package actions;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Assessment;
import models.Assignment;
import models.User;

@WebServlet("/actions/AddAssignment")
public class AddAssignment extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		
//		// Get information submitted
		String assignmentName = request.getParameter("assignmentName");
		String assignmentScore = request.getParameter("assignmentScore");
		String assignmentWorth = request.getParameter("assignmentWorth");
		
		String dueDateString = request.getParameter("dueDate");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		Date dueDate = null;
		try {
			dueDate = df.parse(dueDateString);
		} catch (ParseException e) {
			
		}
		
		int semesterId = Integer.parseInt(request.getParameter("semesterId"));
		int courseId = Integer.parseInt(request.getParameter("courseId"));
		int assessmentId = Integer.parseInt(request.getParameter("assessmentId"));
		
		Assessment assessment = user.getSemesters().get(semesterId).getCourses().get(courseId).getAssessments().get(assessmentId);
		
		boolean assignmentIsDone = Boolean.parseBoolean(request.getParameter("isDone"));
		if (assignmentIsDone) {
			assessment.getAssignments().add(new Assignment(assignmentName, Double.parseDouble(assignmentScore), Double.parseDouble(assignmentWorth), dueDate));
		}
		else {
			Assignment newAssignment = new Assignment(assignmentName, 0, 0, dueDate);
			newAssignment.setCompleted(false);
			
			assessment.getAssignments().add(newAssignment);
		}
		
		response.sendRedirect("../main/CoursePage?semesterId=" + semesterId + "&courseId=" + courseId);
	}

}
