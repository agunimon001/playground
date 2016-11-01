import java.util.Scanner;

public class Queens {
	public static void main(String []args){
		Queens q = new Queens();
	}
	
	public Queens(){
		Board board;
		
		Scanner sc = new Scanner(System.in);
		int choice;
		
		System.out.println("Welcome to the Queens program");
		System.out.println("1. Create board");
		System.out.println("2. Clear board");
		System.out.println("0. Exit");
		System.out.print("Enter choice: ");
		
		choice = sc.nextInt();
		
		do {
			switch(choice){
				case 1:
					System.out.print("Please enter size: ");
					int size = sc.nextInt();
					board = new Board(size);
				case 2:
				default: System.out.println("ERROR! Choice is invalid!");
			}
			
		} while (choice != 0);
	}
	
	class Board{
		private Piece[][] pieces;
		private int size;
		
		Board(int size){
			this.size = size;
			this.pieces = new Piece[size][size];
			init(this.pieces, this.size);
		}
		
		void search(){
			search(0);
		}
		
		boolean search(int depth){
			// backtracking
			if (depth == this.size) return true;
			for (int i = 0; i < this.size; i++){
				if (!this.checkPiece(depth, i)){
					this.setPiece(depth, i);
					if (search(depth+1)){
						return true;
					} else this.clearPiece(depth, i);
				}
			}
			return false;
		}
		
		void clearBoard(){
			for (Piece[] p1 : this.pieces){
				for (Piece p2 : p1){
					p2.clear();
				}
			}
		}
		
		boolean checkPiece(int x, int y){
			// check x
			for (int i = 0; i < this.size; i++){
				if ((this.pieces[i][y].getState() && i != x) || 
				(this.pieces[x][i].getState() && i != y)){
					return true;
				} else{
					if (x - i >= 0){
						if (y - i >= 0)
							if (this.pieces[x-i][y-i].getState()) return true;
						if (y + i < this.size)
							if (this.pieces[x-i][y+i].getState()) return true;
					}
					if (x + i < this.size){
						if (y - i >= 0)
							if (this.pieces[x+i][y-i].getState()) return true;
						if (y + i < this.size)
							if (this.pieces[x+i][y+i].getState()) return true;
					}
				}
			}
			return false;
		}
		
		void setPiece(int x, int y){
			this.pieces[x][y].set();
		}
		
		void clearPiece(int x, int y){
			this.pieces[x][y].clear();
		}
		
		void init(Piece[][] pieces, int size){
			for (int i = 0; i < size; i++){
				for (int j = 0; j < size; j++){
					pieces[i][j] = new Piece();
				}
			}
		}
		public void view(){
			for (int i = size; i > 0; i = i / 10){
				System.out.print(" ");
			} System.out.print(" ");
			for (int i = 0; i < size; i++){
				System.out.print(i + " ");
			} System.out.println();
			
			for (int i = 0; i < this.size; i++){
				System.out.print(i + " ");
				for (int j = 0; j < this.size; j++){
					System.out.print(this.pieces[i][j].getState() ? "Q" : "*");
					if (j != this.size - 1) System.out.print("|");
				}
				System.out.println();
			}
		}
	}
	
	class Piece{
		// state (0 = blank, 1 = queen)
		private boolean state;
		
		Piece(){
			state = false;
		}
		
		boolean getState(){return this.state;}
		
		private void set(){this.state = true;}
		private void clear(){this.state = false;}
	}
}