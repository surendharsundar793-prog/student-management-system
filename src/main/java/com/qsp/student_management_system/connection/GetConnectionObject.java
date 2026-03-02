package com.qsp.student_management_system.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnectionObject {
	private static final String URL ="jdbc:postgresql://localhost:5432/student_management_system";
	private static final String USER ="postgres";
	private static final String PWD ="admin";

	public static Connection getconnection() {
		try {
			Class.forName("org.postgresql.Driver");
			
			Connection c = DriverManager.getConnection(URL,USER,PWD);
			return c;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
