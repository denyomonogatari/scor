package test;

import java.util.Date;

import models.Assessment;
import models.Assignment;
import models.AssignmentType;
import models.Course;
import models.GradingScale;
import models.Semester;
import models.Semester.Season;
import models.User;

public class Tester {
	public static void main(String[] args) {

		long currentMilliseconds = new Date().getTime();

		Assignment lab1 = new Assignment("Hello World Program", 95, 100, true, false, new Date(currentMilliseconds),
				new Date(currentMilliseconds + 100_000_000), AssignmentType.LAB);
		// System.out.println(lab1);

		Assignment lab2 = new Assignment("Strings Lab", 80, 90, true, false,
				new Date(currentMilliseconds + 100_000_000), new Date(currentMilliseconds + 900_000_000),
				AssignmentType.LAB);
		// System.out.println(lab2);

		Assessment labs = new Assessment(AssignmentType.LAB, 20);
		labs.addAssignment(lab1);
		labs.addAssignment(lab2);
		// System.out.println(labs);

		GradingScale gradingScale1 = new GradingScale(95, 90, 87, 85, 80, 77, 75); //
		// ABC/NC grading scale
		// System.out.println(gradingScale2);

		Assessment quizzes = new Assessment(AssignmentType.QUIZ, 50);
		quizzes.addAssignment(new Assignment("Midterm 1", 75, 100, true, false, new Date(currentMilliseconds), null,
				AssignmentType.QUIZ));
		quizzes.addAssignment(new Assignment("Midterm 2", 70, 100, true, false, new Date(currentMilliseconds), null,
				AssignmentType.QUIZ));

		Assessment finalTest = new Assessment(AssignmentType.FINAL, 30);
		finalTest.addAssignment(new Assignment("Final", 95, 100, true, false, new Date(currentMilliseconds), null,
				AssignmentType.FINAL));

		Course cs2011 = new Course("CS 2011", 3, gradingScale1);
		cs2011.addAssessment(labs);
		cs2011.addAssessment(quizzes);
		cs2011.addAssessment(finalTest);

		// System.out.println(cs2011);

		GradingScale gradingScale2 = new GradingScale(95, 94, 87, 85, 80, 77, 75, 70, 68, 65, 60); // ABCDF grading
																									// scale
		// System.out.println(gradingScale2);

		Course cs3220 = new Course("CS 3220", 3, gradingScale2);

		Assessment homework = new Assessment(AssignmentType.HOMEWORK, 100);
		homework.addAssignment(new Assignment("HW1: Create Notes", 95, 100, true, false, new Date(currentMilliseconds),
				null, AssignmentType.HOMEWORK));
		cs3220.addAssessment(homework);

		Semester spring2018 = new Semester(Season.SPRING, 2018);
		spring2018.addCourse(cs2011);
		spring2018.addCourse(cs3220);

		User johnDoe = new User("John", "Doe", "john@doe.com", "abcd");
		johnDoe.addSemester(spring2018);

		// System.out.println(spring2018);
		System.out.println(johnDoe);

		// GradingScale gradingScale1 = new GradingScale(92, 90, 87, 83, 80, 75, 70);

		// User johnDoe = new User("John", "Doe", "john@doe.com", "abcd");

		// Semester spring2018 = new Semester(Season.SPRING, 2018);

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

		// Course cs3220 = new Course("CS 3220", 3, gradingScale1);

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
		System.out.println(johnDoe);

	}
}
