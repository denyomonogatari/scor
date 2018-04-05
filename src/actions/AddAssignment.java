package actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Assessment;
import models.Assignment;
import models.AssignmentType;
import models.User;

@WebServlet("/actions/AddAssignment")
public class AddAssignment extends HttpServlet {
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
		
		int semesterId = Integer.parseInt(request.getParameter("semesterId"));
		int courseId = Integer.parseInt(request.getParameter("courseId"));
		int assessmentId = Integer.parseInt(request.getParameter("assessmentId"));
		
		Assessment assessment = user.getSemesters().get(semesterId).getCourses().get(courseId).getAssessments().get(assessmentId);
		
		String assignmentName = request.getParameter("assignmentName");
		double assignmentScore = Double.parseDouble(request.getParameter("assignmentScore"));
		double assignmentWorth = Double.parseDouble(request.getParameter("assignmentWorth"));
		AssignmentType assignmentType = AssignmentType.valueOf(request.getParameter("assignmentType"));
		
		assessment.getAssignments().add(new Assignment(assignmentName, assignmentScore, assignmentWorth, assignmentType));

		response.sendRedirect("../main/CoursePage?semesterId=" + semesterId + "&courseId=" + courseId);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
