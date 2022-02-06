package com.zee.zee5app.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

import com.zee.zee5app.utils.PasswordUtils;

@Configuration // it is used to mark on a config class/classes
// here we will hold all commonly required objects for our application.

@ComponentScan("com.zee.zee5app")
@PropertySource("classpath:application.properties") // it is responsible to read the property file

public class Config {
	//config : db related, reading prop file, commonly req beans(passwordEncoder)
	
	@Autowired   // will bring the already created objects based on the name(ref name
	Environment environment; // this impl obj is prepared by spring
	
	@Bean(name ="ds") // for providing the singleton object
	//if we will not specify the bean name then it will take / consider
	@Scope("singleton")
	// to get multiple objects scope prototype
	public DataSource dataSource() {
		
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setUsername(environment.getProperty("jdbc.username"));
		basicDataSource.setPassword(environment.getProperty("jdbc.password"));
		basicDataSource.setUrl(environment.getProperty("jdbc.url"));
		basicDataSource.setDefaultAutoCommit(false);
		return basicDataSource;
	}
	
	@Bean
	public PasswordUtils passwordUtils() {
		return new PasswordUtils();
	}
	
}
