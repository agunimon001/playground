import java.io.*;

public class WordToDigit {
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null){
			line = line.trim();
			String[] lines = line.split(";");
			String result = "";
			for (String str : lines){
				if (str.equals("zero")) result += "0";
				else if (str.equals("one")) result += "1";
				else if (str.equals("two")) result += "2";
				else if (str.equals("three")) result += "3";
				else if (str.equals("four")) result += "4";
				else if (str.equals("five")) result += "5";
				else if (str.equals("six")) result += "6";
				else if (str.equals("seven")) result += "7";
				else if (str.equals("eight")) result += "8";
				else if (str.equals("nine")) result += "9";
			}
			System.out.println(result);
		}
	}
}