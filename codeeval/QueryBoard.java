import java.io.*;

public class QueryBoard{
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		int[][] board = new int[256][256];
		int val1, val2;
		boolean set/*query=false*/, row/*column=false*/;
		while ((line = buffer.readLine()) != null){
			line = line.trim();
			String[] lines = line.split(" ");
			int sum = 0;
			val1 = Integer.parseInt(lines[1]);
			try{val2 = Integer.parseInt(lines[2]);}
			catch(Exception e){val2 = 0;}
			set = lines[0].contains("Set");
			row = lines[0].contains("Row");
			if (row){
				for (int j = 0; j < 256; j++){
					if (set) board[val1][j] = val2;
					else sum += board[val1][j];
				}
			} else {
				for (int i = 0; i < 256; i++){
					if (set) board[i][val1] = val2;
					else sum+= board[i][val1];
				}
			}
			if (!set) System.out.println(sum);
		}
	}
}