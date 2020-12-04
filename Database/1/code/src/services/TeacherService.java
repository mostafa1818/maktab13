package services;

import objects.Teacher;
import util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherService {
    /*delete teacher*/
    public void Deleted(int id) {
        try (Connection connection = ConnectionFactory.getconnection();
             PreparedStatement preparedStatement = connection.
                     prepareStatement("delete from teacher where idteacher= ?");
        ) {
            preparedStatement.setInt(1, id);
            try {
                preparedStatement.executeUpdate();
            } catch (SQLException sqlException) {
                System.out.println("warning");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
    /*edite teacher*/
    public void Edite(Teacher teacher) {
        try (Connection connection = ConnectionFactory.getconnection();
             PreparedStatement preparedStatement = connection.
                     prepareStatement("update  teacher set idteacher=?,FirstName=?,LastName=? where idteacher=?");
        ) {
            preparedStatement.setInt(1, teacher.getId());
            preparedStatement.setString(2, teacher.getFirstName());
            preparedStatement.setString(3, teacher.getLastName());
            preparedStatement.setInt(4, teacher.getId());
            try {
                preparedStatement.executeUpdate();
            } catch (SQLException sqlException) {
                System.out.println("warning");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
    /*add teacher*/
    public void Adding(Teacher teacher) {
        try (Connection connection = ConnectionFactory.getconnection();
             PreparedStatement preparedStatement = connection.
                     prepareStatement("insert into Teacher(idteacher,FirstName, LastName) values(?,?,?)");
        ) {
            preparedStatement.setInt(1, teacher.getId());
            preparedStatement.setString(2, teacher.getFirstName());
            preparedStatement.setString(3, teacher.getLastName());
            try {
                preparedStatement.executeUpdate();
            } catch (SQLException sqlException) {
                System.out.println("warning");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
    public List<Teacher> loadall() {
        try (
                Connection connection = ConnectionFactory.getconnection();
                PreparedStatement preparedStatement = connection.prepareStatement("select * from Teacher");
                ResultSet resultSet = preparedStatement.executeQuery()
        ) {
            List<Teacher> list = new ArrayList<>();
            while (resultSet.next()) {
                Teacher teacher = new Teacher();
                teacher.setId(resultSet.getInt("idteacher"));
                teacher.setFirstName(resultSet.getString("FirstName"));
                teacher.setLastName(resultSet.getString("LastName"));

                list.add(teacher);
            }
            return list;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }
    /*print teacher*/
    public void Printing() {
        try (
                Connection connection = ConnectionFactory.getconnection();
                PreparedStatement preparedStatement = connection.prepareStatement("select * from Teacher");
                ResultSet resultSet = preparedStatement.executeQuery()
        ) {
            System.out.println("idteacher     FirstName     LastName");
            System.out.println("-------------------------------------");
            while (resultSet.next()) {
                System.out.printf("%-15s%-15s%-15s",
                        resultSet.getInt("idteacher"),
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
}
