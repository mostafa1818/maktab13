package datainput;

import objects.InputObjectEdite;
import objects.Teacher;

import java.util.Scanner;

public class InputForEdite {

    public InputObjectEdite DataInputForEdite() {
        Scanner intscan = new Scanner(System.in);
        InputObjectEdite inputObjectEdite = new InputObjectEdite();
        System.out.println("press old id of teacher");
        int intinput1 = intscan.nextInt();
        inputObjectEdite.setIntinput1(intinput1);
        System.out.println("press old  id of student");
        int intinput2 = intscan.nextInt();
        inputObjectEdite.setIntinput2(intinput2);
        System.out.println("press new id of teacher");
        int intinput3 = intscan.nextInt();
        inputObjectEdite.setIntinput3(intinput3);
        System.out.println("press new  id of student");
        int intinput4 = intscan.nextInt();
        inputObjectEdite.setIntinput4(intinput4);
        return inputObjectEdite;
    }
}
