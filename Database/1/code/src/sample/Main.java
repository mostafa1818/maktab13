package sample;

import datainput.InputDataForCourse;
import datainput.InputDataForStudent;
import datainput.InputDataForTeacher;
import datainput.InputForEdite;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import objects.Teacher;
import services.CourseService;
import services.StudentService;
import services.TeacherService;

import javax.xml.bind.annotation.XmlType;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*create object*/
        TeacherService teacherService = new TeacherService();
        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        InputDataForTeacher inputDataForTeacher = new InputDataForTeacher();
        InputDataForStudent inputDataForStudent = new InputDataForStudent();
        InputDataForCourse inputDataForCourse = new InputDataForCourse();
        InputForEdite inputForEdite = new InputForEdite();
        Scanner scan = new Scanner(System.in);
        Scanner intscan = new Scanner(System.in);
        int intinput;
        int intinput2;
        int intinput3;
        int intinput4;
        /*menu*/
        System.out.println("menu:");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("addteacher     deleteteacher     showteacher     editeteacher" +
                "\naddstudent     deletestudent     showstudent     editestudent" +
                "\naddcourse      deletecourse      showcourse      showallcourse   editecourse");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("press command");
        /*scan command*/
        String input = scan.nextLine();
        /*choise from menu*/
        while (true) {
            switch (input) {
                case "addteacher":
                    teacherService.Adding(inputDataForTeacher.DataInput());
                    break;
                case "deleteteacher":
                    System.out.println("press id of teacher");
                    intinput = intscan.nextInt();
                    courseService.TeacherDelete(intinput);
                    teacherService.Deleted(intinput);
                    break;
                case "showteacher":
                    teacherService.Printing();
                    break;
                case "editeteacher":
                    teacherService.Edite(inputDataForTeacher.DataInputForEdite());
                    break;
                case "addstudent":
                    studentService.Adding(inputDataForStudent.DataInput());
                    break;
                case "deletestudent":
                    System.out.println("press id of student");
                    intinput = intscan.nextInt();
                    courseService.StudentDelete(intinput);
                    studentService.Deleted(intinput);
                    break;
                case "showstudent":
                    studentService.Printing();
                    break;
                case "editestudent":
                    studentService.Edite(inputDataForStudent.DataInputForEdite());
                    break;
                case "addcourse":
                    courseService.Adding(inputDataForCourse.DataInput());
                    break;
                case "deletecourse":
                    System.out.println("press id of teacher");
                    intinput = intscan.nextInt();
                    System.out.println("press id of student");
                    intinput2 = intscan.nextInt();
                    courseService.Deleted(intinput, intinput2);
                    break;
                case "showcourse":
                    System.out.println("press id of teacher");
                    intinput = intscan.nextInt();
                    courseService.Printing(intinput);
                    break;
                case "showallcourse":
                    courseService.PrintingAll();
                    break;
                case "editecourse":
                    courseService.Edite(inputForEdite.DataInputForEdite());
                    break;
                case "exit":
                    return;
            }
            System.out.println("press command");
            input = scan.nextLine();
        }
    }
}
