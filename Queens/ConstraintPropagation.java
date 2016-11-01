public class ConstraintPropagation{
	public static void main(String[] args){
		new ConstraintPropagation();
	}
	public ConstraintPropagation(){
		Board board = new Board();
		board.viewBoard();
	}
}

class Board{
	Piece[][] pieces;
	Board(){
		this.pieces = new Piece[8][8];
		for (int i = 0; i < 8; i++){
			for (int j = 0; j < 8; j++){
				this.pieces[i][j] = new Piece();
			}
		}
	}
	void viewBoard(){
		System.out.println();
		for (Piece[] row : pieces){
			for (Piece piece : row){
				if (piece.getPropagation()) System.out.print("x ");
				else if (piece.getSet()) System.out.print("Q ");
				else System.out.print("- ");
			}
			System.out.println();
		}
	}
	Board setAndPropagate(int i, int j){
		// check to see if can set Queen
		if (!pieces[i][j].isFree()) return null;
		
		// space is free, continue
		Board nextBoard = this.clone();
		nextBoard.
	}
}

class Piece{
	boolean set;
	boolean propagation;
	Piece(){
		this.set = false;
		this.propagation = false;
	}
	void set(){if (!this.propagation)this.set = true;}
	void clear(){this.set = false;}
	void propagation(){this.propagation = true;this.set = false;}
	void clearPropagation(){this.propagation = false;}
	boolean getSet(){return this.set;}
	boolean getPropagation(){return this.propagation;}
	boolean isFree(){return !this.set && !this.propagation;}
}