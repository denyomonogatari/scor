package actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;
import models.flashcards.FlashCardDeck;

/**
 * Servlet implementation class AddFlashCardDeck
 */
@WebServlet("/actions/AddFlashCardDeck")
public class AddFlashCardDeck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		String deckName = request.getParameter("deckName");
		FlashCardDeck deck = new FlashCardDeck(deckName);
		user.addFlashCardDeck(deck);
		response.sendRedirect("../main/FlashCardDecks");
	}

}
