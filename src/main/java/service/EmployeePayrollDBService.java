package service;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import model.EmployeePayrollData;

public class EmployeePayrollDBService {
	public List<EmployeePayrollData> readData() {
		String sql = "SELECT * FROM employee_payroll";
		List<EmployeePayrollData> employeePayrollList = new ArrayList<EmployeePayrollData>();
		try (Connection connection = this.getConnection()){
			Statement statement = (Statement) connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while(result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				double salary = result.getDouble("salary");
				LocalDate startDate = result.getDate("start").toLocalDate();
				employeePayrollList.add(new EmployeePayrollData(id, name, salary, startDate));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeePayrollList;
	}

	private Connection getConnection() throws SQLException {
		String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
		String userName = "root";
		String password = "Mukul@1008";
		Connection connection;
		System.out.println("Connecting to database: "+jdbcURL);
		connection = (Connection) DriverManager.getConnection(jdbcURL, userName, password);
		System.out.println("Connection is successful! " +connection);
		return connection;
	}
}
