package com.company;



import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) {
	Scanner stringReader = new Scanner(System.in);
	Scanner intReader = new Scanner(System.in);
    int numOfMessageLists = 0;
        MessageList MessageDatabase = new MessageList();
	    while(true){
            System.out.println("These are your message lists.");
            System.out.println(MessageDatabase.allMessageLists);
            System.out.println("Please enter a command. Type 'help' for command info.");
            String userInput = stringReader.nextLine();
            if (userInput.trim().equalsIgnoreCase("help")){
                System.out.println("Commands:\n'create' -> Creates a new message list.\n'view' -> Prompts the user to enter a message list for information to be viewed on.\n'quit' -> Quits the program.");
                System.out.println("\n");
                continue;
            }
            if (userInput.trim().equalsIgnoreCase("quit")){
                System.out.println("Goodbye");
                System.exit(0);
            }
            ////////////////
            if (userInput.trim().equalsIgnoreCase("create")){
                System.out.println("Enter the name of the new message list.");
                String listName = stringReader.nextLine();
                MessageDatabase.createList(listName, numOfMessageLists);

                numOfMessageLists++;
                System.out.println("Message list " + listName + " created.\n");
                continue;
            }
            ///////////////////
            if (userInput.trim().equalsIgnoreCase("view")){
                System.out.println("What message list would you like to view?");
                String userWantsToView = stringReader.nextLine();


                if (MessageDatabase.allMessageLists.contains(userWantsToView)){



                    while (true){

                        System.out.println("You are viewing the message list [" + userWantsToView + "]. Type 'help' for command info.");
                        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                        for (int i = 0; i < MessageDatabase.messagesInAList.size(); i++) {
                            if (MessageDatabase.messagesInAList.get(i).messageLocation.equalsIgnoreCase(userWantsToView) ){ //i like this whole if statement it took me awhile to figure out but i feel smart now
                                System.out.println("[" + MessageDatabase.messagesInAList.get(i).timeStamp.substring(11,19) + "] " + MessageDatabase.messagesInAList.get(i).phoneNumber + ": " + MessageDatabase.messagesInAList.get(i).text);
                            }
                        }
                        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                        String userInputInsideList = stringReader.nextLine();
                        if (userInputInsideList.trim().equalsIgnoreCase("help")){
                            System.out.println("Commands:\n'send' -> Sends a message to the message list. \n'remove' -> Removes a message from the message list. \n'move' -> Moves a message from one message list, to another. \n'exit' -> Return to the message list selection.");
                        }
                        if (userInputInsideList.trim().equalsIgnoreCase("exit")){
                            break;
                        }
                        if (userInputInsideList.trim().equalsIgnoreCase("send")){
                          System.out.println("First, enter your name or phone number.");
                          String userPhoneNumber = stringReader.nextLine();
                          System.out.println("Now, enter the message you want to send.");
                          String userEnterMessage = stringReader.nextLine();
                          MessageDatabase.addMessage(userEnterMessage, userPhoneNumber, userWantsToView);


                        }
                        int userMessageSelect;
                        if (userInputInsideList.trim().equalsIgnoreCase("remove")){
                            System.out.println("Select the message ID number that you would like to delete.\nEx: 3");
                            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                            for (int i = 0; i < MessageDatabase.messagesInAList.size(); i++) {
                                int IDa = i + 1;
                                if (MessageDatabase.messagesInAList.get(i).messageLocation.equalsIgnoreCase(userWantsToView) ){ //i like this whole if statement it took me awhile to figure out but i feel smart now
                                    System.out.println("[ID: " + IDa + "]: " + "[" + MessageDatabase.messagesInAList.get(i).timeStamp.substring(11,19) + "] " + MessageDatabase.messagesInAList.get(i).phoneNumber + ": " + MessageDatabase.messagesInAList.get(i).text);
                                }
                            }
                            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                            userMessageSelect = intReader.nextInt();
                            MessageDatabase.removeMessage(userMessageSelect);

                        }
                        if (userInputInsideList.trim().equalsIgnoreCase("move")){
                            System.out.println("Select the message ID number that you want to move from " + userWantsToView + ".");
                            ////////////
                            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                            for (int i = 0; i < MessageDatabase.messagesInAList.size(); i++) {
                                int IDb = i + 1;
                                if (MessageDatabase.messagesInAList.get(i).messageLocation.equalsIgnoreCase(userWantsToView) ){ //i like this whole if statement it took me awhile to figure out but i feel smart now
                                    System.out.println("[ID: " + IDb + "]: " + "[" + MessageDatabase.messagesInAList.get(i).timeStamp.substring(11,19) + "] " + MessageDatabase.messagesInAList.get(i).phoneNumber + ": " + MessageDatabase.messagesInAList.get(i).text);
                                }
                            }
                            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                            ////////////
                            userMessageSelect = intReader.nextInt();
                            System.out.println("What message list would you like to move the message to?\nExisting message lists: " + MessageDatabase.allMessageLists);
                            userInputInsideList = stringReader.nextLine();
                            if (!(MessageDatabase.allMessageLists.contains(userInputInsideList))){
                                System.out.println("That is not the name of an existing message list.");
                                continue;
                            }
                            MessageDatabase.moveMessage(userMessageSelect, userWantsToView, userInputInsideList);

                        }


                    }
                }




                else {
                    System.out.println("Sorry, that is not an existing message list.\n");
                    continue;
                }
            }
        }

    }

}
