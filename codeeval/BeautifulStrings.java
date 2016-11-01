import java.io.*;

public class BeautifulStrings{
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null){
			line = line.trim();
			char[] array = line.toLowerCase().toCharArray();
			int[] alphabets = new int[26];
			int largest = 0;
			for(char c : array) if (c >= 'a' && c <= 'z') {
				int index = c-'a';
				alphabets[index]++;
				if (alphabets[index] > largest) largest = alphabets[index];
			}
			int nextLargest = 0;
			int sum = 0;
			int toAdd = 26;
			while (toAdd > 0){
				for (int i = 0; i < 26; i++){
					if (alphabets[i] == largest){
						sum += alphabets[i] * toAdd;
						toAdd--;
					}
					if (alphabets[i] > nextLargest && alphabets[i] < largest) nextLargest = alphabets[i];
				}
				largest = nextLargest;
				nextLargest = 0;
			}
			System.out.println(sum);
		}
	}
}