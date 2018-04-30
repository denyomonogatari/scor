package models;

import java.util.Date;

public class UpcomingAssignment {
	
	private String name;
	private Date dueDate;
	private String courseName;
	private String assessmentType;
	
	public UpcomingAssignment() {
		
	}
	
	public UpcomingAssignment(String name, Date dueDate, String courseName, String assessmentType) {
		this.name = name;
		this.setDueDate(dueDate);
		this.setCourseName(courseName);
		this.setAssessmentType(assessmentType);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String assignmentName) {
		this.name = assignmentName;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getAssessmentType() {
		return assessmentType;
	}

	public void setAssessmentType(String assessmentType) {
		this.assessmentType = assessmentType;
	}
	
}
