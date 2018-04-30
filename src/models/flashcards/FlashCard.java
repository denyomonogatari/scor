package models.flashcards;

public class FlashCard {
	private String question;
	private String answer;
	private int id;

	public FlashCard(String question, String answer, int id) {
		this.question = question;
		this.answer = answer;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getAnswer() {
		return this.answer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Question: " + this.question + "\n" + "Answer: " + this.answer;
	}

}