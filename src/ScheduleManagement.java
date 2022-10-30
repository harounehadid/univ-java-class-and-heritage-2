import java.util.ArrayList;

public class ScheduleManagement {
    private class ScheduleCell {
        int startingHour;
        int endingHour;
        boolean occupied;
        ArrayList<String> acceptedEmissionTypes;
        Emission emission = null;

        public ScheduleCell(int startingHour, int endingHour) {
            this.startingHour = startingHour;
            this.endingHour = endingHour;
            this.occupied = false;
            this.acceptedEmissionTypes = new ArrayList<String>();
        }

        public void addEmissionType(String emissionType) {
            // This condition is to avoid adding the same type twice
            if (this.acceptedEmissionTypes.indexOf(emissionType) == -1) {
                this.acceptedEmissionTypes.add(emissionType);
            }
        }

        // Setters --------------------------------
        public void setEmission(Emission emission) {
            this.emission = emission;
        }
    }

    private ArrayList<ScheduleCell> schedule;
    // This is in case there is no time to fit certain emissions
    private ArrayList<Emission> nextDayEmissions;
    // Colors for console print
    final String ANSI_RESET = "\u001B[0m";
    final String ANSI_RED = "\u001B[31m";

    public ScheduleManagement() {
        this.schedule = new ArrayList<ScheduleCell>();
        nextDayEmissions = new ArrayList<Emission>();
        this.initiateSchedule();
    }

    // public void launch() {
    //     this.initialSchedule();
    //     this.displaySchedule();
    // }

    private void initiateSchedule() {
        // Initialize the schedule hour by hour
        for (int i = 0; i < 24; i++) {
            ScheduleCell sc = new ScheduleCell(i, i + 1);

            if (i >= 0 && i < 6) {
                sc.addEmissionType(Utils.getReportageTag());
            }
            else if (i >= 6 && i < 14) {
                sc.addEmissionType(Utils.getOtherTag());
            }
            else if (i >= 14 && i < 18) {
                sc.addEmissionType(Utils.getReportageTag());
            }
            else {
                if (i >= 18 && i < 23) sc.addEmissionType(Utils.getEntertainmentClassTag());
                if (i >= 21) sc.addEmissionType(Utils.getFictionClassTag());
            }

            this.schedule.add(sc);
        }
    }

    public void addEmission(Emission newEmission) {
        int freeSlotStart = -1;
        int freeSlotEnd = -1;
        boolean freeSlotFound = false;

        for (int i = 0; i < schedule.size(); i++) {
            ScheduleCell curCell = this.schedule.get(i);
            String emissionType = newEmission.getType();

            for (int j = 0; j < curCell.acceptedEmissionTypes.size(); j++) {
                if (curCell.acceptedEmissionTypes.get(j).equals(emissionType) && !curCell.occupied) {
                    if (freeSlotStart == -1) freeSlotStart = i;

                    curCell.occupied = true;
                    freeSlotEnd = i;

                    if (freeSlotEnd - freeSlotStart + 1 == newEmission.getDuration()) {
                        freeSlotFound = true;
                        break;
                    }
                }
            }

            if (freeSlotFound) break;
        }

        System.out.println("\nstart:  " + freeSlotStart + "  end:  " + freeSlotEnd);

        if (freeSlotFound) {
            newEmission.setStartingHour(freeSlotStart);
            newEmission.setEndingHour(freeSlotEnd + 1);

            for (int i = newEmission.getStartingHour(); i < newEmission.getEndingHour(); i++) {
                System.out.println("\nstart:  " + freeSlotStart + "  end:  " + freeSlotEnd);
                schedule.get(i).setEmission(newEmission);
            }
        }
        else {
            System.out.println(ANSI_RED + "\nThere is a time conflict!" + ANSI_RESET);
        }
    }

    public void displaySchedule() {
        int len = schedule.size();
        int jumpingIndex = 0;
        ScheduleCell curCell;
        String output;

        for (int i = 0; i < len; i++) {
            jumpingIndex += len / 3;

            for (int j = i; j < jumpingIndex; j++) {
                curCell = schedule.get(j);
                output = Integer.toString(curCell.startingHour) + ":00-" + Integer.toString(curCell.endingHour) + ":00";
                System.out.printf("%-15s", output);
            }

            System.out.printf("\n");

            for (int j = i; j < jumpingIndex; j++) {
                curCell = this.schedule.get(j);
    
                if (curCell.emission != null) output = curCell.emission.getName();
                else output = "none";
    
                System.out.printf("%-15s", output);
            }

            System.out.printf("\n\n");

            i = jumpingIndex - 1;
        }
    }
}
