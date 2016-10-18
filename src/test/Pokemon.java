package test;

import java.util.Arrays;
import java.util.Comparator;

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
    public Pokemon(String name, int nationalNum) {
        this.name = name;
        this.nationalNum = nationalNum;
    }

    /**
     * This method calculates the average score of the Pokemon object based on its other scores.
     * @return the average
     */

    public double calculateAverage() {
        int sum = 0;
        for (int a = 0; a < scores.length; a++) sum = sum + scores[a];
        double average = sum / scores.length;
        return average;
    }

    /**
     * This gets the correct hashCode of the Pokemon based on Professor Nachawati's instructions.
     * @return the hashCode
     */
    public int getHash() {
        String newName = (name.substring(0, (name.length() / 2)) + name.substring((name.length() / 2) + 1));
        if(name.length() % 2 == 0) return name.hashCode();
        else return newName.hashCode();
    }

    /**
     * Merges the wins (*) or losses (^) to the actual scores, to print them out.
     * @return The merged score.
     */
    public String[] getMergedScores() {
        String[] newArr = new String[scores.length];
        for(int a = 0; a < scores.length; a++) {
            newArr[a] = scores[a] + winningScore[a];
        }
        return newArr;
    }

    /**
     * Calculates the winner of the battle
     * @param one One Pokemon
     * @param two The other Pokemon
     * @return An array that indicates the proper winner and loser.
     */
    public static Pokemon[] calculateWinner(Pokemon one, Pokemon two) {
        Pokemon[] oneWins = {one, two};
        Pokemon[] twoWins = {two, one};
        double numOne = Math.abs((one.getHash() - one.calculateAverage()));
        double numTwo = Math.abs((two.getHash() - two.calculateAverage()));

        if(numOne < numTwo) return oneWins;
        else return twoWins;
    }

    /**
     * The toString() method prints out all available information about the constructor
     */
    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", nationalNum=" + nationalNum +
                ", gamesPlayed=" + gamesPlayed +
                ", gameAverage=" + gameAverage +
                ", scores=" + Arrays.toString(scores) +
                ", winningScores" + Arrays.toString(winningScore) +
                ", hash=" + name.hashCode() +
                '}';
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

    public void incrementGamesPlayed() {
        gamesPlayed++;
    }

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

}
