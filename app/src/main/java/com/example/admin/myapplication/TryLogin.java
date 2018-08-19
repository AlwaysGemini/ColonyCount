package com.example.admin.myapplication;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import AndroidServer.Message;

public class TryLogin extends Thread {
    public String run(Object object) {
        try {
                Socket socket = new Socket("10.0.2.2",10001);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                objectOutputStream.writeObject(object);
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                Message message = (Message)objectInputStream.readObject();
                return  message.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
            }catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        return "error";
    }
}
