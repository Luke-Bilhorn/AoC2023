package Days;

import java.io.File;
import java.util.Scanner;
import java.util.*;

public class day1 {
	public static int doo(String fileName) throws Exception {
		File file = new File(System.getProperty("user.dir"), fileName);
		Scanner sc = new Scanner(file);

		int count = 0;
		while (sc.hasNextLine()) {
			//System.out.println(sc.nextLine());
			String string = sc.nextLine();
			
			int[] a = new int[2];
			int spot = 0;
			for(int i = 0; i < string.length(); i++) {
				int aa = 0;
				char c = string.charAt(i);
				boolean b = Character.isDigit(c);
				if(b) aa = Character.getNumericValue(c);
				int w = val(string.substring(i, (i+5<string.length()?i+5:string.length())));
				boolean bb = (w!=0);
				if(bb) {
					aa = w;
					System.out.print(" " + w + "\n");
				}
				if(b || bb) {
					a[1] = aa;
					if(spot == 0) {
						spot++;
						a[0] = aa;
					}
				}
			}
			
			int roh = 10*a[0] + a[1];
			
			
			
			
			
			//int w, x, y, z;
			//String[] arr = string.split(",", 2);
			
			
			//String[] arr1 = arr[0].split("-", 2);
			//String[] arr2 = arr[1].split("-", 2);
    	
		//	w = Integer.parseInt(arr1[0]);
		//	x = Integer.parseInt(arr1[1]);
		//	y = Integer.parseInt(arr2[0]);
		//	z = Integer.parseInt(arr2[1]);
			System.out.print(roh + "\n");
			if(true) count+=roh;
		}
		return count;
  	}
	
	public static int val(String a) {
		if(a.length() >= 3) if(a.substring(0, 3).equals("one")) return 1;
		if(a.length() >= 3) if(a.substring(0, 3).equals("two")) return 2;
		if(a.length() >= 5) if(a.substring(0, 5).equals("three")) return 3;	
		if(a.length() >= 4) if(a.substring(0, 4).equals("four")) return 4;
		if(a.length() >= 4) if(a.substring(0, 4).equals("five")) return 5;
		if(a.length() >= 3) if(a.substring(0, 3).equals("six")) return 6;
		if(a.length() >= 5) if(a.substring(0, 5).equals("seven")) return 7;
		if(a.length() >= 5) if(a.substring(0, 5).equals("eight")) return 8;
		if(a.length() >= 4) if(a.substring(0, 4).equals("nine")) return 9;	
		
		return 0;
	}
	
	public static void main(String[] args) throws Exception {
		//System.out.print("\n" + val("oneee"));
		System.out.print("\n" + doo("day1.txt"));
		System.out.print("\n" + val("oneaaaa"));
	}
		

}
