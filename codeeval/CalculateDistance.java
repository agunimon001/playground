import java.io.*;
import java.lang.Math;

public class CalculateDistance {
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null){
			line = line.trim();
			boolean prev = false;
			String adjusted = "";
			for (char c : line.toCharArray()){
				boolean current = (c >= '0' && c <= '9') || c == '-';
				if (current) adjusted += String.valueOf(c);
				else if (prev && !current) adjusted += " ";
				prev = current;
			}
			String[] values = adjusted.trim().split(" ");
			int x_length = Integer.valueOf(values[0]) - Integer.valueOf(values[2]);
			int y_length = Integer.valueOf(values[1]) - Integer.valueOf(values[3]);
			int dist = (int) Math.pow(x_length*x_length + y_length*y_length, 0.5);
			System.out.println(dist);
		}
	}
}