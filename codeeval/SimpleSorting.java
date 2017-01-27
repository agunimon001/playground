import java.io.*;

public class SimpleSorting{
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null){
			line = line.trim();
			String[] lines = line.split(" ");
			int size = lines.length;
			Float[] values = new Float[size];
			for (int i = 0; i < size; i++){
				values[i] = Float.valueOf(lines[i]);
			}
			// sort
			int ptr = 1;
			int next = 1;
			Float temp;
			while (ptr < size){
				if (values[ptr] >= values[ptr-1]){
					next = 1;
				} else {
					temp = values[ptr];
					values[ptr] = values[ptr-1];
					values[ptr-1] = temp;
					next = -1;
				}
				ptr += next;
				if (ptr < 1) ptr = 1;
			}
			// print
			for (int i = 0; i < size; i++){
				System.out.printf("%.3f", values[i]);
				System.out.print(i < size - 1 ? " " : "\n");
			}
		}
	}
}