import java.util.ArrayList;

public class ScheduleManagement {
    private class ScheduleCell {
        int startingHour;
        int endingHour;
        boolean occupied;
        ArrayList<String> acceptedEmissionTypes;

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
    }

    private ArrayList<ScheduleCell> schedule;

    public ScheduleManagement() {
        this.schedule = new ArrayList<ScheduleCell>();
        this.initialSchedule();
    }

    // public void launch() {
    //     this.initialSchedule();
    //     this.displaySchedule();
    // }

    private void initialSchedule() {
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

            schedule.add(sc);
        }
    }

    public void displaySchedule() {
        // for (int i = 0; i < 24; i++) {
        //     System.out.print("\nSchedule cell:  ");
        //     System.out.print(this.schedule.get(i).acceptedEmissionTypes);
        // }
    }
}
