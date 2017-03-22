import java.io.*;

public class HiddenDigits{
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null){
			line = line.trim();
			String output = "";
			for (char c : line.toCharArray()){
				if (c >= 'a' && c <= 'j')
					output += String.valueOf(c - 'a');
				if (c >= '0' && c <= '9')
					output += String.valueOf(c - '0');
			}
			System.out.println(output.isEmpty() ? "NONE" : output);
		}
	}
}