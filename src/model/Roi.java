package model;

public class Roi extends AbstractPiece{

	public Roi(Couleur couleur, Coord coord) {
		super(couleur, coord);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isMoveOk(int xFinal, int yFinal) {
		boolean result = false;
		if(xFinal < 0 || yFinal < 0) {
		}
		else if((xFinal == this.getX()+1 || xFinal == this.getX()-1 || xFinal == this.getX())
				&&(yFinal == this.getY()+1 || yFinal == this.getY()-1 || yFinal == this.getY())) {
			result = true;
		}
		return result;
	}
	
	
}
