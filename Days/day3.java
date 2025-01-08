package Days;
import java.util.*;
import java.io.*;

public class day3 {
	
	public static String fileName = "day3.txt";
	public static String bar = "-----------------------------------------------------------------------------";
	
	public static void main(String[] args) throws Exception {
		System.out.print("\n\n" + bar + "\n\n\n\t\t  File:   " + fileName + "\n\n\t\tOutput:   " + handleFile(fileName) + "\n\n");
	}	
	
	public static int handleFile(String fileName) throws Exception {
		char[][] arr = makeArrayArray(fileName);
		
		int total = 0;
		int currentNumber = 0;
		int isPart = 0; //0 = false, 1 == true, will multiply
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				char c = arr[i][j];
				if(Character.isDigit(c)){
					currentNumber*=10;
					currentNumber+=Character.digit(c, 10);
				
					for(int k = -1; k < 2; k++) {
						for(int l = -1; l < 2; l++) {
							if(i + k >= 0 && i + k < arr.length) 
								if(j + l >= 0 && j + l < arr[0].length) 
									if(isThing(arr[i + k][j + l]))isPart = 1;
						}
					}
				} else {
					total+=(isPart * currentNumber);
					System.out.print("\n" + currentNumber + " " + isPart);
					isPart = 0;
					currentNumber = 0;
				}
			}
			total+=(isPart * currentNumber); //5792115 without this, 5815088 with
			currentNumber = 0;
			isPart = 0;
		}
		
		
		
		
		
		
		
		return total;
	}
	
	
	public static int countLinesOfFile(String fileName) throws Exception {
		File file = new File(System.getProperty("user.dir"), fileName);
		Scanner sc = new Scanner(file);

		int count = 0;
		while (sc.hasNextLine()) {
			String string = sc.nextLine();
			count ++;
		}
		return count;
  	}
	
	public static int countLinesOfString(String fileName) throws Exception {
		File file = new File(System.getProperty("user.dir"), fileName);
		Scanner sc = new Scanner(file);

			String string = sc.nextLine();
			
		return string.length();
  	}
	
	public static char[][] makeArrayArray(String fileName) throws Exception {
		File file = new File(System.getProperty("user.dir"), fileName);
		Scanner sc = new Scanner(file);

		int count = countLinesOfFile(fileName);
		int size = countLinesOfString(fileName);
		char[][] brr = new char[count][size];
		int i = 0;
		while (sc.hasNextLine()) {
			String string = sc.nextLine();
			brr[i] = makeArray(string);
			i++;
		}
		return brr;
	}
	
	public static boolean isThing(char c) {
		if (Character.isDigit(c)) return false;
		if(c == '.') return false;
		return true;
	}
	
	
	public static char[] makeArray(String string) {
		char[] arr = new char[string.length()];
		System.out.print(string + "\n");
		for(int i = 0; i < string.length(); i++) {
			arr[i] = string.charAt(i);
		}
		return arr;
	}

		
	public static int isPart(char c) {
		
		
		return 0;
	}

}


/* Tyler begins with opening statement
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
