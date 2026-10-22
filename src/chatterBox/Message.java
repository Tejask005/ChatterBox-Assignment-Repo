package chatterBox;

public class Message {
	//attributes
	private int id;
	private RegisteredUser user;
	private String text; 
	
	//constructor
	public Message(int id, RegisteredUser user, String text) {
		this.id = id; 
		this.user = user; 
		this.text = text;
	}
	
	public int getId() { 
		return id;
	}
	
	public String getText() {
		return text; 
	}
	
	public RegisteredUser getUser() {
		return user;
	}
	
	@Override
	public String toString() {
		 return user.getUsername() + id + ":\n" + text;
	}

}
