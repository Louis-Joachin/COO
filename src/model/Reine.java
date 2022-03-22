package model;

public class Reine extends AbstractPiece{

	public Reine(Couleur couleur, Coord coord) {
		super(couleur, coord);
		// TODO Auto-generated constructor stub
	}

	public boolean isMoveOk(int xFinal, int yFinal) {
		boolean result = false;
		if(xFinal < 0 || yFinal < 0) {
		}
		else if(Math.abs(xFinal-this.getX()) == Math.abs(yFinal-this.getY())) {
			result = true;
		}
		else if(xFinal == this.getX() || yFinal == this.getY()){
			result=true;
		}
		return result;
	}
	

}
