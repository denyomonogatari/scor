package models.flashcards;

import java.util.ArrayList;

public class FlashCardManager {

	private ArrayList<FlashCardDeck> decks;
	private int numberOfDecks;

	public FlashCardManager() {
		this.decks = new ArrayList<>();
		this.numberOfDecks = 0;
	}

	public ArrayList<FlashCardDeck> getDecks() {
		return decks;
	}

	public void addFlashCardDeck(FlashCardDeck deck) {
		this.decks.add(deck);
	}

	public void deleteDeck(String name) {
		for (int i = 0; i < this.decks.size(); i++) {
			if (this.decks.get(i).getDeckName().equals(name)) {
				this.decks.remove(i);
				break;
			}
		}
	}

	public FlashCardDeck getDeck(String name) {
		for (FlashCardDeck deck : this.decks) {
			if (deck.getDeckName().equals(name)) {
				System.out.println(deck.getDeckName());
				return deck;
			}
		}
		return null;
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