package in.vamsoft.dao;

import in.vamsoft.pojomodel.DbconnectionUtil;
import in.vamsoft.pojomodel.UserCreation;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
        .prepareStatement("insert into UserCreation(firstName,lastName,email,password) "
                                                                   + "values(?,?,?,?)")) {

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

}
