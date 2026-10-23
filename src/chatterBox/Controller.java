package chatterBox;

import java.util.*;


public class Controller {

    private List<String> messageList;
    private UserList userList;
    public User currentUser;

    public Controller(String messageFilePath) {
        messageList = new ArrayList<>();
        userList = new UserList();
        currentUser = new GuestUser();
    }

    public boolean logIn(String username, String password){
        RegisteredUser user = new RegisteredUser(username, password);
        if (userList.userExists(user)) {
            currentUser = user;
            return true;
        } else {
            return false;
        } 
    }
    public void deleteMessage(String message){
        if (currentUser instanceof RegisteredUser){
            messageList.remove(message);
        } else {
            System.out.println("Only registered users can delete messages.");
        }
        
    }
    public void postMessage(String message){
        if (currentUser instanceof RegisteredUser){
            messageList.add(message);
        } else {
            System.out.println("Only registered users can post messages.");
        }
    }
    public String getAllMessages(){
        StringBuilder allMessages = new StringBuilder();
        for (String message : messageList){
            allMessages.append(message).append("\n");
        }
        return allMessages.toString();
    }
    public String getCurrentUserMessages(){
        if (currentUser instanceof RegisteredUser){
            StringBuilder userMessages = new StringBuilder();
            for (String message : messageList){
                userMessages.append(message).append("\n");
            }
            return userMessages.toString();
        } else {
            return "Only registered users can view their messages.";
        }
    }
    public void deleteMessage(String message, User currentUser){
        if (currentUser instanceof RegisteredUser){
            messageList.remove(message);
        } else {
            System.out.println("Only registered users can delete messages.");
        }    
    }
    
}