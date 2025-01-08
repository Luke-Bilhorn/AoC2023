package Days;
import java.util.*;
import java.io.*;

public class day17 {

	public static String fileName = "day17.txt";
	public static String bar = "-----------------------------------------------------------------------------";


	public static int[][] field = new int[141][141];
	public static boolean[][] activated = new boolean[141][141];
	public static int maxDistance = 800;
	//1000 from 0.0.E yields 6994
	//900 same.
	//800 not. gives 6794
	//880 passes.

	//7077 for 0.8.E:850 


	public static void main(String[] args) throws Exception {
		//System.out.print("\n\n\n\t\t  maxDistance: " + maxDistance + "\n\n" + bar + "\n\n");

		System.out.print("\n\n" + bar + "\n\n\n\t\t  File:   " + fileName + "\n\n\t\tOutput:   " + crawl(fileName) + "\n\n");
	}	

	public static int crawl(String fileName) throws Exception {
		handleFile(fileName);
		//return testAllTraces();
		//return runTraceMax(44, 109, 'N', 1000);
		for(int i = 0; i < 110; i++) {
			for(int j = 0; j < 110; j++) {
				System.out.print("" + depth(field[i][j]) + depth(field[i][j]));
			}
			System.out.print("\n");
		}

		trace(0, 8, 'E', 0, maxDistance);

		System.out.print("\n\n");
		for(int i = 0; i < 110; i++) {
			for(int j = 0; j < 110; j++) {
				if(activated[i][j]) System.out.print(" #");
				else System.out.print(" .");
			}
			System.out.print("\n");
		}

		return readGrid(activated);

	}



	/* xPos: position in little array (east/west changes xPos)
	 * yPos: position in Big array (N/S changes yPos)
	 * dir:  direction (N/S/E/W) it came IN, later changed potentially to the direction it will go ouh
	 * count: how far the light has already traveled. The largest possible number of unique spaces the light can go is 12100, so if it is over that it is automatically looping, and I can cut it.
	 * 
	 * 
	 * 
	 */


	public static int testAllTraces() {
		int highest = 0;
		int current;
		for(int i = 0; i < 110; i++) {
			current = runTrace(i, 109, 'N');
			if(current > highest) highest = current;
			System.out.print("\t\t(high is " + highest + ")\n");
		}
		System.out.print("\n\n");
		for(int i = 0; i < 110; i++) {
			current = runTrace(0, i, 'E');
			if(current > highest) highest = current;
			System.out.print("\t\t(high is " + highest + ")\n");
		}
		for(int i = 0; i < 110; i++) {
			current = runTrace(i, 0, 'S');
			if(current > highest) highest = current;
			System.out.print("\t\t(high is " + highest + ")\n");
		}
		for(int i = 0; i < 110; i++) {
			current = runTrace(109, i, 'W');
			if(current > highest) highest = current;
			System.out.print("\t\t(high is " + highest + ")\n");
		}
		return highest;
	}

	public static int orders[] = {15, 120, 700, 900};//1200, 4000};

	public static int runTraceMax(int x, int y, char dir, int max) {


		System.out.print("" + x + "." + y + "." + dir + ".");
		int ret = 0;
		int j = 0;

		trace(x, y, dir, 0, max);
		ret = readGrid(activated);
		activated = new boolean[110][110];

		System.out.print("" + ret + "\t(at " + j + ")");

		return ret;
	}

	public static int runTrace(int x, int y, char dir) {


		System.out.print("" + x + "." + y + "." + dir + ".");
		int ret = 0;
		int j = 0;
		for(int i = 0; i < orders.length; i++){
			j = orders[i];
			trace(x, y, dir, 0, orders[i]);
			ret = readGrid(activated);
			activated = new boolean[110][110];
			if(ret < orders[i]) break;
			//if(ret > 7077) break; 
		}
		System.out.print("" + ret + "\t(at " + j + ")");

		return ret;
	}

	
	
	
	
	
	/* x: xpos
	 * y: ypos
	 * dir: direction coming in
	 * dis: distance it has traveled in the direction it came in // dis++ first thing
	 * if dis < 3 offer another option, straight, besides just the sides.
	 * 
	 * score: total score accumulated so far
	 * trav: distance traveled, in spaces
	 * max:  maximum distance allowed, in spaces
	 * 
	 * 
	 * 
	 */
	public static int test(int x, int y, char dir, int dis, int score, int trav, int max) {
		if(x < 0 || x >= 110 || y < 0 || y >=110 || trav > max) return (1 << 31 - 1);
		activated[y][x] = true;
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		score += field[y][x];
		trav++;
		
		
		if(dis < 3) {
			dis++;
			list.add(test(x, y, dir, dis, score, trav, max));
		}
		
		
		int set[] = {1, 2, 3};
		//int ret = min(set);
		
		return 0;
	}
	
	
	
	
	
	public static void trace(int x, int y, char dir, int distanceTraveled, int maxDistance) {
		if(x < 0 || x >= 110 || y < 0 || y >=110 || distanceTraveled > maxDistance) return;
		activated[y][x] = true;
		distanceTraveled++;

		//handle splitters (-|)

		if(field[y][x] == '|' && (dir == 'E' || dir == 'W')) {
			trace(x, y-1, 'N', distanceTraveled, maxDistance);
			trace(x, y+1, 'S', distanceTraveled, maxDistance);
			return;
		} else if(field[y][x] == '-' && (dir == 'N' || dir == 'S')) {
			trace(x+1, y, 'E', distanceTraveled, maxDistance);
			trace(x-1, y, 'W', distanceTraveled, maxDistance);
			return;
		}


		//handle empty space(.) and mirrors (/\) and straight cases of splitters (-|)
		else if(field[y][x] == '/') {
			switch(dir) {
			case 'E': dir = 'N';
			break;
			case 'W': dir = 'S';
			break;
			case 'N': dir = 'E';
			break;
			case 'S': dir = 'W';
			break;
			}
		} else if(field[y][x] == '\\') {
			switch(dir) {
			case 'E': dir = 'S';
			break;
			case 'W': dir = 'N';
			break;
			case 'N': dir = 'W';
			break;
			case 'S': dir = 'E';
			break;
			}
		}

		switch(dir) {
		case 'E': x++;
		break;
		case 'W': x--;
		break;
		case 'N': y--;
		break;
		case 'S': y++;
		break;
		}

		trace(x, y, dir, distanceTraveled, maxDistance);


		return;

	}

	public static int readGrid(boolean[][] grid) {
		int count = 0;
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				if(grid[i][j]) count++;
			}
		}
		return count;
	}

	public static int handleFile(String fileName) throws Exception {
		File file = new File(System.getProperty("user.dir"), fileName);
		Scanner sc = new Scanner(file);

		int line = 0;
		while (sc.hasNextLine()) {
			String string = sc.nextLine();
			processString(string, line);
			line++;
		}

		return 0;
	}

	public static int processString(String string, int line) {
		for(int i = 0; i < string.length(); i++) {
			field[line][i] = (string.charAt(i) - '0');
		}
		return 1;
	}
	
	public static char depth(int a) {
		if(a > 7) return '█';
		if(a > 5) return '▅';
		if(a > 3) return 'o';
		if(a > 1) return ':';
		return '.';
	}

}
