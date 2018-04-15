package dataBaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JDBCSelenium {

	public static void main(String[] args) throws SQLException  {

		String host ="localhost";
		String port ="3306";


		Connection con = DriverManager.getConnection("jdbc:mysql://"  + host +":"+ port + "/selenium","root","root");
		Statement a = con.createStatement();
		ResultSet rs  =a.executeQuery("select * from credentials where ssn = 1451");
		


		while(rs.next()) { // It will move your result from baseindex to first index
			System.out.println(rs.getString("Username"));
		
			 System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.google.com/");
			driver.navigate().to("https://login.salesforce.com/");
			driver.findElement(By.cssSelector("#username")).sendKeys(rs.getString("Username"));
			driver.findElement(By.cssSelector("#password")).sendKeys(rs.getString("Password"));
			//DriverManager.getConnection("jdbc:mysql://"+localhost+":"+3306+"/employeeportal", "root", "root")
		}

	}
}

