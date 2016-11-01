package WushuApp.Entity;

public class Institute{
	private final String name;
	private final String initials;
	
	public Institute(String name, String initials){
		this.name = name;
		this.initials = initials;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getInitials(){
		return this.initials;
	}
	
	public static void main(String[] args){
		Institute institute;
		String name, initials;
		
		System.err.println("name = Nanyang Technological University");
		name = "Nanyang Technological University";
		
		System.err.println("initials = NTU");
		initials = "NTU";
		
		institute = new Institute(name, initials);
		System.err.println("\nobject created.\n");
		
		System.err.println("testing accessors.\n");
		
		System.err.println("getName() = " + institute.getName());
		System.err.println("getInitials() = " + institute.getInitials());
		
		System.err.println("\ntest ended.");
	}
}