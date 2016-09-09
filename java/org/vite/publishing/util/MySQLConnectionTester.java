/**
 * 
 */
package org.vite.publishing.util;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author kevinscomp
 *
 */
public class MySQLConnectionTester {

	public static void main(String[] argv) {

		System.out.println("-------- MySQL JDBC Connection Testing ------------");

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return;
		}

		System.out.println("MySQL JDBC Driver Registered!");
		java.sql.Connection connection = null;

		try {
			//connection = DriverManager
			//.getConnection("jdbc:mysql://204.93.216.11:3306/kneibarg_vite_publishing","kneibarg_test", "test2014");
			
			//jdbc:mysql://localhost:3306/kneibarg_vite_publishing
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kneibarg_vite_publishing","root", "");

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
	  }

}
