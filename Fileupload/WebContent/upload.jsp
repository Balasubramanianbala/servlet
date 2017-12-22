<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<body>

<%@ page import="java.io.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*"%>


<%@ page import="org.apache.poi.ss.usermodel.*"%>
<%@ page import="org.apache.poi.xssf.usermodel.XSSFSheet"%>
<%@ page import="org.apache.poi.xssf.usermodel.XSSFWorkbook"%>

<%
    String saveFile="";
    String contentType = request.getContentType();

    if ((contentType != null) && (contentType.indexOf("multipart/form-data") >= 0))
    {
        DataInputStream in = new DataInputStream(request.getInputStream());
        int formDataLength = request.getContentLength();
        byte dataBytes[] = new byte[formDataLength];
        int byteRead = 0;
        int totalBytesRead = 0;

        while (totalBytesRead < formDataLength)
        {
            byteRead = in.read(dataBytes, totalBytesRead,formDataLength);
            totalBytesRead += byteRead;
        }

        String file = new String(dataBytes);

        saveFile = file.substring(file.indexOf("filename=\"") + 10);
        saveFile = saveFile.substring(0, saveFile.indexOf("\n"));
        saveFile = saveFile.substring(saveFile.lastIndexOf("\\") + 1,saveFile.indexOf("\""));

        int lastIndex = contentType.lastIndexOf("=");

        String boundary = contentType.substring(lastIndex + 1,contentType.length());

        int pos;

        pos = file.indexOf("filename=\"");
        pos = file.indexOf("\n", pos) + 1;
        pos = file.indexOf("\n", pos) + 1;
        pos = file.indexOf("\n", pos) + 1;

        int boundaryLocation = file.indexOf(boundary, pos) - 4;

        int startPos = ((file.substring(0, pos)).getBytes()).length;

        int endPos = ((file.substring(0, boundaryLocation)).getBytes()).length;

        File ff = new File(saveFile);

        FileOutputStream fileOut = new FileOutputStream(ff);
        fileOut.write(dataBytes, startPos, (endPos - startPos));

        fileOut.flush();
        fileOut.close();
%>

<table>
    <tr>
        <td><b>You have successfully upload the file:</b>
            <% out.println(saveFile);
            %>
        </td>
    </tr>
</table>

    <%
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        FileInputStream fileInputStream;
            Statement stmt = null;
            File f = null;
            int count = 0;

        ArrayList<String> mylist = new ArrayList<String>();

        try
        {
            Class.forName("com.mysql.jdbc.Driver");  

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/parag","root","tiger"); 
            System.out.println("connection sucessfulyyy");


         //   f = new File("/home/vamsoft/Desktop/test.xslx");

            preparedStatement = connection.prepareStatement("insert into exlogin(username) values(?)");

        //    fileInputStream = new FileInputStream(new File("/home/vamsoft/Desktop/test.xslx"));

            preparedStatement.setBinaryStream(1, (InputStream)fileInputStream, (int)(f.length()));

            preparedStatement.executeUpdate();

            System.out.println("connection sucessfulyyy");

            resultSet = stmt.executeQuery("SELECT COUNT(*) FROM exlogin");

             while(resultSet.next())
                 {

                         int val = resultSet.getInt(1);

                         System.out.println(val);

                        count = val+1;

                }

                preparedStatement.setInt(1,count);

                /* We should now load excel objects and loop through the worksheet data */
                    fileInputStream  = new FileInputStream(new File("/home/vamsoft/Desktop/test.xslx"));
                   // System.out.println("FileInputStream Object created..! "+filePath);

                /* Load workbook */
                
                
                XSSFWorkbook workbook = new XSSFWorkbook ("/home/vamsoft/Desktop/test.xslx");
                System.out.println("XSSFWorkbook Object created..! ");

                /* Load worksheet */
                XSSFSheet sheet = workbook.getSheetAt(0);
                System.out.println("XSSFSheet Object created..! ");

                // we loop through and insert data
            Iterator<Row> ite = sheet.rowIterator();
                System.out.println("Row Iterator invoked..! ");

                while(ite.hasNext()) 
               {
                    Row row = (Row) ite.next(); 

                    Iterator<Cell> cellIterator = row.cellIterator();
                    int index = 1;

                    while(cellIterator.hasNext()) 
                    {
                        Cell cell = cellIterator.next();

                        switch(cell.getCellType()) 
                        { 
                             case Cell.CELL_TYPE_STRING: //handle string columns
                                    preparedStatement.setString(index, cell.getStringCellValue()); 
                                    System.out.println("getting cell value..! "+cell.getStringCellValue());

                                      break;
                              case Cell.CELL_TYPE_NUMERIC: //handle double data

                                    double i = (double)cell.getNumericCellValue();

                                    preparedStatement.setFloat(index, (float) cell.getNumericCellValue());

                                    break;

                            }
                               index++;

                    }
                //we can execute the statement before reading the next row
                preparedStatement.executeUpdate();
                }

                /* Close input stream */
                   fileInputStream.close();
                   /* Close prepared statement */
                   preparedStatement.close();

                   /* Close connection */
                   connection.close();




        }

        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    %>

</body>
    