import java.time.LocalDate;
import java.util.Scanner;

public final class Utils {
    static Scanner keyboard = new Scanner(System.in);

    // Input validation functions
    public static int totallyPositiveInt() {
        int input;

        do {
            input = keyboard.nextInt();

            if (input < 0) System.out.println("Invalid input! Try again: ");

        } while(input < 0);

        return input;
    }

    public static LocalDate inputAndValidateDate() {
        LocalDate date = LocalDate.now();
        boolean dateIsCorrect = true;
        int year;
        int month;
        int day;

        do {
            try {
                System.out.print("Enter the date: ");
                System.out.print("Year - ");
                year = keyboard.nextInt();
                System.out.print("Month - ");
                month = keyboard.nextInt();
                System.out.print("Day - ");
                day = keyboard.nextInt();

                date = LocalDate.of(year, month, day);
                dateIsCorrect = true;
            } catch (Exception e) {
                System.out.println("Wrong date! try again: ");
                dateIsCorrect = false;
            }

        } while (!dateIsCorrect);


        return date;
    }

    public static int minMaxInt(int minInput, int maxInput) {
        int input;

        do {
            input = keyboard.nextInt();

            if (input < minInput || input >= maxInput) {
                System.out.print("Input should be >= " + minInput + " and < " + maxInput + " try again!  ");
            }

        } while (input < minInput || input >= maxInput);

        return input;
    }
}
