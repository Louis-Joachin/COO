package model;

public abstract class AbstractPiece implements Pieces {
	private String name;
	private Couleur couleur;
	private Coord coord;
	
	public AbstractPiece(Couleur couleur, Coord coord) {
		this.couleur=couleur;
		this.coord=coord;
		this.name=this.getClass().getSimpleName()+' '+this.couleur;
	}
	
	public int getX() {
		return this.coord.x;
	}

	
	public int getY() {
		return this.coord.y;
	}

	
	public Couleur getCouleur() {
		return this.couleur;
	}

	
	public abstract boolean isMoveOk(int xFinal, int yFinal);

	
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

	
	public static void main(String[] args) {
		Pieces monFou = new Fou(Couleur.NOIR,new Coord(5,5));
		monFou.move(4, 6);
		System.out.println(monFou);
	}
}
