package in.vamsoft.servlet;

import in.vamsoft.dao.PasswordchangeDao;
import in.vamsoft.dao.UserCreationDao;
import in.vamsoft.pojomodel.PassHistory;
import in.vamsoft.pojomodel.UserCreation;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class UserRegister.
 */
@WebServlet("/UserRegister")
public class UserRegister extends HttpServlet {
  
  PasswordchangeDao pwdchangedao = new PasswordchangeDao();

  public UserRegister() {
    super();
    // TODO Auto-generated constructor stub
  }

  private static final long serialVersionUID = 1L;
  /**
   * @param securitykey.
   */

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response).
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    @SuppressWarnings("unused")
    HttpSession session;

    session = request.getSession();
    String firstName = request.getParameter("firstname");
    String lastName = request.getParameter("lastname");
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    UserCreation user = new UserCreation(firstName, lastName, email, password);
    UserCreationDao userdao = new UserCreationDao();
    userdao.getdata(user);  
    Date ld = new Date();
    SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss ");
    System.out.println(ft.format(ld));
    String date=ft.format(ld);
    PassHistory passHistory = new PassHistory(date,email,password);
    pwdchangedao.insertPasswordHistory(passHistory);
    response.sendRedirect("index.html");
  }

}
