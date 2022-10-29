import java.time.LocalDate;

public class Fiction extends Emission {
    private LocalDate creationDate;
    private String directorName;
    private boolean toBeRediffused;

    public Fiction(String name, int duration, LocalDate creationDate, String directorName, boolean toBeRediffused) {
        super(Utils.getFictionClassTag(), name, duration);
        this.creationDate = creationDate;
        this.directorName = directorName;
        this.toBeRediffused = toBeRediffused;
    }

    @Override
    public void calculateEndingHour(int startingHour) {
        super.setStartingHour(startingHour);
        int duration = super.getDuration();
        int endingHour = startingHour + duration;
        super.setEndingHour(endingHour);
    }
    
    // Getters ---------------------------------------
    public String getName() {
        return super.getName();
    }

    public int getDuration() {
        return super.getDuration();
    }

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
