package test;

import java.util.Date;

import models.Assessment;
import models.Assignment;
import models.Course;
import models.GradingScale;

public class Tester {
	public static void main(String[] args) {
		
		long currentMilliseconds = new Date().getTime();
		
		Assignment lab1 = new Assignment("Hello World Program", 95, 100, true, false, new Date(currentMilliseconds), new Date(currentMilliseconds + 100_000_000));
//		System.out.println(lab1);
		
		Assignment lab2 = new Assignment("Strings Lab", 80, 90, true, false, new Date(currentMilliseconds + 100_000_000), new Date(currentMilliseconds + 900_000_000));
//		System.out.println(lab2);
		
		Assessment labs = new Assessment("Labs", 20);
		labs.addAssignment(lab1);
		labs.addAssignment(lab2);
//		System.out.println(labs);
		
//		GradingScale gradingScale1 = new GradingScale(95, 94, 87, 85, 80, 77, 75, 70, 68, 65, 60); //ABCDF grading scale
//		System.out.println(gradingScale1);
		
		GradingScale gradingScale2 = new GradingScale(95, 90, 87, 85, 80, 77, 75); // ABC/NC grading scale
//		System.out.println(gradingScale2);
		
		Assessment quizzes = new Assessment("Midterms", 50);
		quizzes.addAssignment(new Assignment("Midterm 1", 75, 100, true, false, new Date(currentMilliseconds), null));
		quizzes.addAssignment(new Assignment("Midterm 2", 80, 100, true, false, new Date(currentMilliseconds), null));
		
		Assessment finalTest = new Assessment("Final", 30);
		finalTest.addAssignment(new Assignment("Final", 95, 100, true, false, new Date(currentMilliseconds), null));
		
		Course cs2011 = new Course("CS 2011", gradingScale2);
		cs2011.addAssessment(labs);
		cs2011.addAssessment(quizzes);
		cs2011.addAssessment(finalTest);
		
		System.out.println(cs2011);
	}
}
