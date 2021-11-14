package service;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import com.mysql.jdbc.Connection;

public class EmployeePayrollDBService {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
		String uname = "root";
		String pwd = "Mukul@1008";
		Connection connection;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver is loaded....");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Enumeration<Driver> drivers = DriverManager.getDrivers();
		while(drivers.hasMoreElements()) {
			Driver driver = drivers.nextElement();
			System.out.println("Driver Name : " + driver);
		}
		
		try {
			connection = (Connection) DriverManager.getConnection(url, uname, pwd);
			System.out.println("Connection to the DB succsessful..! " + connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
