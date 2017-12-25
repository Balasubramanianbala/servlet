package in.vamsoft.dao;

import in.vamsoft.pojomodel.DbconnectionUtil;
import in.vamsoft.pojomodel.LoginInfo;
import in.vamsoft.pojomodel.UserCreation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class UserCreationDao {

  Connection con = null;
  public static Logger log = Logger.getLogger(UserCreationDao.class);

  public UserCreationDao() {
    super();
    con = DbconnectionUtil.getConnection();
  }

  /**
   * @param user
   *          in pojo.
   * @return true or false.
   */
  public boolean getdata(UserCreation user) {

    try (PreparedStatement ps = con
        .prepareStatement("insert into UserCreation(firstName,lastName,email,password) " + "values(?,?,?,?)")) {

      ps.setString(1, user.getFirstName());
      ps.setString(2, user.getLastName());
      ps.setString(3, user.getEmail());
      ps.setString(4, user.getPassword());
      int rows = ps.executeUpdate();
      if (rows > 0) {
        log.info("inserted row");
      } else {
        System.err.println("not inserted row");
      }

    } catch (SQLException e) {
      log.info("query syntax error");
      log.error("syntax error on query");
    }

    return false;

  }

  /**
   * @param email.
   * @param password.
   * @return email and password.
   */
  public boolean uservalidate(String email, String password) {
    System.out.println("inside the uservalidation method");
   
    boolean st = false;
    try (PreparedStatement ps = con
        .prepareStatement("select email,password from UserCreation where email=? and password=?")) {
      ps.setString(1, email);
      ps.setString(2, password);
      ResultSet rs = ps.executeQuery();
      st = rs.next();

    } catch (SQLException e) {
      log.error("sql syntax error");
    }
    return st;
  }

  /**
   * @param email.
   * @return
   */
  public String getName(String email) {

    try (PreparedStatement preparedStatement = con
        .prepareStatement("select firstname from UserCreation where email=?")) {
      preparedStatement.setString(1, email);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        return (resultSet.getString(1));
      }

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return null;

  }
  public int getUserId(String email) {

    try (PreparedStatement preparedStatement = con
        .prepareStatement("select userid from UserCreation where email=?")) {
      preparedStatement.setString(1, email);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        return (resultSet.getInt(1));
      }

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return -1;

  }
  public String  getUserEmailId(String email) {

    try (PreparedStatement preparedStatement = con
        .prepareStatement("select email from UserCreation where email=?")) {
      preparedStatement.setString(1, email);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        return (resultSet.getString(1));
      }

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return null;

  }


  public boolean loginformation(LoginInfo loginfo) {
    try (PreparedStatement ps = con
        .prepareStatement("insert into loginlog(login_date,email,ip_address,browser)"+" values(?,?,?,?)")) {
      
      ps.setString(1, loginfo.getDate());
      System.out.println(loginfo.getDate());
      ps.setString(2,loginfo.getEmail());
      System.out.println(loginfo.getEmail());
      ps.setString(3,loginfo.getIpAddress() );
      System.out.println(loginfo.getIpAddress());
      ps.setString(4, loginfo.getBrowser());
      System.out.println(loginfo.getBrowser());
      int rows = ps.executeUpdate();
      if (rows > 0) {
        log.info("inserted row");
      } else {
        System.err.println("not inserted row");
      }

    } catch (SQLException e) {
      log.info("query syntax error");
      log.error("syntax error on query");
    }
    return false;
  }
    
  


}
