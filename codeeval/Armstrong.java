import java.io.*;

public class Armstrong{
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null){
			line = line.trim();
			int size = line.length();
			int number = Integer.parseInt(line);
			int sum = 0;
			while (number > 0){
				int digit = number%10;
				int digitMultiple = digit;
				for (int i = 1; i < size; i++) digitMultiple *= digit;
				sum += digitMultiple;
				number /= 10;
			}
			System.out.println(sum == Integer.parseInt(line) ? "True" : "False");
		}
	}
}