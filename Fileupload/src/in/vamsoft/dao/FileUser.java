package in.vamsoft.dao;

import java.io.FileInputStream;
import java.sql.DriverManager;
import java.util.Iterator;
import java.util.Vector;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class FileUser {

	public static void main(String[] args) {
		String fileName = "/home/vamsoft/Desktop/test.xls";
		Vector dataHolder = read(fileName);
		saveToDatabase(dataHolder);
	}

	public static Vector read(String fileName) {
		Vector cellVectorHolder = new Vector();
		try {
			FileInputStream myInput = new FileInputStream(fileName);
			POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);
			HSSFWorkbook myWorkBook = new HSSFWorkbook(myFileSystem);
			HSSFSheet mySheet = myWorkBook.getSheetAt(0);
			Iterator rowIter = mySheet.rowIterator();
			while (rowIter.hasNext()) {
				HSSFRow myRow = (HSSFRow) rowIter.next();
				Iterator cellIter = myRow.cellIterator();
				Vector cellStoreVector = new Vector();
				while (cellIter.hasNext()) {
					HSSFCell myCell = (HSSFCell) cellIter.next();
					cellStoreVector.addElement(myCell);
				}
				cellVectorHolder.addElement(cellStoreVector);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cellVectorHolder;
	}

	private static void saveToDatabase(Vector dataHolder) {
		String username = "";
		String email = "";
		String password = "";
		for (int i = 0; i < dataHolder.size(); i++) {
			Vector cellStoreVector = (Vector) dataHolder.elementAt(i);
			for (int j = 0; j < cellStoreVector.size(); j++) {
				HSSFCell myCell = (HSSFCell) cellStoreVector.elementAt(j);
				String st = myCell.toString();
				username = st.substring(0, 1);
				email = st.substring(0);
				password = st.substring(0);
			}
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root",
						"root");
				Statement stat = (Statement) con.createStatement();
				int k = stat.executeUpdate("insert into user(username,emailid,password) value('" + username + "','"
						+ email + "','" + password + "')");
				System.out.println("Data is inserted");
				stat.close();
				con.close();
			} catch (Exception e) {
			}
		}
	}
}
