package com.app;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.app.model.UserData;
import com.app.repository.UserRepositery;

@SpringBootApplication
public class LoginUserApiApplication implements CommandLineRunner{

	
	 @org.springframework.beans.factory.annotation.Autowired(required=true)
	  private BCryptPasswordEncoder bCryptPasswordEncoder;
	 
	@Autowired
	private UserRepositery repositery;
	
	public static void main(String[] args) {
		SpringApplication.run(LoginUserApiApplication.class, args);
		System.out.println("this is my API");
	}

	@Override
	public void run(String... args) throws Exception {
		repositery.save(new UserData("prince",bCryptPasswordEncoder.encode("12345")));
		repositery.save(new UserData("silu",bCryptPasswordEncoder.encode("123")));
		repositery.save(new UserData("akash",bCryptPasswordEncoder.encode("123")));
		repositery.save(new UserData("rupam",bCryptPasswordEncoder.encode("123")));
		
		List<UserData> user=repositery.findAll();
		
		Iterator<UserData> itr=user.iterator();
		while(itr.hasNext()) {
                System.out.println(itr.next());
		}
		
	}
		
	

}
