package actions;

import java.io.IOException;
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
import models.User;

@WebServlet("/actions/EditAssessment")
public class EditAssessment extends HttpServlet {
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

		int semesterId = Integer.parseInt(request.getParameter("semesterId"));
		int courseId = Integer.parseInt(request.getParameter("courseId"));
		int assessmentId = Integer.parseInt(request.getParameter("assessmentId"));

		Course course = user.getSemesters().get(semesterId).getCourses().get(courseId);
		Assessment assessmentToEdit = user.getSemesters().get(semesterId).getCourses().get(courseId).getAssessments().get(assessmentId); // Find assessment to edit
		ArrayList<Assignment> assignments = assessmentToEdit.getAssignments();
		
		// Get information submitted
		String assessmentType = request.getParameter("assessmentType");
		String assessmentWorth = request.getParameter("assessmentWorth");
		
		Assessment assessmentCopy = new Assessment(assessmentType, Double.parseDouble(assessmentWorth));
		for (Assignment assignment : assignments) 
			assessmentCopy.addAssignment(assignment);
		
		course.removeAssessment(assessmentToEdit);
		course.addAssessment(assessmentCopy);
		
		response.sendRedirect("../main/CoursePage?semesterId=" + semesterId + "&courseId=" + courseId);
	}

}
