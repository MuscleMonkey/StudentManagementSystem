/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * @author rcurzon
 */
public class StudentManagementSystem {

    @JsonProperty("map")
    @JsonDeserialize(keyUsing = StudentDeserializer.class)
    private static Map<Integer, Student> hm = new HashMap<>();

    @JsonCreator
    public StudentManagementSystem(Map<Integer, Student> map) {
        hm = map;
    }

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static void addStudent() throws IOException {
        Scanner scanner = new Scanner(System.in);
        
        do {
            System.out.print("Enter Id: ");
            int id = setAvailableId();
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            System.out.print("Enter grade: ");
            int grade = Main.getValidInteger();
            System.out.print("Enter email: ");
            String email = scanner.nextLine();
            Student student = Student.createStudent(id, name, grade, email);

            hm.put(id, student);

            System.out.println("Student " + id + " added succesfully!");
            System.out.println("Enter any key to continue...");
        } while (enterAnyKeyToContinue());
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
            } else {
                System.out.println("Student not found!!");

            }
            System.out.println("Enter any key to continue...");
        } while (enterAnyKeyToContinue());

    }

    public static void updateStudentInformationById() {
        System.out.println("Enter to modify only one field to a student.");
        System.out.println("Enter any key to modify multiple field to a student.");

        do {
            System.out.println("Choice: ");

            if (enterAnyKeyToContinue()) {
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
        } while (enterAnyKeyToContinue());

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
            } else {
                System.out.println("Student not found!");
            }

            System.out.println("Enter any key to continue...");
        } while (enterAnyKeyToContinue());

    }

    public static void deleteStudentById() {

        do {
            System.out.print("Enter Student ID to delete: ");

            int id = Main.getValidInteger();

            if (hm.containsKey(id)) {
                hm.remove(id);
                System.out.printf("Student %d deleted succesfully!\n", id);
            } else {
                System.out.println("Student not found!");
            }

            System.out.println("Enter any key to continue...");
        } while (enterAnyKeyToContinue());

    }

    public static int setAvailableId() {
        int id;
        boolean flag;

        do {
            id = Main.getValidInteger();
            flag = false;

            if (hm.containsKey(id) == false) {
            } else {
                System.out.print("Enter a not owned ID: ");
                flag = true;
            }

        } while (flag);

        return id;
    }

    private static boolean enterAnyKeyToContinue() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return !input.equals("");
    }

    public static void serialize(String fileName) throws IOException {
        String serializeHm = OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(hm);
        Path file = Paths.get(fileName);
        byte[] strToBytes = serializeHm.getBytes();
        Files.write(file, strToBytes);
    
    }

    public static void deserialize(String fileTxt) throws FileNotFoundException, IOException {
        String content = Files.readString(Paths.get("student.txt"));
        ObjectMapper mapper = new ObjectMapper();
        StudentManagementSystem sms = mapper.readValue(content, StudentManagementSystem.class);
    }
}
