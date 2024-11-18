package com.codegnan.jdbcpractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateEmployeeTable {
	static final String JDBC_URL = "jdbc:mysql://localhost:3306/adjava";
	static final String USERNAME = "root";
	static final String PASSWORD = "Sai@23112002";

	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Load and Register Driver Successfully.");

		Connection connection = null;
		Statement statement = null;
		try {
			connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
			System.out.println("Connection established Successfully.");
			statement = connection.createStatement();
			System.out.println("Statement object created.");

			String sqlQuery = "create table employee(" + "eno int AUTO_INCREMENT PRIMARY KEY," + "ename VARCHAR(100),"
					+ "esal DECIMAL(10,2)," + "eaddr varchar(100)" + ")";
			statement.executeUpdate(sqlQuery);
			System.out.println("Query excuted succesfully");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
