import java.io.*;

public class JugglingWithZeros{
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null){
			line = line.trim();
			String[] lines = line.split(" ");
			long value = 0;
			line = "";
			for (int i = 0; i < lines.length; i+=2){
				switch (lines[i].length()){
					case 1:	//append 0s
						line += lines[i+1];
						break;
					case 2:	//append 1s
						for (char ch : lines[i+1].toCharArray())
							line += "1";
						break;
				}
			}
			for (char ch : line.toCharArray()){
				value = 2*value + ch-'0';
			}
			System.out.println(value);
		}
	}
}