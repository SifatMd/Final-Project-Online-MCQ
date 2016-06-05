package sample;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * Created by User on 21-May-16.
 */
public class ScoreSheet implements Initializable{

    public Label EasyScore = new Label();
    public Label MediumScore = new Label();
    public Label HardScore = new Label();
    public Scanner x = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try{
            String aa;
            x = new Scanner(new File("ScoresFile.txt"));
            while(x.hasNextLine()){
                aa = x.nextLine();
                if(aa.equals(Controller.usernamefinal)){
                    break;
                }
            }

            String a = x.nextLine();
            if(a.equals("1000")) a = "Not Attempted Yet";
            String b = x.nextLine();
            if(b.equals("1000")) b = "Not Attempted Yet";
            String c = x.nextLine();
            if(c.equals("1000")) c = "Not Attempted Yet";
            EasyScore.setText(a);
            MediumScore.setText(b);
            HardScore.setText(c);


            x.close();


        }catch(Exception e){
            System.out.println("Error");
        }

    }

    public void BackButtonClicked(){
        try {
            Main.FinalResultPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void StartExamButtonClicked(){
        try {
            Main.showSelectionPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void LogOutButtonClicked(){
        try {
            ExtraClass.connect.closeconnection();
            Main.showLoginPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





}
