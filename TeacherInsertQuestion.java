package sample;

import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by User on 19-May-16.
 */
public class TeacherInsertQuestion implements Initializable{
    public TextField EnteredQuestion = new TextField();

    public TextField Option_a = new TextField();
    public TextField Option_b = new TextField();
    public TextField Option_c = new TextField();
    public TextField Option_d = new TextField();

    public ChoiceBox<String> CorrectChoice = new ChoiceBox<>();
    public ChoiceBox<String> ChooseMode = new ChoiceBox<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        CorrectChoice.getItems().addAll("a","b","c","d");
        CorrectChoice.setValue("a");
        ChooseMode.getItems().addAll("Easy","Medium","Hard");
        ChooseMode.setValue("Easy");
    }

    public void LogOutButtonClicked(){
        try {
            ExtraClass.connect.closeconnection();
            Main.showLoginPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void EnterAnotherQuestionButtonClicked(){
        String question = EnteredQuestion.getText();
        String a = Option_a.getText();
        String b = Option_b.getText();
        String c = Option_c.getText();
        String d = Option_d.getText();
        String correctans = CorrectChoice.getValue();
        String mode = ChooseMode.getValue();

        String info = mode + ":" + question+":"+ a+":"+b+":"+c+":"+d+":"+correctans;


        ExtraClass.connect.write(info);



        /*Controller controllerobj = new Controller();



        if(mode.equals("Easy")){
            try {
                BufferedWriter out = new BufferedWriter(new FileWriter("GREExamEasy.txt", true));
                BufferedWriter out2 = new BufferedWriter(new FileWriter("CorrectAnswersEasy.txt",true));
                int no = controllerobj.noOfEasyQuestions;
                System.out.println("No of easy questions are "+no);
                no++;
                question = "\r\n"+String.valueOf(no)+"."+question;
                controllerobj.noOfEasyQuestions++;
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
        else if(mode.equals("Medium")){
            try {
                BufferedWriter out = new BufferedWriter(new FileWriter("GREExamMedium.txt", true));
                BufferedWriter out2 = new BufferedWriter(new FileWriter("CorrectAnswersMedium.txt",true));
                int no = controllerobj.noOfMediumQuestions;
                System.out.println("No of easy questions are "+no);
                no++;
                question = "\r\n"+String.valueOf(no)+"."+question;
                controllerobj.noOfMediumQuestions++;
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
        else if(mode.equals("Hard")){
            try {
                BufferedWriter out = new BufferedWriter(new FileWriter("GREExamHard.txt", true));
                BufferedWriter out2 = new BufferedWriter(new FileWriter("CorrectAnswersHard.txt",true));
                int no = controllerobj.noOfHardQuestions;
                System.out.println("No of easy questions are "+no);
                no++;
                question = "\r\n"+String.valueOf(no)+"."+question;
                controllerobj.noOfHardQuestions++;
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
        }*/


        EnteredQuestion.setText("");
        Option_a.setText("");
        Option_b.setText("");
        Option_c.setText("");
        Option_d.setText("");

        CorrectChoice.setValue("a");
        ChooseMode.setValue("Easy");






        /*System.out.println(question);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(correctans);*/


    }


}
