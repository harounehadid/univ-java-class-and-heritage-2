public class Entertainment extends Emission {
    private String animatorName;
    
    public Entertainment(String name, String animatorName) {
        super(Utils.generateId(), Utils.getEntertainmentClassTag(), name, 2);
        this.animatorName = animatorName;
    }

    public Entertainment(Entertainment entertainment) {
        super(Utils.generateId(), Utils.getEntertainmentClassTag(), entertainment.getName(), 2);
        this.animatorName = entertainment.getAnimatorName();
    }

    @Override
    public void calculateEndingHour(int startingHour) {
        int minHour = 18;
        int maxHour = 23;
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

    // Getters
    public String getAnimatorName() {
        return this.animatorName;
    }
}
