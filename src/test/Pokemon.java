package test;

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

    /**
     * The toString() method prints out all available information about the constructor
     */
    @Override
    public String toString() {
        return "\n__________\nName: " + name + "\nNumber: " + nationalNum + "\n_________";
    }

}
