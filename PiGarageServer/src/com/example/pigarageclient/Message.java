package com.example.pigarageclient;

import java.io.Serializable;

public class Message implements Serializable {
    private String userKey;
    private String action;

    public Message(String userKey, String action){
        this.userKey = userKey;
        this.action = action;
    }

    public String getUserKey(){
        return userKey;
    }

    public String getAction(){
        return action;
    }
}