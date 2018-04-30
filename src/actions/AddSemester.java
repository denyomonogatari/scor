package actions;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Semester;
import models.Semester.Season;
import models.User;

@WebServlet("/actions/AddSemester")
public class AddSemester extends HttpServlet {
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
		
		Season season = Season.valueOf(request.getParameter("term").toUpperCase());
		int year = Integer.parseInt(request.getParameter("year"));
		
		user.addSemester(new Semester(season, year));
		
		response.sendRedirect("../main/MainPage");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
