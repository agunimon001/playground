import java.io.*;

public class FindAWriter {
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null){
			int split = line.indexOf('|');
			String data = line.substring(0,split);
			String indexString = line.substring(split + 1).trim();
			String[] indexes = indexString.split(" ");
			String name = "";
			for (String str : indexes){
				name += data.charAt(Integer.valueOf(str) - 1);
			}
			System.out.println(name);
		}
	}
}