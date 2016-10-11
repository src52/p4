package test;

import java.util.Arrays;

/**
 * The Pokemon class is a class that initializes a Pokemon object, which consists of a name and a number.
 *
 * @author Spencer Carlson
 *
 */

public class Pokemon {

    /*
     * Instance variables
     */
    private String name;
    private int nationalNum;
    private int gamesPlayed;
    private double gameAverage;
    private int[] scores;
    private String[] winningScore;
    private static int n;

    /**
     * Initializes a blank Pokemon object. This is a no-argument constructor, so it sets default values.
     */
    public Pokemon() {
        name = "Default";
        nationalNum = 0;
    }


    /**
     * Initializes a complete Pokemon object. This is a full-argument constructor.
     * It passes all the required parameters to fully define a Pokemon object.
     *
     * @param name The name of the pokemon
     * @param nationalNum The national number of the pokemon
     */
    public Pokemon(String name, int nationalNum, int scores[]) {
        this.name = name;
        this.nationalNum = nationalNum;
        this.scores = scores;
    }

    public double calculateAverage() {
        int sum = 0;
        for (int a = 0; a < scores.length; a++) sum = sum + scores[a];
        double average = sum / scores.length;
        return average;
    }

    public String[] getWinningScore() {
        return winningScore;
    }

    public void setWinningScore(String[] winningScore) {
        this.winningScore = winningScore;
    }

    public static int getN() {
        return n;
    }

    public static void setN(int n) {
        Pokemon.n = n;
    }

    /**
     * The toString() method prints out all available information about the constructor
     */
    @Override
    public String toString() {
        return "Pokemon{" +
                "\nname='" + name + '\'' +
                ", \nnationalNum=" + nationalNum +

                ", \ngamesPlayed=" + gamesPlayed +
                ", \ngameAverage=" + gameAverage +
                ", \nscores=" + Arrays.toString(scores) +
                ", \nwinningScores" + Arrays.toString(winningScore) +
                ", \nhash=" + name.hashCode() +
                '}';
    }

    public Pokemon(String name, int nationalNum) {
        this.name = name;
        this.nationalNum = nationalNum;
    }

    /**
     * Getters and setters
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNationalNum() {
        return nationalNum;
    }

    public void setNationalNum(int nationalNum) {
        this.nationalNum = nationalNum;
    }

    public int getHash() {
        String newName = (name.substring(0, (name.length() / 2)) + name.substring((name.length() / 2) + 1));
        if(name.length() % 2 == 0) return name.hashCode();
        else return newName.hashCode();
    }

    public boolean battle(Pokemon supposedWinner) {
        //if(supposedWinner.getHash() - supposedWinner.getNationalNum())
        return false;
    }

    public Pokemon calculateWinner(Pokemon other) {
        System.out.println("Hash: " + this.getHash() + " (subtract) " + this.calculateAverage() + "\n" + (this.getHash() - this.calculateAverage()) + "\n\nOther: " + other.getHash() + " (subtract) " + other.calculateAverage() + "\n" + (other.getHash() - other.calculateAverage()) + "\n\n");
        if((this.getHash() - this.calculateAverage()) < (other.getHash() - other.calculateAverage())) return this;
        else return other;
    }

    /**
     * The toString() method prints out all available information about the constructor
     */
    //@Override
    //public String toString() {
     //   return "\n__________\nName: " + name + "\nNumber: " + nationalNum + "\n_________";
   // }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public double getGameAverage() {
        return gameAverage;
    }

    public void setGameAverage(double average) {
        gameAverage = average;
    }

    public int[] getScores() {
        return scores;
    }

    public void setScores(int[] scores) {
        this.scores = scores;
    }
}
