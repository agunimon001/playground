import java.io.*;

public class StepwiseWord{
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null){
			String[] words = line.trim().split(" ");
			String longestWord = "";
			for (String word : words){
				if (word.length() > longestWord.length())
					longestWord = word;
			}
			line = "";
			for (char c : longestWord.toCharArray()){
				System.out.print(line + c);
				line += "*";
				if (line.length() < longestWord.length())
					System.out.print(" ");
			}
			System.out.println();
		}
	}
}