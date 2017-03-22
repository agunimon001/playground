import java.io.*;

public class SlangFlavor{
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		boolean seconds = false;
		int choice = 0;
		String[] choices = {", yeah!", ", this is crazy, I tell ya.", ", can U believe this?",", eh?",", aw yea.",", yo.","? No way!",". Awesome!"};
		while ((line = buffer.readLine()) != null){
			String output = "";
			for (char c : line.toCharArray()){
				switch(c){
					case '.':
					case '!':
					case '?':
						if (seconds) {
							output += choices[choice];
							choice = (choice + 1) % choices.length;
						} else
							output += c;
						seconds = !seconds;
						break;
					default:
						output += c;
				}
			}
			System.out.println(output);
		}
	}
}