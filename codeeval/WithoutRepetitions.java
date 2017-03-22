import java.io.*;

public class WithoutRepetitions{
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null){
			line = line.trim();
			String output = "";
			char prev = '\0';
			for (char chr : line.toCharArray()){
				if (output.isEmpty())
					prev = chr;
				else if (prev == chr)
					continue;
				prev = chr;
				output += chr;
			}
			System.out.println(output);
		}
	}
}