package in.vamsoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import in.vamsoft.pojomodel.DbconnectionUtil;
import in.vamsoft.pojomodel.PassHistory;

public class PasswordchangeDao {
  Connection con = null;
  public static Logger log = Logger.getLogger(PasswordchangeDao.class);

  public PasswordchangeDao() {
    con = DbconnectionUtil.getConnection();
  }
  
  public boolean getPwdchangeParam(String currentpwd) {
    
    
    System.out.println("inside the uservalidation method");
    
    boolean st = false;
    try (PreparedStatement ps = con
        .prepareStatement("select email,password from UserCreation where password=?")) {
      
      ps.setString(1, currentpwd);
      ResultSet rs = ps.executeQuery();
      st = rs.next();

    } catch (SQLException e) {
      log.error("sql syntax error");
    }
    return st;
  
  }
  public List<String> getLastTenPasswords(String email) {
    
    List<String> lastTenPasswords = new ArrayList<>();
    System.out.println("inside the getLastTenPasswords");
    
    boolean st = false;
    try (PreparedStatement ps = con
        .prepareStatement("SELECT password FROM password_history where email =? order by password_history_id desc LIMIT  10")) {
      
      ps.setString(1, email);
      ResultSet rs = ps.executeQuery();
     while(rs.next()) {
       lastTenPasswords.add(rs.getString(1));
     }

    } catch (SQLException e) {
      log.error("sql syntax error");
    }
    return lastTenPasswords;
  
  }
  
  
  public boolean insertPasswordHistory(PassHistory passhistory) {
    System.out.println("inside pass dao");
    try (PreparedStatement ps = con
        .prepareStatement("insert into password_history(login_date,email,password) values(?,?,?)")) {
      
      ps.setString(1, passhistory.getLoginDate());
      System.out.println(passhistory.getLoginDate());
      ps.setString(2,passhistory.getEmail());
      System.out.println(passhistory.getEmail());
      ps.setString(3,passhistory.getPassword());
      int rows = ps.executeUpdate();
      if (rows > 0) {
        log.info("inserted row");
      } else {
        System.err.println("not inserted row");
      }

    } catch (SQLException e) {
      log.info("query syntax error pass dao"+e);
      log.error("syntax error on query pass dao"+e);
    }
    return false;
  }

  
  public static void main(String[] args) {
    PasswordchangeDao obj = new PasswordchangeDao();
    
    System.out.println(obj.getLastTenPasswords("siva5@gmail.com"));
    
  }
}
