public class Heroic extends Difficulty implements Challenged {
    private double difficultyConstant;
    private int numChallengesComplete;
    private double bonusScore;

    /**
     * Default constructor for Heroic class.
     */
    public Heroic() {
        super();
    }

    /**
     * Sets difficulty level to Heroic.
     * @param dc
     * @param playerID
     */
    public Heroic(double dc, String playerID) {
        super(playerID);
        this.setDifficultyConstant(dc);
    }

    @Override
    public void setNumChallengesComplete(int numChallenges) {
        this.numChallengesComplete = numChallenges;
    }

    @Override
    public int getNumChallengesComplete() {
        return this.numChallengesComplete;
    }

    @Override
    public double getBonusScore() {
        return this.bonusScore;
    }

    @Override
    public void setBonusScore(double score) {
        this.bonusScore = score;
    }

    @Override
    public String toString() {
        return super.getPlayerID() + "," + Double.toString(getLeaderBoardScore()) + "\n";
    }

    @Override
    public double calculateLeaderBoardScored(int challengeScore, double baseScore, int coinsFound,
            double timeTaken, int livesLost) {
        double t1 = baseScore + coinsFound;
        double t2 = timeTaken * this.difficultyConstant;
        double t3 = livesLost * this.difficultyConstant;
        double t4 = this.numChallengesComplete * this.difficultyConstant;
        double t5 = challengeScore * this.difficultyConstant;
        return (((t1) - (t2) - (t3)) + (t4) + (t5));
    }

    /**
     * Sets difficulty constant based on user input.
     * @param val
     */
    public void setDifficultyConstant(double val) {
        this.difficultyConstant = val;
    }
}
