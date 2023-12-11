/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.mavenproject1;

import java.util.Scanner;

/**
 * @author
 */
public class Main {
  public Main() {
    StudentManagementSystem.testAddStudent();
    printMainMenu();
  }

  public static void main(String[] args) {
    Main main = new Main();
  }
  // Main
  public static void printMainMenu() {
    StudentManagementSystem sms = new StudentManagementSystem();

    System.out.println("Student Management System");
    System.out.println("1. Add Student");
    System.out.println("2. Display All Students");
    System.out.println("3. Search for Student by ID");
    System.out.println("4. Update Student Information");
    System.out.println("5. Delete Student by ID");
    System.out.println("6. Exit");
    System.out.print("Selct an option: ");

    int choice = validChoice(6);

    switch (choice) {
      case 1:
        sms.addStudent();
        break;
      case 2:
        sms.printAllStudents();
        break;
      case 3:
        sms.searchStudentById();
        break;
      case 4:
        sms.updateStudentInformationById();
        break;
      case 5:
        sms.deleteStudentById();
        break;
      case 6:
        System.out.println("Exiting the program. Goodbye!");
        return;
      default:
        break;
    }
    printMainMenu();
  }
  // A function to prevent user from inputing invalid choice
  public static int validChoice(int max) {
    int choice = getValidInteger();
    while (choice <= 0 || choice > max) {
      System.out.print("please enter valid choice : ");
      choice = getValidInteger();
    }
    return choice;
  }
  // A function to prevent user from inputing invalid integer type value
  public static int getValidInteger() {
    int input = 0;
    boolean flag;
    do {
      try {
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextInt();
        flag = false;
      } catch (Exception e) {
        System.out.print("please enter valid number : ");
        flag = true;
      }
    } while (flag);
    return input;
  }
  // A function to prevent user to input invalid double type value
  public static double getValidDouble() {
    double input = 0;
    boolean flag;
    do {
      try {
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextDouble();
        flag = false;
      } catch (Exception e) {
        System.out.print("please enter valid number : ");
        flag = true;
      }
    } while (flag);
    return input;
  }
}
