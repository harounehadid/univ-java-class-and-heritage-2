import java.util.ArrayList;

public final class ScheduleManagement {
    private class ScheduleCell {
        int startingHour;
        int endingHour;
        boolean occupied;
        String acceptedEmissionTypes[];

        public ScheduleCell(int startingHour, int endingHour, String acceptedEmissionTypes[]) {
            this.startingHour = startingHour;
            this.endingHour = endingHour;
            this.occupied = false;
            this.acceptedEmissionTypes = acceptedEmissionTypes;
        }
    }

    private ArrayList<ScheduleCell> schedule;

    public void launch() {
        this.schedule = new ArrayList<ScheduleCell>();

        initialScheduleSet();
    }

    private void initialScheduleSet() {
        String emissionTypes[] = {"entertainment", "fiction", "reportage"};
    }
}
