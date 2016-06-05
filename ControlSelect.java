package sample;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

import javax.swing.plaf.basic.BasicButtonUI;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by User on 05-May-16.
 */
public class ControlSelect implements Initializable{

    //Choice Box
    public ChoiceBox<String> ExamOptionsChoiceBox;

    public ChoiceBox<String> SubjectChoiceBox = new ChoiceBox<>();

    //Holders
    public String ExamOptions="";

    public String SubjectChoice="";





    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ExamOptionsChoiceBox.getItems().addAll("Trial Mode","Exam Mode");

        SubjectChoiceBox.getItems().addAll("GRE");

        ExamOptionsChoiceBox.setValue("Trial Mode");

        SubjectChoiceBox.setValue("GRE");



    }
    public void SubmitButtonClicked(){
        ExamOptions = ExamOptionsChoiceBox.getValue();

        SubjectChoice = SubjectChoiceBox.getValue();
        if(ExamOptionsChoiceBox.getValue().equals("Exam Mode")){
            System.out.println("why");
            try {
                Main.showHardnessLevelPage();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            try {
                Main.ExamPageTrial();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(ExamOptions+"  "+SubjectChoice);
    }

    public void LogOutButtonClicked(){
        try {
            ExtraClass.connect.closeconnection();
            Main.showLoginPage();
        } catch (Exception e) {
            System.out.println("Unwanted error");
        }
        System.out.println("Log out now");
    }


}
