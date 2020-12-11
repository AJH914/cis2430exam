public abstract class Difficulty {
    private double leaderBoardScore;
    private String playerID;

    /**
     * Default constructor for Difficulty class.
     */
    public Difficulty() {
        this.leaderBoardScore = 0;
        this.playerID = null;
    }

    /**
     * Sets difficulty level based on user input.
     * @param id
     */
    public Difficulty(String id) {
        this.playerID = String.valueOf(id);
    }

    /**
     * Gets leaderboard scores for each player.
     * @return Returns leaderboard scores.
     */
    public double getLeaderBoardScore() {
        return this.leaderBoardScore;
    }

    /**
     * Converts leaderboard to string.
     * @return Returns string.
     */
    public abstract String toString();

    /**
     * Sets difficulty level for scoring purposes.
     * @param val
     */
    public abstract void setDifficultyConstant(double val);

    /**
     * Takes in scoring parameters and returns score for each ID.
     * @param baseScore
     * @param coinsFound
     * @param timeTaken
     * @param livesLost
     * @param challengeScore
     * @return Returns score.
     */
    public abstract double calculateLeaderBoardScored(int challengeScore, double baseScore, int coinsFound,
            double timeTaken, int livesLost);

    /**
     * Sets leaderboard scores for each individual player.
     * @param score
     */
    public void setLeaderBoardScore(double score) {
        this.leaderBoardScore = score;
    }

    /**
     * Gets given player ID.
     * @return Returns given player ID.
     */
    public String getPlayerID() {
        return this.playerID;
    }

    /**
     * Sets player ID based on given ID.
     * @param id
     */
    public void setPlayerID(String id) {
        this.playerID = String.valueOf(id);
    }
}
