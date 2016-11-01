import java.io.*;

public class FileSize{
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null){
			line = line.trim();
			long size = File(line).length();
			System.out.println(size);
		}
	}
}