package in.vamsoft.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import in.vamsoft.dao.UserCreationDao;
import in.vamsoft.pojomodel.UserCreation;
import in.vamsoft.service.LoginInformationService;


/**
 * Servlet implementation class LoginServlet
 */
// @WebServlet("/Login")
public class LoginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  public static Logger log = Logger.getLogger(LoginServlet.class);
  UserCreation user = new UserCreation();
  UserCreationDao userdao = new UserCreationDao();
  LoginInformationService informationService = new LoginInformationService();
  /**
   * @see HttpServlet#HttpServlet().
   */

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response).
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
          throws ServletException, IOException {

    HttpSession session=request.getSession();
    String email = request.getParameter("email");
    
    System.out.println("email address////" + email);
    String password = request.getParameter("password");
    session.setAttribute("password", password);
    System.out.println(password + "password");
    user.setEmail(email);
    user.setPassword(password);
    String ip_address = request.getLocalAddr();
    System.out.println(ip_address);
    String ip=request.getRemoteAddr();
    Date ld = new Date();
    SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss ");
    System.out.println(ft.format(ld));
    String date=ft.format(ld);
    int userid = userdao.getUserId(email);
    String emailid=userdao.getUserEmailId(email);
    System.out.println(date);
    String browserDetails = request.getHeader("User-Agent");
    if (userdao.uservalidate(email, password)) {

      session = request.getSession();
      String name = userdao.getName(email);
      System.out.println(name);
      session.setAttribute("name", name);
      session.setAttribute("email", email);
      System.out.println(userid);      
      informationService.getinformation(emailid, date, ip, browserDetails);
   
      RequestDispatcher rd = request.getRequestDispatcher("dashboard.html");
      rd.include(request, response);

    } else {
      
     // informationService.getinformation(userid, s, ip, browserDetails);
      response.sendRedirect("index.html");
    }

    
   
  }
}
