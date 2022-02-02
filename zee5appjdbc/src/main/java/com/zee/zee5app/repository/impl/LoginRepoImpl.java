package com.zee.zee5app.repository.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.ROLE;
import com.zee.zee5app.repository.LoginRepo;
import com.zee.zee5app.service.LoginService;
import com.zee.zee5app.service.impl.LoginServiceImpl;
import com.zee.zee5app.utils.DBUtils;

public class LoginRepoImpl implements LoginRepo {

	DBUtils dbUtils = DBUtils.getInstance();
	
	private LoginRepoImpl() throws IOException {
		
	}
	
	private static LoginRepo loginService=null;
	public static LoginRepo getInstance() throws IOException {
		if(loginService==null) {
			return new LoginRepoImpl();
		}
		return loginService;
	}
	
	@Override
	public String addCredentials(Login login) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String insertStatement = "insert into login"
				+" (username,password,regId,role)" + 
				"values(?,?,?,?)";
		
		connection = dbUtils.getConnection();
		
		try {
			preparedStatement = connection.prepareStatement(insertStatement);
			
			preparedStatement.setString(1, login.getUserName());
			preparedStatement.setString(2, login.getPassword());
			preparedStatement.setString(3, login.getRegId());
			preparedStatement.setString(4, login.getRole().toString());
			int result = preparedStatement.executeUpdate();
			
			if(result>0) {
				connection.commit();
				return "success";
			}
			else
				return "fail";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
		finally {
			dbUtils.closeConnection(connection);
		}
		
	}

	@Override
	public String deleteCredentials(String userName) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String deleteStatement = "delete from register where regId=?";
		
		connection = dbUtils.getConnection();
		
		try {
			preparedStatement = connection.prepareStatement(deleteStatement);
			
			preparedStatement.setString(1, userName);
			
			int result = preparedStatement.executeUpdate();
			
			if(result>0) {
				connection.commit();
				return "success";
			}
			else
				return "fail";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
		finally {
			dbUtils.closeConnection(connection);
		}
		
	}

	@Override
	public String changePassword(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changeRole(String userName, ROLE role) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String updateStatement = "UPDATE login SET role=? WHERE username=?";
		connection = dbUtils.getConnection();
		
		try {
			preparedStatement = connection.prepareStatement(updateStatement);
			preparedStatement.setString(1, role.toString());
			preparedStatement.setString(2, userName);
			
			int result = preparedStatement.executeUpdate();
			if(result>0) {
				connection.commit();
				return "success";
			}
			else
				return "fail";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
		finally {
			dbUtils.closeConnection(connection);
		}
	}
}

