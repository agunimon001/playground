import java.io.*;

public class KnightMoves{
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null){
			line = line.trim();
			char alphabet = line.charAt(0), number = line.charAt(1);
			String output = "";
			for (int i = 2; i >= 1; i--){
				if (alphabet - i >= 'a'){
					if (number - 3 + i >= '1')
						output+=((char)(alphabet-i) + "" +(char)(number-3+i));
					if (number + 3 - i <= '8')
						output+=((char)(alphabet-i) + "" +(char)(number+3-i));
				}
			}
			for (int i = 1; i <= 2; i++){
				if (alphabet + i <= 'h'){
					if (number - 3 + i >= '1')
						output+=((char)(alphabet+i) + "" +(char)(number-3+i));
					if (number + 3 - i <= '8')
						output+=((char)(alphabet+i) + "" +(char)(number+3-i));
				}
			}
			for (int i = 0; i < output.length(); i++){
				if (i != 0 && i%2 == 0)
					System.out.print(" ");
				System.out.print(output.charAt(i));
			}
			System.out.println();
		}
	}
}