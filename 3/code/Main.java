package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main  {

    interface Interface2{
        String avg(String x);

    }

    public  static class  SameLetter implements Interface2{


        @Override
        public   String avg(String input) {

            String y = String.valueOf(input.charAt(0));
            if (y.equals(String.valueOf(input.charAt(input.length()-1))))
                {  return "yes";}
            else
                {  return "no";}
        }
    }


    public static void main(String[] args) {

        Scanner scan =new Scanner(System.in);
        String input=scan.nextLine();
        SameLetter sameLetter=new SameLetter();
        Interface2 c=sameLetter::avg;
        System.out.println(c.avg(input));

    }
}
