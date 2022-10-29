public class Reportage extends Emission {
    private String theme;

    public Reportage(String name, int duration) {
        super(name, duration);
        this.setTheme();
    }

    @Override
    public void calculateEndingHour(int startingHour) {
        super.setStartingHour(startingHour);
        int duration = super.getDuration();
        int endingHour = startingHour + duration;
        super.setEndingHour(endingHour);
    }
    
    // Getters --------------------------------------
    public String getName() {
        return super.getName();
    }

    public int getDuration() {
        return super.getDuration();
    }

    public String getTheme() {
        return this.theme;
    }

    // Setters ---------------------------------------
    private void setTheme() {
        String themes[] = {"Informative", "Animals", "Cultural"};

        System.out.println("Choose reportage's theme:  ");
        for (int i = 0; i < themes.length; i++) System.out.println("  " + i + " for " + themes[i]);
        int input = Utils.minMaxInt(0, themes.length);
        this.theme = themes[input];
    }
}
