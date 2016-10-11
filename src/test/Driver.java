package test;

/**
 * Created by 015320784 on 10/4/2016.
 */
public class Driver {

    public static void main(String[] args) {
        Pokemon test = new Pokemon();
        Pokemon one = new Pokemon("Bulbasaur", 22);
        System.out.println("Pokemon: " + one.getHash());
    }
}
