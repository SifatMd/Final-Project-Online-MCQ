package sample;

import javafx.fxml.Initializable;


import javafx.scene.control.Label;
import javafx.scene.text.*;

import javax.swing.*;
import javax.swing.text.html.ImageView;
import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by User on 05-May-16.
 */
public class finalres implements Initializable{
    public Label SubjectNameId = new Label();
    public Label ScoreId = new Label();
    public ExamControl ob = new ExamControl();


    static ExamEasy ob1 = new ExamEasy();
    static ExamMedium ob2 = new ExamMedium();
    static ExamHard ob3 = new ExamHard();

    public String xx="0";
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String a="GRE";
        int b=10;
        String num = b+"";
        SubjectNameId.setText("Subject: "+ a);



        //System.out.println("Score is"+x);
    }

    public void LogoutButtonClicked(){
        try {
            ExtraClass.connect.closeconnection();
            Main.showLoginPage();
        } catch (Exception e) {
            e.printStackTrace();
        }



        System.out.println("I have to log out of this program");
    }

    public void ScoreButtonSelected(){


        int b = ob1.getScore();
        int c = ob2.getScore();
        int d = ob3.getScore();
        int a=0;
        if(ExtraClass.flag==1) {
            a = ob1.getAnswered()-b;
            xx = String.valueOf(b);
            System.out.println(b);
        }
        else if(ExtraClass.flag==2) {
            a = ob2.getAnswered()-c;
            xx = String.valueOf(c);
            System.out.println(c);
        }
        else if(ExtraClass.flag==3) {
            xx = String.valueOf(d);
            a = ob3.getAnswered()-d;
            System.out.println(d);
        }

        ScoreId.setText("     Correct Answers: "+ xx + "     Wrong Answers: "+ a + "     Score : "+ xx);
        ScoreId.setFont(javafx.scene.text.Font.font(20));
    }

    public void StartAgain(){
        try {
            ob1.setScore(0);
            ob2.setScore(0);
            ob3.setScore(0);
            Main.showSelectionPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ShowScoresButtonClicked(){
        try {
            ob1.setScore(0);
            ob2.setScore(0);
            ob3.setScore(0);
            Main.ShowMyScores();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
