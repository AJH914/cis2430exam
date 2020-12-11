import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScoreCalc {
    private ArrayList<String> filelines;
    private int easyConstant;
    private int heroicConstant;
    private int hardcoreConstant;
    private final int two = 2;
    private final int three = 3;
    private final int four = 4;
    private final int five = 5;
    private final int six = 6;

    /**
     * Default constructor for ScoreCalc class.
     */
    public ScoreCalc() {
        this.filelines = new ArrayList<String>();
    }

    /**
     * Parses file.
     * @param filename
     */
    public ScoreCalc(String filename) {
        try {
            File file = new File(filename);
            Scanner scan = new Scanner(file);
            this.filelines = new ArrayList<String>();
            while (scan.hasNextLine()) {
                this.filelines.add(scan.nextLine());
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    /**
     * Sets constants for each difficulty level.
     */
    public void setConstants() {
        String s = this.filelines.get(0);
        String[] temp = s.split(",");
        this.easyConstant = Integer.parseInt(temp[0]);
        this.heroicConstant = Integer.parseInt(temp[1]);
        this.hardcoreConstant = Integer.parseInt(temp[2]);
    }

    /**
     * Calculates player score with given ID.
     * @param playerID
     * @return Returns player score of given ID.
     */
    public double getScore(String playerID) {
        int index = this.getStringWithID(playerID);
        String s = this.filelines.get(index);
        String[] temp = s.split(",");
        int challengeScore = Integer.parseInt(temp[two]);
        double baseScore = Double.parseDouble(temp[three]);
        int coinsFound = Integer.parseInt(temp[four]);
        if (temp[1].equals("E")) {
            Easy e = new Easy(this.easyConstant, playerID);
            double score = e.calculateLeaderBoardScored(challengeScore, baseScore, coinsFound, Double.parseDouble(temp[five]),
                Integer.parseInt(temp[six]));
            return (score);
        } else if (temp[1].equals("H")) {
            Heroic h = new Heroic(this.heroicConstant, playerID);
            return (h.calculateLeaderBoardScored(challengeScore, baseScore, coinsFound, Double.parseDouble(temp[five]),
                    Integer.parseInt(temp[six])));
        } else {
            HardCore c = new HardCore(this.hardcoreConstant, playerID);
            return (c.calculateLeaderBoardScored(0, baseScore, coinsFound, Double.parseDouble(temp[five]), 0));
        }
    }

    /**
     * Outputs the leaderboard.
     * @return Returns leaderboard.
     */
    public String toString() {
        this.setConstants();
        StringBuilder printer = new StringBuilder();
        for (int i = 1; i < this.filelines.size(); i++) {
            
            printer.append(this.parseDifficulty(this.filelines.get(i).toString()));
        }
        return printer.toString();
    }

    /**
     * Parses to set difficulty level.
     * @param fileline
     * @return Returns difficulty level.
     */
    public Difficulty parseDifficulty(String fileline) {
        String[] temp = fileline.split(",");
        String playerID = temp[0];
        if (temp[1].equals("E")) {
            Easy e = new Easy(this.easyConstant, playerID);
            e.setLeaderBoardScore(getScore(playerID));
            return e;
        } else if (temp[1].equals("H")) {
            Heroic h = new Heroic(this.heroicConstant, playerID);
            h.setLeaderBoardScore(getScore(playerID));
            return h;
        } else {
            HardCore c = new HardCore(this.hardcoreConstant, playerID);
            c.setLeaderBoardScore(getScore(playerID));
            return c;
        }
    }

    private int getStringWithID(String playerID) {
        for (int i = 0; i < this.filelines.size(); i++) {
            if (this.filelines.get(i).contains(playerID)) {
                return i;
            }
        }
        return (-1);
    }

}
