package auth;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Assessment;
import models.Assignment;
import models.AssignmentType;
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

		// Pre-populate ServletContext with and array list of users
		ArrayList<User> users = new ArrayList<>();

		GradingScale gradingScale1 = new GradingScale(92, 90, 87, 83, 80, 75, 70);

		User johnDoe = new User("John", "Doe", "john@doe.com", "abcd");

		Semester spring2018 = new Semester(Season.SPRING, 2018);

		Course cs3035 = new Course("CS 3035", 3, gradingScale1);

		Assessment assessment1 = new Assessment(AssignmentType.LABSANDQUIZZES, 30);
		Assessment assessment2 = new Assessment(AssignmentType.MIDTERM, 20);
		Assessment assessment3 = new Assessment(AssignmentType.HOMEWORK, 30);
		Assessment assessment4 = new Assessment(AssignmentType.FINAL, 20);

		Assignment assignment1 = new Assignment("Lab1", 80, 100, true, false, null, null,
				AssignmentType.LABSANDQUIZZES);
		Assignment assignment2 = new Assignment("Lab2", 10, 13, true, false, null, null, AssignmentType.LABSANDQUIZZES);
		Assignment assignment3 = new Assignment("Lab3", 11, 13, true, false, null, null, AssignmentType.LABSANDQUIZZES);
		Assignment assignment4 = new Assignment("Midterm", 30, 37, true, false, null, null, AssignmentType.MIDTERM);
		Assignment assignment5 = new Assignment("Homework 1", 9, 10, true, false, null, null, AssignmentType.HOMEWORK);
		Assignment assignment6 = new Assignment("Homework 2", 8, 10, true, false, null, null, AssignmentType.HOMEWORK);
		Assignment assignment7 = new Assignment("Final", 83, 100, true, false, null, null, AssignmentType.FINAL);

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

		Assessment assessment5 = new Assessment(AssignmentType.HOMEWORKANDLABS, 20);
		Assessment assessment6 = new Assessment(AssignmentType.QUIZ, 25);
		Assessment assessment7 = new Assessment(AssignmentType.MIDTERM, 25);
		Assessment assessment8 = new Assessment(AssignmentType.FINAL, 25);
		Assessment assessment9 = new Assessment(AssignmentType.ATTENDANCE, 5);

		Assignment assignment8 = new Assignment("Homework 1 Two Paragraphs", 100, 100, true, false, null, null,
				AssignmentType.HOMEWORKANDLABS);
		Assignment assignment9 = new Assignment("Homework 2 Notes", 90, 100, true, false, null, null,
				AssignmentType.HOMEWORKANDLABS);
		Assignment assignment10 = new Assignment("Lab 1 Deployement", 100, 100, true, false, null, null,
				AssignmentType.HOMEWORKANDLABS);
		Assignment assignment11 = new Assignment("Lab 2 Request Summary", 80, 100, true, false, null, null,
				AssignmentType.HOMEWORKANDLABS);
		Assignment assignment12 = new Assignment("Lab 3 Export to Excel", 90, 100, true, false, null, null,
				AssignmentType.HOMEWORKANDLABS);

		Assignment assignment13 = new Assignment("HTML, CSS, and Deployment", 8, 10, true, false, null, null,
				AssignmentType.QUIZ);
		Assignment assignment14 = new Assignment("HTTP Requests", 9, 10, true, false, null, null, AssignmentType.QUIZ);
		Assignment assignment15 = new Assignment("HTTP Responses", 8, 10, true, false, null, null, AssignmentType.QUIZ);
		Assignment assignment16 = new Assignment("Cookies  and Session", 9, 10, true, false, null, null,
				AssignmentType.QUIZ);
		Assignment assignment17 = new Assignment("JSP Scripting Elements and Directives", 10, 10, true, false, null,
				null, AssignmentType.QUIZ);

		Assignment assignment18 = new Assignment("Midterm Exam", 95, 100, true, false, null, null,
				AssignmentType.MIDTERM);

		Assignment assignment19 = new Assignment("Final", 85, 100, true, false, null, null, AssignmentType.FINAL);

		Assignment assignment20 = new Assignment("01-22-2018", 1, 1, true, false, null, null,
				AssignmentType.HOMEWORKANDLABS);

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

		johnDoe.addSemester(spring2018);

		users.add(johnDoe);

		getServletContext().setAttribute("users", users);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Do we have any errors?
		String nameError = (String) request.getAttribute("nameError");
		String emailError = (String) request.getAttribute("emailError");
		String passwordError = (String) request.getAttribute("passwordError");

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");

		name = name == null ? "" : name;
		email = email == null ? "" : email;
		password1 = password1 == null ? "" : password1;
		password2 = password2 == null ? "" : password2;

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
		out.println(
				"        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">");
		out.println("        <title>Register</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");

		out.println("<h1 class=\"display-1\">Register</h1>");

		out.println("<form action=\"Register\" method=\"post\">");
		out.println("    <div class=\"form-group\">");
		out.println("        <label for=\"name\">Full Name</label>");

		if (nameError != null) {
			out.println("        <input class=\"form-control is-invalid\"  value=\"" + name
					+ "\" type=\"text\" name=\"name\" id=\"name\" placeholder=\"Enter your first and last names\">");
			out.println("        <div class=\"invalid-feedback\">" + nameError + "</div>");
		} else
			out.println("        <input class=\"form-control\" type=\"text\" value=\"" + name
					+ "\" name=\"name\" id=\"name\" placeholder=\"Enter your first and last names\">");

		out.println("    </div>");
		out.println("    <div class=\"form-group\">");
		out.println("        <label for=\"email\">E-mail Address</label>");

		if (emailError != null) {
			out.println("        <input class=\"form-control is-invalid\" value=\"" + email
					+ "\" type=\"email\" name=\"email\" id=\"email\" placeholder=\"Enter your e-mail address\">");
			out.println("        <div class=\"invalid-feedback\">" + emailError + "</div>");
		} else
			out.println("        <input class=\"form-control\" value=\"" + email
					+ "\" type=\"email\" name=\"email\" id=\"email\" placeholder=\"Enter your e-mail address\">");

		out.println("    </div>");
		out.println("    <div class=\"form-group\">");
		out.println("        <label for=\"password\">Password</label>");

		if (passwordError != null) {
			out.println("        <input class=\"form-control is-invalid\" value=\"" + password1
					+ "\" type=\"password\" name=\"password1\" id=\"password1\" placeholder=\"Enter your password\">");
			out.println("        <div class=\"invalid-feedback\">" + passwordError + "</div>");
		} else
			out.println("        <input class=\"form-control\" value=\"" + password1
					+ "\" type=\"password\" name=\"password1\" id=\"password1\" placeholder=\"Enter your password\">");

		out.println("    </div>");
		out.println("    <div class=\"form-group\">");
		out.println("        <label for=\"password\">Re-Enter Password</label>");
		out.println(
				"        <input class=\"form-control\" value=\"\" type=\"password\" name=\"password2\" id=\"password2\" placeholder=\"Re-enter your password\">");
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
		// if fullName is empty or null set nameError to You must enter your full name
		if (fullName == null || fullName.trim().length() == 0) {
			request.setAttribute("nameError", "You must enter your full name");
			hasError = true;
		}

		// Get array of strings
		String[] names = fullName.split(" ");

		// if fullName only contains a single string then set nameError to You must
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

		// doGet(request, response);
		if (hasError) {
			doGet(request, response);
		} else {
			User newUser = new User(firstName, lastName, email, password1);
			ArrayList<User> users = (ArrayList<User>) getServletContext().getAttribute("users");
			users.add(newUser);
			displayWelcome(newUser, response);
		}
	}

	protected void displayWelcome(User user, HttpServletResponse response) throws ServletException, IOException {
		// Set the content type to HTML
		response.setContentType("text/html");

		// Get a Print Writer
		PrintWriter out = response.getWriter();

		// Generate the template HTML
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("    <meta charset=\"UTF-8\">");
		out.println("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
		out.println("        <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">");
		out.println(
				"        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">");
		out.println("        <title>Success</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");

		out.println("<h1 class=\"display-1\">Welcome, " + user.getFirst() + "!</h1>");
		out.println("<p class=\"lead\">You have successfully registered!</p>");
		out.println("<a href=\"Login\" class=\"btn btn-primary\">Login</a>");

		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}
}
