package test;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by 015320784 on 10/4/2016.
 */
public class Driver {

    static Random rand = new Random();

    public static void main(String[] args) {
        rand.setSeed(System.currentTimeMillis());
        Pokemon one = new Pokemon("Bulbasaur", 22);
        Pokemon two = new Pokemon("Charmander", 2);
        Pokemon three = new Pokemon("Pikachu", 35);
        Pokemon four = new Pokemon("Oh-ho", 54);
        Pokemon five = new Pokemon("Squirtle", 16);

        one.setScores(new int[]{randomScore(101)});
        two.setScores(new int[]{randomScore(101)});
        three.setScores(new int[]{randomScore(101)});
        four.setScores(new int[]{randomScore(101)});
        five.setScores(new int[]{randomScore(101)});

        one.setWinningScore(new String[]{"*"});
        two.setWinningScore(new String[]{"*"});
        three.setWinningScore(new String[]{"*"});
        four.setWinningScore(new String[]{"*"});
        five.setWinningScore(new String[]{"*"});


        Pokemon[] initialWinners = {one, two, three, four, five};

        //Start the game
        int[] randomOpponents = new int[2];

        for(int a = 0; a < randomOpponents.length; a++) {
            randomOpponents[a] = randomScore(initialWinners.length);
        }
        while(randomOpponents[0] == randomOpponents[1]) {
            randomOpponents[1] = randomScore(initialWinners.length);
        }

        PokeEvolve battleOne = new PokeEvolve(initialWinners[randomOpponents[0]], initialWinners[randomOpponents[1]]);
        Pokemon winner = Pokemon.calculateWinner(battleOne.getHome(), battleOne.getVisitor());
        System.out.println(battleOne + "\n\nWinner: " + winner);




    }

    public static int randomScore(int range) {
        return rand.nextInt(range);
    }
}
