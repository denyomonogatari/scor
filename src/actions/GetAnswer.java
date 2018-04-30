package actions;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.EquationSolver;

/**
 * Servlet implementation class GetAnswer
 */
@WebServlet("/action/GetAnswer")
public class GetAnswer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String question = request.getParameter("mathQuestion");
		String answer = EquationSolver.getAnAnswer(question);
		request.setAttribute("question", question);
		request.setAttribute("answer", answer);
		request.getRequestDispatcher("/WEB-INF/main/MathAnswer.jsp").forward(request, response);
	}

}
