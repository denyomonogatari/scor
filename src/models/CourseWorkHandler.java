package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CourseWorkHandler {

	private Map<AssignmentType, Assessment> courseWork;
	private double maxPoints;
	private double earnedPoints;
	private double currentPercentage;

	// TODO:
	// Validate that assignment doesn't already exist when being added

	public CourseWorkHandler() {
		this.courseWork = new HashMap<>();
		this.maxPoints = 0;
		this.earnedPoints = 0;
		this.currentPercentage = 0;
	}

	public Map<AssignmentType, Assessment> getCourseWork() {
		return courseWork;
	}

	public void setCourseWorkMap(Map<AssignmentType, Assessment> courseWork) {
		this.courseWork = courseWork;
	}

	public double getMaxPoints() {
		return maxPoints;
	}

	public void setMaxPoints(double maxPoints) {
		this.maxPoints = maxPoints;
	}

	public double getEarnedPoints() {
		return earnedPoints;
	}

	public void setEarnedPoints(double earnedPoints) {
		this.earnedPoints = earnedPoints;
	}

	public double getCurrentPercentage() {
		return currentPercentage;
	}

	public void setCurrentPercentage(double currentPercentage) {
		this.currentPercentage = currentPercentage;
	}

	public void addAssignment(Assignment assignment) {
		Assessment assessment = this.courseWork.get(assignment.getType());
		if (assessment == null) {
			// TODO Implement validation if Assessment does not exist
		} else {
			assessment.addAssignment(assignment);
		}
	}

	public void addAssessment(Assessment assessment) {
		// TODO add validation of assessment already exist
		this.courseWork.put(assessment.getType(), assessment);
	}

	public void removeAssessment(Assessment assessment) {
		this.courseWork.remove(assessment.getType());
	}

	public ArrayList<Assessment> getAssessments() {
		return new ArrayList<>(courseWork.values());
	}

	private double calculateGrade(double max, double earned) {
		return (earned / max) * 100;
	}

	public void deleteAssignment(String assignmentName, AssignmentType type) {
		Assessment assessment = this.courseWork.get(type);
		ArrayList<Assignment> assignments = assessment.getAssignments();
		for (Assignment assignment : assignments) {
			if (assignment.getName().equals(assignmentName)) {
				assignments.remove(assignment);
				break;
			}
		}
	}

	public double getCategoryGrade(AssignmentType type) {
		Assessment assessment = this.courseWork.get(type);
		return assessment.getScore();
	}

	public ArrayList<Assignment> getCategoryWork(AssignmentType type) {
		Assessment assessment = this.courseWork.get(type);
		return assessment.getAssignments();
	}

}
