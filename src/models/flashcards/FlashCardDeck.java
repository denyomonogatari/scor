package models.flashcards;

import java.util.ArrayList;
import java.util.Random;

public class FlashCardDeck {

	private ArrayList<FlashCard> deck;
	private int numberOfFlashCards;

	public FlashCardDeck() {
		this.deck = new ArrayList<>();
		this.numberOfFlashCards = 0;
	}

	public ArrayList<FlashCard> getDeck() {
		return deck;
	}

	public void setDeck(ArrayList<FlashCard> deck) {
		this.deck = deck;
	}

	public void addFlashCard(String question, String answer) {
		this.deck.add(new FlashCard(question, answer, numberOfFlashCards++));
	}

	public void deleteFlashCard(FlashCard flashCard) {
		for (FlashCard card : this.deck) {
			if (card.getId() == flashCard.getId()) {
				this.deck.remove(flashCard);
			}
		}
	}

	public FlashCard getFlashCard(int id) {
		for (FlashCard card : this.deck) {
			if (card.getId() == id) {
				return card;
			}
		}
		return null;
	}

	public FlashCard[] getShuffledDeck() {
		FlashCard[] cards = deepCopy();
		Random r = new Random();
		for (int i = this.deck.size() - 1; i > 0; i--) {
			int j = r.nextInt(i);
			FlashCard temp = cards[i];
			cards[i] = cards[j];
			cards[j] = temp;
		}
		return cards;
	}

	private FlashCard[] deepCopy() {
		FlashCard[] cards = new FlashCard[this.deck.size()];
		for (int i = 0; i < cards.length; i++) {
			cards[i] = this.deck.get(i);
		}
		return cards;
	}

}
