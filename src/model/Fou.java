package model;

public class Fou extends AbstractPiece{

	public Fou(Couleur couleur, Coord coord) {
		super(couleur, coord);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isMoveOk(int xFinal, int yFinal) {
		boolean result = false;
		if(xFinal < 0 || yFinal < 0) {
			
		}
		if(Math.abs(xFinal-this.getX()) == Math.abs(yFinal-this.getY())) {
			result = true;
		}
		return result;
	}
	
}