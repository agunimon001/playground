import java.io.*;
import java.util.*;

public class TheMajorElement{
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null){
			line = line.trim();
			String[] lines = line.split(",");
			int[] numbers = new int[lines.length];
			for (int i = 0; i < lines.length; i++){
				numbers[i] = Integer.valueOf(lines[i].trim());
			}
			Arrays.sort(numbers);
			int best = numbers[0], curCount = 1, bestCount = 1;
			boolean sameCount = true;
			for (int i = 1; i < numbers.length; i++){
				if (numbers[i] == numbers[i-1]){
					curCount++;
					if (curCount > bestCount){
						best = numbers[i];
						bestCount = curCount;
						sameCount = false;
					} else if (curCount == bestCount){
						sameCount = true;
					}
				} else {
					curCount = 1;
				}
			}
			System.out.println(sameCount || 2 * bestCount <= numbers.length ? "None" : best);
		}
	}
}