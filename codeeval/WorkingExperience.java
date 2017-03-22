import java.io.*;
import java.util.*;

public class WorkingExperience{
	public static void main(String[] args) throws IOException{
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null){
			line = line.trim();
			String[] lines = line.split("; ");
			MyCalendar myCalendar = new MyCalendar();
			for (String period : lines){
				myCalendar.addPeriod(period);
			}
			System.out.println(myCalendar.getYears());
		}
	}
}

class MyCalendar{
	Set<DayUnit> calendar;
	String[] months = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
	MyCalendar(){
		this.calendar = new TreeSet<DayUnit>();
	}
	private int parseMonth(String monthStr){
		for (int i = 0; i < months.length; i++){
			if (monthStr.equals(months[i])) return i+1;
		}
		System.out.println("something wrong @ parseMonth(" + monthStr + ")");
		System.exit(0);
		return 0;
	}
	void addPeriod(String period){
		int startMonth, startYear, endMonth, endYear;
		String[] dates = period.trim().split(" |-");
		startMonth = parseMonth(dates[0]);
		startYear = Integer.valueOf(dates[1]);
		endMonth = parseMonth(dates[2]);
		endYear = Integer.valueOf(dates[3]);
		addTill(startMonth,startYear,endMonth,endYear);
	}
	void addTill(int startMonth, int startYear, int endMonth, int endYear){
		this.calendar.add(new DayUnit(startMonth,startYear));
		if (startMonth == endMonth && startYear == endYear) return;
		startMonth = startMonth%12 + 1;
		startYear += startMonth == 1 ? 1 : 0;
		addTill(startMonth, startYear, endMonth, endYear);
	}
	int getYears(){
		return this.calendar.size() / 12;
	}
}

class DayUnit implements Comparable<DayUnit>{
	int month, year;
	DayUnit(int month, int year){
		this.month = month;
		this.year = year;
	}
	public int compareTo(DayUnit obj){
		if (this.year < obj.year) return -1;
		else if (this.year > obj.year) return 1;
		else {
			return this.month < obj.month ? -1 : this.month > obj.month ? 1 : 0;
		}
	}
}