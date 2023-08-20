import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

    	Scramble s = new Scramble();
    	String mainWord;
    	String scrambledWord;
        //Header
        System.out.println("------------------------------");
        System.out.println("Welcome to Java Word Scramble!");
        System.out.println("------------------------------");

        System.out.println("~ Scrambled Word: ~");

        s.fileReader();
        s.scrambleWord();
    }
}