package in.vamsoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.vamsoft.pojo.DBConnectionUtil;
import in.vamsoft.pojo.ModelQuestion;


public class ModelQuestionDao {

	Connection cn;
	 ResultSet rs ;
	public ModelQuestionDao() {
		super();
		cn=DBConnectionUtil.getConnection();
	}
	
	public List<ModelQuestion> getQuestions() {

		System.out.println("inside method");
	    List<ModelQuestion> list = new ArrayList<>();
	    try (PreparedStatement ps = cn.prepareStatement("select * from ModelQuestion")) {
	       rs = ps.executeQuery();
	      ModelQuestion e = null;
	      
	      while (rs.next()) {
	        e = new ModelQuestion();
	        e.setQno((rs.getInt(1)));
	        System.out.println(rs.getInt(1));
	        e.setQut((rs.getString(2)));
	        e.setOpta((rs.getString(3)));
	        e.setOptb((rs.getString(4)));
	        e.setOptc(rs.getString(5));
	        e.setOptd(rs.getString(6));	        
	        list.add(e);
	        System.out.println(list);
	        }
	      return list;
	      
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    return null;
	  }

	 public boolean getAnswers(String correctAnswer, String question) {
		    try (PreparedStatement preparedStatement = cn.prepareStatement("select Question,CorrectAnswer from ModelQuestion")) {

		      ResultSet rs = preparedStatement.executeQuery();

		      while (rs.next()) {
		        if (question.equals(rs.getString(1)) && correctAnswer.equals(rs.getString(2))) {
		          return true;
		        }
		      }

		    } catch (SQLException e) {
		      e.printStackTrace();
		    }

		    return false;

	 }
}
