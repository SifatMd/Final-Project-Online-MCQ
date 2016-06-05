package sample;

import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.Vector;

public class Controller implements Initializable{

    //Login Stuff
    public TextField LoginName = new TextField();
    public PasswordField LoginPassword = new PasswordField();
    //Signin Stuff
    public TextField SignInName = new TextField();
    public TextField SignInReName = new TextField();
    public PasswordField SignInPassword = new PasswordField();
    //Filerelated stuff
    public Scanner x=null;

    //CheckBox
    public CheckBox AsTeacher = new CheckBox();
    public CheckBox LoginAsTeacher = new CheckBox();

    //LoginMessage
    public Label LogInMessage = new Label();
    //signinmessage
    public Label SignInMessage = new Label();

    //no of questions
    public  static int noOfEasyQuestions=0;
    public  static int noOfMediumQuestions=0;
    public  static int noOfHardQuestions=0;
    public  static int noOfTrialQuestions;

    public static String usernamefinal="";

    //client info
    private NetworkUtillities client;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        int cnt=0;
        try{
            x = new Scanner(new File("GREExamEasy.txt"));
        }catch(Exception e){
            System.out.println("Error");
        }
        while(x.hasNextLine()){
            String a = x.nextLine();
            cnt++;
        }
        cnt/=5;
        x.close();
        noOfEasyQuestions=cnt;
        cnt=0;


        try{
            x = new Scanner(new File("GREExamMedium.txt"));
        }catch(Exception e){
            System.out.println("Error");
        }
        while(x.hasNextLine()){
            String a = x.nextLine();
            cnt++;
        }
        cnt/=5;
        x.close();
        noOfMediumQuestions=cnt;
        cnt=0;

        try{
            x = new Scanner(new File("GREExamHard.txt"));
        }catch(Exception e){
            System.out.println("Error");
        }
        while(x.hasNextLine()){
            String a = x.nextLine();
            cnt++;
        }
        cnt/=5;
        x.close();
        noOfHardQuestions=cnt;
        cnt=0;

        //client port opening
        //client = new NetworkUtillities("127.0.0.1", 22222);
        ExtraClass.connect = new NetworkUtillities("127.0.0.1", 22222);



        System.out.println("ff "+noOfEasyQuestions+" "+noOfMediumQuestions+" "+noOfHardQuestions);

    }

    public void LoginButtonClicked() throws Exception {
        String loginuser  = LoginName.getText();
        String loginpassword = LoginPassword.getText();

        String info="";
        int flag=0;
        if(LoginAsTeacher.isSelected())  {
            info = "LOGIN:"+"TEACHER:"+loginuser+":"+loginpassword;
            flag=1;
        }
        else info = "LOGIN:"+ loginuser+":"+loginpassword;

        //client.write(info);
        ExtraClass.connect.write(info);
        //String input = client.read().toString();
        String input = ExtraClass.connect.read().toString();
        if(input.equals("Account doesn't exist. Please try Again")){
            LogInMessage.setText("Account doesn't exist. Please try Again");
        }
        else if(input.equals("Accepted")){
            ExtraClass.vector = new Vector<>();
            ExtraClass.vector.clear();
            try {
                if(flag==0) {
                    usernamefinal = loginuser;
                    Main.showSelectionPage();
                }
                else{
                    if(flag==1){
                        usernamefinal = loginuser;
                        Main.InsertQuestionPage();
                    }
                }
            } catch (Exception e) {
                System.out.println("Unwanted error");
            }
        }

        /*String a="";
        String b="";
        int c=0;

        try{
            x = new Scanner(new File("Accounts.txt"));
        }catch(Exception e){
            System.out.println("Error");
        }
        while(x.hasNext()){
            a = x.next();
            b = x.next();
            System.out.println(a+" "+b);

            if(a.equals(loginuser) && b.equals(loginpassword)){
                c=1;
                break;
            }
        }
        x.close();
        if(c==0){
            //JOptionPane.showMessageDialog(null,"Account doesn't exist\nSign In to create new account");
            LogInMessage.setText("Account doesn't exist. Please try Again");
        }
        else{
            //JOptionPane.showMessageDialog(null,"Welcome");

            try {
                usernamefinal = loginuser;
                Main.SelectTeacherOrStudent();
            } catch (Exception e) {
                System.out.println("Unwanted error");
            }

        }
        x.close();*/



    }

    public void SignInButtonClicked(){
        String newuser = SignInName.getText();
        String newreuser = SignInReName.getText();
        String signinpassword =  SignInPassword.getText();





        if(newreuser.equals(newreuser) && (!(newuser.equals("")) || !(signinpassword.equals("")))) {
            int flag=0;
            String info="";
            if(AsTeacher.isSelected()){
                info = "SIGNUP:"+"TEACHER:"+newuser+":"+signinpassword;
                flag=1;
            }
            else info = "SIGNUP:"+newuser+":"+signinpassword;
            System.out.println(info);
            //client.write(info);
            ExtraClass.connect.write(info);
            SignInName.setText("");
            SignInReName.setText("");
            SignInPassword.setText("");
            //String input = client.read().toString();
            String input = ExtraClass.connect.read().toString();
            SignInMessage.setText(input);


           /* try {
                BufferedWriter out = new BufferedWriter(new FileWriter("Accounts.txt", true));
                String a = "\r\n"+newuser;
                String b = " "+signinpassword;
                out.write(a+b);

                //System.out.println(a);
                //JOptionPane.showMessageDialog(null,"Sign in successful");
                SignInMessage.setText("SignUp Successful");
                SignInName.setText("");
                SignInReName.setText("");
                SignInPassword.setText("");
                out.close();

            } catch (IOException e) {
                System.out.println("Error in writing in file");
            }

            try{
                BufferedWriter x = new BufferedWriter(new FileWriter("ScoresFile.txt", true));
                x.write("\r\n"+newuser);
                String a = "1000";
                x.write("\r\n"+a);
                x.write("\r\n"+a);
                x.write("\r\n"+a);

                x.close();
            }catch(Exception e){
                System.out.println("Error");
            }*/


        }
        else{
            SignInMessage.setText("Sign Up Unsuccessful");
            //JOptionPane.showMessageDialog(null,"Error in Signing in\nSign In Again");
        }
    }







}
