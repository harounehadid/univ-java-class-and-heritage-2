public abstract class Emission {
    private String id;
    private String type;
    private String name;
    private int duration;
    private int startingHour;
    private int endingHour;

    public Emission(String id, String type, String name, int duration) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.duration = duration;
    }

    // Made it abstract for the sake of the prerequisites
    public abstract void calculateEndingHour(int startingHour);

    // Getters ----------------------------------
    public String getId() {
        return this.id;
    }

    public String getType() {
        return this.type;
    }

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

    // Setters
    public void setStartingHour(int startingHour) {
        this.startingHour = startingHour;
    }

    public void setEndingHour(int endingHour) {
        this.endingHour = endingHour;
    }
}