import java.io.*;

public class ReadMore{
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null){
			if (line.length() > 55){
				line = line.substring(0,40);
				int index = line.lastIndexOf(" ");
				if (index != -1)
					line = line.substring(0,index);
				line += "... <Read More>";
			}
			System.out.println(line);
		}
	}
}