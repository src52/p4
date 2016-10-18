package test;

import de.vandermeer.asciitable.v2.RenderedTable;
import de.vandermeer.asciitable.v2.V2_AsciiTable;
import de.vandermeer.asciitable.v2.render.V2_AsciiTableRenderer;
import de.vandermeer.asciitable.v2.render.WidthFixedColumns;
import de.vandermeer.asciitable.v2.themes.V2_E_TableThemes;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by 015320784 on 10/4/2016.
 *
 * The Driver class is the beating heart of the program. Most of the calculations and battle logic takes place here,
 * unfortunately.
 *
 * This class initializes a new Driver instance, then starts the program. It creates an initial array of Pokemon objects,
 * with predetermined attributes, such as name, and national number.
 *
 * From there, it begins the program. It asks the user if they want to battle a random set of Pokemon. The battle works
 * correctly, and the new Pokemon is added into the Pomemon array, and printed out into the table.
 */
public class Driver {

    Random rand = new Random();
    public Pokemon[] initialWinners = new Pokemon[100];

    /**
     * Initializes the Driver object, and starts the Pokemon game.
     * @param args run-time arguments, not used
     */
    public static void main(String[] args) {
        Driver instance = new Driver();
        instance.rand.setSeed(System.currentTimeMillis());
        instance.initializeFoundingPokemon();
        System.out.println("Initialized initial pokemon");
        instance.battle();
    }

    /**
     * The initializeFoundingPokemon() method generates the inital predefined Pokemon objects.
     */

    public void initializeFoundingPokemon() {
        rand.setSeed(System.currentTimeMillis());
        Pokemon one = new Pokemon("Cyndaquil", 2);
        Pokemon two = new Pokemon("Chimchar", 3);
        Pokemon three = new Pokemon("Pikachu", 4);
        Pokemon four = new Pokemon("Geodude", 5);
        Pokemon five = new Pokemon("Turtwig", 6);

        one.setScores(new int[]{showRandomInteger(50, 101, rand)});
        two.setScores(new int[]{showRandomInteger(50, 101, rand)});
        three.setScores(new int[]{showRandomInteger(50, 101, rand)});
        four.setScores(new int[]{showRandomInteger(50, 101, rand)});
        five.setScores(new int[]{showRandomInteger(50, 101, rand)});

        one.setWinningScore(new String[]{"*"});
        two.setWinningScore(new String[]{"*"});
        three.setWinningScore(new String[]{"*"});
        four.setWinningScore(new String[]{"*"});
        five.setWinningScore(new String[]{"*"});

        initialWinners[0] = one;
        initialWinners[1] = two;
        initialWinners[2] = three;
        initialWinners[3] = four;
        initialWinners[4] = five;
    }

    /**
     * The battle() method handles all the Pokemon battles
     */

    public void battle() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Would you like to battle some Pokemon?");
        String answer = scan.nextLine();

