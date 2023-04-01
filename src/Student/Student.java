package Student;

import Lib.MyToys;

import java.util.ArrayList;


public class Student {
    private String id;
    private String name;
    private int yob;

    private double gradeToan;

    private double gradeLy;

    private double gradeHoa;



    private ArrayList<Student> stuList = new ArrayList();


    public Student() {
    }

    public Student(String id, String name, int yob, double gradeToan, double gradeLy, double gradeHoa) {
        this.id = id;
        this.name = name;
        this.yob = yob;
        this.gradeToan = gradeToan;
        this.gradeLy = gradeLy;
        this.gradeHoa = gradeHoa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYob() {
        return yob;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }

    public double getGradeToan() {
        return gradeToan;
    }

    public void setGradeToan(double gradeToan) {
        this.gradeToan = gradeToan;
    }

    public double getGradeLy() {
        return gradeLy;
    }

    public void setGradeLy(double gradeLy) {
        this.gradeLy = gradeLy;
    }

    public double getGradeHoa() {
        return gradeHoa;
    }

    private double sumAverage() {
        return (gradeToan + gradeLy + gradeHoa ) / 3;
    }

    public String gradeletter() {
        double sum = sumAverage();
        if (sum >= 8.0) {
            return "Excellent";
        } else if (sum >= 6.5) {
            return "Good";
        } else if (sum >= 5.0) {
            return "Medium";
        } else {
            return "Fail";
        }
    }

    public int searchStudentByID(String stuID) {
        if (stuList.isEmpty())
            return -1;

        for (int i = 0; i < stuList.size(); i++)
            if (stuList.get(i).getId().equalsIgnoreCase(stuID))
                return i;

        return -1;
    }


    public void addNewStudent() {
        String id, name;
        int yob;
        double gradeToan;
        double gradeLy;
        double gradeHoa;
        int pos;

        do {

            id = MyToys.getID("Input student id(CXXXXX): ",
                    "The format of id is CEXXXXXXX (X stands for a digit)", "^[Cc][Ee]\\d{6}$");
            pos = searchStudentByID(id);
            if (pos >= 0)
                System.out.println("The Student id already exists. "
                        + "Input another one!");
        } while (pos != -1);

        name = MyToys.getString("Enter Student Name: ", "Enter again");
        yob = MyToys.getAnInteger("Entrer YOB: ", "Wrong YOB from 1999-2013. Input Agian", 1999 ,2013);
        gradeToan = MyToys.getADouble("Enter Math score: ", "Agian score 1-10",1,10);
        gradeLy = MyToys.getADouble("Enter Physic score: ", "Agian score 1-10",1,10);
        gradeHoa = MyToys.getADouble("Enter Chemis score: ", "Agian score 1-10",1,10);
        stuList.add(new Student(id, name, yob, gradeToan, gradeLy, gradeHoa));
    }

    public void printAll() {
        if (stuList.isEmpty()){
            System.out.println("List of Student is empty => nothing to show!!");
            return;
        }
        System.out.println("------------------------------------");
        System.out.println("Here is the Students list");
        String header = String.format("|%-10s|%-15s|%8s|%8s|%8s|%8s|%8s|%10s|", "ID", "Name", "YOB", "Math", "Physic", "Chemis", "AVG", "GRADE");
        System.out.println(header);
        for (int i = 0; i < stuList.size(); i++){
            stuList.get(i).showProfile();
        }

    }


    public void showProfile() {
        String msg;
        msg = String.format("|%-10s|%-15s|%8d|%8.1f|%8.1f|%8.1f|%8.1f|%10s|", id, name, yob, gradeToan, gradeLy,gradeHoa, sumAverage(), gradeletter());
        System.out.println(msg);
    }
}
