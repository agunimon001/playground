import java.io.*;

public class RacingChars{
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		int prev = 0, cur;
		while ((line = buffer.readLine()) != null){
			line = " " + line.trim() + " ";
			cur = line.indexOf("C");
			if (cur == -1) cur = line.indexOf("_");
			if (prev == 0) prev = cur;
			System.out.println((line.substring(0,cur) + (cur < prev ? "/" : cur > prev ? "\\" : "|") + line.substring(cur + 1)).trim());
			prev = cur;
		}
	}
}