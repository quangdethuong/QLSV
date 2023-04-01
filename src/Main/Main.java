package Main;
import Student.Student;
import Menu.menu;
public class Main {
    public static void main(String[] args) {
        menu menu = new menu("Student Management System");
        menu.addNewOption("1. Add a Student profile");
        menu.addNewOption("2. Print all profile");
        menu.addNewOption("3. Quit");

        Student stu = new Student();

        int choice;
        do {
            menu.printMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    System.out.println("You are preparing to "
                            + "input a new Student profile");
                    stu.addNewStudent();
                    break;
                case 2:
                    System.out.println("You want to "
                            + "list all new students profile");
                    stu.printAll();

                    break;
                case 3:
                    System.out.println("Bye bye, see you next time!");
                    break;
            }
        } while (choice != 3);
    }
    }

