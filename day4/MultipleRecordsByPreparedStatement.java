package com.codegnan.day4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class MultipleRecordsByPreparedStatement {
	static final String jdbc_url = "jdbc:mysql://localhost:3306/adjava";
	static final String USERNAME = "root";
	static final String PASSWORD = "Sai@23112002";

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		Scanner scanner = new Scanner(System.in);
		try {
			connection = DriverManager.getConnection(jdbc_url, USERNAME, PASSWORD);
			String insertQuery = "insert into employee values (?,?,?,?)";
			preparedstatement = connection.prepareStatement(insertQuery);
			System.out.println("Enter the Number of Records to Insert : ");
			int numberOfRecords = scanner.nextInt();
			for (int i = 0; i < numberOfRecords; i++) {
				System.out.println("Enter Details for Record " + (i + 1) + " : ");
				System.out.println("============================================= ");
				System.out.println("Enter Employee Number ");
				int eno = scanner.nextInt();
				System.out.println("Enter Employee Name ");
				String ename = scanner.next();
				System.out.println("Enter Employee Salary ");
				double esal = scanner.nextDouble();
				System.out.println("Enter Employee Address ");
				String eaddr = scanner.next();
				
				preparedstatement.setInt(1, eno);
				preparedstatement.setString(2,ename);
				preparedstatement.setDouble(3,esal);
				preparedstatement.setString(4, eaddr);
				int rowsAffected = preparedstatement.executeUpdate();
				System.out.println(rowsAffected +" Rows Inserted Successfully..");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(scanner!=null) {
				scanner.close();
			}
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
