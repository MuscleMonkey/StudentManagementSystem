/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.mavenproject1;

import java.sql.*;
/**
 * @author rcurzon
 */
public class Database {
  private static Connection connection = null;

  public Database() {

    try {
      connection =
          DriverManager.getConnection("jdbc:mysql://localhost:3306/studentSchema", "admin", "");
      System.out.println("Database connected!");
    } catch (SQLException e) {
      System.out.println(e.getMessage());
      System.out.println("Failed to connect to database");
    }
  }

  public static void insert(int id, String name, int grade, String email) {
    try {
      PreparedStatement preparedStatement =
          connection.prepareStatement(
              "INSERT INTO student(studentId, studentName, studentGrade, studentEmail) VALUES(?,?,?,?)");
      preparedStatement.setInt(1, id);
      preparedStatement.setString(2, name);
      preparedStatement.setInt(3, grade);
      preparedStatement.setString(4, email);
      preparedStatement.executeUpdate();
      System.out.println("The information is added succesfully in database.");
    } catch (SQLException e) {
      System.out.println(e.getMessage());
      System.out.println("There is error when inserting!");
    }
  }

  public static void delete(int id) {
    try {
      PreparedStatement preparedStatement =
          connection.prepareStatement("DELETE FROM student WHERE studentId = ?");
      preparedStatement.setInt(1, id);
      preparedStatement.execute();
      System.out.println("Delete succesfully");

    } catch (SQLException e) {
      System.out.println(e.getMessage());
      System.out.println("There is error when deleting!");
    }
  }

  public static void updateName(int id, String name) {
    try {
      PreparedStatement preparedStatement =
          connection.prepareStatement("UPDATE student SET studentName = ? WHERE studentId = ? ");
      preparedStatement.setString(1, name);
      preparedStatement.setInt(2, id);
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      System.out.println("Error happened in updating name.");
      System.out.println(e.getMessage());
    }
  }

  public static void updateEmail(int id, String email) {
    try {
      PreparedStatement preparedStatement =
          connection.prepareStatement("UPDATE student SET studentEmail = ? WHERE studentId = ?");
      preparedStatement.setString(1, email);
      preparedStatement.setInt(2, id);
    } catch (SQLException e) {
      System.out.println("Error happened in updating Email");
    }
  }

  public static void updateGrade(int id, double grade) {
    try {
      PreparedStatement preparedStatement =
          connection.prepareStatement("UPDATE student SET studentGrade = ? WHERE studentId = ?");
      preparedStatement.setInt(1, id);
      preparedStatement.setDouble(2, grade);
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }
}