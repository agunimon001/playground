import java.io.*;

public class Details{
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null){
			line = line.trim();
			String[] lines = line.split(",");
			int distance = lines[0].length();
			for (String row : lines){
				int X_index = row.lastIndexOf("X");
				int Y_index = row.indexOf("Y");
				if (X_index < Y_index){
					int rowDistance = Y_index - X_index - 1;
					if (rowDistance < distance)
						distance = rowDistance;
				}
			}
			System.out.println(distance);
		}
	}
}