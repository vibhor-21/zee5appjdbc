package com.zee.zee5app;

import java.io.IOException;
import java.math.BigDecimal;

import javax.naming.InvalidNameException;
import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.zee.zee5app.config.Config;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.repository.UserRepository2;

public class MainSpring {

	public static void main(String[] args) {
		
		// do we need to establish / create spring env.
		// initaialize application context container
		// java based config
		
		AbstractApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
		
		DataSource dataSource1 = applicationContext.getBean("ds",DataSource.class);
		System.out.println(dataSource1.hashCode());
		DataSource dataSource2 = applicationContext.getBean("ds",DataSource.class);
		System.out.println(dataSource2.hashCode());
		System.out.println(dataSource1.equals(dataSource2));

		
//		UserRepository2 userRepository = applicationContext.getBean(UserRepository2.class);
//		
//		System.out.println(userRepository);
//		UserRepository2 userRepository2 = applicationContext.getBean(UserRepository2.class);
//		System.out.println(userRepository2);
//		
//		System.out.println(userRepository.hashCode());
//		System.out.println(userRepository2.hashCode());
//		System.out.println(userRepository.equals(userRepository2));
//		
//		DataSource dataSource = applicationContext.getBean("dataSource",DataSource.class);
//		System.out.println(dataSource!=null);
//		
//		try {
//		Register register = new Register("Zee12346","abcdefg","kumar1","vibhor4@gmail.com","1234weew8");
//		
//		register.setContactNumber(new BigDecimal("9998989812"));
//		
//		
//		String result = userRepository.addUser(register);
//		System.out.println(result);
//		
//		}catch(InvalidIdLengthException | InvalidNameException e) {
//			e.printStackTrace();
//		}
//		
		applicationContext.close();
	}

}
