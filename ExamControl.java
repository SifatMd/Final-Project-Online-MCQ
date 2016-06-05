package sample;

import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
//this is control group for trial exam page
public class ExamControl implements Initializable{
    public Label QuestionsAnswered = new Label();
    public Label QuestionsLeft = new Label();

    private int answered;
    private int left;

    public Scanner x=null;
    private static int noofQuestionsAnswered;

    public ScrollPane spane = new ScrollPane();

    public VBox VertBox = new VBox();


    //public Label[] label = new Label[30];
    public ArrayList<Label> label2 = new ArrayList<Label>();

    //public ToggleGroup groups[] = new ToggleGroup[30];
    public ArrayList<ToggleGroup> groups2 = new ArrayList<ToggleGroup>();


    // public RadioButton[] box = new RadioButton[120];
    public ArrayList<RadioButton> box2 = new ArrayList<RadioButton>();
    public static int Score;

    //button
    public Button showAnswersButton = new Button();


    public void SubmitButtonClicked(){
        if(box2.get(1).isSelected()) Score++;
        if(box2.get(6).isSelected()) Score++;
        if(box2.get(8).isSelected()) Score++;
        if(box2.get(13).isSelected()) Score++;
        if(box2.get(17).isSelected()) Score++;
        if(box2.get(22).isSelected()) Score++;
        if(box2.get(25).isSelected()) Score++;
        if(box2.get(31).isSelected()) Score++;
        if(box2.get(33).isSelected()) Score++;
        if(box2.get(37).isSelected()) Score++;
        System.out.println("s "+Score);
        for(int i=0;i<40;i++){
            if(box2.get(i).isSelected()) noofQuestionsAnswered++;

        }
        System.out.println("No of questions anwered is "+ noofQuestionsAnswered);
        try {
            Main.TrialResultpage();
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println("Answers to be submitted");
    }

    public int getScore(){
        return Score;
    }
    public int getNoofQuestionsAnswered(){
        System.out.println(noofQuestionsAnswered+" no ");
        return noofQuestionsAnswered;
    }

    public void ShowAnswersButtonClicked(){

        for(int i=0;i<40;i++){
            if(i==1 ||i==6 ||i==8 ||i==13 ||i==17 ||i==22 ||i==25 ||i==31 ||i==33 ||i==37 ){



                String text = box2.get(i).getText();
                box2.get(i).setText(text+" (correct)");
                box2.get(i).setTextFill(Color.DARKGREEN);

                // box2.get(i).setFont(Font.font(14));
            }
            else if(box2.get(i).isSelected()){
                String text = box2.get(i).getText();
                box2.get(i).setText(text+ " (wrong)");
                box2.get(i).setTextFill(Color.DARKRED);

            }
        }
        for(int i=0;i<40;i++){
            box2.get(i).setDisable(true);
        }
        showAnswersButton.setDisable(true);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String a, b  , c, d;
        answered=0;
        left=10;

        QuestionsAnswered.setText("0");
        QuestionsLeft.setText("10");

        Score=0;
        noofQuestionsAnswered=0;
        String coll[] = new String[200];
        int i=0, j, k;
        try{
            x = new Scanner(new File("GRETrial.txt"));
        }catch(Exception e){
            System.out.println("Error");
        }
        for(i=0;i<10;i++){
            //groups[i] = new ToggleGroup();
            ToggleGroup mygroup = new ToggleGroup();
            groups2.add(mygroup);
        }
        i=0;
        while(x.hasNextLine()){
            a = x.nextLine();
            //System.out.println(a);
            coll[i++]=a;
        }

        for( i=0,j=0;i<10;i++,j+=5){
            //label[i] = new Label();
            //label[i].setText(coll[j]);
            Label mylabel = new Label(coll[j]);
            label2.add(mylabel);
        }
        k=0;
        for(i=0,j=1;i<40;i++,j++){
            if(j%5==0) {
                i--;
                continue;
            }
            /*box[i] = new RadioButton();
            box[i].setText(coll[j]);
            if(i!=0 && i%4==0) k++;
            box[i].setToggleGroup(groups[k]);*/

            RadioButton mybutton = new RadioButton(coll[j]);
            if(i!=0 && i%4==0) k++;
            mybutton.setToggleGroup(groups2.get(k));
            box2.add(mybutton);

        }

        //Making the questions easy
        box2.get(1).setFont(Font.font(14.5));
        box2.get(6).setFont(Font.font(14.5));
        box2.get(8).setFont(Font.font(14.5));
        box2.get(13).setFont(Font.font(14.5));
        box2.get(17).setFont(Font.font(14.5));
        box2.get(22).setFont(Font.font(14.5));
        box2.get(25).setFont(Font.font(14.5));
        box2.get(31).setFont(Font.font(14.5));
        box2.get(33).setFont(Font.font(14.5));
        box2.get(37).setFont(Font.font(14.5));

        box2.get(0).setFont(Font.font(14.5));
        box2.get(4).setFont(Font.font(14.5));
        box2.get(10).setFont(Font.font(14.5));
        box2.get(12).setFont(Font.font(14.5));
        box2.get(18).setFont(Font.font(14.5));
        box2.get(23).setFont(Font.font(14.5));
        box2.get(24).setFont(Font.font(14.5));
        box2.get(29).setFont(Font.font(14.5));
        box2.get(32).setFont(Font.font(14.5));
        box2.get(39).setFont(Font.font(14.5));




       // VertBox.getChildren().add(label[0]);
        for(i=0,j=0,k=0;i<50;i++){
            if(i%5==0){
                VertBox.getChildren().add(label2.get(j));
                j++;
            }
            else{
                VertBox.getChildren().add(box2.get(k));
                k++;
            }

        }
        int questions[] = new int[10];


        for(i=0;i<40;i++) {
            final int ii=i;
            box2.get(i).setOnAction(event -> {

                if (box2.get(ii).isSelected() && questions[ii/4]==0) {
                    answered++;
                    left--;
                    QuestionsAnswered.setText(String.valueOf(answered));
                    QuestionsLeft.setText(String.valueOf(left));
                    questions[ii/4]++;
                } if(!box2.get(ii).isSelected()) {
                    answered--;
                    left++;
                    QuestionsAnswered.setText(String.valueOf(answered));
                    QuestionsLeft.setText(String.valueOf(left));
                }


            });
        }



        x.close();

        VertBox.setPadding(new Insets(8,8,8,8));
        VertBox.setSpacing(8);
        spane.setContent(VertBox);



    }
}






