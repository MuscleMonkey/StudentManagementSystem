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
    System.out.print("Enter Id: ");
    int id = setAvailableId();
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

  public void printAllStudents() {
    System.out.println("All Students:");

    if (student.isEmpty()) {
      System.out.println("List is Empty");
      return;
    }
    for (Student currentStudent : student) {
      System.out.println(currentStudent);
    }
    System.out.println();
  }

  public void searchStudentById() {
    System.out.print("Enter Student by ID: ");

    int id = Main.getValidInteger();

    for (Student currentStudent : student) {
      if (currentStudent.getId() == id) {
        System.out.println("Student found: ");
        System.out.println(currentStudent);
        return;
      }
    }
    System.out.printf("Student %d not found\n", id);
  }

  public void updateStudentInformationById() {

    System.out.println(
        "If you wish to update only one field can just enter [-1] else you can proceed below.");
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

    
    boolean flag;
    int index;
    
    do {
      flag = false;
////////////////////////      System.out.print("You can enter -1 to exit\nEnter Student ID to update: ");
      index = searchStudentId();
      if (index == 0) flag = true;
    } while (flag);

    System.out.println("Select the field you want to update: ");
    System.out.println("1. Name");
    System.out.println("2. Grade");
    System.out.println("3. Email");
    System.out.print("Select an option: ");
    int choose = Main.validChoice(3);

    if (choose == 1) {
      student.get(index).updateName();
    } else if (choose == 2) {
      student.get(index).updateGrade();
    } else if (choose == 3) {
      student.get(index).updateEmail();
    }
    System.out.println("Changes applied");
  }

  public void deleteStudentById() {
    boolean flag;
    int index;
    
    do {
      flag = false;
      
      System.out.print("You can enter -1 to exit\nEnter Student ID to delete: ");

      index = searchStudentId();
      
      if (index == 0) flag = true;
      
    } while (flag);
    System.out.printf("Student %d succesfully deleted!\n", student.get(index).getId());
    student.remove(student.get(index));
  }

  public static int setAvailableId() {
    int id;
    boolean flag;

    do {
      id = Main.getValidInteger();
      flag = false;
      for (Student currStudent : student) {
        if (currStudent.getId() == id) {
          System.out.println(id + "already exist");
          System.out.print("Enter a new ID: ");
          flag = true;
          break;
        }
      }
    } while (flag);
    return id;
  }

  public static int searchStudentId() {
    int i;
    int ids = Main.getValidInteger();
    
    if (ids == -1) return -1;
    for (i = 0; i < student.size(); i++) {
      if (student.get(i).getId() == ids) {
        return i;
      }
    }
    System.out.printf("Student %d not found!\n", ids);
    return 0;
  }

  public static void testAddStudent() {
    student.add(new Student(123, "John Pega", 99, "johnpega@gmail.com"));
    student.add(new Student(456, "Nica Jerusalem", 99, "nica@gmail.com"));
    student.add(new Student(891, "Maui Sabayan", 99, "maui@gmail.com"));
    student.add(new Student(789, "Twinkle Hipolito", 99, "twinkle@gmail.com"));
  }
}
