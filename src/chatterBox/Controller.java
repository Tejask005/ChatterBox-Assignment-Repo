package chatterBox;

public class Controller {

    private MessageList messagesList;
    private UserList userList;
    private User currentUser;

    public Controller() {
        messagesList = new MessageList();
        userList = new UserList();
        currentUser = new GuestUser();
    }
    
    public void loadMessages() throws Exception {
    	messagesList.loadFromFile();
    }

    public boolean logIn(String username, String password){
        RegisteredUser user = new RegisteredUser(username.trim(), password.trim());
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
    public boolean deleteMessage(int messageId) throws Exception {
        if (currentUser instanceof RegisteredUser) {
        	boolean success = messagesList.removeMessage(messageId, (RegisteredUser) currentUser);
        	if (success)
        		messagesList.saveToFile();
        	return success;
        }
        return false;
    }

    public void postMessage(String text) throws Exception {
        if (currentUser instanceof RegisteredUser){
            messagesList.addMessage(text, (RegisteredUser) currentUser);
            messagesList.saveToFile();
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
