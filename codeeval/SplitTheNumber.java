import java.io.*;

public class SplitTheNumber{
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		char[] alphabets = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		int[] values = new int[alphabets.length];
		while ((line = buffer.readLine()) != null){
			line = line.trim();
			String[] lines = line.split(" ");
			String sign = lines[1].contains("+") ? "\\+" : lines[1].contains("-") ? "-" : "";
			String LHS = lines[0].trim();
			lines = lines[1].trim().split(sign);
			String RHS = lines[0] + lines[1];
			for (int i = 0; i < LHS.length(); i++){
				values[RHS.charAt(i) - 'a'] = LHS.charAt(i) - '0';
			}
			int LHSValue = 0, RHSValue = 0, index = 0;
			if (!lines[0].isEmpty()){
				for (char element : lines[0].toCharArray()){
					LHSValue = LHSValue * 10 + values[element - 'a'];
				}
			}
			if (!lines[1].isEmpty()){
				for (char element : lines[1].toCharArray()){
					RHSValue = RHSValue * 10 + values[element - 'a'];
				}
			}
			if (sign.contains("+"))
				System.out.println(LHSValue + RHSValue);
			if (sign.contains("-"))
				System.out.println(LHSValue - RHSValue);
		}
	}
}