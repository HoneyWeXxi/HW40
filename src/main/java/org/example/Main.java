package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String bdUrl = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "testtest";
        try {
            Connection conn = DriverManager.getConnection(bdUrl, username, password);
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM instructors order by age");
            List<Instructors> list = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int salary = resultSet.getInt("salary");
                int age = resultSet.getInt("age");
                list.add(new Instructors(id, name, salary, age));
            }
            list.forEach(System.out::println);
            resultSet.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
