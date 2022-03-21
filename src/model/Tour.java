package model;

public class Tour extends AbstractPiece{

	public Tour(Couleur couleur_de_piece, Coord coord) {
		super(couleur_de_piece, coord);
	}
	
	public boolean isMoveOk(int xFinal, int yFinal) {
		boolean result = false;
		if(xFinal == this.getX() || yFinal == this.getY()){
			result=true;
		}
		return result;
	}
	
}
