/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.mavenproject1;

import java.sql.*;
import java.util.ArrayList;
/**
 * @author rcurzon
 */
public class Database {
  private Connection connection;

  public Database() {

    try {
      this.connection =
          DriverManager.getConnection(
              "jdbc:mysql://localhost:3306/StudentManagementSystemDatabase", "admin", "3187");
    } catch (SQLException e) {
      System.out.println(e.getMessage());
      System.out.println("Failed to connect to database");
    }
  }
  
  public static Connection createConnection() {
    Connection connection = null; 
    try {
      connection =
          DriverManager.getConnection(
              "jdbc:mysql://localhost:3306/StudentManagementSystemDatabase", "admin", "3187");
      System.out.println("Retrieving successful");
    } catch (SQLException e) {
      System.out.println(e.getMessage());
      System.out.println("Failed to connect to database");
    }
    return connection;
  }
  public void insert(int id, String name, double grade, String email) {
    String firstName = name.substring(0, name.indexOf(" "));
    String lastName = name.substring(name.indexOf(" ") + 1);
    try {
      PreparedStatement preparedStatement =
          this.connection.prepareStatement(
              "INSERT INTO Students (studentId, studentFirstName, studentLastName, studentGrade, studentEmail) VALUES(?,?,?,?,?)");
      preparedStatement.setInt(1, id);
      preparedStatement.setString(2, firstName);
      preparedStatement.setString(3, lastName);
      preparedStatement.setDouble(4, grade);
      preparedStatement.setString(5, email);
      preparedStatement.executeUpdate();
      System.out.println("The information is added succesfully in database.");
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  public void delete(int id) {
    try {
      PreparedStatement preparedStatement =
          this.connection.prepareStatement("DELETE FROM Students WHERE studentId = ?");
      preparedStatement.setInt(1, id);
      preparedStatement.execute();
      System.out.println("Delete succesfully");

    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }
  // handle error
  public void updateName(int id, String name) {
    String firstName = name.substring(0, name.indexOf(" "));
    String lastName = name.substring(name.indexOf(" ") + 1);
    try {
      PreparedStatement preparedStatement =
          this.connection.prepareStatement(
              "UPDATE Students SET studentFirstName = ?, studentLastName = ? WHERE studentId = ? ");
      preparedStatement.setString(1, firstName);
      preparedStatement.setString(2, lastName);
      preparedStatement.setInt(3, id);
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  public void updateEmail(int id, String email) {
    try {
      PreparedStatement preparedStatement =
          this.connection.prepareStatement(
              "UPDATE Students SET studentEmail = ? WHERE studentId = ?");
      preparedStatement.setString(1, email);
      preparedStatement.setInt(2, id);
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  public void updateGrade(int id, double grade) {
    try {
      PreparedStatement preparedStatement =
          this.connection.prepareStatement(
              "UPDATE Students SET studentGrade = ? WHERE studentId = ?");
      preparedStatement.setDouble(1, grade);
      preparedStatement.setInt(2, id);
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }
  public static ArrayList<Student> retrieveTable(Connection connection) throws SQLException {
    String query = "select * from Students;";
    ArrayList<Student> students = new ArrayList<>();
    
    try (Statement stmt = connection.createStatement()) {
      ResultSet rs = stmt.executeQuery(query);
      while (rs.next()) {
        int StudentId = rs.getInt(2);
        String StudentName = rs.getString(3) + rs.getString(4);
        int StudentGrade = rs.getInt(5);
        String StudentEmail = rs.getString(6);
//        System.out.println(StudentId + " " + StudentName + " " + StudentGrade + " " + StudentEmail + " ");
        students.add(Student.createStudent(StudentId, StudentName, StudentGrade, StudentEmail));
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    StudentManagementSystem.displayListKeys();
    return students;
  }
}