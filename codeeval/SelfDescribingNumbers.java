import java.io.*;

public class SelfDescribingNumbers{
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null){
			line = line.trim();
			int[] counts = new int[10];
			char[] counts_char = line.toCharArray();
			int size = 0;
			for (char c : counts_char){
				int value = c - '0';
				counts[size++] += value;
				counts[value]--;
			}
			boolean flag = counts[0] == 0;
			for (int i = 1; i < 10;i++){
				flag = flag && counts[i] == 0;
			}
			System.out.println(flag?1:0);
		}
	}
}