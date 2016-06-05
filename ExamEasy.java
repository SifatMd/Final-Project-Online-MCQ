package sample;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * Created by User on 12-May-16.
 */
public class ExamEasy implements Initializable{


    public Label QuestionsAnswered = new Label();
    public Label QuestionsLeft = new Label();
    public  static int answered, left;
    public Scanner x=null;

    public ScrollPane spane = new ScrollPane();

    //public ProgressBar mybar = new ProgressBar();
    //private DoubleProperty ansdouble = new SimpleDoubleProperty(0);
    private double num=0;
    public VBox VertBox = new VBox();

    //Update Button
    public Button UpdateButton = new Button();
    public Button showAnswersButton = new Button();


   // public Label[] label = new Label[10];
    public ArrayList<Label> label2 = new ArrayList<Label>();

    //public RadioButton[] box = new RadioButton[40];
    public ArrayList<RadioButton> box2 = new ArrayList<RadioButton>();
    public  static int Score;

    //togglegroups
   // public ToggleGroup  groups[] = new ToggleGroup[10];
    public ArrayList<ToggleGroup> groups2 = new ArrayList<ToggleGroup>();

    public int getScore(){
        return Score;
    }
    public void setScore(int a){Score = a;}
    public int getAnswered(){
        return answered;
    }

    //Controller obj which will tell me how many questions of easy category are there

    public int noOfQuestions ;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

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
        noOfQuestions = cnt;
        ExtraClass.controller.noOfEasyQuestions = cnt;

        String a, b ,c, d;
        answered = ExtraClass.vector.size();
        num = answered;

        QuestionsLeft.setText(String.valueOf(noOfQuestions-answered));
        QuestionsAnswered.setText(String.valueOf(answered));
        //num=0;
        left = noOfQuestions-answered;
        Score=0;
        String coll[] = new String[200];
        int i=0, j, k;
        System.out.println("Entered initialize of easy questions");





        //set toggle
        for(i=0;i<noOfQuestions;i++){
            ToggleGroup mygroup = new ToggleGroup();
            groups2.add(mygroup);
        }

        //setting progress bar
       // ansdouble.set(num/10.0);
        //mybar.progressProperty().bind(ansdouble);

        try{
            x = new Scanner(new File("GREExamEasy.txt"));
        }catch(Exception e){
            System.out.println("Error");
        }
        i=0;
        while(x.hasNextLine()){
            a = x.nextLine();
            //System.out.println(a);
            coll[i++]=a;
        }

        for( i=0,j=0;i<noOfQuestions;i++,j+=5){
            //label[i] = new Label();
            //label[i].setText(coll[j]);
            Label mylabel = new Label();
            mylabel.setText(coll[j]);
            label2.add(mylabel);
        }
        k=0;
        for(i=0,j=1;i<noOfQuestions*4;i++,j++){
            if(j%5==0) {
                i--;
                continue;
            }
           /* box[i] = new RadioButton();
            box[i].setText(coll[j]);
            if(i!=0 && i%4==0) k++;
            box[i].setToggleGroup(groups[k]);*/

            RadioButton mybutton = new RadioButton();
            mybutton.setText(coll[j]);
            if(i!=0 && i%4==0) k++;
            mybutton.setToggleGroup(groups2.get(k));
            box2.add(mybutton);

        }
        //set toggle


        // VertBox.getChildren().add(label[0]);
        for(i=0,j=0,k=0;i<noOfQuestions*5;i++){
            if(i%5==0){
                //VertBox.getChildren().add(label[j]);
                VertBox.getChildren().add(label2.get(j));
                j++;
            }
            else{
                //VertBox.getChildren().add(box[k]);
                VertBox.getChildren().add(box2.get(k));
                k++;
            }

        }
        i=0;
        j=0;
        int questions[] = new int[noOfQuestions];
        for(i=0;i<noOfQuestions*4;i++){
            for( j=0;j<ExtraClass.vector.size();j++){
                if(ExtraClass.vector.get(j)==i){
                    box2.get(i).setSelected(true);
                    questions[i/4]=1;
                }
            }
        }
        ExtraClass.vector.clear();


        //int localaray[] = new int[40];
        for(i=0;i<noOfQuestions*4;i++) {
            final int ii=i;
            box2.get(i).setOnAction(event -> {
                if (box2.get(ii).isSelected() && questions[ii/4]==0) {

                    answered++;
                    num++;
                    left--;
                    QuestionsAnswered.setText(String.valueOf(answered));
                    QuestionsLeft.setText(String.valueOf(left));
                    questions[ii / 4]=1;


                }


                /*if(!box2.get(ii).isSelected()){
                    answered--;
                    num--;
                    left++;
                    QuestionsAnswered.setText(String.valueOf(answered));
                    QuestionsLeft.setText(String.valueOf(left));
                }*/



            });
        }





        x.close();

        VertBox.setPadding(new Insets(8,8,8,8));
        VertBox.setSpacing(8);
        spane.setContent(VertBox);

