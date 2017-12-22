package in.vamsoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import in.vamsoft.pojo.DBConnectionUtil;
import in.vamsoft.pojo.UserCreation;

public class UserCreationDao {
	 Connection cn = null;
	  ResultSet rs = null;
	
	public UserCreationDao() {
		cn=DBConnectionUtil.getConnection();
	}

	public boolean UserRegister(UserCreation user) {
		 try(PreparedStatement preparedStatement = cn.prepareStatement("insert into usercreation values(seq_person.nextval,?,?,?,?)")){
			 preparedStatement.setString(1, user.getUsername());
		      preparedStatement.setInt(2, user.getPhno());
		      preparedStatement.setString(3, user.getEmail_id());
		      preparedStatement.setString(4, user.getPasswd());
			 int result = preparedStatement.executeUpdate();
			 System.out.println(user);
			 return result>0?true:false;
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		return false;		   		   	  
	  }
	  
	 public boolean  userValidate(String emailid,String passwd) {

		 boolean st=false;
		    try(PreparedStatement preparedStatement = cn.prepareStatement("select emailid,passwd from usercreation where emailid=? and passwd=?")){
		    	preparedStatement.setString(1, emailid);
		         preparedStatement.setString(2, passwd);
		         ResultSet rs =preparedStatement.executeQuery();
		        st=rs.next();
		      return true;
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		    
		   return st;
		  }
	 
	 public String getName(String mail) {
		 
		 try(PreparedStatement preparedStatement = cn.prepareStatement("select user_name from usercreation where emailid=?")){
			preparedStatement.setString(1, mail);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				return (resultSet.getString(1));
			}
			 
			 
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return null;
		 
	 }
}
