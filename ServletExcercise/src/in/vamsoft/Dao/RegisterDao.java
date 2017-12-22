package in.vamsoft.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import in.vamsoft.pojo.DBConnectionUtil;
import in.vamsoft.pojo.User;

public class RegisterDao {

	
	static Connection cn;
	public RegisterDao() {
		super();
		cn=DBConnectionUtil.getConnection();
		
	}

	public static int register(User u){  
		int status=0;  
		System.out.println("inside the register");
		try(PreparedStatement ps=cn.prepareStatement("insert into user1 values(?,?,?)")){  
		ps.setString(1,u.getUname());  
		ps.setString(2,u.getUemail());  
		ps.setString(3,u.getUpass());  
		              
		status=ps.executeUpdate();  
		}catch(Exception e){}  
		      
		return status;  
	}
}
