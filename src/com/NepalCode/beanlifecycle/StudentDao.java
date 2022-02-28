package com.NepalCode.beanlifecycle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDao {

	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/studentdatabase";
	private String userName = "root";
	private String password = "root";

	public void selectAllRows() throws ClassNotFoundException, SQLException {

		System.out.println("Reteriving student data");
		// 1. step: load driver
		Class.forName(driver);

		// 2. step: get a connection
		Connection con = DriverManager.getConnection(url, userName, password);

		// 3. step: execute quer
		Statement stmt = con.createStatement();

		// 4. step: set the result to execute query

		ResultSet rs = stmt.executeQuery("SELECT * FROM studentdatabase.studentinfo");

		while (rs.next()) {
			int studentid = rs.getInt(1);
			String studentName = rs.getString(2);
			String phoneNum = rs.getString(3);
			double fees = rs.getDouble(4);

			System.out.println("Student id is: " + studentid + "student name is: " + studentName
					+ " student phone num is: " + phoneNum + " fees is: " + fees);
		}
	}

	public void deleteStudentRecord(int studentId) throws ClassNotFoundException, SQLException {
		// 1. step: load driver
		Class.forName(driver);

		// 2. step: get a connection
		Connection con = DriverManager.getConnection(url, userName, password);

		// 3. step: execute quer
		Statement stmt = con.createStatement();

		// 4. step: set the result to execute query

		stmt.executeUpdate("DELETE  FROM studentdatabase.studentinfo where student_id = " + studentId);

		System.out.println("Deleting student data" + studentId);

	}

}
