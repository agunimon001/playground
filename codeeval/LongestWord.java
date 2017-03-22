import java.io.*;

public class LongestWord{
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null){
			line = line.trim();
			String[] lines = line.split(" ");
			int longestAt = 0;
			for (int i = 1; i < lines.length; i++){
				if (lines[longestAt].length() < lines[i].length())
					longestAt = i;
			}
			System.out.println(lines[longestAt]);
		}
	}
}