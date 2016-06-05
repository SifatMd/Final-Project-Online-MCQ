package sample;

import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by User on 18-May-16.
 */
public class TeacherOrStudent implements Initializable{

    public ChoiceBox<String> chooseany = new ChoiceBox<String>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        chooseany.getItems().addAll("Teacher","Student");
        chooseany.setValue("Student");
    }

    public void ProceedButtonClicked(){
        String value = chooseany.getValue();
        if(value.equals("Teacher")){
            try {
                Main.InsertQuestionPage();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(value.equals("Student")){
            try {
                Main.showSelectionPage();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



}
