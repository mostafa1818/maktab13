package datainput;

import objects.Course;
import objects.Student;
import java.util.Scanner;
public class InputDataForCourse {
    /*input data*/
    public Course DataInput() {
        Course course = new Course();
        Scanner scan = new Scanner(System.in);
        System.out.println("press idteacher");
        int input = scan.nextInt();
        course.setTeacherId(input);
        System.out.println("press idstudent");
        input = scan.nextInt();
        course.setStudentId(input);

        return course;
    }
}
