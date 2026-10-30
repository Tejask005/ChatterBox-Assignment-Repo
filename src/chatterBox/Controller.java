package chatterBox;

import java.util.*;


public class Controller {

    private MessageList messagesList;
    private UserList userList;
    public User currentUser;

    public Controller(String messageFilePath) {
        messagesList = new MessageList();
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

    public void logOut(){
        currentUser = new GuestUser();
    }

    // delete a message by its ID
    public boolean deleteMessage(int messageId) {
        if (currentUser instanceof RegisteredUser) {
            return messagesList.removeMessage(messageId, (RegisteredUser) currentUser);
        } else {
            System.out.println("Only users can delete messages.");
            return false;
        }
    }


    public void postMessage(String text){
        if (currentUser instanceof RegisteredUser){
            messagesList.addMessage(text, (RegisteredUser) currentUser);
        } else {
            System.out.println("Only registered users can post messages.");
        }
    }
    public String getAllMessages(){
        StringBuilder allMessages = new StringBuilder();
        for (Message message : messagesList.getAllMessages()){
            allMessages.append(message).append("\n");
        }
        return allMessages.toString();
    }
    public String getCurrentUserMessages(){
        if (currentUser instanceof RegisteredUser){
            StringBuilder userMessages = new StringBuilder();
            for (Message message : messagesList.getMessagesFromUser((RegisteredUser) currentUser)){
                userMessages.append(message).append("\n");
            }
            return userMessages.toString();
        } else {
            return "Only registered users can view their messages.";
        }
    }
    
}