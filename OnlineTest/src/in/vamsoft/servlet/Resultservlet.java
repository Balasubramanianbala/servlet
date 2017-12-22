package in.vamsoft.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.vamsoft.dao.ModelQuestionDao;
import in.vamsoft.pojo.ModelQuestion;


/**
 * Servlet implementation class Resultservlet
 */
public class Resultservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 HttpSession session;

		    session = request.getSession();

		    int marks = 0;
		    boolean result;

		    List<ModelQuestion> questionList = (List<ModelQuestion>) session.getAttribute("ModelQuestion");

		    for (ModelQuestion question : questionList) {

		      String ans = request.getParameter(String.valueOf(question.getQno()));

		      String ques = question.getQut();

		      if (ans != null) {
		        ModelQuestionDao dao = new ModelQuestionDao();
		        result = dao.getAnswers(ans, ques);
		        if (result) {
		          marks++;
		        }
		      }
		    }
		    session.setAttribute("marks", marks);
		    RequestDispatcher dispatcher = request.getRequestDispatcher("Test.jsp");
		    dispatcher.forward(request, response);
		  }
	}


