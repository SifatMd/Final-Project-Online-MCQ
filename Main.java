package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.net.URL;

public class Main extends Application {

    static Stage stage;
    public static void main(String[] args) {
        launch(args);
    }

    public void  start(Stage primaryStage) throws Exception{

        stage = primaryStage;
        showLoginPage();
        //SelectTeacherOrStudent() ;
        //InsertQuestionPage();
        //showSelectionPage();
        //showHardnessLevelPage();
        //ExamPageTrial();
        //ExamPageEasy();
        //ExamPageMedium();
        //ExamPageHard();
        //TrialResultpage();
        //FinalResultPage();
        //ShowMyScores();

    }
    public static void showLoginPage() throws Exception{
        Parent root = FXMLLoader.load(Main.class.getResource("controlselect2.fxml"));
        stage.setTitle("Online MCQ Exam");
       // URL cssfile = this.getClass().getResource("Themes.css");
        Scene scene = new Scene(root,600,400);

        //scene.setUserAgentStylesheet(String.valueOf(cssfile));

        stage.setScene(scene);
        stage.show();
    }

    public static void SelectTeacherOrStudent() throws Exception{
        Parent root = FXMLLoader.load(Main.class.getResource("teacherorstudent.fxml"));
        stage.setTitle("Online MCQ Exam");
        stage.setScene(new Scene(root,600,400));
        stage.show();
    }


    public static void InsertQuestionPage() throws Exception{
        Parent root = FXMLLoader.load(Main.class.getResource("teachereditoptions.fxml"));
        stage.setTitle("Online MCQ Exam");
        stage.setScene(new Scene(root,600,500));
        stage.show();
    }

    public static void showSelectionPage() throws Exception{
        Parent root = FXMLLoader.load(Main.class.getResource("select2.fxml"));
        stage.setTitle("Online MCQ Exam");
        stage.setScene(new Scene(root,600,400));
        stage.show();

    }

    public static void showHardnessLevelPage() throws Exception{
        HardnessLevelChoose ob = new HardnessLevelChoose();
        Parent root = FXMLLoader.load(Main.class.getResource("HardnessLevel2.fxml"));
        stage.setTitle("Online MCQ Exam");
        stage.setScene(new Scene(ob.createContent(),600,450));
        //ob.play();
        //stage.setScene(new Scene(root,600,400));
        ob.play();

        stage.show();

    }

    public static void ExamPageTrial() throws Exception{
        Parent root = FXMLLoader.load(Main.class.getResource("exampage.fxml"));
        stage.setTitle("Online MCQ Exam");
        //URL cssfile = Main.class.getResource("ExamThemes.css");
        Scene scene = new Scene(root,600,500);
        //scene.setUserAgentStylesheet(String.valueOf(cssfile));

        stage.setScene(scene);
        stage.show();
    }

    public static void ExamPageEasy() throws Exception{
        Parent root = FXMLLoader.load(Main.class.getResource("Easyexam.fxml"));
        stage.setTitle("Online MCQ Exam");
        //URL cssfile = Main.class.getResource("ExamThemes.css");
        Scene scene = new Scene(root,600,500);
        //scene.setUserAgentStylesheet(String.valueOf(cssfile));

        stage.setScene(scene);
        stage.show();
    }

    public static void ExamPageMedium() throws Exception{
        Parent root = FXMLLoader.load(Main.class.getResource("Mediumexam.fxml"));
        stage.setTitle("Online MCQ Exam");
        //URL cssfile = Main.class.getResource("ExamThemes.css");
        Scene scene = new Scene(root,600,500);
        //scene.setUserAgentStylesheet(String.valueOf(cssfile));

        stage.setScene(scene);
        stage.show();
    }

    public static void ExamPageHard() throws Exception{
        Parent root = FXMLLoader.load(Main.class.getResource("Hardexam.fxml"));
        stage.setTitle("Online MCQ Exam");
        //URL cssfile = Main.class.getResource("ExamThemes.css");
        Scene scene = new Scene(root,600,500);
        //scene.setUserAgentStylesheet(String.valueOf(cssfile));

        stage.setScene(scene);
        stage.show();
    }

    public static void TrialResultpage() throws Exception{
        Parent root = FXMLLoader.load(Main.class.getResource("TrialResult.fxml"));
        stage.setTitle("Online MCQ Exam");
        stage.setScene(new Scene(root,600,450));
        stage.show();
    }



    public static void FinalResultPage() throws Exception{
        Parent root = FXMLLoader.load(Main.class.getResource("finalresult2.fxml"));
        stage.setTitle("Online MCQ Exam");
        stage.setScene(new Scene(root,600,400));
        stage.show();
    }

    public static void ShowMyScores() throws Exception{
        Parent root = FXMLLoader.load(Main.class.getResource("scoresheet.fxml"));
        stage.setTitle("Online MCQ Exam");
        stage.setScene(new Scene(root,600,500));
        stage.show();
    }



}
