public class GridSearch extends Grid{
	private boolean discovered;
	private boolean obstacle;
	int discoverCount;
	GridSearch(){
		this(-1,-1);
	}
	GridSearch(int x, int y){
		this(x,y,false, false);
	}
	GridSearch(int x, int y, boolean discovered){
		this(x, y, discovered, false);
	}
	GridSearch(int x, int y, boolean discovered, boolean obstacle){
		super(x,y);
		this.discovered = discovered;
		this.obstacle = obstacle;
		this.discoverCount = 0;
	}
	/*grid(){
		this(false, false);
	}
	grid(boolean discovered){
		this(discovered, false);
	}
	grid(boolean discovered, boolean obstacle){
		this.discovered = discovered;
		this.obstacle = obstacle;
		this.discoverCount = 0;
	}*/
	void setDiscovered(){
		this.discovered = true;
	}
	void clearDiscovered(){
		this.discovered = false;
	}
	void setObstacle(){
		this.obstacle = true;
	}
	void clearObstacle(){
		this.obstacle = false;
	}
	boolean getDiscovered(){
		return this.discovered;
	}
	boolean getObstacle(){
		return this.obstacle;
	}
	void updateCount(int val){
		/*	val = 1 : increase count
			val = -1: decrease count
		*/
		this.discoverCount += val;
	}
	void resetCount(){
		this.discoverCount = 0;
	}
	int getCount(){
		return this.discoverCount;
	}
}