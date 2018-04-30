package main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import models.User;
import models.flashcards.FlashCard;

/**
 * Servlet implementation class GetFlashCardJSON
 */
@WebServlet("/main/GetFlashCardJSON")
public class GetFlashCardJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		String deckName = request.getParameter("name");
		User user = (User) request.getSession().getAttribute("user");
		ArrayList<FlashCard> d = user.getDeck(deckName);

		JSONObject flashCardSet = new JSONObject();
		JSONObject deck = new JSONObject();
		JSONArray data = new JSONArray();
		try {
			deck.put("name", deckName);
			deck.put("data", data);
			flashCardSet.put("deck", deck);
		} catch (JSONException e1) {
			e1.printStackTrace();
		}
		for (int i = 0; i < d.size(); i++) {

			try {
				JSONObject card = new JSONObject();
				String question = d.get(i).getQuestion();
				String answer = d.get(i).getAnswer();
				card.put("question", question);
				card.put("answer", answer);
				data.put(card);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		writer.print(flashCardSet.toString());
	}

}