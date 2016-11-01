package WushuApp.Entity;

import java.util.ArrayList;

public class Segment{
	private String name;
	private final String id;
	private ArrayList<SegmentEntry> segmentEntryList;
	
	public Segment(String name, String id){
		this.name = name;
		this.id = id;
		this.segmentEntryList = new ArrayList<SegmentEntry>();
	}
	
	public void addSegmentEntry(SegmentEntry segmentEntry){
		if (!segmentEntryList.contains(segmentEntry)){
			segmentEntryList.add(segmentEntry);
		}
	}
	
	public String getName(){return this.name;}
	
	public String getId(){return this.id;}
	
	public SegmentEntry[] getSegmentEntryList(){
		return (SegmentEntry[]) segmentEntryList.toArray();
	}
	
	public void setName(String name){this.name = name;}
}