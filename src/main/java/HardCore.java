public class HardCore extends Difficulty {
    private double difficultyConstant;
    private double timeBeforeDeath;

    /**
     * Default constructor for HardCore class.
     */
    public HardCore() {
        super();
        this.timeBeforeDeath = 0.0;
    }

    /**
     * Sets difficulty level to hardcore.
     * @param dc
     * @param playerID
     */
    public HardCore(double dc, String playerID) {
        super(playerID);
        this.setDifficultyConstant(dc);
    }

    /**
     * Gets time before death.
     * @return Returns time before death.
     */
    public double getTimeBeforeDeath() {
        return this.timeBeforeDeath;
    }

    /**
     * Sets time before death.
     * @param gameMinutes
     */
    public void setTimeBeforeDeath(double gameMinutes) {
        this.timeBeforeDeath = gameMinutes;
    }

    @Override
    public String toString() {
        return super.getPlayerID() + "," + Double.toString(getLeaderBoardScore()) + "\n";
    }

    @Override
    public double calculateLeaderBoardScored(int challengeScore, double baseScore, int coinsFound,
            double timeTaken, int livesLost) {
        return ((baseScore + coinsFound) - (timeTaken * this.difficultyConstant));
    }

    /**
     * Sets difficulty constant based on user input.
     * @param val
     */
    public void setDifficultyConstant(double val) {
        this.difficultyConstant = val;
    }
}
