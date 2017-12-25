package in.vamsoft.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import in.vamsoft.dao.UserCreationDao;

/**
 * Servlet implementation class BrowserInfo
 */
@WebServlet("/BrowserInfo")
public class BrowserInfo extends HttpServlet {
  private static final long serialVersionUID = 1L;
  public static Logger log = Logger.getLogger(BrowserInfo.class);

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String browserDetails = request.getHeader("User-Agent");
    String userAgent = browserDetails;
    String user = userAgent.toLowerCase();

    String os = "";
    String browser = "";

    log.info("User Agent for the request is===>" + browserDetails);
   
    // ===============Browser===========================
    if (user.contains("msie")) {
      String substring = userAgent.substring(userAgent.indexOf("MSIE")).split(";")[0];
      browser = substring.split(" ")[0].replace("MSIE", "IE") + "-" + substring.split(" ")[1];
    } else if (user.contains("safari") && user.contains("version")) {
      browser = (userAgent.substring(userAgent.indexOf("Safari")).split(" ")[0]).split("/")[0] + "-"
          + (userAgent.substring(userAgent.indexOf("Version")).split(" ")[0]).split("/")[1];
    } else if (user.contains("opr") || user.contains("opera")) {
      if (user.contains("opera"))
        browser = (userAgent.substring(userAgent.indexOf("Opera")).split(" ")[0]).split("/")[0] + "-"
            + (userAgent.substring(userAgent.indexOf("Version")).split(" ")[0]).split("/")[1];
      else if (user.contains("opr"))
        browser = ((userAgent.substring(userAgent.indexOf("OPR")).split(" ")[0]).replace("/", "-")).replace("OPR",
            "Opera");
    } else if (user.contains("chrome")) {
      browser = (userAgent.substring(userAgent.indexOf("Chrome")).split(" ")[0]).replace("/", "-");
    } else if ((user.indexOf("mozilla/7.0") > -1) || (user.indexOf("netscape6") != -1)
        || (user.indexOf("mozilla/4.7") != -1) || (user.indexOf("mozilla/4.78") != -1)
        || (user.indexOf("mozilla/4.08") != -1) || (user.indexOf("mozilla/3") != -1)) {
      // browser=(userAgent.substring(userAgent.indexOf("MSIE")).split("
      // ")[0]).replace("/", "-");
      browser = "Netscape-?";

    } else if (user.contains("firefox")) {
      browser = (userAgent.substring(userAgent.indexOf("Firefox")).split(" ")[0]).replace("/", "-");
    } else if (user.contains("rv")) {
      browser = "IE-" + user.substring(user.indexOf("rv") + 3, user.indexOf(")"));
    } else {
      browser = "UnKnown, More-Info: " + userAgent;
    }
    log.info("Operating System======>" + os);
    log.info("Browser Name==========>" + browser);
    System.out.println("browser"+browser);
    // shareimprove this answer
    // edited Mar 9 at 10:17
    //
    // hemu
    // 1,86612
  }

}
