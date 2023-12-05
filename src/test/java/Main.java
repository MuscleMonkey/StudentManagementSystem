/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author rcurzon
 */
public class Main{

  public static void main(String[] args) {
    StudentManagementSystem.testAddStudent();
    printMainMenu();
  }

  public static void printMainMenu() {
    StudentManagementSystem sms = new StudentManagementSystem();

    System.out.println("Student Management System");
    System.out.println("1. Add Student");
    System.out.println("2. Display All Students");
    System.out.println("3. Search for Student by ID");
    System.out.println("4. Update Student Information");
    System.out.println("5. Delete Student by ID");
    System.out.println("6. Exit");
    System.out.println("Selct an option: ");

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

  public static int validChoice(int max) {
    int choice = getValidInteger();
    while (choice <= 0 || choice > max) {
      System.out.print("please enter valid choice : ");
      choice = getValidInteger();
    }
    return choice;
  }

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

class Student {

  private int m_id;
  private String m_name;
  private double m_grade;
  private String m_email;

  public Student(int id, String name, double grade, String email) {
    this.m_id = id;
    this.m_name = name;
    this.m_grade = grade;
    this.m_email = email;
  }

  public int getId() {
    return this.m_id;
  }

  public void setId(int id) {
    this.m_id = id;
  }

  public void updateId() {
    System.out.println("Update ID");
    System.out.println("Enter id: ");

    int id = Main.getValidInteger();

    ArrayList<Student> students = new StudentManagementSystem().getStudents();

    for (Student currStudents : students) {
      if (currStudents.getId() == id) {
        System.out.println("Student " + id + " already exist.");
        return;
      }
    }

    setId(id);
    System.out.println("Id succesfully changed");
  }

  public String getName() {
    return m_name;
  }

  public void setName(String name) {
    this.m_name = name;
  }

  public void updateName() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Update Name");
    System.out.println("Enter name: ");
    String name = scanner.nextLine();

    setName(name);
  }

  public double getGrade() {
    return m_grade;
  }

  public void setGrade(double grade) {
    this.m_grade = grade;
  }

  public void updateGrade() {
    System.out.println("Update Grade");
    System.out.println("Enter Grade: ");
    double grade = Main.getValidDouble();

    setGrade(grade);
  }

  public String getEmail() {
    return m_email;
  }

  public void setEmail(String email) {
    this.m_email = email;
  }

  public void updateEmail() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Update Email");
    System.out.println("Enter Email: ");
    String email = scanner.next();
    setEmail(email);
  }

  @Override
  public String toString() {
    return "Student ID: "
        + this.getId()
        + "\nName: "
        + this.getName()
        + "\nGrade: "
        + this.m_grade
        + "\nEmail: "
        + this.m_email;
  }
}
class StudentManagementSystem {

  private static final ArrayList<Student> student = new ArrayList<>();

  public StudentManagementSystem() {}

  public ArrayList<Student> getStudents() {
    return student;
  }

  public void addStudent() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter Id: ");
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

