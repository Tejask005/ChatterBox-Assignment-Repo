package chatterBox;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.ArrayList;
import java.util.Date;
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
	
	public void loadFromFile() throws Exception {
		try (Scanner input = new Scanner(new File("messages.csv"))){
			ArrayList<Message> newMessages = new ArrayList<>();
			while (input.hasNextLine()) {
				String line = input.nextLine();
				String[] data = line.split("\t");
				Message message = new Message(
						Integer.parseInt(data[0].trim()),
						new RegisteredUser(data[1].trim(), new UserList().getPasswordByUsername(data[1].trim())),
						data[2].trim(),
						new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH).parse(data[3].trim())
						);
				newMessages.add(message);
			}
			messages = newMessages;
			nextId = messages.get(messages.size() - 1).getId() + 1;
		}
	}
	
	public void saveToFile() throws Exception {
		try (PrintWriter writer = new PrintWriter(new FileWriter("messages.csv"))) {
			for(Message message : messages) {
				writer.println(message.getId() + "\t" + message.getUser().getUsername() + "\t" + message.getText() + "\t" + message.getDate().toString());
			}
		}
	}
	
	public void addMessage(String msg, RegisteredUser user) {
		Message message = new Message(nextId, user, msg, new Date());
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
