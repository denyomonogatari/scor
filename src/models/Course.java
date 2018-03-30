package models;

import java.util.ArrayList;

public class Course {
	private String name;
	private GradingScale gradingScale;
	private ArrayList<Assessment> assessments = new ArrayList<>();
	
	public Course(String name, GradingScale gradingScale) {
		this(name, gradingScale, new ArrayList<Assessment>());
	}

	public Course(String name, GradingScale gradingScale, ArrayList<Assessment> assessments) {
		this.name = name;
		this.gradingScale = gradingScale;
		this.assessments = assessments;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public GradingScale getGradingScale() {
		return gradingScale;
	}

	public void setGradingScale(GradingScale gradingScale) {
		this.gradingScale = gradingScale;
	}

	public ArrayList<Assessment> getAssessments() {
		return assessments;
	}

	public void setAssessments(ArrayList<Assessment> assessments) {
		this.assessments = assessments;
	}
	
	public void addAssessment(Assessment assessment) {
		assessments.add(assessment);
	}
	
	public void removeAssessment(Assessment assessment) {
		assessments.remove(assessment);
	}
	
	public boolean assessmentsAreValid() {
		double totalWorth = 0;
		for (Assessment assessment : assessments) {
			totalWorth += assessment.getWorth();
		}
		
		return totalWorth - 100 >= -0.001 && totalWorth - 100 <= 0.001; 
	}
	
	public double getPercentEarned() {
		double total = 0;
		for (Assessment assessment : assessments) {
			total += assessment.getScore();
		}
		
		return total;
	}
	
	public String getGrade() {
		double percentEarned = getPercentEarned();
		
		return gradingScale.getGrade(percentEarned);
	}
	
	public String toString() {
		StringBuilder output = new StringBuilder();
		
		output.append("name: " + name + "\n");
		output.append("grade: " + getGrade() + "\n");
		output.append(String.format("Percent earned: %.2f", getPercentEarned()) + "\n");
		output.append("assessments valid?: " + assessmentsAreValid() + "\n");
		output.append("\n");
		output.append("GRADING SCALE:" + "\n");
		output.append("__________" + "\n");
		output.append(gradingScale);
		output.append("\n");
		output.append("ASSESSMENTS: \n");
		output.append("__________ \n");
		for (int i = 0; i < assessments.size(); i++) {
			output.append("Assessment " + (i + 1) + ". \n");
			output.append("_____ \n");
			output.append(assessments.get(i));
		}
		
		return output.toString();
	}
	
}
