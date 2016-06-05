package sample;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import static sample.ServerClass.x;

/**
 * Created by User on 02-Jun-16.
 */
public class ServerThread2 implements Runnable{

    private NetworkUtillities connection;
    private static Hashtable<String,NetworkUtillities> clientlist;
   // private ExamEasy examEasy;

    ServerThread2(NetworkUtillities con , Hashtable<String,NetworkUtillities> table){
        connection = con;
        clientlist = table;
       // examEasy = new ExamEasy();

    }

    @Override
    public void run() {

        try{

            while(true){
                System.out.println("in server 2 ");
                String info = connection.read().toString();
                System.out.println(info);
                String msg[] = info.split(":",7);
                Set set = clientlist.keySet();
                Iterator it = set.iterator();
                while(it.hasNext()){
                    String s = (String) it.next();
                    if(s.equals("Student")){
                        NetworkUtillities con = clientlist.get(s);
                        con.write("Question has been added");
                    }
                }


                String question, a, b, c, d, correctans;

                question = msg[1];
                a = msg[2];b=msg[3];c=msg[4];d=msg[5];

                correctans = msg[6];



                if(msg[0].equals("Easy")){
                    try {

                        //read no of questions
                        int cnt=0;
                        try{
                            x = new Scanner(new File("GREExamEasy.txt"));
                        }catch(Exception e){
                            System.out.println("Error");
                        }
                        while(x.hasNextLine()){
                            String aa = x.nextLine();
                            cnt++;
                        }
                        cnt/=5;
                        x.close();



                        System.out.println("Easy mode");
                        BufferedWriter out = new BufferedWriter(new FileWriter("GREExamEasy.txt", true));
                        BufferedWriter out2 = new BufferedWriter(new FileWriter("CorrectAnswersEasy.txt",true));



                        int no = cnt;




                        //int no = ExtraClass.examEasy.noOfQuestions;
                        System.out.println("No of easy questions are "+no);
                        no++;



                        question = "\r\n"+String.valueOf(no)+"."+question;
                        ExtraClass.controller.noOfEasyQuestions++;

                        a = "\r\n"+a;
                        b = "\r\n"+b;
                        c = "\r\n"+c;
                        d = "\r\n"+d;
                        out.write(question+a+b+c+d);

                        no--;
                        no = no*4;
                        int nn;
                        if(correctans.equals("a")) nn=0;
                        else if(correctans.equals("b")) nn=1;
                        else if(correctans.equals("c")) nn=2;
                        else nn=3;
                        no+=nn;
                        out2.write("\r\n"+ String.valueOf(no));
                        out.close();
                        out2.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else if(msg[0].equals("Medium")){
                    try {
                        //read no of questions
                        int cnt=0;
                        try{
                            x = new Scanner(new File("GREExamMedium.txt"));
                        }catch(Exception e){
                            System.out.println("Error");
                        }
                        while(x.hasNextLine()){
                            String aa = x.nextLine();
                            cnt++;
                        }
                        cnt/=5;
                        x.close();


                        System.out.println("Medium mode");
                        BufferedWriter out = new BufferedWriter(new FileWriter("GREExamMedium.txt", true));
                        BufferedWriter out2 = new BufferedWriter(new FileWriter("CorrectAnswersMedium.txt",true));



                        int no = cnt;




                        //int no = ExtraClass.examEasy.noOfQuestions;
                        System.out.println("No of easy questions are "+no);
                        no++;



                        question = "\r\n"+String.valueOf(no)+"."+question;
                        ExtraClass.controller.noOfMediumQuestions++;

                        a = "\r\n"+a;
                        b = "\r\n"+b;
                        c = "\r\n"+c;
                        d = "\r\n"+d;
                        out.write(question+a+b+c+d);

                        no--;
                        no = no*4;
                        int nn;
                        if(correctans.equals("a")) nn=0;
                        else if(correctans.equals("b")) nn=1;
                        else if(correctans.equals("c")) nn=2;
                        else nn=3;
                        no+=nn;
                        out2.write("\r\n"+ String.valueOf(no));
                        out.close();
                        out2.close();



                        /*BufferedWriter out = new BufferedWriter(new FileWriter("GREExamMedium.txt", true));
                        BufferedWriter out2 = new BufferedWriter(new FileWriter("CorrectAnswersMedium.txt",true));
                        int no = ExtraClass.controller.noOfMediumQuestions;
                        System.out.println("No of easy questions are "+no);
                        no++;
                        question = "\r\n"+String.valueOf(no)+"."+question;
                        ExtraClass.controller.noOfMediumQuestions++;
                        a = "\r\n"+a;
                        b = "\r\n"+b;
                        c = "\r\n"+c;
                        d = "\r\n"+d;
                        out.write(question+a+b+c+d);

                        no--;
                        no = no*4;
                        int nn;
                        if(correctans.equals("a")) nn=0;
                        else if(correctans.equals("b")) nn=1;
                        else if(correctans.equals("c")) nn=2;
                        else nn=3;
                        no+=nn;
                        out2.write("\r\n"+ String.valueOf(no));
                        out.close();
                        out2.close();*/

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                else if(msg[0].equals("Hard")){
                    try {

                        //read no of questions
                        int cnt=0;
                        try{
                            x = new Scanner(new File("GREExamHard.txt"));
                        }catch(Exception e){
                            System.out.println("Error");
                        }
                        while(x.hasNextLine()){
                            String aa = x.nextLine();
                            cnt++;
                        }
                        cnt/=5;
                        x.close();


                        System.out.println("Hard mode");
                        BufferedWriter out = new BufferedWriter(new FileWriter("GREExamHard.txt", true));
                        BufferedWriter out2 = new BufferedWriter(new FileWriter("CorrectAnswersHard.txt",true));



                        int no = cnt;




                        //int no = ExtraClass.examEasy.noOfQuestions;
                        System.out.println("No of easy questions are "+no);
                        no++;



                        question = "\r\n"+String.valueOf(no)+"."+question;
                        ExtraClass.controller.noOfHardQuestions++;

                        a = "\r\n"+a;
                        b = "\r\n"+b;
                        c = "\r\n"+c;
                        d = "\r\n"+d;
                        out.write(question+a+b+c+d);

                        no--;
                        no = no*4;
                        int nn;
                        if(correctans.equals("a")) nn=0;
                        else if(correctans.equals("b")) nn=1;
                        else if(correctans.equals("c")) nn=2;
                        else nn=3;
                        no+=nn;
                        out2.write("\r\n"+ String.valueOf(no));
                        out.close();
                        out2.close();






                        /*BufferedWriter out = new BufferedWriter(new FileWriter("GREExamHard.txt", true));
                        BufferedWriter out2 = new BufferedWriter(new FileWriter("CorrectAnswersHard.txt",true));
                        int no = ExtraClass.controller.noOfHardQuestions;
                        System.out.println("No of easy questions are "+no);
                        no++;
                        question = "\r\n"+String.valueOf(no)+"."+question;
                        ExtraClass.controller.noOfHardQuestions++;
                        a = "\r\n"+a;
                        b = "\r\n"+b;
                        c = "\r\n"+c;
                        d = "\r\n"+d;
                        out.write(question+a+b+c+d);

                        no--;
                        no = no*4;
                        int nn;
                        if(correctans.equals("a")) nn=0;
                        else if(correctans.equals("b")) nn=1;
                        else if(correctans.equals("c")) nn=2;
                        else nn=3;
                        no+=nn;
                        out2.write("\r\n"+ String.valueOf(no));
                        out.close();
                        out2.close();*/

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }


            }


        }catch (Exception ee){
            ee.printStackTrace();
        }
    }
}
