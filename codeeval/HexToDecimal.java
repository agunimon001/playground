import java.io.*;

public class HexToDecimal{
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null){
			line = line.trim();
			char[] hex_array = line.toCharArray();
			int size = line.length();
			int hexMultiple = 1;
			int value = 0;
			for (int i = 0; i < size; i++){
				char hex = hex_array[size-1-i];
				int decimal = 0;
				if (hex >= '0' && hex <= '9') decimal = hex - '0';
				else if (hex >= 'a' && hex <= 'f') decimal = hex - 'a' + 10;
				value += decimal * hexMultiple;
				hexMultiple *= 16;
			}
			System.out.println(value);
		}
	}
}