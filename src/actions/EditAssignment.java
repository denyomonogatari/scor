package actions;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
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
		int semesterId = Integer.parseInt(request.getParameter("semesterId"));
		int courseId = Integer.parseInt(request.getParameter("courseId"));
		int assessmentId = Integer.parseInt(request.getParameter("assessmentId"));
		int assignmentId = Integer.parseInt(request.getParameter("assignmentId"));
		
		request.setAttribute("semesterId", semesterId);
		request.setAttribute("courseId", courseId);
		request.setAttribute("assessmentId", assessmentId);
		request.setAttribute("assignmentId", assignmentId);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/actions/EditAssignment.jsp");
		requestDispatcher.forward(request, response);
		
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
