import java.io.*;

public class MultiplyLists{
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null){
			line = line.trim();
			String line2 = line.split("\\|")[1].trim();
			line = line.split("\\|")[0].trim();
			String[] lineElements = line.split(" ");
			String[] line2Elements = line2.split(" ");
			for (int i = 0; i < lineElements.length; i++){
				lineElements[i] = String.valueOf(Integer.valueOf(lineElements[i]) * Integer.valueOf(line2Elements[i]));
			}
			line = "";
			for (String element : lineElements) line += (line.isEmpty() ? "" : " ") + element;
			System.out.println(line);
		}
	}
}