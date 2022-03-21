package model;

public abstract class AbstractPiece implements Pieces {
	private String name;
	private Couleur couleur;
	private Coord coord;
	
	public AbstractPiece(Couleur couleur, Coord coord) {
		this.couleur=couleur;
		this.coord=coord;
	}
	@Override
	public int getX() {
		return this.coord.x;
	}

	@Override
	public int getY() {
		return this.coord.y;
	}

	@Override
	public Couleur getCouleur() {
		return this.couleur;
	}

	@Override
	public abstract boolean isMoveOk(int xFinal, int yFinal);

	@Override
	public boolean move(int xFinal, int yFinal) {
		boolean result=false;
		if(this.isMoveOk(xFinal, yFinal)) {
			this.coord.x=xFinal;
			this.coord.y=yFinal;
			result=true;
		}
		return result;
	}

	@Override
	public boolean capture() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public String toString() {
		return this.name+" : "+this.coord.toString();
		}

}
