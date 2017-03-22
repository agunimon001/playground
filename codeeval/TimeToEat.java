import java.io.*;
import java.util.Arrays;

public class TimeToEat{
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null){
			String[] lines = line.trim().split(" ");
			int[] times = new int[lines.length];
			for (int i = 0; i < times.length; i++){
				String[] timeSplit = lines[i].split(":");
				times[i] = Integer.valueOf(timeSplit[2].trim());
				times[i] += Integer.valueOf(timeSplit[1].trim()) * 60;
				times[i] += Integer.valueOf(timeSplit[0].trim()) * 60*60;
			}
			Arrays.sort(times);
			for (int i = times.length - 1; i >= 0; i--){
				System.out.format("%02d:", times[i]/60/60);
				times[i] %= 60*60;
				System.out.format("%02d:%02d", times[i]/60, times[i]%60);
				if (i != 0)
					System.out.print(" ");
			}
			System.out.println();
		}
	}
}