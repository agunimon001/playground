import java.io.*;

public class RightmostChar{
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null){
			String[] lines = line.split(",");
			char compareChar = lines[1].charAt(0);
			int position = -1, index = 0;
			for (char testChar : lines[0].toCharArray()){
				if (testChar == compareChar){
					position = index;
				}
				index++;
			}
			System.out.println(position);
		}
	}
}