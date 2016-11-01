import java.util.Scanner;

public class CommandConverter{
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		CommandConverter cc = new CommandConverter();
		String command;
		command = sc.nextLine();
		System.out.println(cc.convert(command));
	}
	
	public CommandConverter(){
		
	}
	
	public String convert(String command){
		String newCom = "";
		char prev = '\0';
		int count = 0;
		for (char c : command.toCharArray()){
			if (c == prev){
				count++;
			} else if (newCom.equals("")) {
				newCom += c;
				newCom += String.valueOf(count);
				newCom += ";";
				prev = c;
				count = 0;
			}
		}
		if (!newCom.equals("")){
			newCom += String.valueOf(count);
			newCom += ";";
		}
		return newCom;
	}
}