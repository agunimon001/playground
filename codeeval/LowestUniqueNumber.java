import java.io.*;

public class LowestUniqueNumber {
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null){
			line = line.trim();
			String[] lines = line.split(" ");
			int size = lines.length;
			int[] count = new int[10];
			for (int i = 0; i < lines.length; i++){
				int data = Integer.valueOf(lines[i]) - 1;
				if (count[data] == 0){
					count[data] = i + 1;
				} else if (count[data] > 0){
					count[data] = -1;
				}
			}
			int unique = 0;
			for (int i : count){
				if (i > 0){
					unique = i;
					break;
				}
			}
			System.out.println(unique);
		}
	}
}