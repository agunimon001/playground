import java.io.*;

public class CapitalizeWords{
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null){
			line = line.trim();
			String[] lines = line.split(" ");
			char[] c;
			for (int i = 0; i < lines.length; i++){
				c = lines[i].toCharArray();
				c[0] = Character.toUpperCase(c[0]);
				lines[i] = String.valueOf(c);
			}
			for (int i = 0; i < lines.length; i++){
				System.out.print(lines[i]);
				System.out.print(i < lines.length - 1 ? " " : "\n");
			}
		}
	}
}