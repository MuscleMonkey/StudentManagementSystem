/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import com.fasterxml.jackson.annotation.JsonKey;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Scanner;

/**
 * @author rcurzon
 */
public class Student {

    
    private String m_name;
    private double m_grade;
    private String m_email;
    
    @JsonKey
    private int m_id;
    
    private Student(int id, String name, double grade, String email) {
        this.m_id = id;
        this.m_name = name;
        this.m_grade = grade;
        this.m_email = email;
    }
    
    public Student(String student) {
        String[] details = student.split(" ");
        this.m_id = Integer.parseInt(details[0]);
        this.m_name = details[1].trim();
        this.m_grade = Double.parseDouble(details[2]);
        this.m_email = details[3].trim();
    }
    
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

        this.setName(name);

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
        this.setGrade(grade);
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
        this.setEmail(email);
    }

    public static Student createStudent(int id, String name, double grade, String email) {
        return new Student(id, name, grade, email);
    }

    @Override
    @JsonValue
    public String toString() {
        return this.m_id
                + " "
                + this.m_name
                + " "
                + this.m_grade
                + " "
                + this.m_email;
    }
}
