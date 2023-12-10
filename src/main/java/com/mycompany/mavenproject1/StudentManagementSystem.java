/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author rcurzon
 */
public class StudentManagementSystem {

  private static final ArrayList<Student> student = new ArrayList<>();

  public StudentManagementSystem() {}

  public ArrayList<Student> getStudents() {
    return student;
  }

  public void addStudent() {
    while (true) {
      System.out.println("Enter -1 to exit!");
      Scanner scanner = new Scanner(System.in);
      System.out.print("Enter Id: ");
      int id = setAvailableId();
      if (id == -1) return;
      System.out.print("Enter name: ");
      String name = scanner.nextLine();
      System.out.print("Enter grade: ");
      double grade = Main.getValidDouble();
      System.out.print("Enter email: ");
      String email = scanner.next();

      Student stdnt = new Student(id, name, grade, email);

      student.add(stdnt);
      System.out.println("Student " + id + " has been added.");
    }
  }

  public void printAllStudents() {
    System.out.println("All Students:");

    if (student.isEmpty()) {
      System.out.println("List is Empty");
      return;
    }
    for (Student currentStudent : student) {
      System.out.println(currentStudent);
    }
  }

  public void searchStudentById() {
    boolean found;

    do {
      found = false;
      System.out.print("Enter -1 to exit!\nEnter Student by ID: ");
      int id = Main.getValidInteger();

      if (id == -1) return;

      for (Student currentStudent : student) {
        if (currentStudent.getId() == id) {
          found = true;
          System.out.println("Student found: ");
          System.out.println(currentStudent);
        }
      }
      if (!found) System.out.printf("Student %d not found\n", id);
    } while (true);
  }

  public void updateStudentInformationById() {

    System.out.println("To update one field only from a student just enter -1.");
    System.out.print("Enter Student ID to update: ");
    int id = Main.getValidInteger();
    if (id == -1) {
      updateSingleStudentInformation();
    } else {

      for (Student currentStudent : student) {
        if (currentStudent.getId() == id) {
          currentStudent.updateName();

          currentStudent.updateGrade();

          currentStudent.updateEmail();
          return;
        }
      }
      System.out.printf("Student %d doesn't exist.\n", id);
    }
  }

  void updateSingleStudentInformation() {

    while (true) {

      System.out.print("Enter -1 to Exit\nEnter Student ID to update: ");
      int id = Main.getValidInteger();

      if (id == -1) return;

      for (Iterator<Student> iterator = student.iterator(); iterator.hasNext(); ) {
        Student tempStudent = iterator.next();
        if (tempStudent.getId() == id) {
          System.out.println("Select the field you want to update: ");
          System.out.println("1. Name");
          System.out.println("2. Grade");
          System.out.println("3. Email");
          System.out.print("Select an option: ");
          int choose = Main.validChoice(3);

          switch (choose) {
            case 1:
              tempStudent.updateName();
              break;
            case 2:
              tempStudent.updateGrade();
              break;
            case 3:
              tempStudent.updateEmail();
              break;
            default:
              break;
          }
          System.out.println("Changes applied");
        }
      }
    }
  }

  public void deleteStudentById() {
    boolean flag;
    int index;

    do {
      flag = true;

      System.out.print("You can enter -1 to exit\nEnter Student ID to delete: ");

      int id = Main.getValidInteger();
      if (id == -1) flag = false;
      index = 0;
      for (Iterator<Student> iterator = student.iterator(); iterator.hasNext(); ) {
        Student currStudent = iterator.next();
        if (currStudent.getId() == id) {
          System.out.printf("Student %s has be removed.\n", currStudent.getName());
          iterator.remove();
          break;
        }
        if (!iterator.hasNext()) {
          System.out.println("No Student has been removed!");
        }
      }

    } while (flag);
    System.out.println("deletion exit");
  }

  public static int setAvailableId() {
    int id;
    boolean flag;

    do {
      flag = false;
      id = Main.getValidInteger();
      for (Student currStudent : student) {
        if (currStudent.getId() == id) {
          System.out.println("Student" + id + " already exist");
          System.out.print("Enter a new ID: ");
          flag = true;
          break;
        }
      }
    } while (flag);
    return id;
  }

  public static void testAddStudent() {
    student.add(new Student(123, "John Pega", 99, "johnpega@gmail.com"));
    student.add(new Student(456, "Nica Jerusalem", 99, "nica@gmail.com"));
    student.add(new Student(891, "Maui Sabayan", 99, "maui@gmail.com"));
    student.add(new Student(789, "Twinkle Hipolito", 99, "twinkle@gmail.com"));
  }
}
