package Days;
import java.util.*;
import java.io.*;

public class day0 {
	
	public static String fileName = "day0.txt";
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
		/*int w, x, y, z;
		String[] arr = string.split(",", 2);	
		
		String[] arr1 = arr[0].split("-", 2);
		String[] arr2 = arr[1].split("-", 2);
	
		w = Integer.parseInt(arr1[0]);
		x = Integer.parseInt(arr1[1]);
		y = Integer.parseInt(arr2[0]);
		z = Integer.parseInt(arr2[1]);
		System.out.print(x + "     " + y + "     " + z + "    " + w + "\n\n");
		*/
		return 1;
	}

		

}
