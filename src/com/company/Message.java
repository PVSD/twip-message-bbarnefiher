package com.company;

public class Message {
    String text;
    String phoneNumber;
    String timeStamp;
    String messageLocation;
    int totalMessageNumber;
    MessageList temp = new MessageList();
    public Message(String text, String phoneNumber, String timeStamp, String messageLocation){
        this.text = text;
        this.phoneNumber = phoneNumber;
        this.timeStamp = timeStamp;
        this.messageLocation = messageLocation;
        totalMessageNumber = temp.getMessageNumber();
    }
    public void changeLocation (String fromLocation, String toLocation){
        this.messageLocation = toLocation;
    }

}
