package chatterBox;

import java.io.*;
import java.util.ArrayList; 
import java.util.Scanner;


public class MessageList {
	//attributes
	private ArrayList<Message> messages;
	private int nextId;
	
	//constructor
	public MessageList () {
		//empty list to store messages
		this.messages = new ArrayList<>();
		this.nextId = 1;
	}
	
	public ArrayList<Message> getAllMessages() {
		return messages;
	}
	
	public void loadFromFile() {
		try (Scanner input = new Scanner(new File("messages.csv")) ){
			while (input.hasNextLine()) {
				String line = input.nextLine();
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public void saveToFile() {
		try (PrintWriter writer = new PrintWriter(new FileWriter("messages.csv"))){
			for(Message message : messages) {
				writer.println(message.getId() + "," + message.getUser().getUsername() + "," + message.getText());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addMessage(String msg, RegisteredUser user) {
		Message message = new Message(nextId, user, msg); 
		messages.add(message);
		nextId++;
	}
	public boolean removeMessage(int id, RegisteredUser user) {
		for (int i = 0; i < messages.size(); i++) {
			if (messages.get(i).getId() == id && messages.get(i).getUser().equals(user)) {
				messages.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Message> getMessagesFromUser(RegisteredUser user) {
		ArrayList<Message> userMessages = new ArrayList<>(); 
		
		for(Message message : messages) {
			if (message.getUser().equals(user)) {
				userMessages.add(message);
			}
		}
		return userMessages;
		
	}
}
