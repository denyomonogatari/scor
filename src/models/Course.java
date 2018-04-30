package models;

import java.util.ArrayList;

public class Course {
	private String name;
	private GradingScale gradingScale;
	// private ArrayList<Assessment> assessments = new ArrayList<>();
	private double units;
	
	private boolean hasPredefinedGrade = false;
	
	private String predefinedGrade;

	protected CourseWorkHandler cwh;

	public Course(String name, double units, GradingScale gradingScale, String predefinedGrade) {
		this.name = name;
		this.gradingScale = gradingScale;
		this.units = units;
		this.cwh = new CourseWorkHandler();
		this.predefinedGrade = predefinedGrade;
		this.hasPredefinedGrade = true;
	}
	
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
		ArrayList<Assessment> assessments = cwh.getAssessments();
		
		if (assessments.isEmpty()) 
			return 0;
		
		double percentEarned = 0;
		double assessmentWorthTotal = 0;
		for (int i = 0; i < assessments.size(); i++) {
			if (!assessments.get(i).getAssignments().isEmpty()) {
				double assignmentScoreTotal = 0;
				double assignmentWorthTotal = 0;
				for (int j = 0; j < assessments.get(i).getAssignments().size(); j++) {
					assignmentScoreTotal += assessments.get(i).getAssignments().get(j).getScore();
					assignmentWorthTotal += assessments.get(i).getAssignments().get(j).getTotal();
				}
				if (!Double.isNaN((assignmentScoreTotal / assignmentWorthTotal))) {
					percentEarned += (assignmentScoreTotal / assignmentWorthTotal) *  assessments.get(i).getWorth();
					assessmentWorthTotal += assessments.get(i).getWorth();
				}
			}
		}
		
		if (Double.isNaN(percentEarned / assessmentWorthTotal))
			return 0;
		
		return (percentEarned / assessmentWorthTotal) * 100;
	}

	public String getGrade() {
		if (hasPredefinedGrade) {
			return predefinedGrade;
		}
		
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
