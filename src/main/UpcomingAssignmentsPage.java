package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Assessment;
import models.Assignment;
import models.Course;
import models.Semester;
import models.UpcomingAssignment;
import models.User;

@WebServlet("/main/UpcomingAssignmentsPage")
public class UpcomingAssignmentsPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		
		// Get all the semesters of user
		ArrayList<Semester> semesters = user.getSemesters();
		
		// Put all the courses in each semester in a single list
		ArrayList<Course> allCourses = new ArrayList<Course>();
		for (Semester semester : semesters)
			allCourses.addAll(semester.getCourses());
		
		// Construct UpcomingAssignment objects and add them to a list
		ArrayList<UpcomingAssignment> upcomingAssignments = new ArrayList<>();
		
		for (int i = 0; i < allCourses.size(); i++) {
			String courseName = allCourses.get(i).getName();
			
			ArrayList<Assessment> assessments = allCourses.get(i).getAssessments();
			for (int j = 0; j < assessments.size(); j++) {
				String assessmentType = assessments.get(j).getType();
				
				ArrayList<Assignment> assignments = assessments.get(j).getAssignments();
				for (int k = 0; k < assignments.size(); k++) {
					if (!assignments.get(k).isCompleted()) {
						String assignmentName = assignments.get(k).getName();
						Date dueDate = assignments.get(k).getDueDate();
						
						UpcomingAssignment upcomingAssignment = new UpcomingAssignment(assignmentName, dueDate, courseName, assessmentType);
						upcomingAssignments.add(upcomingAssignment);
					}
				}
			}
			
		}
			
		sortByDueDate(upcomingAssignments);
		request.setAttribute("upcomingAssignments", upcomingAssignments);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/main/UpcomingAssignmentsPage.jsp");
		requestDispatcher.forward(request, response);
	}
	
	public static void sortByDueDate(ArrayList<UpcomingAssignment> upcomingAssignments) {
		mergeSort(upcomingAssignments);
	}
	
	public static void mergeSort(ArrayList<UpcomingAssignment> upcomingAssignments) {
		mergeSort(upcomingAssignments, 0, upcomingAssignments.size() - 1);
	}
	
	private static void mergeSort(ArrayList<UpcomingAssignment> upcomingAssignments, int p, int r) {
		if (p < r) {
			int q = (int)((p + r) / 2); 
			mergeSort(upcomingAssignments, p, q);
			mergeSort(upcomingAssignments, q + 1, r);
			merge(upcomingAssignments, p, q, r);
		}
	}
	
	private static void merge(ArrayList<UpcomingAssignment> upcomingAssignments, int p, int q, int r) {
		int n1 = q - p + 1;
		int n2 = r - q;
		
		UpcomingAssignment[] left = new UpcomingAssignment[n1]; 
		UpcomingAssignment[] right = new UpcomingAssignment[n2];
		
		for (int i = 0; i < n1; i++)  
			left[i] = upcomingAssignments.get(p + i);
		
		for (int i = 0; i < n2; i++)  
			right[i] = upcomingAssignments.get(q + i + 1);
		
		int i = 0;
		int j = 0;
		int k = p;
		
		while (i < left.length && j < right.length) { 
			if (left[i].getDueDate().getTime() <= right[j].getDueDate().getTime()) {
				upcomingAssignments.set(k, left[i]);
				i++;
			}
			else {
				upcomingAssignments.set(k, right[j]);
				j++;
			}
			k++;
		}
		
		while (i < left.length) { 
			upcomingAssignments.set(k, left[i]);
			i++;
			k++;
		}
		
		while(j < right.length) {
			upcomingAssignments.set(k, right[j]);
			j++;
			k++;
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
