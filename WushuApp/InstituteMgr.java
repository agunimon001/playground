package WushuApp.Controller;

import WushuApp.Entity.Institute;
import WushuApp.Entity.Participant;
import java.util.ArrayList;

public class InstituteMgr{
	private ArrayList<Institute> instituteList;
	
	public InstituteMgr(){
		this.instituteList = new ArrayList<Institute>();
	}
	
	public void addInstitute(String name, String initials){
		instituteList.add(new Institute(name, initials));
	}
	
	public Institute[] getInstituteList(){return (Institute[]) instituteList.toArray();}
	
	public 
}