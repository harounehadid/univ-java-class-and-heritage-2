import java.time.LocalDate;

public class Fiction extends Emission {
    private LocalDate creationDate;
    private String directorName;
    private boolean toBeRediffused;

    public Fiction(String name, int duration, LocalDate creationDate, String directorName, boolean toBeRediffused) {
        super(Utils.generateId(), Utils.getFictionClassTag(), name, duration);
        this.creationDate = creationDate;
        this.directorName = directorName;
        this.toBeRediffused = toBeRediffused;
    }

    public Fiction(Fiction fiction) {
        super(Utils.generateId(), Utils.getFictionClassTag(), fiction.getName(), fiction.getDuration());
        this.creationDate = fiction.getCreationDate();
        this.directorName = fiction.getDirectorName();
        this.toBeRediffused = fiction.getToBeRediffused();
    }

    @Override
    public void calculateEndingHour(int startingHour) {
        int minHour = 21;
        int maxHour = 24;
        int duration = super.getDuration();
        boolean outOfRange = false;

        do {
            if (startingHour < minHour || startingHour >= maxHour) {
                System.out.print("\nWrong input! try again");
                System.out.print("\n>> ");
                startingHour = Utils.minMaxInt(minHour, maxHour);
            }

            if (startingHour + duration > maxHour) {
                System.out.print("\nThe emission can be placed in the schedule! try again");
                System.out.print("\n>> ");
                startingHour = -1;
                outOfRange = true;
            }
            else {
                outOfRange = false;
            }

        } while (outOfRange);


        super.setStartingHour(startingHour);
        int endingHour = startingHour + duration;
        super.setEndingHour(endingHour);
    }
    
    // Getters ---------------------------------------
    public LocalDate getCreationDate() {
        return this.creationDate;
    }

    public String getDirectorName() {
        return this.directorName;
    }

    public boolean getToBeRediffused() {
        return this.toBeRediffused;
    }
}
