import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Graph{
	Scanner sc = new Scanner(System.in);
	List<String> node;
	float[][] edge;
	int size;
	List<Float> heuristic;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("size: ");
		int size = sc.nextInt();
		Graph graph = new Graph(size);
		graph.view();
		graph.addHeurisitic();
		Integer[] arr = graph.nextNode("B");
		for (Integer n : arr){
			System.out.println("B to " + graph.node.get((int)n) + ": " + graph.getEdge("B", graph.node.get((int)n)));
		}
	}
	
	public Graph(int size){
		this.node = new ArrayList<String>();
		this.edge = new float[size][size];
		this.size = size;
		this.heuristic = new ArrayList<Float>();
		init();
	}
	
	private void init(){
		for (int i = 0; i < this.size; i++){
			System.out.print((i+1) + ": ");
			String str = sc.nextLine();
			if (this.node.contains(str)){
				System.err.println("Error! Duplicate detected.");
				i--;
				continue;
			}
			this.node.add(str);
		} System.out.println();
		
		for (int i = 0; i < this.size; i++){
			for (int j = 0; j < this.size; j++){
				this.edge[i][j] = (i == j) ? 0 : -1;
			}
		}
		
		System.err.println("from | to | weight (-1 to discontinue)\n");
		String s;
		while (!(s = sc.next()).equals("-1")){
			int i = this.node.indexOf(s);
			int j = this.node.indexOf(sc.next());
			if (i == -1 || j == -1){
				System.err.println("Error!");
				continue;
			}
			this.edge[i][j] = sc.nextFloat();
		} System.err.println();
	}
	
	public void view(){
		for (int i = 0; i < this.size; i++){
			System.err.printf(" %-5s", this.node.get(i));
			for (float j : this.edge[i]){
				if (j == -1){
					System.err.print(" x    ");
				} else {
					System.err.printf("%5.2f ", j);
				}
			}
			System.err.println();
		}
	}
	
	public void addHeurisitic(){
		for (String node : this.node){
			System.out.printf("%-5s: ", node);
			this.heuristic.add(sc.nextFloat());
		}
		
		// view
		/*for (int i = 0; i < this.size; i++){
			System.out.println (this.node.get(i) + " | " + this.heuristic.get(i));
		}
		System.out.println();*/
	}
	
	private Integer[] nextNode(String name){
		int index = this.node.indexOf(name);
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < this.size; i++){
			if (index == i){
				continue;
			}
			System.out.println(this.node.get(i) + " : " + this.edge[index][i]);
			if (this.edge[index][i] > 0){
				list.add(i);
			}
		}
		return list.toArray(new Integer[0]);
	}
	
	public float getEdge(String start, String end){
		return this.edge[this.node.indexOf(start)][this.node.indexOf(end)];
	}
	
	public List<String> aStar(String start, String goal){
		int s = this.node.indexOf(start);
		int g = this.node.indexOf(goal);
		float[] g_value = new float[this.size];
		float[] f_value = new float[this.size];
		List<int> queue = new ArrayList<int>();
		
	}
}