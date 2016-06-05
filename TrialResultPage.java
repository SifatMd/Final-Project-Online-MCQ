package sample;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by User on 13-May-16.
 */
public class TrialResultPage implements Initializable{
    public Label AnsweredQuestions = new Label();
    public Label TotalQuestions = new Label();
    public Label CorrectAnswers = new Label();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        int a;
        String x;
        ExamControl ob = new ExamControl();
        a = ob.getNoofQuestionsAnswered();
        x = String.valueOf(a);
        AnsweredQuestions.setText(x);
        System.out.println("a "+a);
        a = ob.getScore();
        x = String.valueOf(a);
        CorrectAnswers.setText(x);

        TotalQuestions.setText("10");

    }

    public void LogOutButtonClicked(){
        try {
            Main.showLoginPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void StartAgain(){
        try {
            Main.showSelectionPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
