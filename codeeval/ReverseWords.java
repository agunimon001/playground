import java.io.*;

public class ReverseWords{
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line, newLine;
		while ((line = buffer.readLine()) != null){
			line = line.trim();
			String[] lines = line.split(" ");
			newLine = "";
			for (String word : lines){
				newLine = word + " " + newLine;
			}
			System.out.println(newLine);
		}
	}
}