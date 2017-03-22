import java.io.*;

public class RollerCoaster{
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null){
			line = line.trim();
			boolean high = true;
			String output = "";
			for (char chr : line.toCharArray()){
				if (Character.isLetter(chr)){
					output += high ? Character.toUpperCase(chr) : Character.toLowerCase(chr);
					high = !high;
				} else output += chr;
			}
			System.out.println(output);
		}
	}
}