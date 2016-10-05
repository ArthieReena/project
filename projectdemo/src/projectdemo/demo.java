package projectdemo;

import java.sql.*;

public class demo {

	public static void main(String args[]) throws ClassNotFoundException, SQLException{
		Class.forName("org.h2.Driver");
		Connection c = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
		Statement s = c.createStatement();
		//s.execute("CREATE TABLE employee(eid INT PRIMARY KEY,ename VARCHAR(25),dept VARCHAR(25))");
		int i = s.executeUpdate("INSERT INTO employee values(2,'asd','asdf')");
		System.out.println(i+" row inserted");
		ResultSet rs = s.executeQuery("SELECT * FROM employee");
		while(rs.next()){
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
		}
		rs.close();
		s.close();
		c.close();
	}
}
