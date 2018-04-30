package models;

import java.util.ArrayList;

import models.flashcards.FlashCard;
import models.flashcards.FlashCardDeck;
import models.flashcards.FlashCardManager;

public class User {
	private String first;
	private String last;
	private String email;
	private String password;
	private ArrayList<Semester> semesters = new ArrayList<>();
	private int id;
	private FlashCardManager fcm = new FlashCardManager();

	static int count = 0;

	public User(String first, String last, String email, String password) {
		this(first, last, email, password, new ArrayList<Semester>());
	}

	public User(String first, String last, String email, String password, ArrayList<Semester> semesters) {
		this.id = ++count;
		this.first = first;
		this.last = last;
		this.email = email;
		this.password = password;
		this.semesters = semesters;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public ArrayList<Semester> getSemesters() {
		return semesters;
	}

	public void setSemesters(ArrayList<Semester> semesters) {
		this.semesters = semesters;
	}

	public void addSemester(Semester semester) {
		semesters.add(semester);
	}

	public void removeSemester(Semester semester) {
		semesters.remove(semester);
	}

	public ArrayList<FlashCardDeck> getFlashCardDecks() {
		return this.fcm.getDecks();
	}

	public ArrayList<FlashCard> getDeck(String name) {

		FlashCardDeck deck = this.fcm.getDeck(name);
		return deck.getDeck();
	}

	public void addFlashCardDeck(FlashCardDeck deck) {
		this.fcm.addFlashCardDeck(deck);
	}

	public void deleteDeck(String name) {
		this.fcm.deleteDeck(name);
	}

	public double getCumulativeGPA() {
		double totalGradePoints = 0;
		double totalUnits = 0;

		for (int i = 0; i < semesters.size(); i++) {
			for (int j = 0; j < semesters.get(i).getCourses().size(); j++) {
				totalGradePoints += semesters.get(i).getCourses().get(j).getGradePoints();
				totalUnits += semesters.get(i).getCourses().get(j).getUnits();
			}
		}

		return totalGradePoints / totalUnits;
	}

	public String toString() {
		StringBuilder output = new StringBuilder();

		output.append("first: " + first + "\n");
		output.append("last: " + last + "\n");
		output.append("email: " + email + "\n");
		output.append("password: " + password + "\n");
		output.append("id: " + id + "\n");
		output.append("CUM GPA: " + getCumulativeGPA() + "\n");
		output.append("SEMESTERS: \n");
		output.append("_________________________ \n");
		for (int i = 0; i < semesters.size(); i++) {
			output.append("Semester " + (i + 1) + ". \n");
			output.append("____________________ \n");
			output.append(semesters.get(i));
		}

		return output.toString();
	}
}