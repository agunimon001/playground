import java.io.*;

public class SumOfDigits{
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null){
			line = line.trim();
			int sum = 0;
			for (char c : line.toCharArray()){
				sum += c - '0';
			}
			System.out.println(sum);
		}
	}
}