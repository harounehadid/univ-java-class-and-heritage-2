public abstract class Emission {
    private String name;
    private int duration;
    private int startingHour;
    private int endingHour;

    public Emission(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    // Made it abstract for the sake of the prerequisites
    public abstract void calculateEndingHour(int startingHour);

    // Getters ----------------------------------
    public String getName() {
        return this.name;
    }

    public int getDuration() {
        return this.duration;
    }

    public int getStartingHour() {
        return this.startingHour;
    }

    public int getEndingHour() {
        return this.endingHour;
    }

    // Setters ----------------------------------
    public void setStartingHour(int startingHour) {
        this.startingHour = startingHour;
    }

    public void setEndingHour(int endingHour) {
        this.endingHour = endingHour;
    }
}