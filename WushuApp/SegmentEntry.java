package WushuApp.Entity;

public class SegmentEntry{
	private final Participant participant;
	private final String description;
	private final Segment segment;
	private float score;
	private float secondaryScore;
	private String remark;
	
	public SegmentEntry(Participant participant, String description, Segment segment){
		this.participant = participant;
		this.description = description;
		this.segment = segment;
		segment.addSegmentEntry(this);
		this.score = 0;
		this.secondaryScore = 0;
		this.remark = "";
		participant.addSegmentEntry(this);
		segment.addSegmentEntry(this);
	}
	
	public Participant getParticipant(){return this.participant;}
	
	public String getDescription(){return this.description;}
	
	public Segment getSegment(){return this.segment;}
	
	public float getScore(){return this.score;}
	
	public float getSecondaryScore(){return this.secondaryScore;}
	
	public String getRemark(){return this.remark;}
	
	public void setScore(float value){this.score = value;}
	
	public void setScore(double value){this.score = (float) value;}
	
	public void setSecondaryScore(float value){this.score = value;}
	
	public void setSecondaryScore(double value){this.score = (float) value;}
	
	public void setRemark(String remark){this.remark = remark;}
}