import java.io.*;

public class AgeDistribution{
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null){
			int age = Integer.valueOf(line.trim());
			if (age < 0)
				line = "This program is for humans";
			else if (age <= 2)
				line = "Still in Mama's arms";
			else if (age <= 4)
				line = "Preschool Maniac";
			else if (age <= 11)
				line = "Elementary school";
			else if (age <= 14)
				line = "Middle school";
			else if (age <= 18)
				line = "High school";
			else if (age <= 22)
				line = "College";
			else if (age <= 65)
				line = "Working for the man";
			else if (age <= 100)
				line = "The Golden Years";
			else
				line = "This program is for humans";
			System.out.println(line);
		}
	}
}