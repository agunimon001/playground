import java.util.Scanner;

public class Graph{
	Scanner sc = new Scanner(System.in);
	String[] node;
	float[][] edge;
	int size;
	float[] heuristic;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("size: ");
		Graph graph = new Graph(sc.nextInt());
		
		graph.view();
		
		System.out.print("nextNode: ");
		int[] arr = graph.nextNode(sc.next());
		for (int n : arr){
			System.out.println(graph.node[n]);
		}
	}
	
	public Graph(int size){
		this.node = new String[size];
		this.edge = new float[size][size];
		this.size = size;
		this.heuristic = new float[size];
		init();
	}
	
	private void init(){
		System.out.println("node names");
		for (int i = 0; i < this.size; i++){
			System.err.print((i+1) + ": ");
			if (i == 0){
				this.node[0] = sc.nextLine();
				continue;
			}
			String str = sc.nextLine();
			boolean duplicate = false;
			for (String str2 : this.node){
				if (str2 == null){
					break;
				}
				if (str2.equals(str)){
					System.err.println("duplicate detected");
					System.err.println("str = " + str);
					System.err.println("str2 = " + str2);
					duplicate = true;
					break;
				}
			}
			if (duplicate){
				i--;
				continue;
			}
			this.node[i] = str;
			//this.node[i] = sc.nextLine();
		}
		System.out.println();
		
		for (int i = 0; i < this.size; i++){
			this.heuristic[i] = 0;
			for (int j = 0; j < this.size; j++){
				if (i == j){
					this.edge[i][j] = 0;
				} else {
					this.edge[i][j] = -1;
				}
			}
		}
		
		System.err.println("from | to | weight (-1 to discontinue)\n");
		String s;
		while (!(s = sc.next()).equals("-1")){
			//String[] ss = s.split(" +");
			/*for (String d : ss){
				System.out.println(d);
			}*/
			int i = indexOf(/*ss[0]*/s);
			int j = indexOf(/*ss[1]*/sc.next());
			if (i == -1 || j == -1){
				System.err.println("error!");
				continue;
			}
			this.edge[i][j] = (float) Float.parseFloat(/*ss[2]*/sc.next());
		} System.out.println();
	}
	
	private int indexOf(String name){
		for (int i = 0; i < this.size; i++){
			if (this.node[i].equals(name)){
				return i;
			}
		}
		return -1;
	}
	
	public void view(){
		for (int i = 0; i < this.size; i++){
			System.out.printf(" %-5s", this.node[i]);
			for (int j = 0; j < this.size; j++){
				if (this.edge[i][j] == -1){
					System.out.print(" x   ");
				} else {
					System.out.printf("%5.2f", this.edge[i][j]);
				}
			}
			System.out.println();
		}
		System.out.println("Heuristic");
		for (int i = 0; i < this.size; i++){
			System.out.println(this.node[i] + " = " + this.heuristic[i]);
		}
	}
	
	public void addHeuristic(){
		for (int i = 0; i < this.size; i++){
			System.out.print(this.node[i] + ": ");
			this.heuristic[i] = sc.nextFloat();
		}
	}
	
	private int[] nextNode(int nodeIndex, int index){
		if (index == this.size){
			return new int[0];
		} else if (this.edge[nodeIndex][index] > 0){
			int[] arr = nextNode(nodeIndex, index + 1);
			int size = sizeOf(arr);
			int[] arr2 = new int[size + 1];
			for (int i = 0; i < size; i++){
				arr2[i] = arr[i];
			} arr2[size] = index;
			return arr2;
		} else {
			return nextNode(nodeIndex, index + 1);
		}
	}
	
	private int sizeOf(int[] arr){
		int size = 0;
		for (int n : arr){
			size++;
		}
		return size;
	}
	
	public int[] nextNode(String name){
		return nextNode(indexOf(name), 0);
	}
	
	public void aStar(){
		
	}
	
	private class Queue{
		
	}
}