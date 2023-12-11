/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author
 */
public class StudentManagementSystem {
  // For automatic resizing of the list when the user tries to alter the size of it.
  private static final ArrayList<Student> student = new ArrayList<>();

  public void addStudent() {

    while (true) {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Enter -1 to exit!");
      System.out.print("Enter Id: ");
      int id = setAvailableId();

      if (id == -1) return;

      System.out.print("Enter name: ");
      String name = scanner.nextLine();

      System.out.print("Enter grade: ");
      double grade = Main.getValidDouble();

      System.out.print("Enter email: ");
      String email = scanner.next();
      // Provide the values user inputted to object creation
      Student stdnt = new Student(id, name, grade, email);
      // add the object to list
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
    // Use for-each loop to traverse and print the students inside our list
    for (Student currentStudent : student) {
      System.out.println(currentStudent);
    }
  }

  public void searchStudentById() {
    boolean found;

    while (true) {
      found = false;
      System.out.println("Enter -1 to exit!");
      System.out.print("Enter Student by ID: ");
      int id = Main.getValidInteger();

      if (id == -1) return;
      // traverse the list and display a success message if the current student ID is equal to what
      // the user
      // is searching else display a fail message.
      for (Student currentStudent : student) {
        if (currentStudent.getId() == id) {
          found = true;
          System.out.println("Student found: ");
          System.out.println(currentStudent);
          break;
        }
      }
      if (!found) System.out.printf("Student %d not found\n", id);
    }
  }

  public void updateStudentInformationById() {
    System.out.println("To update one field only from a student just enter -1.");
    System.out.print("Enter Student ID to update: ");
    int id = Main.getValidInteger();

    if (id == -1) {
      updateSingleStudentInformation();
    }
    // traverse the list and proceed to update the fields if the
    // student is found
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

  void updateSingleStudentInformation() {
    boolean isFound;
    Student tempStudent = null;

    while (true) {
      isFound = false;
      System.out.println("Enter -1 to Exit");
      System.out.print("Enter Student ID to update: ");
      int id = Main.getValidInteger();

      if (id == -1) return;
      // Search and copy the address of the student that the user is looking for.
      for (Student currStudent : student) {
        if (currStudent.getId() == id) {
          tempStudent = currStudent;
          isFound = true;
          break;
        }
      }
      // if the student is in the list, use this block
      if (isFound) {
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
        }
        System.out.println("Changes applied");
      }
      // if the specific student is not found, use this block
      if (!isFound) System.out.printf("Student %d not found!", id);
    }
  }

  public void deleteStudentById() {
    while (true) {
      System.out.println("You can enter -1 to exit");
      System.out.print("Enter Student ID to delete: ");
      int id = Main.getValidInteger();

      if (id == -1) return;
      // we used the Iterator object to loop through our students list and
      // remove the student if found
      for (Iterator<Student> iterator = student.iterator(); iterator.hasNext(); ) {
        Student currStudent = iterator.next();
        if (currStudent.getId() == id) {
          System.out.printf("Student %s has be removed.\n", currStudent.getName());
          iterator.remove();
          break;
        }
        // use this block if the students list is empty
        if (!iterator.hasNext() || student.isEmpty()) {
          System.out.println("No Student has been removed!");
        }
      }
    }
  }
  //Function to check or use only the unused ID
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
  // testing
  public static void testAddStudent() {
    student.add(new Student(123, "John Pega", 99, "johnpega@gmail.com"));
    student.add(new Student(456, "Nica Jerusalem", 99, "nica@gmail.com"));
    student.add(new Student(891, "Maui Sabayan", 99, "maui@gmail.com"));
    student.add(new Student(789, "Twinkle Hipolito", 99, "twinkle@gmail.com"));
  }
}
