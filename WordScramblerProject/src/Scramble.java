import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Scramble {

	int count;
	int guesses = 3;
	List<String> words = new ArrayList<String>();
	
    public List<String> fileReader() throws FileNotFoundException {

    	int size = getSize();
        Scanner file = new Scanner(new File("random-words.txt"));
        

        for(int i = 0; i < size; i++) {
            String str = file.next();
            words.add(str);
        }
        
        return words;
    }
    
    public int getSize() throws FileNotFoundException {
    	
    	this.count = 0;
    	
        Scanner files = new Scanner(new File("random-words.txt"));
        
        while(files.hasNextLine()) {
        	this.count++;
            files.nextLine();
        }
 
        return this.count;
    }
    
    public String getWord(String finalWord) {

    	String word = finalWord;
    	
    	return word;
    	
    }
    
    public void scrambleWord() throws FileNotFoundException {
	
    	String finalWord = "";
    	Random random = new Random(this.count);
        int randomNumber = Math.abs(random.nextInt(this.count));
        
    	Collections.shuffle(this.words);
   
    	finalWord = this.words.get(randomNumber);
    	//System.out.println(finalWord);
    	
    	Random r = new Random();
    	char[] letters = finalWord.toCharArray();
    	char temp;
    	
    	for(int i = letters.length - 1; i > 0; i--) {
    		int upper = r.nextInt(i + 1);
    		temp = letters[i];
    		letters[i] = letters[upper];
    		letters[upper] = temp;
    	}
    	
    	//Returns scrambled char array as String
    	new String(letters);
    	System.out.println("------------------------------");
    	System.out.println(letters);
    	String input;
    
    	Scanner scan = new Scanner(System.in);

    	guesses = 3;
    	
    	while(this.guesses != 0) {
    		input = scan.nextLine();
    		if(!input.equals(finalWord)) {
        		this.guesses--;
        		
        		if(this.guesses > 0) {
        			System.out.println();
            		System.out.println("Try again!");
            		System.out.println("Remaining attempts: " + this.guesses);
        		}
        	}
    		else if(input.equals(finalWord)) {
    			System.out.println("========");
    			System.out.println("You Win!");
    			break;
    		}
    	}
    	
    	if(guesses == 0) {
    		System.out.println("==============================");
    		System.out.println("The correct word was: " + getWord(finalWord));
    		System.out.println();
    	}
    	
    	repeatOption();
    }
    
    public void repeatOption() throws FileNotFoundException {
    	
    	String y = "Yes";
    	String n = "No";
    	String user = "";
    	Scanner input = new Scanner(System.in);
    	
    	System.out.println("Play again? Please type Yes or No");
    	user = input.nextLine();
    	
    	if(user.equals(y)) {
    		System.out.println();
    		scrambleWord();
    	}
    	else if(user.equals(n)) {
    		System.out.println("Thanks for playing!");
    	}
    	else {
    		System.out.println("Invalid response! Please type Yes or No");
    		input.nextLine();
    	}
    }
}