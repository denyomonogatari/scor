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
import models.flashcards.FlashCardDeck;

/**
 * Servlet implementation class FlashCardServlet
 */
@WebServlet("/main/FlashCardDecks")
public class FlashCardDecks extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FlashCardDecks() {
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
		ArrayList<FlashCardDeck> decks = user.getFlashCardDecks();

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
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Flash Card HomePage</h1>");
		out.println("<div class=\"container\">");
		out.println("	<table class=\"table table-hover\">");
		out.println("		<tr>");
		out.println("			<th>#</th>");
		out.println("			<th>Name:</th>");
		out.println("			<th>Action: </th>");
		out.println("		</tr>");

		for (int i = 0; i < decks.size(); i++) {
			out.println("		<tr>");
			out.println("			<td>" + (i + 1) + "</td>");
			out.println("			<td>" + decks.get(i).getDeckName() + "</td>");
			out.println("			<td> <a href=\"FlashCards?name=" + decks.get(i).getDeckName() + "\"> view</a> <a href=\"\"> delete</a> </td>");
			out.println("		</tr>");
		}

		out.println("</table>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
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
