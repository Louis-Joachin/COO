package model;

public class Pion extends AbstractPiece{

	public Pion(Couleur couleur, Coord coord) {
		super(couleur, coord);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isMoveOk(int xFinal, int yFinal) {
		boolean result = false;
		if(yFinal == this.getY()+1 && this.getCouleur()==Couleur.BLANC) {
			result = true;
		}
		if(yFinal == this.getY()-1 && this.getCouleur()==Couleur.NOIR) {
			result = true;
		}
		return result;
	}
	
}
