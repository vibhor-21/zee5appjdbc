package com.zee.zee5app;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.service.LoginService;
import com.zee.zee5app.service.MoviesService2;
import com.zee.zee5app.service.SubscriptionService;
import com.zee.zee5app.service.SubscriptionService2;
import com.zee.zee5app.service.UserService;
import com.zee.zee5app.service.UserService2;
import com.zee.zee5app.service.impl.LoginServiceImpl;
import com.zee.zee5app.service.impl.MoviesServiceImpl;
import com.zee.zee5app.service.impl.SubscriptionServiceImpl;
import com.zee.zee5app.service.impl.UserServiceImpl;

import lombok.Data;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.naming.InvalidNameException;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.dto.ROLE;

@Data



public class Main {

	public static void main(String[] args) {
		
//		UserService2 service;
//		try {
//			service = UserServiceImpl.getInstance();
//			Optional<List<Register>> optional = service.getAllUsers();
//			
//			if(optional.isEmpty()) {
//				System.out.println("No records found");
//			}
//			else {
//				optional.get().forEach(e -> System.out.println(e));
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvalidNameException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvalidIdLengthException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
			
//			LoginService service;
//			try {
//				service = LoginServiceImpl.getInstance();
//				System.out.println(service.changeRole("vibhrr@gmail.com", ROLE.ROLE_ADMIN));
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
//		try {
//			Register register = new Register("Zee12344","abcdefg","kumar1","vibhrr@gmail.com","1234weew8");
//			
//			register.setContactNumber(new BigDecimal("9998989812"));
//			
////			UserService2 service = UserServiceImpl.getInstance();
//			String result = service.addUser(register);
//			System.out.println(result);
//			
//		}catch(InvalidIdLengthException | InvalidNameException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
//		try {
//			Login login = new Login("vibhorKumar","1234567qwe","");
//			LoginService service = LoginServiceImpl.getInstance();
//			String result = service.addCredentials(login);
//			System.out.println(result);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		UserService2 service;
//		try {
//			service = UserServiceImpl.getInstance();
//			Optional<Register> register = service.getUserById("xyz1234");
//			System.out.println(register.get());
//			
//			Optional<List<Register>> optional = service.getAllUsers();
//			
//			if(optional.isEmpty()) {
//				System.out.println("there is no records");
//			}
//			else {
//				optional.get().forEach(e -> System.out.println(e));
//			}
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IdNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvalidIdLengthException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvalidNameException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		
		
		
		
//		Login login = new Login();
//		login.setUserName("vibhor");
//		login.setPassword("abc");
////		
//		UserService2 userservice;
//		try {
//			userservice = UserServiceImpl.getInstance();
//		} catch (IOException e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		} // interface
//		
//		for(int i=1;i<=20;i++) {
//			Register register2 = new Register();
//			try {
//				register2.setId("ab0000"+i);
//				register2.setFirstName(100-i+"vibhor"+i);
//			} catch (InvalidIdLengthException e1) {
//				e1.printStackTrace();
//			}
//		    catch (InvalidNameException e) {
//				e.printStackTrace();
//			}
//			register2.setPassword("abc");
//			String result = userservice.addUser(register2);
//			System.out.println(result);
//		}
//		
//		Optional<Register> optional;
//		try {
//			optional = userservice.getUserById("ab00001");
//		} catch (IdNotFoundException e) {
//			e.printStackTrace();
//		}
//		
//		
////		List<Register> users = userservice.getAllUsers();
////		for(Register user: users) {
////			if(user!=null)
////				System.out.println(user.getFirstName()+" ");
////		}
//
//		userservice.getAllUsers().forEach(e -> System.out.println(e.getFirstName()));
//		
//		try {
//			System.out.println(userservice.deleteUserById("ab00001"));
//		} catch (IdNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		
//		
//		
//		
//		//subscription
//		SubscriptionService2 subscription_service = SubscriptionServiceImpl.getInstance();
//		
//		for(int i=1;i<=15;i++) {
//			Subscription subscription1 = new Subscription();
//			subscription1.setType("premium");
//			subscription1.setStatus(true);
//			subscription1.setPayment_Mode("online");
//			subscription1.setPack_Country("India");
//			subscription1.setId("x100");
//			subscription1.setExpiry_Date("19th August 2022");
//			subscription1.setDate_Of_Purchase("1st January 2022");
//			subscription1.setAutoRenewal(true);
//			String result = subscription_service.addSubscribtion(subscription1);
//			System.out.println(result);
//			
//		}
//		
//		Optional<Subscription> subscription1;
//		try {
//			subscription1 = subscription_service.getSubscriptionById("x100");
//		} catch (IdNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		List<Subscription> subscriptions = subscription_service.getAllSubscribtion();
//		for(Subscription sub:subscriptions) {
//			if(sub!=null) {
//				System.out.println(sub);
//			}
//		}
//		Subscription subscription2 = new Subscription("premium","1st January 2022" , false, "India", "online", true, "19th August 2022", "x101");
//		String result = subscription_service.addSubscribtion(subscription2);
//		
//		
//		try {
//			System.out.println(subscription_service.deleteSubscription("x100"));
//		} catch (IdNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		System.out.println(subscription_service.modifySubscription("abc", subscription2));
//		
//
//	//Movies
//	
//		MoviesService2 movieService = MoviesServiceImpl.getInstance();
//		for(int i=1;i<20;i++) {
//			String[] cast = {"a","b","c"};
//			Movies movie = new Movies("spiderman","22/02/2022","xyz","eng",cast,100,"x10000");
//			movieService.addMovies(movie);
//		}
	
	}
	
}
