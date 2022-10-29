import java.time.LocalDate;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_GREEN = "\u001B[32m";


        System.out.println("---------Set your emission schedule-----------");

        ScheduleManagement todaySchedule = new ScheduleManagement();
        
        Scanner keyboard = new Scanner(System.in);
        boolean addEmission = false;
        String yesAndNoAnwser[] = {"y", "n"};

        do {
            System.out.println("\n\n" + ANSI_GREEN + ">>>>>>>>>>>>>>>>>>>>>>>>>>>" + ANSI_RESET);
            System.out.println("Do you want to add an emission?");
            System.out.print("Y (yes) | N (no):  ");
            String addAnswer = Utils.inputAndValidateString(yesAndNoAnwser);
            addEmission = addAnswer.equals("y");
            System.out.println("\n");

            if (addEmission) {
                System.out.println("Choose the type of emission:  ");
                System.out.print("0 > " + Utils.getEntertainmentClassTag() + "   ");
                System.out.print("1 > " + Utils.getFictionClassTag() + "   ");
                System.out.print("2 > " + Utils.getReportageTag());
                System.out.print("\n>> ");

                int typeChosen = Utils.minMaxInt(0, 3);
                System.out.println("\n");

                Emission emission;
                
                System.out.print("\nEnter emission Name:  ");
                String name = keyboard.next();

                if (typeChosen == 0) {
                    System.out.print("\nEnter animator name:  ");
                    String animatorName = keyboard.next();
                    emission = new Entertainment(name, animatorName);
                    // Add emission to schedule
                }
                else {
                    System.out.print("\nEnter the duration:  ");
                    int duration;

                    if (typeChosen == 1) {
                        // Max value is excluded
                        duration = Utils.minMaxInt(1, 4);

                        System.out.print("\nEnter creation date:  ");
                        LocalDate date = Utils.inputAndValidateDate();

                        System.out.print("\nEnter director name:  ");
                        String directorName = keyboard.next();

                        System.out.println("\nDo you want to rediffuse the emission?");
                        System.out.print("Y (yes) | N (no):  ");
                        String rediffuse = Utils.inputAndValidateString(yesAndNoAnwser);

                        emission = new Fiction(name, duration, date, directorName, rediffuse.equals("y"));
                        
                        // Add emission to schedule
                    }
                    else if (typeChosen == 2) {
                        // Max value is excluded
                        duration = Utils.minMaxInt(1, 7);
                        emission = new Reportage(name, duration);

                        // Add emission to schedule
                    }
                }
            }
            
        } while (addEmission);
    }
}
