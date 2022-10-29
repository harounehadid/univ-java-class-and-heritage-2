public class Entertainment extends Emission {
    private String animatorName;
    
    public Entertainment(String name, String animatorName) {
        super(Utils.getEntertainmentClassTag(), name, 2);
        this.animatorName = animatorName;
    }

    @Override
    public void calculateEndingHour(int startingHour) {
        super.setStartingHour(startingHour);
        int duration = super.getDuration();
        int endingHour = startingHour + duration;
        super.setEndingHour(endingHour);
    }

    // Getters
    public String getName() {
        return super.getName();
    }

    public int getDuration() {
        return super.getDuration();
    }

    public int getStartingHour() {
        return super.getStartingHour();
    }

    public int getEndingHour() {
        return super.getEndingHour();
    }

    public String getAnimatorName() {
        return this.animatorName;
    }
}
