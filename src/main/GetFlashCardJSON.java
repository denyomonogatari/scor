package main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

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
		// writer.print("{\"finalData:\" {\"name:\"\"java\", data:[{question:\"what
		// language is this\", answer=\"java\"}]}}");
		JSONObject flashCardSet = new JSONObject();
		JSONArray jsonArr = new JSONArray();

		JSONObject obj1 = new JSONObject();
		try {
			obj1.put("question", "What is 10 * 10");
			obj1.put("answer", "100");

			JSONObject obj2 = new JSONObject();
			obj2.put("question", "What is 10 - 6");
			obj2.put("answer", "4");

			jsonArr.put(obj1);
			jsonArr.put(obj2);

			flashCardSet.put("flashCardSet", jsonArr);
			String jsonData = flashCardSet.toString();
			System.out.println(jsonData);

			writer.print(jsonData);
		} catch (Exception e) {

		}

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
