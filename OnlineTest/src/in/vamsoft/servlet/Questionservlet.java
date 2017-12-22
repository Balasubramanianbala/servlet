package in.vamsoft.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.vamsoft.dao.ModelQuestionDao;
import in.vamsoft.pojo.ModelQuestion;
import in.vamsoft.pojo.UserCreation;


/**
 * Servlet implementation class Resultservlet
 */
@WebServlet("/Questionservlet")
public class Questionservlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session;
		PrintWriter out=response.getWriter();
		out.println("inside question servlet");
	    ModelQuestionDao dao = new ModelQuestionDao();
	    List<ModelQuestion> questions = dao.getQuestions();
	    session = request.getSession();
	    session.setAttribute("ModelQuestion", questions);
	    System.out.println(questions);
	    RequestDispatcher dispatcher = request.getRequestDispatcher("Home.jsp");
	    dispatcher.forward(request, response);
	}

}
