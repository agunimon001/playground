import java.io.*;

public class StringsAndArrows{
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null){
			line = line.trim();
			int count = 0, index = -1;
			do {
				index = line.indexOf("<--<<",index+1);
				if (index != -1)
					count++;
			} while (index != -1);
			do {
				index = line.indexOf(">>-->",index+1);
				if (index != -1)
					count++;
			} while (index != -1);
			System.out.println(count);
		}
	}
}