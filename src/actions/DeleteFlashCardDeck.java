package actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;

/**
 * Servlet implementation class DeleteFlashCardDeck
 */
@WebServlet("/actions/DeleteFlashCardDeck")
public class DeleteFlashCardDeck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		User user = (User) request.getSession().getAttribute("user");
		user.deleteDeck(name);
		response.sendRedirect("../main/FlashCardDecks");
	}


}
