package test;

/**
 * The PokEvolver class takes two seperate Pokemon objects and merges them into one Pokemon object.
 * It takes the first three letters of the first Pokemon object, along with the last three letters of
 * the other Pokemon object, and sets that as the new Pokemon's name. Additionally, it also takes the two
 * Pokemon's national numbers, multiplies them together, and uses that as the new Pokemon's object.
 *
 * Created by Spencer on 9/19/2016.
 */
public class PokeEvolve {

    /*
     * Instance variables.
     */
    private Pokemon home;
    private Pokemon visitor;


    /**
     * The PokEvolve constructor. Takes two Pokemon objects as parameters.
     */

    public PokeEvolve(Pokemon home, Pokemon visitor) {
        this.home = home;
        this.visitor = visitor;
    }

    public PokeEvolve() {
        home = new Pokemon();
        visitor = new Pokemon();
    }

    /**
     * Getters and setters0
     */

    public Pokemon getHome() {
        return home;
    }

    public void setHome(Pokemon home) {
        this.home = home;
    }

    public Pokemon getVisitor() {
        return visitor;
    }

    public void setVisitor(Pokemon visitor) {
        this.visitor = visitor;
    }

    /**
     * The pokeName(Pokemon, Pokemon) method takes two Pokemon objects, and merges them into one, in the way I specified
     * at the beginning of the class.
     *
     * @param winner The home Pokemon
     * @param loser The visitor Pokemon
     * @return A merged Pokemon
     */
    public Pokemon pokeName(Pokemon winner, Pokemon loser) { //@TODO: Insert correct pokeNum() method
        return new Pokemon(winner.getName().substring(0, 3) + loser.getName().substring(visitor.getName().length() - 3), pokeNum(winner.getNationalNum(), loser.getNationalNum()));
    }

    /**
     * ZThe pokeNum(int, int) method takes the national numbers of both of the Pokemon objects as parameters, and outputs
     * the product of them.
     *
     * @param winningNum The national number of the winning Pokemon.
     * @param losingNum The national number of the losing Pokemon.
     * @return The product of the two numbers.
     */
    private int pokeNum(int winningNum, int losingNum) {
        return (winningNum * losingNum) + ((int)Math.pow((Math.abs(winningNum - losingNum) - 1), 2))/4;
    }



    public static void main(String[] args) {

    }
    /**
     * The toString() prints out all the information about the PokEvolve object. The Pokemon's toString() is printed, along
     * with the output from the pokeName(Pokemon, Pokemon) method.
     *
     * @return The information about the PokEvolve objects and the Pokemon objects.
     */
    @Override
    public String toString() {
        return "PokEvolve{" +
                "home=" + home +
                ", \nvisitor=" + visitor +
                ", \n\n\nEvolved Pokemon=" + pokeName(home, visitor) +
                '}';
    }
}
