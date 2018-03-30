package models;

import java.util.ArrayList;

public class Assessment {
	private String type;
	private double worth;
	ArrayList<Assignment> assignments = new ArrayList<>();
	
	public Assessment(String type, double worth) {
		this(type, worth, new ArrayList<Assignment>());
	}
	
	public Assessment(String type, double worth, ArrayList<Assignment> assignments) {
		this.setType(type);
		this.setWorth(worth);
		this.assignments = assignments;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getWorth() {
		return worth;
	}

	public void setWorth(double worth) {
		this.worth = worth;
	}
	
	public ArrayList<Assignment> getAssignments() {
		return assignments;
	}
	
	public void addAssignment(Assignment assignment) {
		assignments.add(assignment);
	}
	
	public void removeAssignment(Assignment assignment) {
		assignments.remove(assignment);
	}
	
	public double getScore() {
		double score = 0;
		double total = 0;
		for (Assignment assignment : assignments) {
			if (assignment.isCompleted()) {
				score += assignment.getScore();
				total += assignment.isExtraCredit() ? 0 : assignment.getTotal();
			}
		}
		
		// 0.0/0.0 returns NaN
		// any score/0.0 returns Infinity
		return (score / total) * worth;//(worth / 100);
	}

	public String toString() {
		StringBuilder output = new StringBuilder();
		double score = getScore();
		
		output.append("type: " + type + "\n");
		output.append(String.format("score: %.2f %s\n", score, "%"));
		output.append(String.format("worth: %.2f %s\n", worth, "%"));
		
//		output.append("Assignments: \n");
		output.append("_______ \n");
		for (int i = 0; i < assignments.size(); i++) {
			output.append("Assignment " + (i + 1) + ". \n");
			output.append("_____ \n");
			output.append(assignments.get(i) + "\n");
		}
		
		return output.toString();
	}
}
