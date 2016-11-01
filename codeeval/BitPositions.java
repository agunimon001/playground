import java.io.*;

public class BitPositions{
	public static void main (String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null){
			line = line.trim();
			String[] numbers = line.split(",", 3);
			int n = Integer.parseInt(numbers[0]);
			int p1 = Integer.parseInt(numbers[1]);
			int p2 = Integer.parseInt(numbers[2]);
			String n_bin = Integer.toBinaryString(n);
			int p1_bin = p1 > n_bin.length() ? 0 : n_bin.charAt(n_bin.length()-p1) - '0';
			int p2_bin = p2 > n_bin.length() ? 0 : n_bin.charAt(n_bin.length()-p2) - '0';
			System.err.println("n = " + n);
			System.err.println("p1 = " + p1);
			System.err.println("p2 = " + p2);
			System.err.println("n_bin = " + n_bin);
			System.err.println("p1_bin = " + p1_bin);
			System.err.println("p2_bin = " + p2_bin);
			System.out.println(p1_bin == p2_bin ? "true" : "false");
		}
	}
}