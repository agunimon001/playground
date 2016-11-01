import java.io.*;

public class Multiples{
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null){
			line = line.trim();
			String[] lines = line.split(",",2);
			int x = Integer.parseInt(lines[0]);
			int n = Integer.parseInt(lines[1]);
			int val = n;
			for (int i = 1; val < x; i++){
				val = i*n;
			}
			System.out.println(val);
		}
	}
}