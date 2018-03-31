package test;

import models.flashcards.FlashCard;
import models.flashcards.FlashCardDeck;

public class FlashCardTester {

	public static void main(String[] args) {

		FlashCardDeck deck = new FlashCardDeck();

		deck.addFlashCard("What langauge am I using?", "Java");
		deck.addFlashCard("What time is it?", "12:38 PM");
		deck.addFlashCard("What time is it?", "12:38 P");
		deck.addFlashCard("What time is it?", "12:38 P");
		deck.addFlashCard("What time ist?", "1:38 PM");
		deck.addFlashCard("What time it?", "12:3PM");
		deck.addFlashCard("Whats it?", "12:3PM");

		// for (FlashCard card : cards) {
		// System.out.println(card);
		// System.out.println();
		// }

		FlashCard[] c = deck.getShuffledDeck();
		for (FlashCard card : c) {
			System.out.println(card);
			System.out.println();
		}

	}
}
