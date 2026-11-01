package useCase;

import java.util.ArrayList; 
import java.io.*

public class MessageList {
	
	private ArrayList<Message> messages;
	private int nextId;
	
	public MessageList () {
		this.messages = new ArrayList<>();
		this.nextId = 1;
	}
	
	public void loadFromFile() {}
	public void saveToFile() {}
	
	public void addMessage(String msg, RegisteredUser user) {
		Message message = new Message(nextId, user, msg); 
		messages.add(message);
		nextId++;
	}
	public void removeMessage(int id) {
		for (int i = 0; i < messages.size(); i++) {
			if (messages.get(i).getId() == id) {
				messages.remove(i);
				return;
			}
		}
	}
	
	public ArrayList<Message> getMessagesFromUser(User user) {
		ArrayList<Message> userMessages = new ArrayList<>(); 
		
		for(Message message : messages) {
			if (message.getUser().equals(user)) {
				userMessages.add(message);
			}
		}
		return userMessages;
		
	}
}
