package actions;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Course;
import models.GradingScale;
import models.Semester;
import models.User;

@WebServlet("/actions/AddCourseWithPredefinedGrade")
public class AddCourseWithPredefinedGrade extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Reference to session
		HttpSession session = request.getSession();
		
		//Get reference to user if possible, otherwise redirect
		User user = (User)session.getAttribute("user");

		if(user == null) {
			response.sendRedirect("../auth/Login");
			return;
		}
		
		int semesterId = Integer.parseInt(request.getParameter("semesterId"));
		
		request.setAttribute("semesterId", request.getParameter("semesterId"));
		
		// get course name
		String courseName = request.getParameter("courseName");
		
		// get course grade
		String grade = request.getParameter("grade");
		
		// get course units
		double units = Integer.parseInt(request.getParameter("units"));
		
		//new course gradingScale (default/traditional scale)
		GradingScale gradingScale = new GradingScale(93, 90, 87, 83 ,80, 77, 73, 70, 67, 63, 60);
		
		//get current semester
		Semester currentSemester = user.getSemesters().get(semesterId);
		
		//add course to current semester
		currentSemester.addCourse(new Course(courseName, units, gradingScale, grade));
	
		response.sendRedirect("../main/SemesterPage?semesterId=" + semesterId);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
