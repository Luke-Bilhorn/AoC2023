package Days;
import java.util.*;
import java.io.*;

public class day4 {
	
	public static String fileName = "day4.txt";
	public static String bar = "-----------------------------------------------------------------------------";
	
	public static void main(String[] args) throws Exception {
		System.out.print("\n\n" + bar + "\n\n\n\t\t  File:   " + fileName + "\n\n\t\tOutput:   " + handleFile(fileName) + "\n\n");
	}	
	
	public static int handleFile(String fileName) throws Exception {
		File file = new File(System.getProperty("user.dir"), fileName);
		Scanner sc = new Scanner(file);

		int count = 0;
		while (sc.hasNextLine()) {
			String string = sc.nextLine();
			count += processString(string);
		}
		return count;
  	}
	
	public static int processString(String string) {
		System.out.print(string + "\n");
		int w, x, y, z;
		String[] arr = string.split(":\s+", 2);	
		String[] brr = arr[1].split(" \\|\s+", 2);
		//System.out.print(brr[0] + "\n" + brr[1] + "\n");
		String[] winners = brr[0].split("\\s+", 10);
		String[] havers = brr[1].split("\\s+", 25);
	
		int[] A = new int[10];
		
		for(int i = 0; i < winners.length; i++) {
			A[i] = Integer.parseInt(winners[i]);
			System.out.print("/" + winners[i]);
		}
		System.out.print("\n");
		for(int i = 0; i < havers.length; i++) {
			System.out.print("-" + havers[i]);
		}
		
		int count = 0;
		for(int i = 0; i < havers.length; i++) {
			for(int j = 0; j < winners.length; j++) {
				if(havers[i].equals(winners[j])) {
					count++;
					
					System.out.print("\n" + havers[i] + "\n");
				}
			}
		}
		
		if(count != 0) count = (int)(Math.pow(2,  (count - 1)));
		System.out.print("\n\t\t" + count + "\n");
		//System.out.print("" + winners + "\n");
		//w = Integer.parseInt(arr1[0]);
		//x = Integer.parseInt(arr1[1]);
		//y = Integer.parseInt(arr2[0]);
		//z = Integer.parseInt(arr2[1]);
		//System.out.print(x + "     " + y + "     " + z + "    " + w + "\n\n");
		/*for(int i = 0; i < winners.length; i++) {
			System.out.print("" + "" + winners[i] + "*");
		}
		System.out.print("\n");
		
		for(int i = 0; i < havers.length; i++) {
			System.out.print("" + havers[i] + "-");
		}
		System.out.print("\n\n");*/
		
		
		
		
		
		return count;
	}

		

}
