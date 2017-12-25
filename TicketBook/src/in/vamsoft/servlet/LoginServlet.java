package in.vamsoft.servlet;

import in.vamsoft.dao.UserCreationDao;
import in.vamsoft.pojomodel.UserCreation;
import in.vamsoft.service.LoginInformationService;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.tomcat.jni.Local;

/**
 * Servlet implementation class LoginServlet
 */
// @WebServlet("/Login")
public class LoginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  public static Logger log = Logger.getLogger(LoginServlet.class);
  UserCreation user = new UserCreation();
  UserCreationDao userdao = new UserCreationDao();
  LoginInformationService informationService=new LoginInformationService();
  /**
   * @see HttpServlet#HttpServlet().
   */

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response).
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
          throws ServletException, IOException {

    HttpSession session;
    String email = request.getParameter("email");
    System.out.println("email address////" + email);
    String password = request.getParameter("password");
    System.out.println(password + "password");
    user.setEmail(email);
    user.setPassword(password);
    String ip_address = request.getLocalAddr();
    System.out.println(ip_address);
    String ip=request.getRemoteAddr();
    Date ld = new Date();
    SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss ");
    System.out.println(ft.format(ld));
    String s=ft.format(ld);
    int userid = userdao.getUserId(email);
    String emailid=userdao.getUserEmailId(email);
    System.out.println(s);
    String browserDetails = request.getHeader("User-Agent");
    if (userdao.uservalidate(email, password)) {

      session = request.getSession();
      String name = userdao.getName(email);
      System.out.println(name);
      session.setAttribute("name", name);           
      System.out.println(userid);      
      informationService.getinformation(emailid, s, ip, browserDetails);
      // request.getSession().setAttribute("user", user);;
      RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
      rd.forward(request, response);

    } else {
      
     // informationService.getinformation(userid, s, ip, browserDetails);
      response.sendRedirect("index.html");
    }

    
   
  }
}
