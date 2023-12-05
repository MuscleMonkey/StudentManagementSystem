/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author rcurzon
 */
public class StudentManagementSystem {

  private static final ArrayList<Student> student = new ArrayList<>();

  ;

  public StudentManagementSystem() {}

  public ArrayList<Student> getStudents() {
    return student;
  }

  public void addStudent() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter Id: ");
    //think of id validation
    int id = Main.getValidInteger();
    System.out.println("Enter name: ");
    String name = scanner.nextLine();
    System.out.println("Enter grade: ");
    double grade = Main.getValidDouble();
    System.out.println("Enter email: ");
    String email = scanner.next();

    Student currStudent = searchId();

    if (currStudent != null) {
      System.out.println("Student " + id + " already exist");
      return;
    }
    Student stdnt = new Student(id, name, grade, email);

    student.add(stdnt);
    System.out.println("Student " + id + " has been added.");
  }

  public void printAllStudents() {
    System.out.println("All Students:");

    if (student.isEmpty()) {
      System.out.println("List is Empty");
      return;
    }
    for (Student currentStudent : student) {
      System.out.printf("\n%s\n", currentStudent);
    }
    System.out.println();
  }

  public void searchStudentById() {
    System.out.println("Search Student");

    Student currentStudent = searchId();

    if (currentStudent != null) {
      System.out.println(currentStudent);
    } else {
      System.out.println("student not found.");
    }
  }

  public void updateStudentInformationById() {

    Student tempStudent = null;

    System.out.println("Update Student Information");
    System.out.println("Enter Student ID to update: ");

    int id = Main.getValidInteger();

    tempStudent = searchId();

    if (tempStudent == null) {
      System.out.println("no id " + id);
      return;
    }

    System.out.println("2. name");
    tempStudent.updateName();
    System.out.println("3. grade");
    tempStudent.updateGrade();

    System.out.println("4. email");
    tempStudent.updateEmail();

    System.out.println("Enter the number of your choice: ");

    int choice = Main.validChoice(4);

    if (choice == 1) {

    } else if (choice == 2) {
    } else if (choice == 3) {
    } else if (choice == 4) {
    }

    updateStudentInformationById();
  }

  public void deleteStudentById() {
    System.out.println("Delete Student");
    int id = Main.getValidInteger();

    for (int i = 0; i < student.size(); i++) {
      if (student.get(i).getId() == id) {
        student.remove(i);
        return;
      }
    }
    System.out.println("no student has been removed");
  }

  public Student searchId() {
    System.out.println("Enter Student ID: ");
    int id = Main.getValidInteger();
    for (Student currentStudent : student) {
      if (currentStudent.getId() == id) {
        return currentStudent;
      }
    }
    return null;
  }

  public static void testAddStudent() {
    student.add(new Student(123, "John Pega", 99, "johnpega@gmail.com"));
    student.add(new Student(456, "Nica Jerusalem", 99, "nica@gmail.com"));
    student.add(new Student(891, "Maui Sabayan", 99, "maui@gmail.com"));
    student.add(new Student(789, "Twinkle Hipolito", 99, "twinkle@gmail.com"));
  }
}
