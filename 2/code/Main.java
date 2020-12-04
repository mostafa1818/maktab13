package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Scanner;
import java.util.function.BiFunction;

public class Main   {



    public static void main(String[] args) {

        Scanner scan =new Scanner(System.in);
        int inputa=scan.nextInt();
        int inputb=scan.nextInt();
        Average average=(input1,input2)->((double)(input1+input2)/2);
        System.out.println(average.avg(inputa,inputb));
 

    }

    interface Average{
        double avg(int input1,int input2);

    }

    public static class  Avg implements Average{

        @Override
        public double avg(int input1,int input2) {
            return  (((double)(input1+input2))/2);
        }
    }





}
