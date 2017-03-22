import java.io.*;

public class RomanNumerals {
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		char[] romans = "IVXLCDM".toCharArray();
		while ((line = buffer.readLine()) != null){
			line = line.trim();
			int value = Integer.valueOf(line);
				// I = 1
				// V = 5
				// X = 10
				// L = 50
				// C = 100
				// D = 500
				// M = 1,000
				
				// 159 >> C L IX
				// 296 >> CC XC VI
			
			String output = "";
			int i;
			for (i = 0; i < romans.length/2; i++){
				line = "";
				int digit = value % 10;
				if (digit % 5 == 4){
					line += romans[i*2];
					digit++;
				}
				if (digit == 10){
					line += romans[i*2+2];
					digit -= 10;
				}
				if (digit >= 5){
					line += romans[i*2+1];
					digit -= 5;
				}
				while (digit-- > 0) line += romans[i*2];
				output = line + output;
				value /= 10;
			}
			line = "";
			while (value-- > 0) line += romans[i*2];
			System.out.println(line + output);
		}//*/
	}
}