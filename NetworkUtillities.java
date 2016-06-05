package sample;

import sun.nio.ch.Net;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by User on 26-May-16.
 */
public class NetworkUtillities {

    private Socket socket;
    private ObjectOutputStream os;
    private ObjectInputStream is;

    public NetworkUtillities(String add, int port){
        try {
            socket = new Socket(add, port);
            os = new ObjectOutputStream(socket.getOutputStream());
            is = new ObjectInputStream(socket.getInputStream());
        }catch(Exception ee){

        }
    }

    public NetworkUtillities(Socket soc) {
        try {
            socket = soc;
            os = new ObjectOutputStream(socket.getOutputStream());
            is = new ObjectInputStream(soc.getInputStream());
        }catch (Exception ee){
            ee.printStackTrace();
        }
    }


    public void write(Object o){
        try {
            os.writeObject(o);
        }catch (Exception ee){
            ee.printStackTrace();
        }
    }

    public Object read(){
        Object o = null;
        try{
            o = is.readObject();
        }catch (Exception ee){

        }
        return o;
    }

    public void closeconnection(){
        try {
            //socket.close();
            os.close();
            is.close();
        }catch (Exception ee){
            ee.printStackTrace();
        }
    }











}
