package chatterBox;

import java.util.Scanner;

public class View {

    private Controller controller;
    private Scanner scanner;

    public View() {
        controller = new Controller();
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        View view = new View();
        boolean running = true;

        while (running) {
            int choice = view.displayStartPage();

            if (choice == 1) {
                // Log in
                boolean loggedIn = view.displayLogIn();
                if (loggedIn) {
                    int option = view.displayRegisteredInterface();
                    if (option == 1) {
                        view.displayPostMessage();
                    } else if (option == 2) {
                        view.displayDeleteMessage();
                    } else if (option == 3) {
                        view.displayUserMessages();
                    } else if (option == 4) {
                        view.displayAllMessages();
                    } else if (option == 5) {
                        System.out.println("Logged out.");
                    } else {
                        System.out.println("Invalid choice, try again.");
                    }
                }
            } else if (choice == 2) {
                // Continue as guest
                boolean inGuestMode = true;
                while (inGuestMode) {
                    int option = view.displayGuestInterface();
                    if (option == 1) {
                        view.displayAllMessages();
                    } else if (option == 2) {
                        inGuestMode = false;
                    } else {
                        System.out.println("Invalid choice, try again.");
                    }
                }
            } else if (choice == 3) {
                // Quit
                System.out.println("Goodbye!");
                running = false;
            } else {
                System.out.println("Invalid choice, try again.");
            }
        }
    }

    // Prints the first text the user sees and returns the chosen option
    public int displayStartPage() {
        System.out.println();
        System.out.println("ChatterBox");
        System.out.println("1. Log in");
        System.out.println("2. Continue as guest");
        System.out.println("3. Quit");
        System.out.print("Your choice: ");
        return readInt();
    }

    // Prints the options for a guest and returns the chosen option
    public int displayGuestInterface() {
        System.out.println();
        System.out.println("Guest");
        System.out.println("1. View all messages");
        System.out.println("2. Back to start page");
        System.out.print("Your choice: ");
        return readInt();
    }

    // Asks for username and password, returns true if login worked
    public boolean displayLogIn() {
        System.out.println();
        System.out.println("Log in");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        boolean success = controller.logIn(username, password);
        if (success) {
            System.out.println("Login successful. Welcome " + username + "!");
        } else {
            System.out.println("Login failed. Wrong username or password.");
        }
        return success;
    }

    // Prints the options for a logged in user and returns the chosen option
    public int displayRegisteredInterface() {
        System.out.println();
        System.out.println("Menu");
        System.out.println("1. Post message");
        System.out.println("2. Delete message");
        System.out.println("3. View my messages");
        System.out.println("4. View all messages");
        System.out.println("5. Log out");
        System.out.print("Your choice: ");
        return readInt();
    }

    // Shows the user's own messages and lets them pick one to delete
    public void displayDeleteMessage() {
        System.out.println();
        System.out.println("Delete message");
        System.out.println(controller.getCurrentUserMessages());
        System.out.print("Enter the id of the message to delete: ");
        int id = readInt();

        if (id == -1) {
            System.out.println("That is not a valid id.");
        } else {
            controller.deleteMessage(id);
            System.out.println("Done. If the id was one of your messages it has been deleted.");
        }
    }

    // Lets the user write a message and posts it
    public void displayPostMessage() {
        System.out.println();
        System.out.println("Post message");
        System.out.print("Write your message: ");
        String msg = scanner.nextLine();

        if (msg.trim().isEmpty()) {
            System.out.println("You can't post an empty message.");
        } else {
            controller.postMessage(msg);
            System.out.println("Message posted!");
        }
    }

    // Prints the user's own messages
    public void displayUserMessages() {
        System.out.println();
        System.out.println("My messages");
        System.out.println(controller.getCurrentUserMessages());
    }

    // Prints all messages in the application
    public void displayAllMessages() {
        System.out.println();
        System.out.println("All messages");
        System.out.println(controller.getAllMessages());
    }

    // Helper: reads a number from the user, returns -1 if it isn't a number.
    private int readInt() {
        String input = scanner.nextLine().trim();
        for (int i = 0; i <= 1000; i++) {
            if (String.valueOf(i).equals(input)) {
                return i;
            }
        }
        return -1;
    }
}


