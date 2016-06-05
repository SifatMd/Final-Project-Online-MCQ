package sample;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;
import java.util.Scanner;

/**
 * Created by User on 02-Jun-16.
 */
public class ServerClass {

    private static ServerSocket serverSocket;

    public static Scanner x=null;

    private static int cnt=0;
    private static Hashtable<String,NetworkUtillities> clientlist;
    public static void main(String args[]){

        try {
            clientlist = new Hashtable<>();
            serverSocket = new ServerSocket(22222);
            System.out.println("Server has started successfully");
            while(true) {
                Socket client = serverSocket.accept();
                NetworkUtillities connection = new NetworkUtillities(client);
                System.out.println("Client has connected "+ cnt);

                new Thread(new ServerThread1(connection, ++cnt, clientlist)).start();


            }





        } catch (IOException e) {
            e.printStackTrace();
        }



    }




}
