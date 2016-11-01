import java.io.*;

public class NModM{
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null){
			line = line.trim();
			String[] lines = line.split(",");
			int N = Integer.parseInt(lines[0]);
			int M = Integer.parseInt(lines[1]);
			while (N >= M) N -= M;
			System.out.println(N);
		}
	}
}