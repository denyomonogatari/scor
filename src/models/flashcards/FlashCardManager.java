package models.flashcards;

import java.util.ArrayList;

public class FlashCardManager {

	private ArrayList<FlashCardDeck> decks;
	private int numberOfDecks;

	public FlashCardManager() {
		this.decks = new ArrayList<>();
		this.numberOfDecks = 0;
		addDummyTestData();
	}

	public void addDummyTestData() {
		String name1 = "java";
		FlashCardDeck d1 = new FlashCardDeck(name1);
		FlashCard c1 = new FlashCard("name?", "Alex", 0);
		FlashCard c2 = new FlashCard("what is your name?", "joselyne", 1);
		FlashCard c3 = new FlashCard("what is my dogs name?", "buddy", 2);
		FlashCard c4 = new FlashCard("what is the weenies name?", "kaia", 3);
		FlashCard c5 = new FlashCard("what is the bears name?", "oso", 4);
		FlashCard c6 = new FlashCard("who is that white dog?", "rocky", 5);

		d1.addFlashCard(c1);
		d1.addFlashCard(c2);
		d1.addFlashCard(c3);
		d1.addFlashCard(c4);
		d1.addFlashCard(c5);
		d1.addFlashCard(c6);

		String name2 = "c++";
		FlashCardDeck d2 = new FlashCardDeck(name2);

		String name3 = "python";
		FlashCardDeck d3 = new FlashCardDeck(name3);

		String name4 = "node";
		FlashCardDeck d4 = new FlashCardDeck(name4);

		String name5 = "c#";
		FlashCardDeck d5 = new FlashCardDeck(name5);

		String name6 = "haskell";
		FlashCardDeck d6 = new FlashCardDeck(name6);

		this.decks.add(d1);
		this.decks.add(d2);
		this.decks.add(d3);
		this.decks.add(d4);
		this.decks.add(d5);
		this.decks.add(d6);

	}

	public ArrayList<FlashCardDeck> getDecks() {
		return decks;
	}

	public FlashCardDeck getDeck(String name) {
		System.out.println(name);
		return this.decks.get(0);
//		for (FlashCardDeck deck : this.decks) {
//			if (deck.getDeckName().equals(name)) {
//				return deck;
//			}
//		}
//
//		return null;
	}

	public void setDecks(ArrayList<FlashCardDeck> decks) {
		this.decks = decks;
	}

	public int getNumberOfDecks() {
		return numberOfDecks;
	}

	public void setNumberOfDecks(int numberOfDecks) {
		this.numberOfDecks = numberOfDecks;
	}

}