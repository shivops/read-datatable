import java.sql.*;
import java.util.Properties;
public class jtest{
	public static void main(String[] args) {
		try(
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "user");
Statement stmt = conn.createStatement();
) {
String strSelect = "select no, name from data";
System.out.println("The SQL query is: " + strSelect);
System.out.println();

ResultSet rset = stmt.executeQuery(strSelect);

System.out.println("The records selected are:");int rowCount = 0;
while(rset.next()) {
	int no = rset.getInt("no");
	String name = rset.getString("name");
	System.out.println(no + "," + name);
	++rowCount;
}
System.out.println("Total number of records = " + rowCount);

} catch(SQLException ex) {
	ex.printStackTrace();
}
}
}