        //UpdateButton.setDisable(true);
        //String get = ExtraClass.connect.read().toString();
        //if(get.equals("Question has been added")){
        //    UpdateButton.setDisable(false);
        //}
       // UpdateButtonFunctionality();


    }


    public void UpdateButtonFunctionality(){

            String get = ExtraClass.connect.read().toString();
            if (get.equals("Question has been added")) {
                UpdateButton.setDisable(false);

            }


    }



    public void ShowAnswersButtonClicked(){
        try{
            x = new Scanner(new File("CorrectAnswersEasy.txt"));
        }catch(Exception e){
            System.out.println("Error");
        }
        int ii=0;
        String answers[] = new String[100];
        while(x.hasNextLine()){
            answers[ii]=x.nextLine();
            ii++;
            //System.out.println(answers[ii-1]);
        }
        int j=0;
        int flag=0;
        int kkk=0;
        for(int i=0;i<((noOfQuestions)*4);i++){
            if(flag==0) {
                String s = answers[j];
               // System.out.println("S is "+s);
                kkk=0;
                int jj=0;

                //System.out.println("length of s "+s.length());
                while(jj<s.length()){
                    kkk*=10;
                    kkk+=(s.charAt(jj)-'0');
                    jj++;
                    //System.out.println("kkk "+" "+kkk);
                }

                //System.out.println("k " + kkk);
            }
            if(flag==0 && i==kkk){
                //box2.get(i).setTextFill(Paint.valueOf("#A1B56C"));

                String text = box2.get(i).getText();
                box2.get(i).setText(text+" (correct)");
                box2.get(i).setTextFill(Color.DARKGREEN);
                j++;

               // System.out.println("J is "+j);
            }
            else if(box2.get(i).isSelected()){
                //box2.get(i).setTextFill(Paint.valueOf("#AB4642"));
                String text = box2.get(i).getText();
                box2.get(i).setText(text+ " (wrong)");
                box2.get(i).setTextFill(Color.DARKRED);

            }
            if(j==noOfQuestions) flag=1;

        }
        for(int i=0;i<noOfQuestions*4;i++){
            box2.get(i).setDisable(true);
        }
        UpdateButton.setDisable(true);
        x.close();
        showAnswersButton.setDisable(true);

    }


    public void SubmitButtonClicked() throws Exception{

        /*if(box2.get(1).isSelected()) Score++;
        if(box2.get(6).isSelected()) Score++;
        if(box2.get(8).isSelected()) Score++;
        if(box2.get(13).isSelected()) Score++;
        if(box2.get(17).isSelected()) Score++;
        if(box2.get(22).isSelected()) Score++;
        if(box2.get(25).isSelected()) Score++;
        if(box2.get(31).isSelected()) Score++;
        if(box2.get(33).isSelected()) Score++;
        if(box2.get(37).isSelected()) Score++;*/

        try{
            x = new Scanner(new File("CorrectAnswersEasy.txt"));
        }catch(Exception e){
            System.out.println("Error");
        }

        String answers[] = new String[100];
        int ii=0;
        while(x.hasNextLine()){
            answers[ii]=x.nextLine();
            ii++;
        }
        int j=0;
        int kkk=0;
        int jj=0;
        int flag=0;
        for(int i=0;i<noOfQuestions*4;i++){
            //System.out.println("no of questions are "+noOfQuestions);
            if(flag==0) {
                String s = answers[j];
                //System.out.println("S is "+s);
                kkk=0;
                jj=0;

                while(jj<s.length()){
                    kkk*=10;
                    kkk+=(s.charAt(jj)-'0');
                    jj++;
                    // System.out.println(s.length()+" "+kkk);
                }

                //System.out.println("k " + kkk);
            }
            if(flag==0 && i==kkk && box2.get(i).isSelected()){
                Score++;


                //System.out.println("J is "+j);
            }
            if(i%4==3){
               j++;
            }

            if(j==noOfQuestions) flag=1;
        }

        System.out.println("s "+Score);
        x.close();
        System.out.println("Answers to be submitted");
        String info = Controller.usernamefinal +":" + "Easy"+":"+ Score;
        System.out.println("info is "+info);
        ExtraClass.connect.write(info);


        /*String aa="";

        int cnt=0;
        Scanner x = null;
        try {
            x = new Scanner(new File("ScoresFile.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while(x.hasNextLine()){
            aa = x.nextLine();
            cnt++;
            if(aa.equals(Controller.usernamefinal)){
                System.out.println("Username is "+aa);
                break;
            }
        }
        aa = x.nextLine();
        x.close();


        BufferedReader reader = new BufferedReader(new FileReader("ScoresFile.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("DummyFile.txt"));
        String linetoremove = aa;
        System.out.println("line to remove "+linetoremove);
        String currline="";
        int mark=0;
        int i=0;
        while((currline = reader.readLine())!=null){
            String trimmed = currline.trim();
            if(mark==0 && trimmed.equals(linetoremove) && i==cnt) {
                writer.write("\r\n"+String.valueOf(Score));
                mark=1;
                continue;
            }
            if(i==0) writer.write(currline);
            else  writer.write("\r\n"+currline );
            i++;

        }
        writer.close();
        reader.close();

        FileInputStream instream = null;
        FileOutputStream outstream = null;

        try{
            instream = new FileInputStream("DummyFile.txt");
            outstream = new FileOutputStream("ScoresFile.txt");
            byte[] buffer = new byte[1024];

            int length;

            while((length = instream.read(buffer))>0){
                outstream.write(buffer,0,length);
            }

            instream.close();outstream.close();

        }catch(IOException ioe){
            ioe.printStackTrace();
        }*/


        ExtraClass.flag=1;


        try {
            Main.FinalResultPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void UpdateButtonClicked(){
        ExtraClass.vector.clear();
        for(int i=0;i<noOfQuestions*4;i++){
            if(box2.get(i).isSelected()){
                ExtraClass.vector.add(i);
            }
        }


        try {
            Main.ExamPageEasy();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //read no of questions
        /*int cnt=0;
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
        int diff = cnt-noOfQuestions;
        noOfQuestions = cnt;
        //String ques = String.valueOf(diff+left);
        QuestionsLeft.setText(String.valueOf(diff+left));*/








    }



}
