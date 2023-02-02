import java.util.InputMismatchException;
import java.util.Scanner;

public class Entrys {
    public static String stringEntry(String msg) {
        Scanner scString = new Scanner(System.in);
        Boolean correct = false;
        String rsps = null;

        while(!correct) {
            try {
                System.out.println(msg + "\n");
                rsps = scString.nextLine();
                if (rsps.matches(".*\\d.*")){
                    throw new WrongInputException();
                } else {
                    correct = true;
                }

            } catch (WrongInputException e){
                System.out.println("Incorrect Value, you must enter a String without any digit");
            }
        }
        scString.reset();
        return rsps;
    }

    public static int intEntry(String msg){
        Scanner sc = new Scanner(System.in);
        boolean correct = false;
        int value = 0;
        while (!correct) {
            try {
                System.out.println(msg + "\n");
                value = sc.nextInt();
                correct = true;
            } catch (InputMismatchException e) {
                System.out.println("\n Incorrect Value, you must enter an Integer \n");
            }
        }
        return value;
    }
}
