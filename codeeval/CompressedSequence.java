import java.io.*;

public class CompressedSequence{
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null){
			line = line.trim();
			String[] elements = line.split(" ");
			int count = 1;
			String prev = "", output = "";
			for (String element : elements){
				if (element.equals(prev))
					count++;
				else {
					if (!prev.isEmpty())
						output += (output.isEmpty() ? "" : " ") + count + " " + prev;
					prev = element;
					count = 1;
				}
			}
			if (!prev.isEmpty())
				output += (output.isEmpty() ? "" : " ") + count + " " + prev;
			System.out.println(output);
		}
	}
}