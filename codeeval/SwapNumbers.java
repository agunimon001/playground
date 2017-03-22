import java.io.*;

public class SwapNumbers{
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null){
			char[] charArray = line.trim().toCharArray();
			String suffix = "", prefix = "", word = "", output = "";
			for (char c : charArray){
				if (c == ' '){
					output += suffix + word + prefix + " ";
					prefix = ""; word = ""; suffix = "";
				} else if (Character.isLetter(c)){
					word += c;
				} else if (word.isEmpty()){
					prefix += c;
				} else {
					suffix += c;
				}
			}
			System.out.println(output + suffix + word + prefix);
		}
	}
}