import java.io.*;

public class UniqueElements{
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null){
			line = line.trim();
			String[] values = line.split(",");
			int lastVal = 0;
			String sentence = "";
			for (String str : values){
				int val = Integer.parseInt(str);
				if (!sentence.isEmpty()){
					if (lastVal != val){
						lastVal = val;
						sentence += "," + val;
					}
				} else {
					lastVal = val;
					sentence += val;
				}
			}
			System.out.println(sentence);
		}
	}
}