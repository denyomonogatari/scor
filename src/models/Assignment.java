package models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Assignment {
	private String name;
	private double score;

	private double total;

	private boolean isCompleted;
	private boolean isExtraCredit;

	private Date dateAssigned;

	private Date dueDate;

	private String type;

	public Assignment(String name, double score, double total) {
		this(name, score, total, true, false, null, null, null);
	}
	
	public Assignment(String name, double score, double total, Date dueDate) {
		this(name, score, total, true, false, null, dueDate, null);
	}
	
	public Assignment(String name, double score, double total, String type) {
		this(name, score, total, true, false, null, null, type);
	}
	
	public Assignment(String name, double score, double total, Date dueDate, String type) {
		this(name, score, total, true, false, null, dueDate, type);
	}
	
	public Assignment(String name, double score, double total, boolean isCompleted, boolean isExtraCredit,
			Date dateAssigned, Date dueDate, String type) {
		this.name = name;
		this.score = score;
		this.total = total;
		this.isCompleted = isCompleted;
		this.isExtraCredit = isExtraCredit;
		this.dateAssigned = dateAssigned;
		this.dueDate = dueDate;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public boolean isExtraCredit() {
		return isExtraCredit;
	}

	public void setExtraCredit(boolean isExtraCredit) {
		this.isExtraCredit = isExtraCredit;
	}

	public Date getDateAssigned() {
		return dateAssigned;
	}

	public void setDateAssigned(Date dateAssigned) {
		this.dateAssigned = dateAssigned;
	}

	public Date getDueDate() {
		return dueDate;
	}
	
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
	public String getDueDateString() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		if (dueDate != null)
			return df.format(dueDate);
		else 
			return null;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	// name, score, total, isCompleted, isExtraCredit, dateAssigned, dueDate
	public String toString() {
		StringBuilder output = new StringBuilder();
		output.append("name: " + name + "\n");
		output.append(String.format("score: %.2f\n", score));
		output.append(String.format("total: %.2f\n", total));
		output.append("isCompleted: " + isCompleted + "\n");
		output.append("isExtraCredit: " + isExtraCredit + "\n");
		output.append("dateAssigned: " + dateAssigned + "\n");
		output.append("dueDate: " + dueDate + "\n");

		return output.toString();
	}
}
