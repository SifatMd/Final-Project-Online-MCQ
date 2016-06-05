package sample;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by User on 05-Jun-16.
 */
public class SThreadScore implements Runnable {

    private NetworkUtillities connection;


    public SThreadScore(NetworkUtillities con){
        connection = con;
    }

    @Override
    public void run() {

        try{
            while(true) {
                System.out.println("In sthreasscore");
                String scoretext = connection.read().toString();
                System.out.println("Scoretext is "+scoretext);
                String msg[] = scoretext.split(":", 3);
                String username = msg[0];
                String mode = msg[1];
                int Score = Integer.parseInt(msg[2]);
                if (mode.equals("Easy")) {
                    String aa = "";

                    int cnt = 0;
                    Scanner x = null;
                    try {
                        x = new Scanner(new File("ScoresFile.txt"));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    while (x.hasNextLine()) {
                        aa = x.nextLine();
                        cnt++;
                        if (aa.equals(username)) {
                            System.out.println("Username is " + aa);
                            break;
                        }
                    }
                    aa = x.nextLine();
                    x.close();


                    BufferedReader reader = new BufferedReader(new FileReader("ScoresFile.txt"));
                    BufferedWriter writer = new BufferedWriter(new FileWriter("DummyFile.txt"));
                    String linetoremove = aa;
                    System.out.println("line to remove " + linetoremove);
                    String currline = "";
                    int mark = 0;
                    int i = 0;
                    while ((currline = reader.readLine()) != null) {
                        String trimmed = currline.trim();
                        if (mark == 0 && trimmed.equals(linetoremove) && i == cnt) {
                            writer.write("\r\n" + String.valueOf(Score));
                            mark = 1;
                            continue;
                        }
                        if (i == 0) writer.write(currline);
                        else writer.write("\r\n" + currline);
                        i++;

                    }
                    writer.close();
                    reader.close();

                    FileInputStream instream = null;
                    FileOutputStream outstream = null;

                    try {
                        instream = new FileInputStream("DummyFile.txt");
                        outstream = new FileOutputStream("ScoresFile.txt");
                        byte[] buffer = new byte[1024];

                        int length;

                        while ((length = instream.read(buffer)) > 0) {
                            outstream.write(buffer, 0, length);
                        }

                        instream.close();
                        outstream.close();

                    } catch (IOException ioe) {
                        ioe.printStackTrace();
                    }


                }

                else if(mode.equals("Medium")){
                    String aa="";

                    int cnt=0;
                    Scanner x = null;
                    try {
                        x = new Scanner(new File("ScoresFile.txt"));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    while(x.hasNextLine()){
                        aa = x.nextLine();
                        cnt++;
                        if(aa.equals(username)){
                            System.out.println("Username is "+aa);
                            break;
                        }
                    }
                    aa = x.nextLine();
                    aa = x.nextLine();
                    x.close();


                    BufferedReader reader = new BufferedReader(new FileReader("ScoresFile.txt"));
                    BufferedWriter writer = new BufferedWriter(new FileWriter("DummyFile.txt"));
                    String linetoremove = aa;
                    System.out.println("line to remove "+linetoremove);
                    String currline="";
                    int mark=0;
                    int i=0;
                    while((currline = reader.readLine())!=null){
                        String trimmed = currline.trim();
                        if(mark==0 && trimmed.equals(linetoremove) && i-1==cnt) {
                            writer.write("\r\n"+String.valueOf(Score));
                            mark=1;
                            continue;
                        }
                        if(i==0) writer.write(currline);
                        else  writer.write("\r\n"+currline );
                        i++;

                    }
                    writer.close();
                    reader.close();

                    FileInputStream instream = null;
                    FileOutputStream outstream = null;

                    try{
                        instream = new FileInputStream("DummyFile.txt");
                        outstream = new FileOutputStream("ScoresFile.txt");
                        byte[] buffer = new byte[1024];

                        int length;

                        while((length = instream.read(buffer))>0){
                            outstream.write(buffer,0,length);
                        }

                        instream.close();outstream.close();

                    }catch(IOException ioe){
                        ioe.printStackTrace();
                    }

                }
                else if(mode.equals("Hard")){

                    String aa="";

                    int cnt=0;
                    Scanner x = null;
                    try {
                        x = new Scanner(new File("ScoresFile.txt"));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    while(x.hasNextLine()){
                        aa = x.nextLine();
                        cnt++;
                        if(aa.equals(username)){
                            System.out.println("Username is "+aa);
                            break;
                        }
                    }
                    aa = x.nextLine();
                    aa = x.nextLine();
                    aa= x.nextLine();
                    x.close();


                    BufferedReader reader = new BufferedReader(new FileReader("ScoresFile.txt"));
                    BufferedWriter writer = new BufferedWriter(new FileWriter("DummyFile.txt"));
                    String linetoremove = aa;
                    System.out.println("line to remove "+linetoremove);
                    String currline="";
                    int mark=0;
                    int i=0;
                    while((currline = reader.readLine())!=null){
                        String trimmed = currline.trim();
                        if(mark==0 && trimmed.equals(linetoremove) && i-2==cnt) {
                            writer.write("\r\n"+String.valueOf(Score));
                            mark=1;
                            continue;
                        }
                        if(i==0) writer.write(currline);
                        else  writer.write("\r\n"+currline );
                        i++;

                    }
                    writer.close();
                    reader.close();

                    FileInputStream instream = null;
                    FileOutputStream outstream = null;

                    try{
                        instream = new FileInputStream("DummyFile.txt");
                        outstream = new FileOutputStream("ScoresFile.txt");
                        byte[] buffer = new byte[1024];

                        int length;

                        while((length = instream.read(buffer))>0){
                            outstream.write(buffer,0,length);
                        }

                        instream.close();outstream.close();

                    }catch(IOException ioe){
                        ioe.printStackTrace();
                    }

                }




            }




        }catch (Exception ee){
            ee.printStackTrace();
        }



    }
}
