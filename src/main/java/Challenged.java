interface Challenged {
    /**
     * Sets number of challenges completed for scoring.
     * @param numChallenges
     */
    void setNumChallengesComplete(int numChallenges);

    /**
     * Gets number of challenges completed for scoring.
     * @return Returns number of challenges completed.
     */
    int getNumChallengesComplete();

    /**
     * Gets bonus score for additional points.
     * @return Returns double of points scored.
     */
    double getBonusScore();

    /**
     * Sets amount of point scored in bonus challenges.
     * @param bonusScore
     */
    void setBonusScore(double bonusScore);
}
