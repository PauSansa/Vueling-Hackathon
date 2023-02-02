import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
                if (rsps.matches(".*\\d.*") || rsps.isEmpty()){
                    throw new WrongInputException();
                } else {
                    correct = true;
                }

            } catch (WrongInputException e){
                System.out.println("Incorrect Value, you must enter a String without any digit \n");
            }
        }
        scString.reset();
        return rsps;
    }

    public static int scoreEntry(String msg){
        Scanner sc = new Scanner(System.in);
        boolean correct = false;
        int value = 0;
        while (!correct) {
            try {
                System.out.println(msg + "\n");
                value = sc.nextInt();
                if(0 > value || value > 5) {
                    throw new WrongInputException();
                }
                correct = true;
            } catch (InputMismatchException e) {
                System.out.println("Incorrect Value, you must enter an Integer \n");
            } catch (WrongInputException e) {
                System.out.println("Incorrect Value, you must enter a numbres between 0 and 5 \n");
            }
        }
        return value;
    }

    public static String stringEntryNotStrict(String msg) {
        Scanner scStringNotStrict = new Scanner(System.in);

        System.out.println(msg + "\n");
        String rsps = scStringNotStrict.nextLine();
        scStringNotStrict.reset();
        return rsps;
    }

    public static String hourEntry(String msg) {
        Scanner scHour = new Scanner(System.in);
        boolean correct = false;
        String convertedDate = null;

        System.out.println(msg + "\n");

        while (!correct){
            try {
                String dateraw = scHour.nextLine();
                SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
                Date date = formatter.parse(dateraw);
                convertedDate = formatter.format(date);
                correct = true;
            } catch (ParseException e){
                System.out.println("You must enter a hour using the format hh:mm \n");
            }
        }

        return convertedDate;
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
                System.out.println("Incorrect Value, you must enter an Integer \n");
            }
        }
        return value;
    }
}
