package com.zee.zee5app.repository.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import javax.naming.InvalidNameException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.ROLE;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.repository.LoginRepo;
import com.zee.zee5app.repository.UserRepository2;
import com.zee.zee5app.utils.DBUtils;
import com.zee.zee5app.utils.PasswordUtils;

@Repository // it will create a singleton object for us.

public class UserRepositoryImpl implements UserRepository2 {

	@Autowired // it will bring already created obj
	DataSource dataSource;
	PasswordUtils passwordUtils;
	static private LoginRepo loginRepo = null;
	
	public UserRepositoryImpl() throws IOException {
		loginRepo = LoginRepoImpl.getInstance();
	}
	
	
	
	
	
	@Override
	public String addUser(Register register) {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String insertStatement = "insert into register"
				+" (regId, firstname,lastname,email,"
				+ "contactnumber,password)" + 
				"values(?,?,?,?,?,?)";
		
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		try {
			preparedStatement = connection.prepareStatement(insertStatement);
			
			preparedStatement.setString(1, register.getId());
			preparedStatement.setString(2, register.getFirstName());
			preparedStatement.setString(3, register.getLastName());
			preparedStatement.setString(4, register.getEmail());
			preparedStatement.setBigDecimal(5, register.getContactNumber());
			
			String salt = passwordUtils.getSalt(30);
			String encryptedPassword = passwordUtils.generateSecurePassword(insertStatement, salt);
			preparedStatement.setString(6, encryptedPassword);
			
			int result = preparedStatement.executeUpdate();
			
			if(result>0) {
				connection.commit();
				Login login = new Login();
				login.setUserName(register.getEmail());
				login.setPassword(encryptedPassword);
				login.setRegId(register.getId());
				login.setRole(ROLE.ROLE_USER);
				String res = loginRepo.addCredentials(login);
				if(res.equals("success")) {
					return "success";
				}
				else {
					connection.rollback();
					return "fail";
				}
			}
			else {
				connection.rollback();
				return "fail";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return "fail";
		}		
	}

	@Override
	public String updateUser(String id, Register register) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Register> getUserById(String id) throws IdNotFoundException, InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		Connection connection= null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String selectStatement = "select * from register where regId=?";
		
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			preparedStatement = connection.prepareStatement(selectStatement);
			preparedStatement.setString(1, id);
			
			// to retrieve the data
			// RS will hold the complete result
			
			resultSet =  preparedStatement.executeQuery();
			
			// RS object its a single one which is holding all the records
			// do we need to traverse it? ===> yes
			// 
			if (resultSet.next()) {
				
				
				//next method is used to traverse the RS, initially Rs will
				//be places just above the 1st rec. when u will call 1st time rs
				//will retrive the 1st rec & it will refer the 2n one.
				
				Register register = new Register();
				register.setId(resultSet.getString("regId"));
				register.setFirstName(resultSet.getString("firstname"));
				register.setLastName(resultSet.getString("lastname"));
				register.setEmail(resultSet.getString("email"));
				register.setPassword(resultSet.getString("password"));
				register.setContactNumber(resultSet.getBigDecimal("contactnumber"));
				return Optional.of(register);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Optional.empty();
	}
	

	@Override
	public String deleteUserById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String deleteStatement = "delete from register where regId=?";
		
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			preparedStatement = connection.prepareStatement(deleteStatement);
			
			preparedStatement.setString(1, id);
			
			int result = preparedStatement.executeUpdate();
			
			if(result>0) {
				
				//delete his credentials
				String res = loginRepo.deleteCredentials(id);
				if(res.equals("success")) {
					return "success";
				}
				else {
					connection.rollback();
					return "fail";
				}
			}
			else
				return "fail";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
	}


	@Override
	public Optional<List<Register>> getAllUsers() throws InvalidNameException, InvalidIdLengthException {
		
		ArrayList<Register> users = new ArrayList<>();
		
		Connection connection= null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String selectStatement = "select * from register";
		
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			preparedStatement = connection.prepareStatement(selectStatement);
			// to retrieve the data
			// RS will hold the complete result
			
			resultSet =  preparedStatement.executeQuery();
			
			// RS object its a single one which is holding all the records
			// do we need to traverse it? ===> yes
			// 
			while (resultSet.next()) {
				
				
				//next method is used to traverse the RS, initially Rs will
				//be places just above the 1st rec. when u will call 1st time rs
				//will retrive the 1st rec & it will refer the 2n one.
				
				Register register = new Register();
				register.setId(resultSet.getString("regId"));
				register.setFirstName(resultSet.getString("firstname"));
				register.setLastName(resultSet.getString("lastname"));
				register.setEmail(resultSet.getString("email"));
				register.setPassword(resultSet.getString("password"));
				register.setContactNumber(resultSet.getBigDecimal("contactnumber"));
				users.add(register);
			}
			return Optional.ofNullable(users);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Optional.empty();
		
	}


}
