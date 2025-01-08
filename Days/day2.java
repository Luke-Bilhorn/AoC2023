
package Days;
import java.util.*;
import java.io.*;


public class day2 {
		
		public static int doo(String fileName) throws Exception {
			File file = new File(System.getProperty("user.dir"), fileName);
			Scanner sc = new Scanner(file);

			int count = 0;
			int numPossible = 0;
			while (sc.hasNextLine()) {
				count++;
				//System.out.println(sc.nextLine());
				String string = sc.nextLine();
				string = string.split(":", 2)[1];
				int w, x, y, z;
				//int s = numberOfChars
				
				
				int[] nums = new int[3];
				
				String[] arr = string.split(";", numberOfChars(string, ';'));
				for(int i = 0; i < arr.length; i++) {
					//System.out.print(arr[i] + "\n");
					String[] brr = arr[i].split(",", 3);
					for(int j = 0; j < brr.length; j++) {
						String[] crr = brr[j].split(" ", 3);
						System.out.print("-" + crr[1] + "-" + crr[2] + "-\n");
						if(crr[2].equals("red")) 
							if(Integer.parseInt(crr[1]) > nums[0]) 
								nums[0] = Integer.parseInt(crr[1]);
						if(crr[2].equals("green")) 
							if(Integer.parseInt(crr[1]) > nums[1]) 
								nums[1] = Integer.parseInt(crr[1]);
						if(crr[2].equals("blue")) 
							if(Integer.parseInt(crr[1]) > nums[2]) 
								nums[2] = Integer.parseInt(crr[1]);
						
					}
					System.out.print("\n");
				}
				/*if(nums[0] <= 12 && nums[1] <= 13 && nums[2] <= 14) {
					System.out.print("!!! " + count + "\n");
					numPossible+=count;
				}*/
				
				numPossible+=(nums[0]*nums[1]*nums[2]);
				
				//String[] arr1 = arr[0].split("-", 2);
				//String[] arr2 = arr[1].split("-", 2);
	    	
				
				//w = Integer.parseInt(arr1[0]);
				//x = Integer.parseInt(arr1[1]);
				//y = Integer.parseInt(arr2[0]);
				//z = Integer.parseInt(arr2[1]);
				//System.out.print(x + "     " + y + "     " + z + "    " + w + "\n\n");
				//if(true) count++;
				System.out.print("\n\n\n");
			}
			return numPossible;
	  	}
		
		
		public static void main(String[] args) throws Exception {
			System.out.print("" + doo("day2.txt"));
		}
			
		
		
		public static int numberOfChars(String s, char c) {
			int count = 0;
			 
			for (int i = 0; i < s.length(); i++) {
			    if (s.charAt(i) == c) {
			        count++;
			    }
			}
			
			
			
			return 9;
		}

	}
