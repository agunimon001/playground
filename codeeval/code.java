import java.io.*;

public class code {
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null){
			line = line.trim();
			String values[] = line.split(" ", 3);
			int X = Integer.parseInt(values[0]);
			int Y = Integer.parseInt(values[1]);
			int N = Integer.parseInt(values[2]);
			int Xval, Yval;
			line = "";
			for (int i = 1; i <= N; i++){
				if (i % X == 0) line += "F";
				if (i % Y == 0) line += "B";
				if (line.equals("")) line += i;
				else if (line.charAt(line.length()-1) == ' ') line += i;
				if (i != N) line += " ";
			}
			System.out.println(line);
		}
	}
}