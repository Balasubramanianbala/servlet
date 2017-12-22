package in.vamsoft.fileservlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.oreilly.servlet.MultipartRequest;


import in.vamsoft.filep.User;

/**
 * Servlet implementation class FileuploadServlet
 */
@WebServlet("/FileuploadServlet")
public class FileuploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileuploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		MultipartRequest mp=new MultipartRequest(request, "/home/vamsoft/Desktop");
		User u=new User();
		File xlfile=new File("file"+mp);
		FileInputStream fin=new FileInputStream(xlfile);
		org.apache.poi.ss.usermodel.Workbook workbook = null;
		try {
			 workbook = WorkbookFactory.create(fin);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
