import java.io.*;

public class ChardonnayOrCabernet{
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null){
			String[] lines = line.trim().split("\\|");
			char[] hint = lines[1].trim().toCharArray();
			String[] choices = lines[0].trim().split(" ");
			String output = "";
			for (String choice : choices){
				line = choice;
				for (char c : hint){
					choice = choice.replaceFirst(String.valueOf(c), "");
				}
				if (line.length() - choice.length() == hint.length){
					if (!output.isEmpty())
						output += " ";
					output += line;
				}
			}
			if (output.isEmpty())
				output = "False";
			System.out.println(output);
		}
	}
}