package in.vamsoft.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import in.vamsoft.pojo.User;

public class UserDao {

	Connection cn;

	public UserDao() {
		super();
		cn = DBConnectionUtil.getConnection();

	}

	public boolean addUser(User u) {

		try (PreparedStatement pst = cn.prepareStatement("insert into usercreation(name,email,password) values(?,?,?)")) {
			System.out.println("in");
			pst.setString(1, u.getName());
			pst.setString(2, u.getEmail());
			pst.setString(3, u.getPwd());
			int i = pst.executeUpdate();
			System.out.println(i);
			return i > 0 ? true : false;

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return false;
	}

}
