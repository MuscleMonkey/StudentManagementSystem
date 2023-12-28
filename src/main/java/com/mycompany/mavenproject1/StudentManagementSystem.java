/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author rcurzon
 */
public class StudentManagementSystem {
  private static final HashMap<Integer, Student> hm = new HashMap<>();

  public StudentManagementSystem() {}

  public static void addStudent() {
    do {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Enter Id: ");
      int id = setAvailableId();
      System.out.print("Enter name: ");
      String name = scanner.nextLine();
      System.out.print("Enter grade: ");
      int grade = Main.getValidInteger();
      System.out.print("Enter email: ");
      String email = scanner.next();

      Database.insert(id, name, grade, email);
      hm.put(id, Student.createStudent(id, name, grade, email));
      
      System.out.println("Student " + id + " added succesfully!");

    } while (enterToContinue());
  }

  public static void printAllStudents() {
    Iterator<Integer> i = hm.keySet().iterator();

    System.out.println("All Students: \n");

    if (!i.hasNext()) {
      System.out.println("List is empty!");
      return;
    }

    while (i.hasNext()) {
      int key = (int) i.next();
      System.out.println(hm.get(key));
    }
  }

  public static void searchStudentById() {

    do {
      System.out.print("Enter Student ID to search: ");
      int id = Main.getValidInteger();

      if (hm.containsKey(id)) {
        System.out.println("Student found: ");
        System.out.println(hm.get(id));
      } else System.out.println("Student not found!!");
    } while (enterToContinue());
  }
  // music
  public static void updateStudentInformationById() {
    System.out.println("Enter to modify only one field to a student.");
    System.out.println("Enter any key to modify multiple field to a student.");
    do {
      if (enterToContinue()) {
        updateSingleStudentInformation();
        break;
      }
      System.out.print("Enter Student ID to update: ");
      int id = Main.getValidInteger();

      if (!hm.containsKey(id)) {
        System.out.println("Student not found!");
      } else {
        Student student = hm.get(id);
        student.updateName();
        student.updateGrade();
        student.updateEmail();
        System.out.println("Student information updated successfully!");
      }
    } while (enterToContinue());
  }

  public static void updateSingleStudentInformation() {
    do {
      System.out.print("Enter Student ID to update: ");

      int id = Main.getValidInteger();

      if (hm.containsKey(id)) {
        Student student = hm.get(id);
        System.out.println("Select the field you want to update: ");
        System.out.println("1. Name");
        System.out.println("2. Grade");
        System.out.println("3. Email");
        System.out.print("Select an option: ");

        int choose = Main.validChoice(3);

        switch (choose) {
          case 1:
            student.updateName();
            break;
          case 2:
            student.updateGrade();
            break;
          case 3:
            student.updateEmail();
            break;
          default:
            break;
        }
        System.out.println("Student information updated successfully!");
      } else System.out.println("Student not found!");
    } while (enterToContinue());
  }

  public static void deleteStudentById() {

    do {

      System.out.print("Enter Student ID to delete: ");

      int id = Main.getValidInteger();

      if (hm.containsKey(id)) {
        hm.remove(id);
        Database.delete(id);
        System.out.printf("Student %d deleted succesfully!\n", id);
      } else System.out.println("Student not found!");
    } while (enterToContinue());
  }

  public static int setAvailableId() {
    int id;
    boolean flag;

    do {
      id = Main.getValidInteger();
      flag = false;
      if (hm.containsKey(id) == false) {
        break;
      } else {
        System.out.print("Enter a not owned ID: ");
        flag = true;
      }
    } while (flag);
    return id;
  }

  public static boolean enterToContinue() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter key to continue...");
    String input = scanner.nextLine();

    return input.equals("");
  }

  public static void testAddStudent() {

    hm.put(123, Student.createStudent(123, "John Pega", 99, "johnpega@gmail.com"));
    hm.put(456, Student.createStudent(456, "Nica Jerusalem", 95, "nica@gmail.com"));
    hm.put(891, Student.createStudent(891, "Maui Sabayan", 99, "maui@gmail.com"));
    hm.put(789, Student.createStudent(789, "Twinkle Hipolito", 91, "twinkle@gmail.com"));
    hm.put(000, Student.createStudent(000, "Zero", 00, "zero0@gmail.com"));
  }
}
