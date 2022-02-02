package com.zee.zee5app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.zee.zee5app.config.Config;
import com.zee.zee5app.repository.UserRepository2;

public class MainSpring {

	public static void main(String[] args) {
		
		// do we need to establish / create spring env.
		
		AbstractApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
		UserRepository2 userRepository = applicationContext.getBean(UserRepository2.class);
		
		System.out.println(userRepository);
		UserRepository2 userRepository2 = applicationContext.getBean(UserRepository2.class);
		System.out.println(userRepository2);
		
		System.out.println(userRepository.hashCode());
		System.out.println(userRepository2.hashCode());
		System.out.println(userRepository.equals(userRepository2));
		applicationContext.close();
	}

}
