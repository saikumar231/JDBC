package com.codegnan.day5.BatchUpdates;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ScorallableResultSetDemo {
	static final String jdbc_url = "jdbc:mysql://localhost:3306/adjava";
	static final String USERNAME = "root";
	static final String PASSWORD = "Sai@23112002";

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DriverManager.getConnection(jdbc_url, USERNAME, PASSWORD);
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String selectQuery = "select * from employee";
			resultSet = statement.executeQuery(selectQuery);
			System.out.println("Records in Forward Direction: ");
			System.out.println();
			System.out.println("SNO\tEN0\tENAME\tESAL\tEADDR");
			System.out.println("============================================");
			while (resultSet.next()) {
				System.out.println(resultSet.getRow() + "--------->" + resultSet.getInt(1) + "\t"
						+ resultSet.getString(2) + "\t" + resultSet.getDouble(3) + "\t" + resultSet.getString(4));
				
			}
			System.out.println("----------------------------------------------------------------------------------------");
			System.out.println("Records in Backward Direction: ");
			System.out.println();
			System.out.println("SNO\tEN0\tENAME\tESAL\tEADDR");
			System.out.println("============================================");
			while (resultSet.previous()) {
				System.out.println(resultSet.getRow() + "--------->" + resultSet.getInt(1) + "\t"
						+ resultSet.getString(2) + "\t" + resultSet.getDouble(3) + "\t" + resultSet.getString(4));
				
			}
			resultSet.first();
			System.out.println(resultSet.getRow() + "--------->" + resultSet.getInt(1) + "\t"
					+ resultSet.getString(2) + "\t" + resultSet.getDouble(3) + "\t" + resultSet.getString(4));
			
			resultSet.last();
			System.out.println(resultSet.getRow() + "--------->" + resultSet.getInt(1) + "\t"
					+ resultSet.getString(2) + "\t" + resultSet.getDouble(3) + "\t" + resultSet.getString(4));
			
			resultSet.relative(-4);
			System.out.println(resultSet.getRow() + "--------->" + resultSet.getInt(1) + "\t"
					+ resultSet.getString(2) + "\t" + resultSet.getDouble(3) + "\t" + resultSet.getString(4));
			
			resultSet.absolute(4);
			System.out.println(resultSet.getRow() + "--------->" + resultSet.getInt(1) + "\t"
					+ resultSet.getString(2) + "\t" + resultSet.getDouble(3) + "\t" + resultSet.getString(4));
			
			System.out.println(resultSet.isFirst());
			System.out.println(resultSet.isLast());
			System.out.println(resultSet.isBeforeFirst());
			System.out.println(resultSet.isAfterLast());
			
			
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