import java.util.ArrayList;

public class testObserver{
	private ArrayList<testSubject> subjects;
	
	public testObserver(){
		this.subjects = new ArrayList<testSubject>();
	}
	
	public void addSubject(testSubject subject){this.subjects.add(subject);}
	
	public void getMessages(){
		for (testSubject s : subjects){
			System.out.println(s.getMsg());
		}
	}
	
	public static void main(String[] args){
		testSubject subject1 = new testSubject("This is test 1.");
		testSubject subject2 = new testSubject("This is test 2.");
		testObserver observer = new testObserver();
		observer.addSubject(subject1);
		observer.addSubject(subject2);
		
		// check contents
		observer.getMessages();
		
		// change content
		subject1.setMsg("Test 1 has succeeded.");
		
		// check contents
		observer.getMessages();
	}
}