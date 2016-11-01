class MDP{
	public static void main(String[] args){
		MDP mdp = new MDP();
	}
	MDP(){
		Arena arena = new Arena();
		arena.view();
	}
	
	class Arena{
		private final int length;
		private final int width;
		Position[][] position;
		//HexaGenerator hexaGenerator = new HexaGenerator();
		
		/*constructors*/
		Arena(){	// default: length = 20, width = 15
			this(20, 15);
		}
		Arena(int length){
			this(length, length);
		}
		Arena(int length, int width){
			this.length = length;
			this.width = width;
			this.position = new Position[length][width];
			init();
		}
		
		private void init(){
			for (int i = 0; i < this.length; i++){
				for (int j = 0; j < this.width; j++){
					this.position[i][j] = new Position();
				}
			}
		}
		
		void view(){
			System.out.println("x = unexplored, # = obstacle, o = empty space");
			for (int i = 0; i < length; i++){
				for (int j = 0; j < width; j++){
					System.out.print(!this.position[i][j].isExplored() ? "x" :
					this.position[i][j].isObstacle() ? "#" : "o");
				} System.out.println();
			}
			//hexaGenerator.mdpGen1(this.position, this.length, this.width);
		}
	}
	
	class HexaGenerator{
		String mdpGen1(Position[][] position, int length, int width){
			int size = length * width;
			/*Position[] position2 = new Position[size];
			int i = 0;
			for (int j = 0; j < length; j++){
				for (int k = 0; k < width; k++){
					position2[i] = position[j][k];
					i++;
				}
			}*/
			int i = 0;
			for (Position[] p1 : position){
				for (Position p2 : p1){
					System.out.println((i++) + " ");
				}
			}
			System.out.println("size = " + size);
			//return genMDP(position2, size);
			return null;
		}
		private String genMDP(Position[] position, int size){
			String output = "";
			int num;
			int padding = 8 - size % 8;
			
			num = 0;
			/*for (int i = padding / 2; i > 0; i--){
				int 
			}*/
			return null;
		}
	}
	
	class Position{
		private boolean explored;
		private boolean obstacle;
		Position(){
			this(false);
		}
		Position(boolean explored){
			this(explored, false);
		}
		Position(boolean explored, boolean obstacle){
			this.explored = explored;
			this.obstacle = obstacle;
		}
		
		//int getObstacleCount(){return obstacleCount;}
		
		boolean isExplored(){return explored;}
		boolean isObstacle(){return obstacle;}
		
		private void setExplored(){this.explored = true;}
		private void setObstacle(){this.obstacle = true;}
		//private void clearExplored(){this.explored = false;}
		//private void clearObstacle(){this.obstacle = false;}
	}
}