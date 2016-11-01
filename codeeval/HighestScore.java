import java.io.*;

public class HighestScore{
	public static void main(String[] args) throws IOException{
		System.err.println("|");
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null){
			line = line.trim();
			String result = "";
			System.err.println(line);
			String[] lines = line.split("|");
			for (String x : lines) System.err.println(x);
			int voters = 0;
			for (String x : lines) voters++;
			String[][] scores = new String[voters][];
			for (int i = 0; i < voters; i++){
				scores[i] = lines[i].trim().split(" ");
			}
			int categoryIndex = 0;
			for (String category : scores[0]){
				int highest = Integer.parseInt(scores[0][categoryIndex]);
				for (int voterIndex = 1; voterIndex < voters; voterIndex++){
					System.err.println(scores[voterIndex][categoryIndex]);
					int vote = Integer.parseInt(scores[voterIndex][categoryIndex]);
					if (vote > highest) highest = vote;
				}
				result += " " + highest;
			}
			System.out.println(result.trim());
		}
	}
}