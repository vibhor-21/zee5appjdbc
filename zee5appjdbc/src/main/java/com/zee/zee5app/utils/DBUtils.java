
package com.zee.zee5app.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
	
	public static DBUtils dbutils = null;
	static Properties properties = null;
	
	Connection connection = null;
	
	private DBUtils() throws IOException {
		// TODO Auto-generated constructor stub
		properties = this.loadProperties();
	}
	
	
	public static DBUtils getInstance() throws IOException {
		if(dbutils ==null) {
			dbutils = new DBUtils();
		}
		return dbutils;
	}
	
	
	
	public Connection getConnection() {
		// the connection with Database
		
		try {
			
			if(connection==null || connection.isClosed()) {
				connection =	DriverManager.getConnection(properties.getProperty("jdbc.url"),
					properties.getProperty("jdbc.username"),
					properties.getProperty("jdbc.password"));
			connection.setAutoCommit(false);
			System.out.println(properties);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
	}
	
	
	
	public void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public Properties loadProperties() throws IOException {
		// read the properties file
		
	InputStream inputStream =	DBUtils.class.getClassLoader().getResourceAsStream("application.properties");
	
	Properties properties = new Properties();
	properties.load(inputStream);
	// it will read the properties internally.
	
	return properties;
	
	}
}