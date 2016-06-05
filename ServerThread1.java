package sample;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;

/**
 * Created by User on 02-Jun-16.
 */
public class ServerThread1 implements Runnable {

    private NetworkUtillities connection;
    private int count;
    private static Scanner x=null;
    private static Hashtable<String,NetworkUtillities> clientlist;

    ServerThread1(NetworkUtillities con, int cnt, Hashtable<String,NetworkUtillities> table){
        count = cnt;
        connection = con;
        clientlist = table;

    }

    @Override
    public void run() {
        while (true) {
            String input = connection.read().toString();
            String msg[] = input.split(":", 4);

            if (msg[0].equals("LOGIN")) {
                String aa = msg[1];
                String bb = msg[2];
                String cc = "";
                int flag = 0;
                if (aa.equals("TEACHER")) {
                    cc = msg[3];
                    flag = 1;
                }

                String a = "";
                String b = "";
                int c = 0;
                if (flag == 0) {
                    try {
                        x = new Scanner(new File("StudentsAccounts.txt"));
                    } catch (Exception e) {
                        System.out.println("Error");
                    }
                    while (x.hasNext()) {
                        a = x.next();
                        b = x.next();
                        System.out.println(a + " " + b);

                        if (a.equals(aa) && b.equals(bb)) {
                            c = 1;
                            break;
                        }
                    }
                    x.close();
                    if (c == 0) {
                        //JOptionPane.showMessageDialog(null,"Account doesn't exist\nSign In to create new account");
                        connection.write("Account doesn't exist. Please try Again");
                    } else {
                        //JOptionPane.showMessageDialog(null,"Welcome");

                        connection.write("Accepted");
                        clientlist.put("Student", connection);
                        System.out.println("Before thread starts");
                        new Thread(new SThreadScore(connection)).start();
                        x.close();
                        break;
                        //new Thread(new ServerThread2(connection, clientlist)).start();
                    }
                    //x.close();
                } else {
                    try {
                        x = new Scanner(new File("TeachersAccounts.txt"));
                    } catch (Exception e) {
                        System.out.println("Error");
                    }
                    while (x.hasNext()) {
                        a = x.next();
                        b = x.next();
                        System.out.println(a + " " + b);

                        if (a.equals(bb) && b.equals(cc)) {
                            c = 1;
                            break;
                        }
                    }
                    x.close();
                    if (c == 0) {
                        //JOptionPane.showMessageDialog(null,"Account doesn't exist\nSign In to create new account");
                        connection.write("Account doesn't exist. Please try Again");
                    } else {
                        //JOptionPane.showMessageDialog(null,"Welcome");

                        connection.write("Accepted");
                        clientlist.put("Teacher", connection);
                        new Thread(new ServerThread2(connection, clientlist)).start();
                        x.close();
                        break;

                    }
                    //x.close();

                }


            } else if (msg[0].equals("SIGNUP")) {

                String aa = msg[1];
                String bb = msg[2];
                String cc = "";
                String user="", pass="";
                int c=0;
                System.out.println("aa and bb is " + aa + " " + bb);
                if (aa.equals("TEACHER")) {
                    cc = msg[3];
                    System.out.println("cc " + cc);
                    try {
                        BufferedWriter out = new BufferedWriter(new FileWriter("TeachersAccounts.txt", true));

                        try {
                            x = new Scanner(new File("TeachersAccounts.txt"));
                        } catch (Exception e) {
                            System.out.println("Error");
                        }
                        while (x.hasNext()) {
                            user = x.next();
                            pass = x.next();
                            //System.out.println(a + " " + b);

                            if(user.equals(bb)){
                                c=1;
                                break;
                            }
                        }
                        x.close();
                        if(c==1){
                            connection.write("SignUp Unseccessful");
                        }
                        else if(c == 0){

                            String a = bb + "\r\n";
                            String b = cc + "\r\n";
                            out.write(a + b);

                            connection.write("SignUp Successful");
                        }
                        //new Thread(new ServerThread2(connection)).start();
                        //SignInMessage.setText("SignUp Successful");
                        //SignInName.setText("");
                        //SignInReName.setText("");
                        // SignInPassword.setText("");
                        out.close();

                    } catch (IOException e) {
                        System.out.println("Error in writing in file");
                    }
                } else {
                    try {
                        BufferedWriter out = new BufferedWriter(new FileWriter("StudentsAccounts.txt", true));

                        try {
                            x = new Scanner(new File("StudentsAccounts.txt"));
                        } catch (Exception e) {
                            System.out.println("Error");
                        }
                        while (x.hasNext()) {
                            user = x.next();
                            pass = x.next();
                            //System.out.println(a + " " + b);

                            if(user.equals(aa)){
                                c=1;
                                break;
                            }
                        }
                        x.close();
                        if(c==1){
                            connection.write("SignUp Unseccessful");
                        }
                        else if(c == 0){

                            String a = aa + "\r\n";
                            String b = bb + "\r\n";
                            out.write(a + b);

                            connection.write("SignUp Successful");


                            try {
                                BufferedWriter x = new BufferedWriter(new FileWriter("ScoresFile.txt", true));
                                x.write("\r\n" + aa);
                                String ab = "1000";
                                x.write("\r\n" + ab);
                                x.write("\r\n" + ab);
                                x.write("\r\n" + ab);

                                x.close();
                            } catch (Exception e) {
                                System.out.println("Error");
                            }


                        }


                        //System.out.println(a);
                        //JOptionPane.showMessageDialog(null,"Sign in successful");
                        //connection.write("SignUp Successful");
                        //new Thread(new ServerThread2(connection)).start();
                        //SignInMessage.setText("SignUp Successful");
                        //SignInName.setText("");
                        //SignInReName.setText("");
                        // SignInPassword.setText("");
                        out.close();

                    } catch (IOException e) {
                        System.out.println("Error in writing in file");
                    }


                }


            }
        }
    }


        //System.out.println("Client " + ++cnt + " has joined");


}

