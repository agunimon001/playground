import java.io.*;
import java.util.ArrayList;

public class MixedContent{
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null){
			line = line.trim();
			String[] elements = line.split(",");
			ArrayList<String> words = new ArrayList<String>();
			ArrayList<String> numbers = new ArrayList<String>();
			for (String element : elements){
				try{
					numbers.add(String.valueOf(Integer.valueOf(element)));
				} catch(NumberFormatException e){
					words.add(element);
				}
			}
			line = "";
			for (String element : words)
				line += (line.isEmpty() ? "" : ",") + element;
			System.out.print(line + (words.isEmpty() | numbers.isEmpty() ? "" : "|"));
			line = "";
			for (String element : numbers)
				line += (line.isEmpty() ? "" : ",") + element;
			System.out.println(line);
		}
	}
}