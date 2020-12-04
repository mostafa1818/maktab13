package services;

import datainput.InputForEdite;
import objects.Course;
import objects.InputObjectEdite;
import objects.Teacher;
import util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseService {
    /*add in course*/
    public void Adding(Course course) {
        try (
                Connection connection = ConnectionFactory.getconnection();
                PreparedStatement preparedStatement = connection
                        .prepareStatement("INSERT into Course (idteacher,idstudent) values (?,?)");
        ) {
            preparedStatement.setInt(1, course.getTeacherId());
            preparedStatement.setInt(2, course.getStudentId());
            try {
                preparedStatement.executeUpdate();
            } catch (SQLException sqlException) {
                System.out.println("warning");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
    /*edite course*/
    public void Edite(InputObjectEdite inputObjectEdite) {
        try (Connection connection = ConnectionFactory.getconnection();
             PreparedStatement preparedStatement = connection.
                     prepareStatement
                             ("update  course set idteacher=?,idstudent=? where idteacher=? and  idstudent=?");
        ) {
            preparedStatement.setInt(1, inputObjectEdite.getIntinput3());
            preparedStatement.setInt(2, inputObjectEdite.getIntinput4());
            preparedStatement.setInt(3, inputObjectEdite.getIntinput1());
            preparedStatement.setInt(4, inputObjectEdite.getIntinput2());
            try {
                preparedStatement.executeUpdate();
            } catch (SQLException sqlException) {
                System.out.println("warning");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
    public void TeacherDelete(int idteacher) {
        try (Connection connection = ConnectionFactory.getconnection();
             PreparedStatement preparedStatement = connection.
                     prepareStatement("delete from course where idteacher= ? ");
        ) {
            preparedStatement.setInt(1, idteacher);
            try {
                preparedStatement.executeUpdate();
            } catch (SQLException sqlException) {
                System.out.println("warning");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
    public void Deleted(int idteacher, int idstudent) {
        try (Connection connection = ConnectionFactory.getconnection();
             PreparedStatement preparedStatement = connection.
                     prepareStatement("delete from course where idteacher= ? and idstudent= ?");
        ) {
            preparedStatement.setInt(1, idteacher);
            preparedStatement.setInt(2, idstudent);
            try {
                preparedStatement.executeUpdate();
            } catch (SQLException sqlException) {
                System.out.println("warning");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
    public void StudentDelete(int idstudent) {
        try (Connection connection = ConnectionFactory.getconnection();
             PreparedStatement preparedStatement = connection.
                     prepareStatement("delete from course where  idstudent= ?");
        ) {

            preparedStatement.setInt(1, idstudent);
            try {
                preparedStatement.executeUpdate();
            } catch (SQLException sqlException) {
                System.out.println("warning");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public List<Course> loadall() {
        try (
                Connection connection = ConnectionFactory.getconnection();
                PreparedStatement preparedStatement = connection.prepareStatement("select * from Course");
                ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            List<Course> list = new ArrayList<>();
            while (resultSet.next()) {
                Course course = new Course();
                course.setTeacherId(resultSet.getInt("idteacher"));
                course.setStudentId(resultSet.getInt("idstudent"));
                list.add(course);
            }
            return list;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }
    public void Printing(int input) {
        try (
                Connection connection = ConnectionFactory.getconnection();
                PreparedStatement preparedStatement = connection.
                        prepareStatement(" select s.idstudent,s.firstname,s.lastname from Course c join Teacher t join student s on c.idteacher=t.idteacher\n" +
                                " and s.idstudent=c.idstudent  where t.idteacher=? ");
        ) {
            ResultSet resultSet = null;
            preparedStatement.setInt(1, input);
            try {
                resultSet = preparedStatement.executeQuery();
            } catch (SQLException sqlException) {
            }
            System.out.println("idstudent     FirstName     LastName");
            System.out.println("-------------------------------------");
            while (resultSet.next()) {
                System.out.printf("%-15s%-15s%-15s",
                        resultSet.getInt("idstudent"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("LastName")
                );
                System.out.println();
            }
            System.out.println("-------------------------------------");

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
    public void PrintingAll() {
        try (
                Connection connection = ConnectionFactory.getconnection();
                PreparedStatement preparedStatement = connection.
                        prepareStatement(" select t.idteacher,s.idstudent,s.firstname,s.lastname from Course c join Teacher t join student s on c.idteacher=t.idteacher\n" +
                                " and s.idstudent=c.idstudent    ");
        ) {
            ResultSet resultSet = null;
            try {
                resultSet = preparedStatement.executeQuery();
            } catch (SQLException sqlException) {
            }
            System.out.println("idteacher    idstudent     FirstName     LastName");
            System.out.println("-------------------------------------------------");
            while (resultSet.next()) {

                System.out.printf("%-15s%-15s%-15s%-15s",
                        resultSet.getInt("idteacher"),
                        resultSet.getInt("idstudent"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("LastName")
                );
                System.out.println();
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
