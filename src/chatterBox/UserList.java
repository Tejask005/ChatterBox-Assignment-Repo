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
	
	public String getPasswordByUsername(String username) {
		for (User user: users) {
			RegisteredUser regUser = (RegisteredUser) user;
			if (regUser.getUsername().equals(username))
				return regUser.getPassword();
		}
		//if user does not exist in user list
		return null;
	}
	
}
