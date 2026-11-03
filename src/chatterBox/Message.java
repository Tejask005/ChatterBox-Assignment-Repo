package chatterBox;

import java.util.Date;

public class Message {
	//attributes
	private int id;
	private RegisteredUser user;
	private String text;
	private Date date;
	
	//constructor
	public Message(int id, RegisteredUser user, String text, Date date) {
		this.id = id; 
		this.user = user; 
		this.text = text;
		this.date = date;
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
	
	public Date getDate() {
		return date;
	}
	
	@Override
	public String toString() {
		 return "ID: " + id + ", Date: " + date.toString() +  ", User: " + user.getUsername() + ", Message: " + text;
	}

}
