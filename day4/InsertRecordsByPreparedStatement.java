package com.codegnan.day4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertRecordsByPreparedStatement {
	static final String jdbc_url = "jdbc:mysql://localhost:3306/adjava";
	static final String USERNAME = "root";
	static final String PASSWORD = "Sai@23112002";

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		try {
			connection = DriverManager.getConnection(jdbc_url, USERNAME, PASSWORD);
			String insertQuery = "insert into employee(eno,ename,esal,eaddr) values (?,?,?,?)";
			preparedstatement = connection.prepareStatement(insertQuery);
			preparedstatement.setInt(1, 7);
			preparedstatement.setString(2, "karan");
			preparedstatement.setDouble(3, 80000);
			preparedstatement.setString(4, "prakasham");
			int rowsAffected = preparedstatement.executeUpdate();
			System.out.println(rowsAffected + " rows inserted successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (preparedstatement != null) {
				try {
					preparedstatement.close();
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
