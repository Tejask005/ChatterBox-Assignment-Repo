package chatterBox;

import java.util.ArrayList;

public class UserList {
	
	private ArrayList<User> users;
	
	public UserList() {
		users = new ArrayList<>();
		users.add(new RegisteredUser("user1", "123"));
		users.add(new RegisteredUser("user2", "456"));
		users.add(new RegisteredUser("user3", "789"));
	}
	
	public boolean userExists(User user) {
		return users.contains(user);
	}

	/*
	public static void main(String[] args) {
		UserList userList = new UserList();
		System.out.println(new GuestUser().equals(new GuestUser()));
		System.out.println(new GuestUser().equals(new RegisteredUser("user1", "123")));
		System.out.println(new RegisteredUser("user1", "123").equals(new RegisteredUser("user2", "456")));
		System.out.println(new RegisteredUser("user1", "123").equals(new RegisteredUser("user1", "123")));
		System.out.println(userList.userExists(new RegisteredUser("user1", "123")));
		System.out.println(userList.userExists(new RegisteredUser("hello", "world")));
	}
	*/
	
}
