import java.io.*;

public class DeltaTime{
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null){
			line = line.trim();
			String[] lines = line.split(" |:");
			int time1, time2, diff;
			time1 = 60*60*Integer.valueOf(lines[0]) + 60*Integer.valueOf(lines[1]) + Integer.valueOf(lines[2]);
			time2 = 60*60*Integer.valueOf(lines[3]) + 60*Integer.valueOf(lines[4]) + Integer.valueOf(lines[5]);
			if (time1 < time2) time1 = -time1; else time2 = -time2;
			diff = time1 + time2;
			int hour, min, sec;
			hour = diff/60/60;
			diff -= hour*60*60;
			min = diff/60;
			sec = diff - min*60;
			System.out.format("%02d:%02d:%02d\n",hour,min,sec);
		}
	}
}