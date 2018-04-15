package dataBaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class JDBConncetion {

	public static void main(String[] args) throws SQLException {

		String host ="localhost";
		String port ="3306";


		Connection con = DriverManager.getConnection("jdbc:mysql://"  + host +":"+ port + "/employeeportal","root","root");

		Statement a = con.createStatement();

		ResultSet rs  =a.executeQuery("select * from Employeeinfo where id = 56784");
		

		while(rs.next()) // It will move your result from baseindex to first index
		{


			System.out.println(rs.getString("name"));
			System.out.println (rs.getString("dept"));
			System.out.println(rs.getInt("age"));

			//DriverManager.getConnection("jdbc:mysql://"+localhost+":"+3306+"/employeeportal", "root", "root")
		}

	}
}
