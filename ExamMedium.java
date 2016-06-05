package sample;

import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * Created by User on 12-May-16.
 */
public class ExamMedium implements Initializable{

    public Label QuestionsAnswered = new Label();
    public Label QuestionsLeft = new Label();

    private static int answered, left;


    public Scanner x=null;

    public ScrollPane spane = new ScrollPane();

    public VBox VertBox = new VBox();

    private double num=0;

   // public ToggleGroup groups[] =new ToggleGroup[20];
    public ArrayList<ToggleGroup> groups2 = new ArrayList<ToggleGroup>();

    //public Label[] label = new Label[20];
    public ArrayList<Label> label2 = new ArrayList<Label>();

    //public RadioButton[] box = new RadioButton[80];
    public ArrayList<RadioButton> box2 = new ArrayList<RadioButton>();
    public static int Score;

    public void setScore(int a){Score = a;}

    public Controller controller = new Controller();
    public int noOfQuestions;

    //Button
    public Button UpdateButton = new Button();
    public Button showAnswersButton = new Button();
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //read no of questions
        int cnt=0;
        try{
            x = new Scanner(new File("GREExamMedium.txt"));
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
        ExtraClass.controller.noOfMediumQuestions = cnt;

        answered = ExtraClass.vector.size();
        num = answered;
        String a, b ,c, d;
        Score=0;

        left=noOfQuestions - answered;
        QuestionsLeft.setText(String.valueOf(noOfQuestions-answered));
        QuestionsAnswered.setText(String.valueOf(answered));

        String coll[] = new String[200];
        int i=0, j, k;
        try{
            x = new Scanner(new File("GREExamMedium.txt"));
        }catch(Exception e){
            System.out.println("Error");
        }

        for(i=0;i<noOfQuestions;i++){
           // groups[i] = new ToggleGroup();
            ToggleGroup mygroup = new ToggleGroup();
            groups2.add(mygroup);
        }

        i=0;
        while(x.hasNextLine()){
            a = x.nextLine();
            //System.out.println(a);
            coll[i++]=a;
        }

        for( i=0,j=0;i<noOfQuestions;i++,j+=5){
            //label[i] = new Label();
            //abel[i].setText(coll[j]);
            Label mylabel = new Label(coll[j]);
            label2.add(mylabel);
        }
        k=0;
        for(i=0,j=1;i<noOfQuestions*4;i++,j++){
            if(j%5==0) {
                i--;
                continue;
            }
            /*box[i] = new RadioButton();
            box[i].setText(coll[j]);
            if(i!=0 && i%4==0) k++;
            box[i].setToggleGroup(groups[k]);*/
            RadioButton mybutton = new RadioButton(coll[j]);
            box2.add(mybutton);
            if(i!=0 && i%4==0) k++;
            box2.get(i).setToggleGroup(groups2.get(k));

        }
        // VertBox.getChildren().add(label[0]);
        for(i=0,j=0,k=0;i<noOfQuestions*5;i++){
            if(i%5==0){
                VertBox.getChildren().add(label2.get(j));
                j++;
            }
            else{
                VertBox.getChildren().add(box2.get(k));
                k++;
            }

        }
        i=0;j=0;

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


        for(i=0;i<noOfQuestions*4;i++) {
            final int ii=i;
            box2.get(i).setOnAction(event -> {

                if (box2.get(ii).isSelected() && questions[ii/4]==0) {
                    answered++;
                    num++;
                    left--;
                    QuestionsAnswered.setText(String.valueOf(answered));
                    QuestionsLeft.setText(String.valueOf(left));
                    questions[ii/4]++;
                }
                if(!box2.get(ii).isSelected()){
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

    public int getScore(){
        return Score;
    }
    public int getAnswered(){
        return answered;
    }

    public void UpdateButtonFunctionality(){

        String get = ExtraClass.connect.read().toString();
        if (get.equals("Question has been added")) {
            UpdateButton.setDisable(false);

        }


    }



    public void ShowAnswersButtonClicked(){
        try{
            x = new Scanner(new File("CorrectAnswersMedium.txt"));
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
                System.out.println("S is "+s);
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
                String text = box2.get(i).getText();
                box2.get(i).setText(text+" (correct)");
                box2.get(i).setTextFill(Color.DARKGREEN);
                j++;
                // System.out.println("J is "+j);
            }
            else if(box2.get(i).isSelected()){
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

       /* if(box2.get(1).isSelected()) Score++;
        if(box2.get(6).isSelected()) Score++;
        if(box2.get(8).isSelected()) Score++;
        if(box2.get(13).isSelected()) Score++;
        if(box2.get(17).isSelected()) Score++;
        if(box2.get(22).isSelected()) Score++;
        if(box2.get(25).isSelected()) Score++;
        if(box2.get(31).isSelected()) Score++;
        if(box2.get(33).isSelected()) Score++;
        if(box2.get(37).isSelected()) Score++;

        if(box2.get(42).isSelected()) Score++;
        if(box2.get(46).isSelected()) Score++;
        if(box2.get(50).isSelected()) Score++;
        if(box2.get(55).isSelected()) Score++;
        if(box2.get(57).isSelected()) Score++;
        if(box2.get(62).isSelected()) Score++;
        if(box2.get(67).isSelected()) Score++;
        if(box2.get(68).isSelected()) Score++;
        if(box2.get(74).isSelected()) Score++;
        if(box2.get(76).isSelected()) Score++;*/



        try{
            x = new Scanner(new File("CorrectAnswersMedium.txt"));
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

                System.out.println("k " + kkk);
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

        String info = Controller.usernamefinal +":" + "Medium"+":"+ Score;
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
            if(mark==0 && trimmed.equals(linetoremove) && i-1==cnt) {
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




        ExtraClass.flag=2;



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
            Main.ExamPageMedium();
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
