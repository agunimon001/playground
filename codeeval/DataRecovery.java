import java.io.*;

public class DataRecovery{
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null){
			line = line.trim();
			String[] lines = line.split(";", 2);
			String[] words = lines[0].split(" ");
			String[] order = lines[1].split(" ");
			String sentence = "";
			int orderLastIndex = -1;
			for (String x : order) orderLastIndex++;
			int index = 1;
			for (String x : words){
				int i = 0;
				for (String orderVal : order){
					if (Integer.parseInt(orderVal) == index){
						break;
					}
					i++;
				}
				sentence += words[i] + " ";
				index++;
			}
			System.out.println(sentence.trim());
		}
	}
}