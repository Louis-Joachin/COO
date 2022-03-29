package model;

public class Cavalier extends AbstractPiece{

	public Cavalier(Couleur couleur, Coord coord) {
		super(couleur, coord);
	}

	@Override
	public boolean isMoveOk(int xFinal, int yFinal) {
		boolean result = false;
		if(xFinal < 0 || yFinal < 0) {
		}
		if((xFinal == this.getX()+1 && yFinal == this.getY()+2) || (xFinal == this.getX()+1 && yFinal == this.getY()-2)
				|| (xFinal == this.getX()-1 && yFinal == this.getY()+2) || (xFinal == this.getX()-1 && yFinal == this.getY()-2)
				|| (xFinal == this.getX()+2 && yFinal == this.getY()+1) || (xFinal == this.getX()+2 && yFinal == this.getY()-1)
				|| (xFinal == this.getX()-2 && yFinal == this.getY()+1) || (xFinal == this.getX()-2 && yFinal == this.getY()-1)) {
			result = true;
		}
		return result;
	}

}
