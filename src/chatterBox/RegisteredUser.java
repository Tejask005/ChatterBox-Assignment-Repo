package chatterBox;

public class RegisteredUser extends User {
	
	private String username;
	private String password;

	public RegisteredUser(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof RegisteredUser))
			return false;
		RegisteredUser other = (RegisteredUser) obj;
		return this.username.equals(other.username) && this.password.equals(other.password);
	}

}
