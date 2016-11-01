import java.util.Scanner;
import java.math.BigInteger;

/*	undiscoveredSearch
		init
			generateMap
			updateMapCounts
				updateGridCount
					GridSearch.resetCount
					GridSearch.updateCount
		search
			(incomplete)
*/

public class undiscoveredSearch{
	final static int MAP_WIDTH = 15;
	final static int MAP_LENGTH = 20;
	private GridSearch[][] map;
	public static void main(String []args){
		undiscoveredSearch search = new undiscoveredSearch();
		search.init("f8007e00e001c003800700000000000000000000000000000000000000000000000000000003", "000010");
		//search.search(5,10);
		search.view();
	}
	// public void search(int x_pos, int y_pos){
		// /*	x_pos = 0~14 MAP_WIDTH
			// y_pos = 0~19 MAP_LENGTH
			// return x * 100 + y
			// use "x = search() / 100"
		// */
		// int distance = 1;
		// int corner_x, corner_y, oppCorner_x, oppCorner_y;
		// boolean flag = true;
		// try {
			// while (flag){
				// if ((corner_x = x_pos - distance) < 0){
					// corner_x = 0;
				// }
				// if ((corner_y = y_pos - distance) < 0){
					// corner_y = 0;
				// }
				// if ((oppCorner_x = x_pos + distance) >= MAP_WIDTH){
					// oppCorner_x = MAP_WIDTH - 1;
				// }
				// if ((oppCorner_y = y_pos + distance) >= MAP_LENGTH){
					// oppCorner_y = MAP_LENGTH - 1;
				// }
				// while ()
			// }
		// } catch (Exception e){
			// System.err.println("Error: undiscoveredSearch.search()");
		// }
	// }
	public void view(){
		Scanner sc = new Scanner(System.in);
		String printString;
		System.err.println("view");
		for (int j = 0; j < MAP_LENGTH; j++){
			printString = "    ";
			printString = (this.map[0][j].getDiscovered() ? "1" : "0") + printString +
							String.valueOf(this.map[0][j].getCount());
			System.out.println("'" + printString + "'");
			for (int i = 1; i < MAP_WIDTH; i++){
				printString =  printString.substring(0,i-1) + 
								(this.map[i][j].getDiscovered() ? "1" : "0") +
								printString.substring(i) +
								String.valueOf(this.map[i][j].getCount());
				System.out.println("'"+ printString +"'" + "i = " + i);
			}
			System.out.print(printString);
			sc.next();
		}
	}
	public void updateMapCounts(){
		for (int i = 0; i < MAP_WIDTH; i++){
			for (int j = 0; j < MAP_LENGTH; j++){
				updateGridCount(i,j);
			}
		}
	}
	private void updateGridCount(int x, int y){
		map[x][y].resetCount();
		try{
			for (int i = -1; i < 2; i++){
				for (int j = -1; j < 2; j++){
					int m = x+i;
					int n = y+j;
					if (m < 0 || m > MAP_WIDTH - 1 || n < 0 || n > MAP_LENGTH - 1){
						map[x][y].updateCount(1);
					} else {
						map[x][y].updateCount(map[m][n].getDiscovered() ? 1 : 0);
					}
				}
			}
		} catch (Exception e){
			System.err.println("Error: undiscoveredSearch.updateGridCount() x="+x+" y="+y);
		}
	}
	public undiscoveredSearch(){
		// still require init()
		map = new GridSearch[MAP_WIDTH][MAP_LENGTH];
	}
	public undiscoveredSearch(String MDF1_hex, String MDF2_hex){
		map = new GridSearch[MAP_WIDTH][MAP_LENGTH];
		init(MDF1_hex, MDF2_hex);
	}
	public void init(String MDF1_hex, String MDF2_hex){
		BigInteger MDF1, MDF2;
		MDF2_hex = "1" + MDF2_hex;
		MDF1 = new BigInteger(MDF1_hex, 16);
		MDF2 = new BigInteger(MDF2_hex, 16);
		generateMap(MDF1.toString(2), MDF2.toString(2).substring(1) /*single '1' bit padding in front*/);
		updateMapCounts();
	}
	private void generateMap(String MDF1_bin, String MDF2_bin){
		int MDF1_index = 2;		// padding '11' at the front
		int MDF2_index = 0;
		//String MDF1 = MDF1_bin.subString(2, MAP_WIDTH * MAP_LENGTH - 3);
		try {
			for (int j = 0; j < MAP_LENGTH; j++){			// j = 0 ~ 19
				for (int i = 0; i < MAP_WIDTH; i++){		// i = 0 ~ 14
					if (MDF1_bin.charAt(MDF1_index) == '1'){
						if (MDF2_bin.charAt(MDF2_index) == '1'){
							this.map[i][j] = new GridSearch(i,j,true, true);
						} else if (MDF2_bin.charAt(MDF2_index) == '0'){
							this.map[i][j] = new GridSearch(i,j,true, false);
						} else {
							System.err.println("Error reading MDF2 at MDF2_index=" + MDF2_index);
							return;
						}
						MDF2_index++;
					} else if (MDF1_bin.charAt(MDF1_index) == '0'){
						this.map[i][j] = new GridSearch(i,j,false);
					} else {
						System.err.println("Error reading MDF1 at MDF1_index=" + MDF1_index);
						return;
					}
					MDF1_index++;
				}
			}
		} catch (Exception e){
			System.err.println("Error: undiscoveredSearch.generateMap()");
		}
		System.err.println("Map Generation: Success");
	}
	
}