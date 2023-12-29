/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.util.Scanner;

/**
 * @author rcurzon
 */
public class Student {
  private int m_id;
  private String m_name;
  private double m_grade;
  private String m_email;
  Database database = new Database();
  private Student(int id, String name, double grade, String email) {
    this.m_id = id;
    this.m_name = name;
    this.m_grade = grade;
    this.m_email = email;
  }

  public int getId() {
    return this.m_id;
  }

  public void setId(int id) {
    this.m_id = id;
  }

  public String getName() {
    return m_name;
  }

  public void setName(String name) {
    this.m_name = name;
  }

  public void updateName() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter updated Name: ");
    String name = scanner.nextLine();
    
    database.updateName(this.m_id, name);
    this.setName(name);
  }

  public double getGrade() {
    return m_grade;
  }

  public void setGrade(double grade) {
    this.m_grade = grade;
  }

  public void updateGrade() {
    System.out.print("Enter updated Grade: ");
    double grade = Main.getValidDouble();

    database.updateGrade(this.m_id, grade);
    this.setGrade(grade);
  }

  public String getEmail() {
    return m_email;
  }

  public void setEmail(String email) {
    this.m_email = email;
  }

  public void updateEmail() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter updated Email: ");
    String email = scanner.next();

    database.updateEmail(this.m_id, email);
    this.setEmail(email);
  }
  
  public static Student createStudent(int id, String name, int grade, String email) {
    return new Student(id, name, grade, email);
  }
  @Override
  public String toString() {
    return "Student ID: "
        + this.m_id
        + "\nName: "
        + this.m_name
        + "\nGrade: "
        + this.m_grade
        + "\nEmail: "
        + this.m_email
        +'\n';
  }
}
