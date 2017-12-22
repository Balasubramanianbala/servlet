package in.vamsoft.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.vamsoft.Dao.Employee;
import in.vamsoft.pojo.DemoBean;

/**
 * Servlet implementation class DemoServlet
 */
@WebServlet("/DemoServlet")
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	Employee e;
	HttpSession session;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<DemoBean> list=e.emp();
		session=request.getSession();
		request.setAttribute("list", list);
		session.setAttribute("list", list);
		RequestDispatcher dispatcher=request.getRequestDispatcher("display1.jsp");
		dispatcher.forward(request,response);
	}

}
