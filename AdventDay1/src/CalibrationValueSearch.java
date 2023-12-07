import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 * Solutions for both parts
 * Advent Day 1
 * 
 */

public class CalibrationValueSearch {

	public static void main(String[] args) {
		File file = new File("src/file.txt");
		//Uncomment for part 1 solution
		//
		//System.out.println(part1(file));
		//
		//Uncomment for part 2 solution
		//
		//System.out.println(part2(file));
		

	}

	/*
	 * Part one solution
	 * Finding the first and last integer values
	 */
	public static int part1(File file) {
		String line;
		int total = 0;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));  
			//loop for iterating through text file
			while ((line = br.readLine()) != null)  
			{  
				total+=NumericalOnly(line);	
			}

		} catch (IOException e) {
			e.printStackTrace();
		} 
		return total;
	}
	
	/*
	 * Part two solution
	 * Finding the first and last numerical and non numerical integer values
	 */
	
	public static int part2(File file) {
		String line;
		String newString;
		int total = 0;
		int linenum = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));  
			//loop for iterating through text file
			while ((line = br.readLine()) != null)  
			{  
				
				newString = ReplaceTextWithNumeric(line);
				total+=NumericalOnly(newString);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} 
		return total;
	}
	
	/*
	 * Function to replace all the numerical text with 
	 * actual numbers
	 */
	
	public static String ReplaceTextWithNumeric(String line) {
		
		ArrayList<String> numbers = new ArrayList<String>();
		String newString = "";
		boolean found = false;
		numbers.add("one");
		numbers.add("two");
		numbers.add("three");
		numbers.add("four");
		numbers.add("five");
		numbers.add("six");
		numbers.add("seven");
		numbers.add("eight");
		numbers.add("nine");
		// loops through the array of text numbers and replace them in the string with 
		// numerical values
		for(int i = 0; i < numbers.size(); i++) {
			while(line.contains(numbers.get(i))) {
				int index = line.indexOf(numbers.get(i));
				String replacement = Integer.toString(i+1);
				// Cannot replace first or last letters due to test cases
				//eg. oneeight = 18 
				newString =  line.substring(0, index+1) + replacement + line.substring(index+1);
				line = newString;
				found = true;
			}
			
		}
		//if there was no numerical text return original string
		if(!found) {
			newString = line;
		}
		
		return newString;
	}
	
	/*
	 * Helper method to determine the first and last integer and return them as one value 
	 */
	public static int NumericalOnly(String line) {
		//loop to start searching for first int
		int i = 0;
		while (i < line.length() && !Character.isDigit(line.charAt(i))) i++;
		char first = line.charAt(i);
		
		//loop to search for last int
		int j = line.length()-1;
		while(j > 0 && !Character.isDigit(line.charAt(j))) j--;
		char second = line.charAt(j);
		
		//combining two ints
		String s = new StringBuilder().append(first).append(second).toString();
		int temp = Integer.parseInt(s);
		return temp;
	}
	
	

}
