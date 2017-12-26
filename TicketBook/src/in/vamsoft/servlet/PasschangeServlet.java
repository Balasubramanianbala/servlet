package in.vamsoft.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.vamsoft.dao.PasswordchangeDao;
import in.vamsoft.dao.UserCreationDao;
import in.vamsoft.pojomodel.PassHistory;

/**
 * Servlet implementation class PasschangeServlet
 */
@WebServlet("/PasschangeServlet")
public class PasschangeServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  UserCreationDao userdao = new UserCreationDao();
  PasswordchangeDao pwdchangedao = new PasswordchangeDao();

  /**
   * @see HttpServlet#HttpServlet()
   */
  public PasschangeServlet() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();

    System.out.println("email address////" + session.getAttribute("email"));
    String email = (String) session.getAttribute("email");
    String currentpwd = request.getParameter("current");
    System.out.println("currentpass////" + currentpwd);

    String newpass = request.getParameter("new");
    System.out.println("Newpass////" + newpass);

    String conpass = request.getParameter("confirm");
    System.out.println("conpass" + conpass);

    Date ld = new Date();
    SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss ");
    System.out.println(ft.format(ld));
    String date = ft.format(ld);

    PassHistory passHistory = new PassHistory(date, email, newpass);
    if (userdao.uservalidate(email, currentpwd)) {
      session = request.getSession();
      
      List<String> lastTenPasswords=pwdchangedao.getLastTenPasswords(email);
      if(!lastTenPasswords.contains(newpass)) {
        pwdchangedao.insertPasswordHistory(passHistory);
        userdao.updatePassword(email,newpass);
        
      }
      else {
        response.getWriter().println("You cannot use last ten passwords");
        
      }

    } else {
      response.getWriter().println("Either current password  is wrong");
    }

  }

}
