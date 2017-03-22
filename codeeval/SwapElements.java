import java.io.*;

public class SwapElements{
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null){
			line = line.trim();
			String[] data = line.split(":");
			String[] elements = data[0].trim().split(" ");
			String[] swapInfo = data[1].trim().split(", ");
			for (String swapEach : swapInfo){
				int swap1 = Integer.valueOf(swapEach.split("-")[0]);
				int swap2 = Integer.valueOf(swapEach.split("-")[1]);
				line = elements[swap1];
				elements[swap1] = elements[swap2];
				elements[swap2] = line;
			}
			line = "";
			for (String element : elements) line += (line.isEmpty() ? "" : " ") + element;
			System.out.println(line);
		}
	}
}