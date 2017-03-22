import java.io.*;

public class FindTheHighestScore{
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null){
			String[] lines = line.trim().split("\\|");
			String[] players = new String[lines.length];
			for (int i = 0; i < players.length; i++){
				players[i] = lines[i].trim();
			}
			int[][] scores = new int[players.length][players[0].split(" ").length];
			for (int playerIndex = 0; playerIndex < players.length; playerIndex++){
				String[] playerScores = players[playerIndex].split(" ");
				for (int scoreIndex = 0; scoreIndex < playerScores.length; scoreIndex++){
					scores[playerIndex][scoreIndex] = Integer.valueOf(playerScores[scoreIndex]);
				}
			}
			int[] highestScores = new int[scores[0].length];
			boolean firstEntry = true;
			for (int[] player : scores){
				for (int scoreIndex = 0; scoreIndex < player.length; scoreIndex++){
					if (player[scoreIndex] > highestScores[scoreIndex] || firstEntry)
						highestScores[scoreIndex] = player[scoreIndex];
				}
				firstEntry = false;
			}
			for (int i = 0; i < scores[0].length; i++){
				if (i != 0)
					System.out.print(" ");
				System.out.print(highestScores[i]);
			}
			System.out.println();
		}
	}
}