package in.vamsoft.service;

import java.util.Date;

import org.apache.log4j.Logger;

import in.vamsoft.dao.UserCreationDao;
import in.vamsoft.pojomodel.LoginInfo;
import in.vamsoft.servlet.LoginServlet;

public class LoginInformationService {
  public static Logger log = Logger.getLogger(LoginInformationService.class);
  UserCreationDao creationDao=new UserCreationDao();
  
  public void getinformation(String  emailid, String logindate, String ip, String browserDetails) {

    /*-----------------------------------------------------------------------------------------*/

    String userAgent = browserDetails;
    String userdetails = userAgent.toLowerCase();

    String browser = "";

    log.info("User Agent for the request is===>" + browserDetails);

    // ===============Browser===========================
    if (userdetails.contains("msie")) {
      String substring = userAgent.substring(userAgent.indexOf("MSIE")).split(";")[0];
      browser = substring.split(" ")[0].replace("MSIE", "IE") + "-" + substring.split(" ")[1];
    } else if (userdetails.contains("safari") && userdetails.contains("version")) {
      browser = (userAgent.substring(userAgent.indexOf("Safari")).split(" ")[0]).split("/")[0] + "-"
          + (userAgent.substring(userAgent.indexOf("Version")).split(" ")[0]).split("/")[1];
    } else if (userdetails.contains("opr") || userdetails.contains("opera")) {
      if (userdetails.contains("opera"))
        browser = (userAgent.substring(userAgent.indexOf("Opera")).split(" ")[0]).split("/")[0] + "-"
            + (userAgent.substring(userAgent.indexOf("Version")).split(" ")[0]).split("/")[1];
      else if (userdetails.contains("opr"))
        browser = ((userAgent.substring(userAgent.indexOf("OPR")).split(" ")[0]).replace("/", "-")).replace("OPR",
            "Opera");
    } else if (userdetails.contains("chrome")) {
      browser = (userAgent.substring(userAgent.indexOf("Chrome")).split(" ")[0]).replace("/", "-");
    } else if ((userdetails.indexOf("mozilla/7.0") > -1) || (userdetails.indexOf("netscape6") != -1)
        || (userdetails.indexOf("mozilla/4.7") != -1) || (userdetails.indexOf("mozilla/4.78") != -1)
        || (userdetails.indexOf("mozilla/4.08") != -1) || (userdetails.indexOf("mozilla/3") != -1)) {
      // browser=(userAgent.substring(userAgent.indexOf("MSIE")).split("
      // ")[0]).replace("/", "-");
      browser = "Netscape-?";

    } else if (userdetails.contains("firefox")) {
      browser = (userAgent.substring(userAgent.indexOf("Firefox")).split(" ")[0]).replace("/", "-");
    } else if (userdetails.contains("rv")) {
      browser = "IE-" + userdetails.substring(userdetails.indexOf("rv") + 3, userdetails.indexOf(")"));
    } else {
      browser = "UnKnown, More-Info: " + userAgent;
    }
    // log.info("Operating System======>" + os);
    log.info("Browser Name==========>" + browser);
    System.out.println("browser" + browser);
    System.out.println(ip);
    System.out.println(logindate);
    System.out.println(emailid);
    LoginInfo loginfo=new LoginInfo(logindate,emailid,ip,browser);
    creationDao.loginformation(loginfo);
  }

}
