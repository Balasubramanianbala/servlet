package in.vamsoft.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.vamsoft.pojo.DBConnectionUtil;
import in.vamsoft.pojo.DemoBean;

public class Employee {

	Connection cn;
	public Employee() {
		super();
		cn=DBConnectionUtil.getConnection();
	}
	
	public List<DemoBean> emp(){
		List<DemoBean> list=new ArrayList<>();
		DemoBean d=null;
		try(PreparedStatement ps=cn.prepareStatement("select * from emp1")){
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				d=new DemoBean();
				d.setName(rs.getString(1));
				d.setAge(rs.getInt(2));
				list.add(d);
				System.out.println(list);
			}
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	

}
