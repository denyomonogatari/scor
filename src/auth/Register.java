package auth;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Assessment;
import models.Assignment;
import models.Course;
import models.GradingScale;
import models.Semester;
import models.Semester.Season;
import models.User;

@WebServlet(urlPatterns = { "/auth/Register" }, loadOnStartup = 1)
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		String dueDateString = null;
		Date dueDate = null;
		
		// Pre-populate ServletContext with and array list of users
		
		ArrayList<User> users = new ArrayList<>();

		GradingScale gradingScale1 = new GradingScale(92, 90, 87, 83, 80, 75, 70);

		User johnDoe = new User("John", "Doe", "john@doe.com", "abcd");

		Semester spring2018 = new Semester(Season.SPRING, 2018);

		Course cs3035 = new Course("CS 3035", 3, gradingScale1);

		Assessment assessment1 = new Assessment("Labs and Quizzes", 30);
		Assessment assessment2 = new Assessment("Midterm", 20);
		Assessment assessment3 = new Assessment("Homework", 30);
		Assessment assessment4 = new Assessment("Final", 20);

		Assignment assignment1 = new Assignment("Lab1", 80, 100, true, false, null, null,
				"Labs and Quizzes");
		Assignment assignment2 = new Assignment("Lab2", 10, 13, true, false, null, null, "Labs and Quizzes");
		
		try {
			dueDateString = "2018-05-04T12:59";
			dueDate = df.parse(dueDateString);
		}
		catch (ParseException e) {
			System.out.println(e);
		}
		Assignment assignment3 = new Assignment("Lab3", 11, 13, false, false, null, dueDate, "Labs and Quizzes");
		
		Assignment assignment4 = new Assignment("Midterm", 30, 37, true, false, null, null, "Midterm");
		Assignment assignment5 = new Assignment("Homework 1", 9, 10, true, false, null, null, "Homework");
		
		try {
			dueDateString = "2018-05-06T23:59";
			dueDate = df.parse(dueDateString);
		}
		catch (ParseException e) {
			System.out.println(e);
		}
		Assignment assignment6 = new Assignment("Homework 2", 8, 10, false, false, null, dueDate, "Homework");
		
		Assignment assignment7 = new Assignment("Final", 83, 100, true, false, null, null, "Final");

		assessment1.addAssignment(assignment1);
		assessment1.addAssignment(assignment2);
		assessment1.addAssignment(assignment3);
		assessment2.addAssignment(assignment4);
		assessment3.addAssignment(assignment5);
		assessment3.addAssignment(assignment6);
		assessment4.addAssignment(assignment7);

		cs3035.addAssessment(assessment1);
		cs3035.addAssessment(assessment2);
		cs3035.addAssessment(assessment3);
		cs3035.addAssessment(assessment4);

		spring2018.addCourse(cs3035);

		Course cs3220 = new Course("CS 3220", 3, gradingScale1);

		Assessment assessment5 = new Assessment("Homework and Labs", 20);
		Assessment assessment6 = new Assessment("Quizzes", 25);
		Assessment assessment7 = new Assessment("Midterm", 25);
		Assessment assessment8 = new Assessment("Final", 25);
		Assessment assessment9 = new Assessment("Attendance", 5);

		Assignment assignment8 = new Assignment("Homework 1 Two Paragraphs", 100, 100, true, false, null, null,
				"Homework and Labs");
		Assignment assignment9 = new Assignment("Homework 2 Notes", 90, 100, true, false, null, null,
				"Homework and Labs");
		Assignment assignment10 = new Assignment("Lab 1 Deployement", 100, 100, true, false, null, null,
				"Homework and Labs");
		Assignment assignment11 = new Assignment("Lab 2 Request Summary", 80, 100, true, false, null, null,
				"Homework and Labs");
		
		try {
			dueDateString = "2018-05-05T18:00";
			dueDate = df.parse(dueDateString);
		}
		catch (ParseException e) {
			System.out.println(e);
		}
		Assignment assignment12 = new Assignment("Lab 3 Export to Excel", 90, 100, false, false, null, dueDate,
				"Homework and Labs");

		Assignment assignment13 = new Assignment("HTML, CSS, and Deployment", 8, 10, true, false, null, null,
				"Quizzes");
		Assignment assignment14 = new Assignment("HTTP Requests", 9, 10, true, false, null, null, "Quizzes");
		Assignment assignment15 = new Assignment("HTTP Responses", 8, 10, true, false, null, null, "Quizzes");
		Assignment assignment16 = new Assignment("Cookies  and Session", 9, 10, true, false, null, null,
				"Quizzes");
		
		try {
			dueDateString = "2018-05-03T18:00";
			dueDate = df.parse(dueDateString);
		}
		catch (ParseException e) {
			System.out.println(e);
		}
		Assignment assignment17 = new Assignment("JSP Scripting Elements and Directives", 10, 10, false, false, null,
				dueDate, "Quizzes");

		Assignment assignment18 = new Assignment("Midterm Exam", 95, 100, true, false, null, null,
				"Midterm");

		Assignment assignment19 = new Assignment("Final", 85, 100, true, false, null, null, "Final");

		Assignment assignment20 = new Assignment("01-22-2018", 1, 1, true, false, null, null,
				"Attendance");

		assessment5.addAssignment(assignment8);
		assessment5.addAssignment(assignment9);
		assessment5.addAssignment(assignment10);
		assessment5.addAssignment(assignment11);
		assessment5.addAssignment(assignment12);

		assessment6.addAssignment(assignment13);
		assessment6.addAssignment(assignment14);
		assessment6.addAssignment(assignment15);
		assessment6.addAssignment(assignment16);
		assessment6.addAssignment(assignment17);

		assessment7.addAssignment(assignment18);

		assessment8.addAssignment(assignment19);

		assessment9.addAssignment(assignment20);

		cs3220.addAssessment(assessment5);
		cs3220.addAssessment(assessment6);
		cs3220.addAssessment(assessment7);
		cs3220.addAssessment(assessment8);
		cs3220.addAssessment(assessment9);

		spring2018.addCourse(cs3220);
		
		GradingScale gradingScale2 = new GradingScale(93, 90, 87, 83 ,80, 77, 73, 70, 67, 63, 60);
		Course ee3445 = new Course("EE 3445", 3, gradingScale2);
		spring2018.addCourse(ee3445);

		johnDoe.addSemester(spring2018);

		users.add(johnDoe);

		getServletContext().setAttribute("users", users);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/auth/Register.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Parse the request parameters and validate
		String fullName = request.getParameter("name");
		String email = request.getParameter("email");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");

		// Assume there are no errors to begin with
		boolean hasError = false;

		// validate name
		if (fullName == null || fullName.trim().length() == 0) {
			request.setAttribute("nameError", "You must enter your full name");
			hasError = true;
		}

		// Get array of strings
		String[] names = fullName.split(" ");

		// if fullName only contains a single string then set nameError to you must
		// enter both, your first and last name
		if (names.length == 1) {
			request.setAttribute("nameError", "You must enter both, your first and last name");
			hasError = true;
		}

		String firstName = "";
		String lastName = "";
		if (names.length > 1) {
			firstName = names[0];
			for (int i = 1; i < names.length; i++)
				lastName += names[i];
		}

		// validate e-mail
		if (email == null || email.trim().length() == 0) {
			request.setAttribute("emailError", "You must provide an e-mail address");
			hasError = true;
		} else if (!email.matches(
				"(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")) {
			request.setAttribute("emailError", "Invalid e-mail address");
			hasError = true;
		}

		// validate password
		if (password1 == null || password1.trim().length() == 0) {
			request.setAttribute("passwordError", "You must specify a password");
			hasError = true;
		} else if (password2 == null || !password1.trim().equals(password2.trim())) {
			request.setAttribute("passwordError", "Passwords do not match");
			hasError = true;
		}

		if (hasError) { // if an error exists go back to form
			request.setAttribute("name", fullName);
			request.setAttribute("email", email);
			doGet(request, response);
		} else {
			User newUser = new User(firstName, lastName, email, password1);
			ArrayList<User> users = (ArrayList<User>) getServletContext().getAttribute("users");
			users.add(newUser);
			
			response.sendRedirect("MainPage");
		}
	}

}
