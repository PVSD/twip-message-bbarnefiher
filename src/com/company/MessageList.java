package com.company;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class MessageList {

    ArrayList allMessageLists = new ArrayList(); //holds Strings
    ArrayList<Message> messagesInAList = new ArrayList<>(); //holds Message objects
    public int numberOfMessages = 0;

    public MessageList(){

    }
    public void createList(String listName, int numOfMessageLists){
        allMessageLists.add(listName);

    }
    public void addMessage(String textMessage, String phoneNumber, String listItsIn){
        numberOfMessages++;
        LocalDateTime ldt = LocalDateTime.now();
        messagesInAList.add(new Message(textMessage, phoneNumber, ldt.toString(), listItsIn));
        System.out.println("Message sent.");
    }
    public void removeMessage(int messageNum){
    //    System.out.println("I AM REMOVING INDEX " + messageNum);
        messagesInAList.remove(messageNum - 1);
        numberOfMessages--;
        System.out.println("Removed message successfully.");
    }
    public int getMessageNumber (){
        return numberOfMessages;
}
    public void moveMessage(int messageID, String fromList, String toList){
        messagesInAList.get(messageID - 1).changeLocation(fromList, toList);
        System.out.println("Moved message successfully.");
    }
}
//