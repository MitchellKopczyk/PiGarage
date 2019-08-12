package com.example.pigarageclient;

import android.os.AsyncTask;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SignalDoor extends AsyncTask<String, Void, String> {
    static private Socket socket;

    //strings[0] = ip, strings[1] = port, strings[2] = key, strings[3] = action
    @Override
    protected String doInBackground(String... strings) {
        if(!connect(strings[0], Integer.parseInt(strings[1])))
            return null;
        try{
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            Message me = new Message(strings[2],strings[3]);
            out.writeObject(me);
        }
        catch (IOException e){
            System.err.println("Error Sending Key to Server :(");
        }
        close();
        return null;
    }

    private boolean connect(String ipaddress, int ServerPortNumber){
        try{
            System.err.println(ipaddress + " " + ServerPortNumber);
            socket = new Socket(ipaddress, ServerPortNumber);
            return true;
        }
        catch (IOException e){
            System.err.println("Error: Failed To Connect To Garage Server  :(" + " " + e.getMessage());
            return false;
        }
    }
    private static void close(){
        try{
            socket.close();
        }
        catch (IOException e){
            System.err.println("Error: Closing Socket  :(");
        }
    }
}