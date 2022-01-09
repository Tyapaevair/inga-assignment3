package com.coderscampus.assignment3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UserService {

	 public User[] readFile() throws IOException {

		  BufferedReader fileReader = null;
		  String[] newUser = new String[0];
		  try {
				fileReader = new BufferedReader(new FileReader("data.txt"));

				BufferedReader bufferedReader = new BufferedReader(fileReader);

				String inputUser = "";
				int i = 0;
				User[] userObjects = new User[4];

				while((inputUser = bufferedReader.readLine()) != null) {
					 User user = new User();
					 newUser = inputUser.split(",");
					 user.setUsername(newUser[0]);
					 user.setPassword(newUser[1]);
					 user.setName(newUser[2]);
					 userObjects[i] = user;
					 i++;

				}
				return userObjects;
		  } catch(FileNotFoundException e) {
				System.out.println("The file wasn't found");
				e.printStackTrace();
		  } catch(IOException e) {
				System.out.println("There was an I/O Exeption");
				e.printStackTrace();
		  } finally {
				try {
					 fileReader.close();
				} catch(IOException e) {
					 e.printStackTrace();
				}
		  }

		  return new User[0];
	 }
}




