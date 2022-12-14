import java.util.Scanner;

public class Reportage extends Emission {
    private String theme;

    public Reportage(String name) {
        super(Utils.generateId(), Utils.getReportageTag(), name, 1);
        this.setTheme();
    }

    public Reportage(Reportage reportage) {
        super(Utils.generateId(), Utils.getReportageTag(), reportage.getName(), 1);
        this.theme = reportage.getTheme();
    }

    @Override
    public void calculateEndingHour(int startingHour) {
        Scanner keyboard = new Scanner(System.in);
        int minHour1 = 0;
        int maxHour1 = 6;
        int minHour2 = 14;
        int maxHour2 = 18;
        int duration = super.getDuration();
        boolean outOfRange = false;
        boolean firstCondition = startingHour >= minHour1 && startingHour < maxHour1;
        boolean secondCondition = startingHour >= minHour2 && startingHour < maxHour2;
        boolean firstRange = true;

        do {
            if (firstCondition || secondCondition) {
                outOfRange = false;
            }
            else {
                outOfRange = true;
                startingHour = keyboard.nextInt();
            }

            if (startingHour < maxHour1 && outOfRange) {
                firstRange = true;
                System.out.print("\nWrong input! try again");
                System.out.print("\n>> ");
                startingHour = Utils.minMaxInt(minHour1, maxHour1);
            }
            else if (startingHour > maxHour1 && outOfRange) {
                firstRange = false;
                System.out.print("\nWrong input! try again");
                System.out.print("\n>> ");
                startingHour = Utils.minMaxInt(minHour2, maxHour2);
            }

            

            // if (firstRange) {
            //     if (startingHour + duration > 14) {
            //         System.out.print("\nThe emission can be placed in the schedule! try again");
            //         System.out.print("\n>> ");
            //         startingHour = -1;
            //         outOfRange = true;
            //     }
            //     else {
            //         outOfRange = false;
            //     }
            // }
            // else {
            //     if (startingHour + duration > 18) {
            //         System.out.print("\nThe emission can be placed in the schedule! try again");
            //         System.out.print("\n>> ");
            //         startingHour = -1;
            //         outOfRange = true;
            //     }
            //     else {
            //         outOfRange = false;
            //     }
            // }

        } while (outOfRange);


        super.setStartingHour(startingHour);
        int endingHour = startingHour + duration;
        super.setEndingHour(endingHour);
    }
    
    // Getters --------------------------------------
    public String getTheme() {
        return this.theme;
    }

    // Setters ---------------------------------------
    private void setTheme() {
        String themes[] = {"Informative", "Animals", "Cultural"};

        System.out.println("\nChoose reportage's theme:  ");
        for (int i = 0; i < themes.length; i++) System.out.println("  " + i + " for " + themes[i]);
        System.out.print(">> ");
        int input = Utils.minMaxInt(0, themes.length);
        this.theme = themes[input];
    }
}
