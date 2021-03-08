package Employee;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class EmployeeDetails {
	private static String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private static String DB_URL = "jdbc:mysql://localhost:3306/employee";
	private static String USER_NAME = "root";
	private static String PASSWORD = "";
	

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		try {
			//Load Driver class
			Class.forName(DRIVER_NAME);
			
			//Establish Connection
			 con= DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD);
			 
			//Create Statement
			stmt = con.createStatement();
			
			//Send and Execute Query
		      String sql;
		      sql =  "select e.empid,e.firstname,e.lastname,a.line1,"
		      		+ "a.line2,a.line3,a.city,a.state,a.zip,a.country,\r\n" + 
		      		"a.type,d.name from ((employee e\r\n" + 
		      		"inner join address a on e.empid=a.empid)\r\n" + 
		      		"inner join department d on d.empid=e.empid)\r\n" + 
		      		"where firstname = 'Paranji Muralikumar'";
		       ResultSet rs = stmt.executeQuery(sql);
		       
		    //  Create CSV File
			File f=new File("Employee_Details.csv");
			PrintWriter pw=new PrintWriter(f);
			StringBuilder sb=new StringBuilder();
			
			sb.append("Emp_id,First_name,Last_name,Line1,Line2,Line3,City,State,"
					+ "Zip,Country,Type,Department_name\r\n");
			
			//Process Result set
			while(rs.next()) {
				sb.append(rs.getInt(1));
				sb.append(",");
				sb.append(rs.getString(2));
				sb.append(",");
				sb.append(rs.getString(3));
				sb.append(",");
				sb.append(rs.getString(4));
				sb.append(",");
				sb.append(rs.getString(5));
				sb.append(",");
				sb.append(rs.getString(6));
				sb.append(",");
				sb.append(rs.getString(7));
				sb.append(",");
				sb.append(rs.getString(8));
				sb.append(",");
				sb.append(rs.getInt(9));
				sb.append(",");
				sb.append(rs.getString(10));
				sb.append(",");
				sb.append(rs.getString(11));
				sb.append(",");
				sb.append(rs.getString(12));
				sb.append(",");
				sb.append("\r\n");
			}
			pw.write(sb.toString());
			// Close Connection
			pw.close();
			stmt.close();
			con.close();
			System.out.println("CSV Created");
			
		}catch(Exception e) {
			System.out.println("ERROR");
		}

	}

}