        if(answer.equals("no")) {
            System.out.println("Okay, thanks for playing!\nBefore you go, do you want to output the table by name or by average?");
            String choice = scan.nextLine();

            switch(choice) {
                case "name":
                    System.out.println(printTable(initialWinners, null, "name"));
                    break;

                case "average":

                    break;
            }
        } else if(answer.equals("yes")) {
            if(getRealLength(initialWinners) == 0) {
                System.out.println("The array cannot hold any more Pokemon! Goodbye!");
                System.exit(0);
            }
            //Start the game
            int[] randomOpponents = new int[2];

            for (int a = 0; a < randomOpponents.length; a++) {
                randomOpponents[a] = randomScore(getRealLength(initialWinners));
            }
            while (initialWinners[randomOpponents[0]].getName() == initialWinners[randomOpponents[1]].getName()) {
                randomOpponents[1] = randomScore(getRealLength(initialWinners));
            }

            PokeEvolve battleOne = new PokeEvolve(initialWinners[randomOpponents[0]], initialWinners[randomOpponents[1]]);
            Pokemon winner = Pokemon.calculateWinner(battleOne.getHome(), battleOne.getVisitor())[0];
            Pokemon loser = Pokemon.calculateWinner(battleOne.getHome(), battleOne.getVisitor())[1];
            Pokemon evolved = PokeEvolve.pokeNameStatic(winner, loser);
            evolved.setScores(ArrayUtils.add(evolved.getScores(), showRandomInteger(50, 100, rand)));
            evolved.setWinningScore(ArrayUtils.add(evolved.getWinningScore(), "*"));

            initialWinners[getRealLength(initialWinners) + 1] = evolved;

            int losersScore = 0;
            int winnersScore = (int) (Math.abs((winner.getHash() - winner.calculateAverage())) % 100);

            if (winnersScore >= 50) {
                losersScore = 100 - winnersScore;
            } else {
                losersScore = 50 - winnersScore;
            }

            winner.incrementGamesPlayed();
            loser.incrementGamesPlayed();

            winner.setScores(ArrayUtils.add(winner.getScores(), winnersScore));
            winner.setWinningScore(ArrayUtils.add(winner.getWinningScore(), "*"));

            loser.setScores(ArrayUtils.add(loser.getScores(), losersScore));
            loser.setWinningScore(ArrayUtils.add(loser.getWinningScore(), "^"));


            for (int a = 0; a < getRealLength(initialWinners); a++) {
                if (initialWinners[a].getName().equals(winner.getName()) && initialWinners[a].getNationalNum() == winner.getNationalNum())
                    initialWinners[a] = winner;
                if (initialWinners[a].getName().equals(loser.getName()) && initialWinners[a].getNationalNum() == loser.getNationalNum())
                    initialWinners[a] = loser;
            }

            for (int a = 0; a < initialWinners.length; a++) {
                if (initialWinners[a] == null) break;
                initialWinners[a].setGameAverage(initialWinners[a].calculateAverage());
            }
            System.out.println(printTable(initialWinners, randomOpponents, "default"));
            System.out.println(loser.getName() + " battled " + winner.getName() + " and lost! " + evolved.getName() + " was formed!");
            //System.out.println("Real length: " + getRealLength(initialWinners));
        }
        battle();
    }

    /**
     * Generates a random number from 0 to range
     * @param range
     * @return
     */
    public int randomScore(int range) {
        return rand.nextInt(range);
    }

    /**
     * Gets the real length of the Pokemon array, without all the nulled entries.
     *
     * This is "n" from the assignment.
     *
     * @param array the array
     * @return the real, no nulls, length of the array
     */
    public static int getRealLength(Pokemon[] array) {
        int num = 0;
        for(int a = 0; a < array.length; a++) {
            if(array[a] == null) {
                num = a - 1;
                break;
            }

        }
        return num;
    }


    /**
     * Prints the Pokemon objects onto a neat table. I am using the third-party library, "ASCIITable" to generate these
     * tables. The project is located here: https://github.com/vdmeer/asciitable
     *
     * The project is licensed under Apache 2.0 Licensing.
     *
     * @param arr the pokemon array
     * @param randomOpponents the random opponent choices
     * @param type which type of printing will be done
     * @return the table in a String format.
     */
    public static String printTable(Pokemon[] arr, int[] randomOpponents, String type) {
        Pokemon[] sortedByName = arr;
        V2_AsciiTable at = new V2_AsciiTable();
        at.addRule();
        at.addRow("Name", "National Number", "Games played", "Average", "Scores", "Hash");
        at.addRule();
        for(int a = 0; a < arr.length; a++) {
            if(arr[a] == null) break;
            if(type == "name") { //I didn't get this feature working
                System.out.println("test");
                at.addRow((a + 1) + ": " + sortedByName[a].getName(), sortedByName[a].getNationalNum(), sortedByName[a].getGamesPlayed(), sortedByName[a].getGameAverage(), Arrays.toString(sortedByName[a].getMergedScores()), sortedByName[a].getHash());
                at.addRule();
            } else if(type == "default") {
                if (a == randomOpponents[0] || a == randomOpponents[1])
                    at.addRow("*" + (a + 1) + ": " + arr[a].getName(), arr[a].getNationalNum(), arr[a].getGamesPlayed(), arr[a].getGameAverage(), Arrays.toString(arr[a].getMergedScores()), arr[a].getHash());
                else
                    at.addRow((a + 1) + ": " + arr[a].getName(), arr[a].getNationalNum(), arr[a].getGamesPlayed(), arr[a].getGameAverage(), Arrays.toString(arr[a].getMergedScores()), arr[a].getHash());
                at.addRule();
            }
        }
        V2_AsciiTableRenderer rend = new V2_AsciiTableRenderer();
        rend.setTheme(V2_E_TableThemes.NO_BORDERS.get());
        rend.setWidth(new WidthFixedColumns().add(15).add(14).add(10).add(12).add(25).add(25));
        //rend.setWidth(new WidthAbsoluteEven(90));
        RenderedTable rt = rend.render(at);
        return rt.toString();
    }

    /**
     * Generates a random integer within the bounds of aStart and aEnd.
     *
     * I did not create this method, it was provided to me by Professor Nachawati on her BeachBoard page.
     *
     * @param aStart Beginning of range
     * @param aEnd End of range
     * @param aRandom the Random object to generate the number
     * @return a random number
     */
    private static int showRandomInteger(int aStart, int aEnd, Random aRandom){

        if ( aStart > aEnd ) {
            throw new IllegalArgumentException("Start cannot exceed End.");
        }
        //get the range, casting to long to avoid overflow problems
        long range = (long)aEnd - (long)aStart + 1;
        // compute a fraction of the range, 0 <= frac < range
        long fraction = (long)(range * aRandom.nextDouble());
        int randomNumber = (int)(fraction + aStart);
        return randomNumber;
    }
}
