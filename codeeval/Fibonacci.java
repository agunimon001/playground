import java.io.*;

public class Fibonacci{
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null){
			int n = Integer.parseInt(line.trim());
			int back2 = 0, back1 = 1, present = 0;
			if (n < 2) present += n;
			else {
				for (int i = 2; i <= n; i++){
					present = back2 + back1;
					back2 = back1;
					back1 = present;
				}
			}
			System.out.println(present);
		}
	}
}