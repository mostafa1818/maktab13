package datainput;

import objects.Teacher;

import java.util.Scanner;

public class InputDataForTeacher {
    /*input data for edite*/
    public Teacher DataInputForEdite()
    {
        Teacher teacher=new Teacher();
        Scanner scanner =new Scanner(System.in);
        Scanner scan =new Scanner(System.in);
        System.out.println("press id");
        int intinput=scan.nextInt();
        teacher.setId(intinput);
        System.out.println("press firstname");
        String input=scan.next();

        teacher.setFirstName(input);
        System.out.println("press lasttname");
        String  input2=scanner.nextLine();
        teacher.setLastName(input2);

        return teacher;
    }
    /*input data for add*/

    public Teacher DataInput()
    {
        Teacher teacher=new Teacher();
        Scanner scan =new Scanner(System.in);
        Scanner scanner =new Scanner(System.in);

        System.out.println("press firstname");
        String input=scan.next();
        teacher.setFirstName(input);
        System.out.println("press lasttname");
        String  input2=scanner.nextLine();
        teacher.setLastName(input2);

        return teacher;
    }
}
