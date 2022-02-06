package com.zee.zee5app.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.naming.InvalidNameException;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.repository.UserRepository2;
import com.zee.zee5app.repository.impl.UserRepositoryImpl;
import com.zee.zee5app.service.UserService2;

@Service
public class UserServiceImpl implements UserService2 {

	private UserRepository2 userRepository;
	
	
	
	@Override
	public String addUser(Register register) {
		// TODO Auto-generated method stub
		return this.userRepository.addUser(register);
	}

	@Override
	public String updateUser(String id, Register register) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Register> getUserById(String id) throws IdNotFoundException, InvalidNameException, InvalidIdLengthException {
		// TODO Auto-generated method stub
		return userRepository.getUserById(id);
	}

	@Override
	public Optional<List<Register>> getAllUsers() throws InvalidNameException, InvalidIdLengthException {
		// TODO Auto-generated method stub
//		return userRepository.getAllUsers();
		return userRepository.getAllUsers();
	}

	@Override
	public String deleteUserById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return userRepository.deleteUserById(id);
	}

}
