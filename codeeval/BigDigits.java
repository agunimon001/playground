import java.io.*;
import java.util.Arrays;

public class BigDigits{
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null){
			line = line.trim();
			String[] output = new String[6];
			Arrays.fill(output,"");
			for (char chr : line.toCharArray()){
				if (chr >= '0' && chr <= '9')
					output[5] += "-----";
				switch(chr){
					case '0':	output[0] += "-**--";
								output[1] += "*--*-";
								output[2] += "*--*-";
								output[3] += "*--*-";
								output[4] += "-**--";
								break;
					case '1':	output[0] += "--*--";
								output[1] += "-**--";
								output[2] += "--*--";
								output[3] += "--*--";
								output[4] += "-***-";
								break;
					case '2':	output[0] += "***--";
								output[1] += "---*-";
								output[2] += "-**--";
								output[3] += "*----";
								output[4] += "****-";
								break;
					case '3':	output[0] += "***--";
								output[1] += "---*-";
								output[2] += "-**--";
								output[3] += "---*-";
								output[4] += "***--";
								break;
					case '4':	output[0] += "-*---";
								output[1] += "*--*-";
								output[2] += "****-";
								output[3] += "---*-";
								output[4] += "---*-";
								break;
					case '5':	output[0] += "****-";
								output[1] += "*----";
								output[2] += "***--";
								output[3] += "---*-";
								output[4] += "***--";
								break;
					case '6':	output[0] += "-**--";
								output[1] += "*----";
								output[2] += "***--";
								output[3] += "*--*-";
								output[4] += "-**--";
								break;
					case '7':	output[0] += "****-";
								output[1] += "---*-";
								output[2] += "--*--";
								output[3] += "-*---";
								output[4] += "-*---";
								break;
					case '8':	output[0] += "-**--";
								output[1] += "*--*-";
								output[2] += "-**--";
								output[3] += "*--*-";
								output[4] += "-**--";
								break;
					case '9':	output[0] += "-**--";
								output[1] += "*--*-";
								output[2] += "-***-";
								output[3] += "---*-";
								output[4] += "-**--";
								break;
				}
			}
			for (String str : output){
				System.out.println(str);
			}
		}
	}
}