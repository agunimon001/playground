import java.io.*;

public class MatrixRotation{
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null){
			line = line.trim();
			String[] lines = line.split(" ");
			int size = (int) Math.sqrt(lines.length);
			for (int j = 0; j < size; j++){
				for (int i = size - 1; i >= 0; i--){
					System.out.print(lines[i*size+j]);
					if (!(i == 0 && j == size - 1)){
						System.out.print(" ");
					}
				}
			}
			System.out.println();
		}
	}
}