import java.io.*;

public class MaxRangeSum{
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null){
			line = line.trim();
			String[] lines = line.split(";");
			int days = Integer.valueOf(lines[0]);
			String[] recordStr = lines[1].split(" ");
			int[] record = new int[recordStr.length];
			for (int i = 0; i < record.length; i++)
				record[i] = Integer.valueOf(recordStr[i]);
			int greatestFrom = 0, begin = 0, lastBegin = record.length - days;
			if (lastBegin < 0){
				System.out.println(0);
				continue;
			}
			int prevSum = 0, sum = 0;
			for (int i = 0; i < days; i++)
				sum += record[i];
			if (lastBegin == 0){
				System.out.println(sum > 0 ? sum : 0);
				continue;
			}
			prevSum = sum;
			for (int i = 0; i < lastBegin; i++){
				sum += record[i + days] - record[i];
				if (sum > prevSum){
					greatestFrom = i + 1;
					prevSum = sum;
				}
			}
			sum = 0;
			for (int i = 0; i < days; i++)
				sum += record[i+greatestFrom];
			System.out.println(sum > 0 ? sum : 0);
		}
	}
}