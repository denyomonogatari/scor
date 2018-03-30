package models;

import java.util.ArrayList;

public class Semester {
	
	private Season season;
	private int year;
	private ArrayList<Course> courses = new ArrayList<Course>();
	
	public enum Season {
		FALL, WINTER, SPRING, SUMMER
	}
	
	public Semester(Season season, int year) {
		this(season, year, new ArrayList<Course>());
	}
	
	public Semester(Season season, int year, ArrayList<Course> courses) {
		this.season = season;
		this.year = year;
		this.courses = courses;
	}
	
	public void addCourse(Course course) {
		courses.add(course);
	}
	
	public void removeCourse(Course course) {
		courses.remove(course);
	}

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}
	
	public double getGPA() {
		double totalGradePoints = 0;
		double totalUnits = 0;
		
		for (int i = 0; i < courses.size(); i++) {
			totalGradePoints += courses.get(i).getGradePoints();
			totalUnits += courses.get(i).getUnits();
		}
		
		return totalGradePoints / totalUnits;
	}
	
	public String toString() {
		StringBuilder output = new StringBuilder();
		
		output.append("Season: " + season + "\n");
		output.append("year: " + year + "\n");
		output.append("GPA: " + getGPA() + "\n");
		output.append("COURSES: \n");
		output.append("____________________ \n");
		for (int i = 0; i < courses.size(); i++) {
			output.append("Course " + (i + 1) + ". \n");
			output.append("_______________ \n");
			output.append(courses.get(i));
		}
		
		return output.toString();
	}
}
