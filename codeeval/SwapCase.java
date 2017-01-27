import java.io.*;

public class SwapCase {
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null){
			char[] charLine = line.toCharArray();
			for(char c : charLine){
				if (Character.isUpperCase(c)) c = Character.toLowerCase(c);
				else if (Character.isLowerCase(c)) c = Character.toUpperCase(c);
				System.out.print(c);
			}
			System.out.println();
		}
	}
}