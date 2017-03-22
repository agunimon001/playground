import java.io.*;
import java.util.Arrays;

public class MinimumDistance{
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		int sum = 0, totalDistance;
		while ((line = buffer.readLine()) != null){
			line = line.trim();
			String[] housesStr = line.substring(line.indexOf(" ")+1).split(" ");
			int[] houses = new int[housesStr.length];
			for (int i = 0; i < houses.length; i++){
				houses[i] = Integer.valueOf(housesStr[i]);
			}
			Arrays.sort(houses);
			int smallestAt = 0, distanceAtSmallest = 0;
			for (int i = 0; i < houses.length; i++){
				sum = 0;
				for (int house : houses){
					sum += Math.abs(house - houses[i]);
				}
				if (i == 0)
					distanceAtSmallest = sum;
				if (sum < distanceAtSmallest){
					smallestAt = i;
					distanceAtSmallest = sum;
				}
			}
			int leftHouse = houses[(smallestAt > 0 ? smallestAt-1 : 0)];
			int rightHouse = houses[(smallestAt < houses.length-1 ? smallestAt+1 : houses.length-1)];
			int myHouse = leftHouse;
			while (myHouse < rightHouse){
				sum = 0;
				for (int house : houses){
					sum += Math.abs(house - myHouse);
				}
				if (sum < distanceAtSmallest){
					smallestAt = myHouse;
					distanceAtSmallest = sum;
				}
				myHouse++;
			}
			System.out.println(distanceAtSmallest);
		}
	}
}