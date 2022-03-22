package model;

public class Echiquier implements BoardGames {
	Jeu current;
	Jeu JeuNoir;
	Jeu JeuBlanc;
	String message;


	public Echiquier() {
		JeuNoir= new Jeu(Couleur.NOIR);
		JeuBlanc = new Jeu(Couleur.BLANC);	
		current=JeuBlanc;
	}

	@Override
	public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnd() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Couleur getColorCurrentPlayer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Couleur getPieceColor(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public String toString() {
		return JeuNoir.toString()+'\n'+JeuBlanc.toString();
		
	}
	
	public static void main(String[] args) {
		Echiquier monEchiquier = new Echiquier();
		System.out.println(monEchiquier);
	}
}
