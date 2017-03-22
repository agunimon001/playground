import java.io.*;

public class ComparePoints{
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null){
			String[] lines = line.trim().split(" ");
			int horizontal = Integer.valueOf(lines[0]) - Integer.valueOf(lines[2]);
			int vertical = Integer.valueOf(lines[1]) - Integer.valueOf(lines[3]);
			line = "";
			if (vertical < 0)
				line += "N";
			else if (vertical > 0)
				line += "S";
			if (horizontal > 0)
				line += "W";
			else if (horizontal < 0)
				line += "E";
			if (line.isEmpty())
				line = "here";
			System.out.println(line);
		}
	}
}