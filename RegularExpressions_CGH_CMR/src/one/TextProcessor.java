package one;
/**
 * This class reads through Dracula and finds several regex patterns, and then prints out the instances and number
 * of instances.
 * 
 * @authors Cameron Herbert and Claire Roeder
 * Version 1.0
 * Compiler Project 3
 * CS322 - Compiler Construction
 * Fall 2021
 * 
 * pattern 1: \ban?\b|\bthe?\b
 * pattern 2: (Mrs.|Mina)\sHarker
 * pattern 3: (?:\S+\s)?\S*Transylvania
 * pattern 4: to\s\w+
 * pattern 5: \b(?!Godalming|Helsing)(\b\w*ing)
 * 
 */

import java.util.Scanner;
import java.io.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class TextProcessor {
	
	public static void main(String args[]) throws Exception{
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter a file name: ");
		String fileName = scan.nextLine();
		
		System.out.print("Enter a regex pattern: ");
		String regex = scan.nextLine();
		
		processor(fileName, regex);
		
	}

	//This method processes the regex pattern and counts the number of instances found
    public static void processor(String fileName, String regexPattern) throws Exception{
	
    	File dracula = new File(fileName);
    	BufferedReader br = new BufferedReader(new FileReader(dracula));
	
    	Pattern pattern = Pattern.compile(regexPattern);
    	int counter = 0;
    	String currentLine;
	
    	while((currentLine = br.readLine()) != null) {
    		
    		Matcher matcher = pattern.matcher(currentLine);
		
    		if(matcher.find()) {
    			
    			System.out.println(matcher.group());
    			counter ++;
    			
    		}	 
    	}
    	
    	System.out.println(counter + " occurences found");
    	
    	
    }

}