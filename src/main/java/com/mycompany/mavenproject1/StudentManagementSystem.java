/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
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

            hm.put(id, Student.createStudent(id, name, grade, email));

            System.out.println("Student " + id + " added succesfully!");
            System.out.println("Enter any key to continue...");
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
            System.out.println("Enter any key to continue...");
        } while (enterToContinue());
    }

    public static void updateStudentInformationById() {
        System.out.println("Enter to modify only one field to a student.");
        System.out.println("Enter any key to modify multiple field to a student.");
        do {
            System.out.println("Choice: ");
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
            System.out.println("Enter any key to continue...");
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
            System.out.println("Enter any key to continue...");
        } while (enterToContinue());
    }

    public static void deleteStudentById() {

        do {

            System.out.print("Enter Student ID to delete: ");

            int id = Main.getValidInteger();

            if (hm.containsKey(id)) {
                hm.remove(id);

                System.out.printf("Student %d deleted succesfully!\n", id);
            } else System.out.println("Student not found!");
            System.out.println("Enter any key to continue...");
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
        
        String input = scanner.nextLine();

        return !input.equals("");
    }

    public static void saveChangesToText(String fileName) {
        System.out.println("Enter any key to save changes: ");
        if (!enterToContinue()) return;

        // open file then write to file
        File file;
        FileWriter writer;
        try {
            file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            writer = new FileWriter(file);
            String details = "";
            for (int key : hm.keySet()) {
                Student student = hm.get(key);
                int id = student.getId();
                double grade = student.getGrade();
                String name = student.getName(), email = student.getEmail();
                details += String.join("-", String.valueOf(id), name, String.valueOf(grade), email);
                writer.write(details);
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occured.");
            System.out.println(e.getMessage());
        }
    }

    public static void populate(String fileTxt) {
        File file;
        Scanner reader;

        try {
            file = new File(fileTxt);
            if (!file.exists()) return;
            reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String[] studentDetails = reader.nextLine().split("-");
                System.out.println(Arrays.toString(studentDetails));
                int id = Integer.parseInt(studentDetails[0]);
                double grade = Double.parseDouble(studentDetails[2]);
                String name = studentDetails[1], email = studentDetails[3];
                hm.put(id, Student.createStudent(id, name, grade, email));
            }
            reader.close();
        } catch (FileNotFoundException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        
    }

    public static long getListCount() {
        return hm.keySet().stream().count();
    }

    public static void displayListKeys() {
        hm.keySet().forEach(key -> System.out.println(key));
    }
}
