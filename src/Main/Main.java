package Main;
import Student.Student;
import Menu.menu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        menu menu = new menu("Student Management System");
        menu.addNewOption("1. Add a Student profile");
        menu.addNewOption("2. Print all profile");
        menu.addNewOption("3. Print all Student Sort by AVG score (Descending)");
        menu.addNewOption("4. Print all Student Sort by name");
        menu.addNewOption("5. Quit");

        Student stu = new Student();

        int choice;
        do {
            menu.printMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    System.out.println("You are preparing to "
                            + "input a new Student profile");
                    System.out.print("Enter number of Student you want to add: ");
                    int number = Integer.parseInt(sc.nextLine());
                    for (int i = 1; i <= number; i++) {
                        System.out.println("Student: " + i);
                        stu.addNewStudent();

                    }

                    break;
                case 2:
                    System.out.println("You want to "
                            + "list all new students profile");
                    stu.printAll();

                    break;
                case 3:
                    System.out.println("You want to "
                            + "sort all new students by AVG");
                    stu.printAllSortDesAvg();

                    break;

                case 4:
                    System.out.println("You want to "
                            + "sort all new students by Name");
                    stu.printAllSortAscByname();

                    break;
                case 5:
                    System.out.println("Bye bye, see you next time!");
                    break;
            }
        } while (choice != 5);
    }
    }

