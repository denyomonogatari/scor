package main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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

	int count = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FlashCards() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Set the content type to HTML
		response.setContentType("text/html");

		// Get a Print Writer
		PrintWriter out = response.getWriter();

		User user = (User) request.getSession().getAttribute("user");

		// Generate the template HTML
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("    <meta charset=\"UTF-8\">");
		out.println("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
		out.println("        <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">");
		out.println(
				"        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">");
		out.println("        <title>Document</title>");
		out.println("<script type=\"text/javascript\" src=\"../jquery-3.3.1.min.js\"></script>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");

		String deckName = request.getParameter("name");
		ArrayList<FlashCard> deck = getDeck(deckName, user);

		out.println("	<h1>" + deckName + "</h1>");
		out.println("<div class='center_div'>");

		out.println("	<p id=\"cardHolder\"></p>");
		out.println("	<input id='deckName' type='hidden' value='" + deckName + "' >");
		out.println("	<button onclick=\"next();\">Next</button>");
		count++;

		out.println("<form action='../actions/AddFlashCard?name=\"" + deckName + "\" method='GET'>");
		out.println("	<label for='q'>Question</label>");
		out.println("	<input type='text' name='question' id='q'>");
		out.println("	<label for='a'>Question</label>");
		out.println("	<input type='text' name='answer' id='a'>");
		out.println("	<button>Add</butto>");
		out.println("</form>");

		out.println("<script type='text/javascript' src='../flashcards.js' ></script>");
		out.println("</body>");
		out.println("</html>");
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
