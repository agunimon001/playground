package WushuApp.Entity;

import java.util.ArrayList;

public class Participant{
	private String name;
	private final int tagNumber;
	private String gender;
	private Institute institute;
	private ArrayList<SegmentEntry> segmentEntryList;
	
	public Participant(String name, int tagNumber, String gender, Institute institute){
		this.name = name;
		this.tagNumber = tagNumber;
		gender = gender.toLowerCase();
		this.gender = (gender.equals("m") || gender.equals("male") || gender.equals("f") || gender.equals("female")) ? gender : "";
		this.institute = institute;
		this.segmentEntryList = new ArrayList<SegmentEntry>();
	}
	
	public void addSegmentEntry(SegmentEntry segmentEntry){
		if (!this.segmentEntryList.contains(segmentEntry)){
			this.segmentEntryList.add(segmentEntry);
		}
	}
	
	public String getName(){return this.name;}
	
	public int getTagNumber(){return this.tagNumber;}
	
	public String getGender(){return this.gender;}
	
	public Institute getInstitute(){return this.institute;}
	
	public SegmentEntry[] getSegmentEntryList(){return (SegmentEntry[]) segmentEntryList.toArray();}
	
	public void setName(String name){this.name = name;}
	
	public void setGender(String gender){this.gender = (gender.equals("m") || gender.equals("male") || gender.equals("f") || gender.equals("female")) ? gender : "";}
	
	public void setInstitute(Institute institute){this.institute = institute;}
	
	public static void main(String[] args){
		
	}
}