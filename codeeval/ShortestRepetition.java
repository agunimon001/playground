import java.io.*;

public class ShortestRepetition{
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null){
			line = line.trim();
			int a = 0, b = 0, length = line.length();
			if (length == 1){
				System.out.println("1");
				continue;
			}
			while (++b < length){
				if (line.charAt(a) == line.charAt(b))
					a++;
				else a = 0;
			}
			System.out.println(b-a);
		}
	}
}