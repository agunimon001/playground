import java.io.*;
import java.util.*;

public class RoadTrip{
	public static void main(String[] args) throws IOException{
		new RoadTrip(args[0]);
	}
	
	public RoadTrip(String input) throws IOException{
		File file = new File(input);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		List<City> cities = new ArrayList<City>();
		while ((line = buffer.readLine()) != null){
			line = line.trim();
			String[] lines = line.split(";");
			cities.clear();
			for (String city : lines){
				String[] cityInfo = city.split(",");
				cities.add(new City(cityInfo[0].trim(),cityInfo[1].trim()));
			}
			Collections.sort(cities);
			int fuel = 0;
			String output = "";
			for (City city : cities){
				output += (output.isEmpty() ? "" : ",") + (city.distance - fuel);
				fuel = city.distance;
			}
			System.out.println(output);
		}
	}
	
	public class City implements Comparable<City>{
		public String name;
		public int distance;
		
		public City(String name, String distance){
			this.name = name;
			this.distance = Integer.valueOf(distance);
		}
		
		public int compareTo(City city){
			int value = this.distance - city.distance;
			return value > 0 ? 1 : value < 0 ? -1 : 0;
		}
	}
}