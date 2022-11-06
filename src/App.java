import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_GREEN = "\u001B[32m";

        // Clear the console before displaying the program
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.print("---------Set your emission schedule-----------");

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
                    }
                    else if (typeChosen == 2) {
                        emission = new Reportage(name);
                    }
                    else {
                        emission = null;
                    }
                }

                if (emission != null) {
                    System.out.print("\nEnter the starting hour ");

                    if (emission.getType().equals(Utils.getEntertainmentClassTag())) {
                        System.out.println("Hours range 18h - 23h:  ");
                    }
                    else if (emission.getType().equals(Utils.getFictionClassTag())) {
                        System.out.println("Hours range 21h - 0h:  ");
                    }
                    else if (emission.getType().equals(Utils.getReportageTag())) {
                        System.out.println("Hours range 0h - 6h and 14h - 18h:  ");
                    }

                    System.out.print(">> ");

                    int startingHour = keyboard.nextInt();
                    emission.calculateEndingHour(startingHour);
                    todaySchedule.addEmission(emission);
                }
            }

            todaySchedule.displaySchedule();
            todaySchedule.displayScheduledEmissions();
            
        } while (addEmission);
    }
}
