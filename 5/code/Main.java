package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) {


        String[] Names = {"Rahim","Jalal","Jamal","Ali","sara","neda","Jalal"};

        System.out.println(Arrays.stream(Names).collect(Collectors.groupingBy(String::length)));

    }
}
