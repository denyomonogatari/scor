package actions;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;
import models.flashcards.FlashCard;

/**
 * Servlet implementation class AddFlashCard
 */
@WebServlet("/actions/AddFlashCard")
public class AddFlashCard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		String deckName = request.getParameter("name");
		ArrayList<FlashCard> deck = user.getDeck(deckName);
		String question = request.getParameter("question");
		String answer = request.getParameter("answer");
		FlashCard card = new FlashCard(question, answer, deck.size() + 1);
		deck.add(card);
		response.sendRedirect("../main/FlashCards?name=" + deckName + "");

	}

}
