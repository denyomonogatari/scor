package main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/main/FlashCards")
public class FlashCards extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String deckName = request.getParameter("name");
		request.setAttribute("name", deckName);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/main/FlashCards.jsp");
		requestDispatcher.forward(request, response);
	}

}
