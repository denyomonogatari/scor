package models;

import java.util.ArrayList;

public class Course {
	private String name;
	private GradingScale gradingScale;
	// private ArrayList<Assessment> assessments = new ArrayList<>();
	private double units;

	protected CourseWorkHandler cwh;

	public Course(String name, double units, GradingScale gradingScale) {
		this(name, units, gradingScale, new CourseWorkHandler());
	}

	public Course(String name, double units, GradingScale gradingScale, CourseWorkHandler cwh) {
		this.name = name;
		this.gradingScale = gradingScale;
		// this.assessments = assessments;
		this.units = units;

		this.cwh = cwh;
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
		return this.cwh.getAssessments();
	}

	// public void setAssessments(ArrayList<Assessment> assessments) {
	// this.assessments = assessments;
	// }

	public double getUnits() {
		return units;
	}

	public void setUnits(double units) {
		this.units = units;
	}

	public void addAssessment(Assessment assessment) {
		this.cwh.addAssessment(assessment);
	}

	public void removeAssessment(Assessment assessment) {
		cwh.removeAssessment(assessment);
	}

	public boolean assessmentsAreValid() {
		double totalWorth = 0;
		for (Assessment assessment : this.cwh.getAssessments()) {
			totalWorth += assessment.getWorth();
		}

		return totalWorth - 100 >= -0.001 && totalWorth - 100 <= 0.001;
	}

	public double getPercentEarned() {
		double total = 0;
		for (Assessment assessment : this.cwh.getAssessments()) {
			total += assessment.getScore();
		}

		return total;
	}

	public String getGrade() {
		double percentEarned = getPercentEarned();

		return gradingScale.getGrade(percentEarned);
	}

	public double getGradePoints() {
		return gradingScale.getCredits(getGrade()) * units;
	}

	public String toString() {
		StringBuilder output = new StringBuilder();

		output.append("name: " + name + "\n");
		output.append("units: " + units + "\n");
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
		for (int i = 0; i < this.cwh.getAssessments().size(); i++) {
			output.append("Assessment " + (i + 1) + ". \n");
			output.append("_____ \n");
			output.append(this.cwh.getAssessments().get(i));
		}

		return output.toString();
	}

}
