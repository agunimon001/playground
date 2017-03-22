import java.io.*;

public class LettercasePercentageRatio{
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null){
			line = line.trim();
			int lower = 0, upper = 0, total = 0;
			for (char chr : line.toCharArray()){
				if (chr >= 'a' && chr <= 'z')
					lower++;
				else if (chr >= 'A' && chr <= 'Z')
					upper++;
				total++;
			}
			System.out.format("lowercase: %.2f uppercase: %.2f\n",lower*100.0/total,upper*100.0/total);
		}
	}
}