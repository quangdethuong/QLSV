package Lib;

import java.util.Scanner;

/**
 *
 * @author giao-lang | fb/giao.lang.bis | fb/bmag.vn
 * version 18.03
 */
//class chứa các hàm đồ chơi, dùng cho việc nhập xuất dữ liệu
public class MyToys {

    private static Scanner sc = new Scanner(System.in);


    public static int getAnInteger(String inputMsg, String errorMsg, int lowerBound, int upperBound) {
        int n, tmp;
        //nếu đầu vào lower > upper thì đổi chỗ
        if (lowerBound > upperBound) {
            tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                if (n < lowerBound || n > upperBound)
                    throw new Exception();
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }



    
    public static double getADouble(String inputMsg, String errorMsg, double lowerBound, double upperBound) {
        double n, tmp;

        if (lowerBound > upperBound) {
            tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Double.parseDouble(sc.nextLine());
                if (n < lowerBound || n > upperBound)
                    throw new Exception();                
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }
        
    //nhập vào một chuỗi kí tự, theo định dạng đc đưa vào
    //định dạng xài Regular Expression
    public static String getID(String inputMsg, String errorMsg, String format) {
        String id;
        boolean match;
        while (true) {
            System.out.print(inputMsg);
            id = sc.nextLine().trim().toUpperCase();
            match = id.matches(format);
            if (id.length() == 0 || id.isEmpty() || match == false)
                System.out.println(errorMsg);
            else
                return id;            
        }
    }
    
    //nhập vào một chuỗi kí tự, khác rỗng
    public static String getString(String inputMsg, String errorMsg) {
        String id;        
        while (true) {
            System.out.print(inputMsg);
            id = sc.nextLine().trim();            
            if (id.length() == 0 || id.isEmpty())
                System.out.println(errorMsg);
            else 
                return id;
        }
    }
    

//    public static void main(String[] args) {
//        String id = getID("Input ID(CEXXXXXX): ", "Your input must be under "
//                + "the format of CEXXXXXX, X stands for a digit",
//                "^[Cc][Ee]\\d{6}$");
//        System.out.println("Your ID: " + id);
//    }
}