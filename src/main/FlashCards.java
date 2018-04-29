package main;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;
import models.flashcards.FlashCard;
import models.flashcards.FlashCardDeck;

/**
 * Servlet implementation class FlashCards
 */
@WebServlet("/main/FlashCards")
public class FlashCards extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String deckName = request.getParameter("name");
		request.setAttribute("name", deckName);
		User user = (User) request.getSession().getAttribute("user");
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/main/FlashCards.jsp");
		requestDispatcher.forward(request, response);
	}

	private ArrayList<FlashCard> getDeck(String deckName, User user) {
		ArrayList<FlashCardDeck> decks = user.getFlashCardDecks();
		for (FlashCardDeck deck : decks) {
			if (deck.getDeckName().equals(deckName)) {
				return deck.getDeck();
			}
		}
		return null;
	}

}
