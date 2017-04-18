import java.io.*;
import java.util.*;

public class IP_Assignments{
	public static void main(String[] args){
		System.out.println("Welcome to IP_Assignments app");
		System.out.println();
		new appMgr();
	}
}

class appViewer{
	void show_help(String command, String explanation){
		System.out.format("%-10s%s\n",command, explanation);
	}
}

class appMgr{
	Scanner sc = new Scanner(System.in);
	appViewer viewer = new appViewer();
	// 
	
	appMgr(){
		String input = "";
		do{
			System.out.print(">> ");
			input = sc.nextLine().trim();
			if (input.isEmpty()) continue;
			boolean success = command(input);
			if (!success){
				System.out.println("invalid command");
			}
			System.out.println();
		} while (!input.equals("exit"));
	}
	
	boolean command(String input){
		// {root}
		// show, set, save, load
		String[] commands = input.split(" ");
		
		//show
		if (commands[0].equals("show")){
			return command_show(Arrays.copyOfRange(commands,1,commands.length));
		}
		//set
		else if (commands[0].equals("set")){
			return command_set(Arrays.copyOfRange(commands,1,commands.length));
		}
		//save
		else if (input.equals("save")){
			return command_save();
		}
		//load
		else if (input.equals("load")){
			return command_load();
		}
		//help
		else if (input.equals("help") || input.equals("?")){
			viewer.show_help("show","display data");
			viewer.show_help("set","change data");
			viewer.show_help("help/?","display help");
			viewer.show_help("exit","quit app");
			return true;
		}
		//exit
		else{
			return input.equals("exit");
		}
	}
	
	boolean command_show(String[] commands){
		
		return true;
	}
	
	boolean command_set(String[] commands){
		//empty
		if (commands.length == 0){
			commands = new String[1];
			commands[0] = "help";
		}
		if (commands.length == 1){
			//default
			if (commands[0].equals("default")){
				System.out.print("Set default settings? [yes/no]:");
				String input = sc.nextLine();
				if (input.equals("yes")){
					// default settings
				}
				return true;
			}
			//help
			else if (commands[0].equals("help") || commands[0].equals("?")){
				viewer.show_help("default","set all settings to default");
				viewer.show_help("help/?","display help");
				return true;
			}
		} else {
			//subnet
			if (commands[0].equals("subnet")){
				return setSubnet(Arrays.copyOfRange(commands,1,commands.length));
			}
		}
		return false;
	}
	
	boolean command_save(){
		return false;
	}
	
	boolean command_load(){
		return false;
	}
	
	boolean setSubnet(String[] commands){
		return false;
	}
}

class csvWriter{
	
}

class csvReader{
	
}

class IP extends IP_checker{
	private short[] ip_address;
	private String description;
	IP(String ip){
		this.ip_address = check_ip(ip.trim());
	}
	void set_description(String description){
		this.description = description;
	}
	short[] get_ip(){
		return this.ip_address;
	}
	String get_description(){
		return this.description;
	}
}

class Subnet extends IP_checker{
	private IP network_ID;
	private IP broadcast_ID;
	private short mask;
	Subnet(String subnet){
		String[] segments = subnet.trim().split("/");
		this.network_ID = new IP(segments[0]);
		this.mask = check_mask(segments[1]);
		this.broadcast_ID = calculate_broadcast();
	}
	
	private IP calculate_broadcast(){
		// calculate broadcast ID
		if (this.network_ID == null) return null;
		
	}
}

class IP_checker{
	short[] check_ip(String ip){
		short[] output = new short[4];
		String[] segments = ip.split("\\.");
		if (segments.length == 4){
			short i = 0;
			for (String segment : segments){
				int value = Integer.valueOf(segment);
				if (value >= 0 && value <= 255){
					output[i++] = Short.valueOf(segment);
				} else return null;
			}
		}
		return output;
	}
	short check_mask(String mask){
		int value = Integer.valueOf(mask);
		if (value < 0 || value > 32) return -1;
		return Short.valueOf(mask);
	}
}