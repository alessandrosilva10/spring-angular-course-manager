package com.javacorner.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.javacorner.admin.dao.UserDAO;
import com.javacorner.admin.utility.OperationUtilityClass;

@SpringBootApplication
public class JavacornerApplication implements CommandLineRunner {

	@Autowired
	private UserDAO userDAO;

	public static void main(String[] args) {
		SpringApplication.run(JavacornerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		OperationUtilityClass.usersOperations(userDAO);
	}
}
