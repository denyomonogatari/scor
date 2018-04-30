 package main;

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
import models.User;

@WebServlet("/main/CoursePage")
public class CoursePage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String semesterId = request.getParameter("semesterId");
		request.setAttribute("semesterId", semesterId);
		
		String courseId = request.getParameter("courseId");
		request.setAttribute("courseId", courseId);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/main/CoursePage.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
