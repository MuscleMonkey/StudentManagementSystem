/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.util.Scanner;

/**
 * @author 
 */
public class Student {

  private int m_id;
  private String m_name;
  private double m_grade;
  private String m_email;

  public Student(int id, String name, double grade, String email) {
    this.m_id = id;
    this.m_name = name;
    this.m_grade = grade;
    this.m_email = email;
  }
  /*
    we made getter, setter, and updater methods for the operation of our object
  */
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

    setName(name);
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

    setGrade(grade);
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
    setEmail(email);
  }
  //print the details of th student
  @Override
  public String toString() {
    return "Student ID: "
        + this.getId()
        + "\nName: "
        + this.getName()
        + "\nGrade: "
        + this.m_grade
        + "\nEmail: "
        + this.m_email
        + "\n";
  }
}
