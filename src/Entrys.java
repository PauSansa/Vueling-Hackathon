import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

//Class of Static Methods to agilize the inputs
public class Entrys {
    private static Scanner sc = new Scanner(System.in);


    //Asks for a String without any digit
    public static String stringEntry(String msg) {
        Boolean correct = false;
        String rsps = null;

        while(!correct) {
            try {
                System.out.println(msg + "\n");
                rsps = sc.nextLine();
                if (rsps.matches(".*\\d.*") || rsps.isEmpty()){
                    throw new WrongInputException();
                } else {
                    correct = true;
                }

            } catch (WrongInputException e){
                System.out.println("Incorrect Value, you must enter a String without any digit \n");
            }
        }
        sc.reset();
        return rsps;
    }

    //Asks for a score (the value must be 0 < v < 5)
    public static int scoreEntry(String msg){
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
        sc.reset();
        return value;
    }

    //Asks for a String, it can contain digits
    public static String stringEntryNotStrict(String msg) {

        System.out.println(msg + "\n");
        String rsps = sc.nextLine();
        sc.reset();
        return rsps;
    }

    //Asks for an hour (it only accepts HH:mm format)
    public static String hourEntry(String msg) {
        boolean correct = false;
        String convertedDate = null;

        System.out.println(msg + "\n");

        while (!correct){
            try {
                String dateraw = sc.nextLine();
                SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
                Date date = formatter.parse(dateraw);
                convertedDate = formatter.format(date);
                correct = true;
            } catch (ParseException e){
                System.out.println("You must enter a hour using the format hh:mm \n");
            }
        }
        sc.reset();
        return convertedDate;
    }

    //Asks for a integer
    public static int intEntry(String msg){
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
        sc.reset();
        return value;
    }
}
