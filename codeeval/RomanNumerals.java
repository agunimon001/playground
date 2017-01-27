import java.io.*;

public class RomanNumerals {
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null){
			line = line.trim();
			int value = Integer.valueOf(line);
			/*	I = 1
				V = 5
				X = 10
				L = 50
				C = 100
				D = 500
				M = 1,000
				
				159 >> CLIX
				296 >> CCXCVI
			*/
			
		}
	}
}