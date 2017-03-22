import java.io.*;

public class NiceAngles{
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null){
			float time = Float.valueOf(line.trim());
			float hour, minute, second;
			hour = (int) time;
			time -= (int) hour;
			time *= 60;
			minute = (int) time;
			time -= minute;
			time *= 60;
			second = (int) time;
			System.out.format("%.0f.%02.0f'%02.0f\"\n",hour,minute,second);
		}
	}
}