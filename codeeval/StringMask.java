import java.io.*;

public class StringMask{
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null){
			line = line.trim();
			char[] message = line.split(" ")[0].toCharArray();
			char[] mask = line.split(" ")[1].toCharArray();
			line = "";
			for (int i = 0; i < message.length; i++){
				if (mask[i] == '1')
					System.out.print(Character.toUpperCase(message[i]));
				else
					System.out.print(message[i]);
			}
			System.out.println();
		}
	}
}