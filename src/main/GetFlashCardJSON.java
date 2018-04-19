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

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetFlashCardJSON() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
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
		// JSONObject card = new JSONObject();
		// JSONObject card1 = new JSONObject();

		for (int i = 0; i < d.size(); i++) {

			try {
				JSONObject card = new JSONObject();
				String question = d.get(i).getQuestion();
				String answer = d.get(i).getAnswer();
				card.put("question", question);
				card.put("answer", answer);
				data.put(card);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		writer.print(flashCardSet.toString());

		// try {
		// card.put("question", "what language is this?");
		// card.put("answer", "java");
		// card1.put("question", "what school do i go to?");
		// card1.put("answer", "python and js");
		// deck.put("name", "java");
		// deck.put("data", data);
		// data.put(card);
		// data.put(card1);
		// flashCardSet.put("deck", deck);
		// writer.print(flashCardSet.toString());
		// } catch (JSONException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		// JSONObject flashCardSet = new JSONObject();
		// JSONArray jsonArr = new JSONArray();
		//
		// JSONObject obj1 = new JSONObject();
		// try {
		// obj1.put("question", "What is 10 * 10");
		// obj1.put("answer", "100");
		//
		// JSONObject obj2 = new JSONObject();
		// obj2.put("question", "What is 10 - 6");
		// obj2.put("answer", "4");
		//
		// jsonArr.put(obj1);
		// jsonArr.put(obj2);
		//
		// flashCardSet.put("flashCardSet", jsonArr);
		// String jsonData = flashCardSet.toString();
		// System.out.println(jsonData);
		//
		// writer.print(jsonData);
		// } catch (Exception e) {
		//
		// }

		// String jsonData = "";
		// try {
		// //FlashCardDAO dao = new FlashCardDAO(getServletContext());
		// //jsonData = dao.getJSONFormatData();
		// //writer.print(jsonData);
		// } catch (JSONException e) {
		// e.printStackTrace();
		// } finally {
		// writer.close();
		// }

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
