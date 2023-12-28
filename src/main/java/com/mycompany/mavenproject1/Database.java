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

  private Database() {}

  public static Connection createConnection() {
   
    try {
      Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentSchema", "admin", "");
      System.out.println("Connected to database");
      return connection;
    } catch (SQLException e) {
      System.out.println(e.getMessage());
      System.out.println("Failed to connect to database");
      return null;
    }
  }

  public static void insert(int id, String name, int grade, String email) {
    try {
      Connection connection = createConnection();
      PreparedStatement preparedStatement =
          connection.prepareStatement("INSERT INTO student(studentId, studentName, studentGrade, studentEmail) VALUES(?,?,?,?)");
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
      Connection connection = createConnection();
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
  
  public static void updateSingleField(int id, <T> update) {
    try {
      Connection connection = createConnection();
    PreparedStatement preparedStatement = connection.prepareStatement("ALTER TABLE student WHERE studentId = ?");
      preparedStatement.setString(1, update);
    } catch (SQLException e) {
    }
  }
}
