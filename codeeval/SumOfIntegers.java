import java.io.*;

public class SumOfIntegers{
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		int sum = 0;
		while ((line = buffer.readLine()) != null){
			int num = Integer.parseInt(line.trim());
			sum += num;
		}
		System.out.println(sum);
	}
}