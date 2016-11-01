import java.io.*;
import java.util.ArrayList;

public class HappyNumber{
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		int i, testNum, digit, sum = 0;
		ArrayList<Integer> usedNumbers = new ArrayList<Integer>();
		while ((line = buffer.readLine()) != null){
			line = line.trim();
			int num = Integer.parseInt(line);
			usedNumbers.clear();
			usedNumbers.add((Integer)num);
			testNum = num;
			for (i = 0; i < 1000; i++){
				sum = 0;
				while (testNum > 0){
					digit = testNum % 10;
					sum += digit * digit;
					testNum /= 10;
				}
				if (usedNumbers.contains((Integer)sum)) break;
				usedNumbers.add((Integer)sum);
				testNum = sum;
			}
			System.out.println(i != 1000 && sum == 1 ? 1 : 0);
		}
	}
}