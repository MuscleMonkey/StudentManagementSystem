/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author rcurzon
 */
   

public class StudentManagementSystem {

    private static final ArrayList<Student> student = new ArrayList<>(); ;

    public StudentManagementSystem() {}
    
    public ArrayList<Student> getStudents() {
        return student;
    }
    
    public void addStudent() {        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Id: ");
        String id = scanner.nextLine();
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter grade: ");
        double grade = Main.getValidDouble();
        System.out.println("Enter email: ");
        String email = scanner.next();

        Student currStudent = searchId(id);
        
        if (currStudent != null) {
            System.out.println("Student " + id + " already exist");
            return;  
        } 
        Student stdnt = new Student(id, name, grade, email);
        
        student.add(stdnt);
        System.out.println("Student " + id + " has been added.");
    }
    
    public static void testAddStudent() {
        student.add(new Student("123", "John Pega", 99, "johnpega@gmail.com"));
        student.add(new Student("456", "Nica Jerusalem", 99, "nica@gmail.com"));
        student.add(new Student("891", "Maui Sabayan", 99, "maui@gmail.com"));
        student.add(new Student("789", "Twinkle Hipolito", 99, "twinkle@gmail.com"));
    }
    
    public  void printAllStudents() {
        System.out.println("All Students:");
        if (student.isEmpty()) {
            System.out.println("List is Empty");
            return;
        }
        for (Student currentStudent: student) {
            System.out.printf("\n%s\n", currentStudent);
        }
        System.out.println();
    }

    public void searchStudentById() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Search Student");
        System.out.println("Enter Student Id to search: ");
        String id = scanner.nextLine();
        
        for (Student currentStudent: student) {
            if (currentStudent.getId().equals(id)) {
                System.out.println(currentStudent);
                return;
            }
        }
        System.out.println("student " + id + " not found.");
    }

    public  void updateStudentInformationById() {
        Scanner scanner = new Scanner(System.in);
        
        Student tempStudent = null;
        System.out.println("Update Student Information");
        System.out.println("Enter Student ID to update: ");
        
        String id = scanner.nextLine();
        
        for (Student currentStudent: student) {
            if (currentStudent.getId().equals(id)) {
                tempStudent = currentStudent;
                break;
            }
        }

        if (tempStudent == null) {
            System.out.println("no id " + id);
            return;
        }
        System.out.println("1. id");
        System.out.println("2. name");
        System.out.println("3. grade");
        System.out.println("4. email");
        System.out.println("Enter the number of your choice: ");
        
        int choice = Main.validChoice(5);
        
        if (choice == 1) {
            tempStudent.updateId();
        }
        
        else if (choice == 2)
            tempStudent.updateName();
        else if (choice == 3) {
            tempStudent.updateGrade();
        }
        else if (choice == 4) {
            tempStudent.updateEmail();
        }
        
        updateStudentInformationById();
    }
   
    public  void deleteStudentById() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Delete Student");
        String id = scanner.nextLine();
        
        for (int i = 0; i < student.size(); i++) {
            if (student.get(i).getId().equals(id)) {
                student.remove(i);
                return;
            }
        }
        System.out.println("no student has been removed");
    }
    
    public Student searchId(String id) {
        for (Student currentStudent: student) {
            if (currentStudent.getId().equals(id)) {
                return currentStudent;
            }
        }
        return null;
    }
}
