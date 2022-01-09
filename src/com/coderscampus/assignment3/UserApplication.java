package com.coderscampus.assignment3;

import java.io.IOException;
import java.util.Scanner;

public class UserApplication {

	 public static void main(String[] args) throws IOException {

		  UserService userService = new UserService();
		  User[] users = userService.readFile();

		  Scanner userInput = new Scanner(System.in);

		  boolean isUserNameAndPasswordCorrect = false;
		  int j = 1;
		  while(j < 5 && !(isUserNameAndPasswordCorrect)) {
				System.out.println("username");
				String userNameInput = userInput.next();
				System.out.println("password");
				String passwordInput = userInput.next();

				for(int i = 0; i < users.length; i++) {

					 if(userNameInput.equalsIgnoreCase(users[i].getUsername()) && (passwordInput
							 .equals((users[i].getPassword())))) {
						  isUserNameAndPasswordCorrect = true;
						  System.out.println("Welcome " + users[i].getName());

					 }

				}
				if(j < 4 && !isUserNameAndPasswordCorrect) {
					 System.out.println("Invalid login, please try again");

				}
					j++;
		  }

		  if(!isUserNameAndPasswordCorrect) {
				System.out.println("Too many failed login attempts, you are now locked out.");
				userInput.close();
		  }

	 }
}

