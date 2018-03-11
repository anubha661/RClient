package com.messageSeeker;

public class Message {



   private  String messageCode;
    private String todaysMessage;

    public Message()
    {}
    public Message(String messageCode, String todaysMessage) {
        this.messageCode = messageCode;
        this.todaysMessage = todaysMessage;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public String getTodaysMessage() {
        return todaysMessage;
    }

    public void setTodaysMessage(String todaysMessage) {
        this.todaysMessage = todaysMessage;
    }

}
