package com.zee.zee5app.service.impl;

import java.io.IOException;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.ROLE;
import com.zee.zee5app.repository.LoginRepo;
import com.zee.zee5app.repository.impl.LoginRepoImpl;
import com.zee.zee5app.service.LoginService;

public class LoginServiceImpl implements LoginService {

	LoginRepo loginRepo = LoginRepoImpl.getInstance();
	
	private LoginServiceImpl() throws IOException {
		
	}
	private static LoginService loginService = null;
	public static LoginService getInstance() throws IOException {
		if(loginService==null)
			return new LoginServiceImpl();
		return loginService;
	}
	
	
	@Override
	public String addCredentials(Login login) {
		// TODO Auto-generated method stub
		return this.loginRepo.addCredentials(login);
	}

	@Override
	public String deleteCredentials(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changePassword(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String changeRole(String userName, ROLE role) {
		// TODO Auto-generated method stub
		return loginRepo.changeRole(userName, role);
	}

}
