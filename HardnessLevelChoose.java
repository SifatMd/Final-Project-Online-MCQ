package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static java.lang.Math.random;

/**
 * Created by User on 12-May-16.
 */
public class HardnessLevelChoose implements Initializable {
    public ChoiceBox<String> hardnesslevel = new ChoiceBox<String>();
    public String a;

    private static final double WIDTH = 600, HEIGHT = 500;
    private Timeline animation;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        hardnesslevel.getItems().addAll("Easy","Medium","Hard");
        hardnesslevel.setValue("Easy");
        createContent();
    }

    public void SubmitButtonClicked(){
        if(hardnesslevel.getValue().equals("Easy")){
            try {
                Main.ExamPageEasy();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(hardnesslevel.getValue().equals("Medium")){
            try {
                Main.ExamPageMedium();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(hardnesslevel.getValue().equals("Hard")){
            try {
                Main.ExamPageHard();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        a=hardnesslevel.getValue();
    }



    public Parent createContent() {
        Pane layer1 = new Pane();

        ChoiceBox<String> hardnesslevel = new ChoiceBox<String>();
        hardnesslevel.getItems().addAll("Easy","Medium","Hard");
        hardnesslevel.setValue("Easy");

        Label mylabel = new Label("Choose Exam Mode");

        Button submit = new Button("SUBMIT");

        for (int i = 0; i < 15; i++) {
            Circle circle = new Circle(200, Color.web("white", 0.05f));
            circle.setStrokeType(StrokeType.OUTSIDE);
            circle.setStroke(Color.web("white", 0.2f));
            circle.setStrokeWidth(4f);
            layer1.getChildren().add(circle);
        }
        // create second list of circles
        Pane layer2 = new Pane();
        for (int i = 0; i < 20; i++) {
            Circle circle = new Circle(70, Color.web("white", 0.05f));
            circle.setStrokeType(StrokeType.OUTSIDE);
            circle.setStroke(Color.web("white", 0.1f));
            circle.setStrokeWidth(2f);
            layer2.getChildren().add(circle);
        }
        // create third list of circles
        Pane layer3 = new Pane();
        for (int i = 0; i < 10; i++) {
            Circle circle = new Circle(150, Color.web("white", 0.05f));
            circle.setStrokeType(StrokeType.OUTSIDE);
            circle.setStroke(Color.web("white", 0.16f));
            circle.setStrokeWidth(4f);
            layer3.getChildren().add(circle);
        }
        // Set a blur effect on each layer
        layer1.setEffect(new BoxBlur(30, 30, 3));
        layer2.setEffect(new BoxBlur(2, 2, 2));
        layer3.setEffect(new BoxBlur(10, 10, 3));
        // create a rectangle size of window with colored gradient
        Rectangle colors = new Rectangle(WIDTH, HEIGHT,
                new LinearGradient(0f, 1f, 1f, 0f, true, CycleMethod.NO_CYCLE, new Stop(0, Color.web("#f8bd55")),
                        new Stop(0.14f, Color.web("#c0fe56")),
                        new Stop(0.28f, Color.web("#5dfbc1")),
                        new Stop(0.43f, Color.web("#64c2f8")),
                        new Stop(0.57f, Color.web("#be4af7")),
                        new Stop(0.71f, Color.web("#ed5fc2")),
                        new Stop(0.85f, Color.web("#ef504c")),
                        new Stop(1, Color.web("#f2660f"))));
        colors.setBlendMode(BlendMode.OVERLAY);
        // create main content
        ScrollPane sp = new ScrollPane();
        sp.setFitToWidth(true);
        sp.setFitToHeight(true);
        sp.setPrefSize(WIDTH, HEIGHT);

        Pane pane = new Pane();
        sp.setContent(pane);
        pane.getChildren().addAll( new Rectangle(WIDTH, HEIGHT, Color.BLACK),
                layer1,
                layer2,
                layer3,
                colors);
        Rectangle clip = new Rectangle(WIDTH, HEIGHT);
        clip.setSmooth(false);
        pane.setClip(clip);

        //choicebox added
        hardnesslevel.relocate(200,200);
        hardnesslevel.setMinWidth(100);
        hardnesslevel.setMinHeight(30);
        pane.getChildren().add(hardnesslevel);


        //label added
        mylabel.relocate(200,150);
        mylabel.setFont(Font.font(25));
        pane.getChildren().add(mylabel);

        //button added
        submit.relocate(450,400);
        submit.setFont(Font.font(15));
        pane.getChildren().add(submit);


        // create list of all circles
        List<Node> allCircles = new ArrayList<>();
        allCircles.addAll(layer1.getChildren());
        allCircles.addAll(layer2.getChildren());
        allCircles.addAll(layer3.getChildren());
        // Create a animation to randomly move every circle in allCircles
        animation = new Timeline();
        for (Node circle : allCircles) {
            animation.getKeyFrames().addAll(
                    new KeyFrame(Duration.ZERO, // set start position at 0s
                            new KeyValue(circle.translateXProperty(), random() * WIDTH),
                            new KeyValue(circle.translateYProperty(), random() * HEIGHT)),
                    new KeyFrame(new Duration(40000), // set end position at 40s
                            new KeyValue(circle.translateXProperty(), random() * WIDTH),
                            new KeyValue(circle.translateYProperty(), random() * HEIGHT)));
        }


        submit.setOnAction(event-> {
            if(hardnesslevel.getValue().equals("Easy")){
                try {
                    Main.ExamPageEasy();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else if(hardnesslevel.getValue().equals("Medium")){
                try {
                    Main.ExamPageMedium();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else if(hardnesslevel.getValue().equals("Hard")){
                try {
                    Main.ExamPageHard();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            a=hardnesslevel.getValue();
        });










        animation.setAutoReverse(true);
        animation.setCycleCount(Animation.INDEFINITE);
        return sp;
    }

    public void play() {
        animation.play();
    }


    public void stop() {
        animation.stop();
    }












}
