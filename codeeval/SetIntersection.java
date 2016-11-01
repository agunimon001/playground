import java.io.*;

public class SetIntersection{
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null){
			line = line.trim();
			String[] sets = line.split(";", 2);
			String[] set1 = sets[0].split(",");
			String[] set2 = sets[1].split(",");
			String sentence = "";
			for (String val1 : set1){
				for (String val2 : set2){
					if (val1.equals(val2)){
						if (!sentence.isEmpty()) sentence += ",";
						sentence += val1;
					}
				}
			}
			System.out.println(sentence);
		}
	}
}