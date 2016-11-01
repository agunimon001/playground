import java.io.*;

public class WordCleanUp{
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null){
			line = line.trim();
			boolean wordFound = false;
			char[] array = line.toLowerCase().toCharArray();
			String sentence = "";
			for (char c : array){
				if (c >= 'a' && c <= 'z'){
					if (!wordFound){
						sentence += " ";
						wordFound = true;
					}
					sentence += String.valueOf(c);
				} else {
					wordFound = false;
				}
			}
			System.out.println(sentence.trim());
		}
	}
}