package datainput;

import objects.Student;
import objects.Teacher;


import java.util.Scanner;

public class InputDataForStudent {

    /*input data for edite*/
    public Student DataInputForEdite() {
        Student student = new Student();
        Scanner scanner = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);
        System.out.println("press id");
        int intinput = scan.nextInt();
        student.setId(intinput);
        System.out.println("press firstname");
        String input = scan.next();
        student.setFirstName(input);
        System.out.println("press last");
        String input2 = scanner.nextLine();
        student.setLastName(input2);

        return student;
    }

    /*input data for add*/
    public Student DataInput() {
        Student student = new Student();
        Scanner scan = new Scanner(System.in);
        System.out.println("press firstname");
        String input = scan.next();
        student.setFirstName(input);
        System.out.println("press lastname");
        String input2 = scan.nextLine();
        student.setLastName(input2);
        input2 = scan.nextLine();

        return student;
    }


}
