package model;

import java.util.LinkedList;
import java.util.List;

public class Echiquier implements BoardGames {
	private Jeu current;
	private Jeu notCurrent;
	public String message;

	public Echiquier() {
		notCurrent= new Jeu(Couleur.NOIR);
		current = new Jeu(Couleur.BLANC);
	}

	public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
		boolean result = false;
		if(this.isMoveOk(xInit, yInit, xFinal, yFinal))
			if(this.notCurrent.isPieceHere(xFinal, yFinal)) {
				//this.notCurrent.capture(xFinal, yFinal); TODO
			}
			this.current.move(xInit, yInit, xFinal, yFinal);
		return result;
	}
	
	public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal) {
		boolean result = false;
		if(this.current.isPieceHere(xInit, yInit)) {
			result = false;
		}
		else if(xFinal>7 || xFinal<0 || yFinal >7 || yFinal <0
				||xFinal == xInit || yFinal == yInit) {
			result=false;
		}
		else if(this.current.isMoveOk(xInit, yInit, xFinal, yFinal)==false) {
			result = false;
		}
		//TODO pieces intermerdiaires
		else if(this.current.isPieceHere(xFinal, yFinal)) {
			result = false;
			//TODO Roque du roi
		}
		else if(this.notCurrent.isPieceHere(xFinal, yFinal)) {
			result = true;
		}
		else {
			result = true;
		}
		return result;
	}

	@Override
	public boolean isEnd() {
		// TODO Auto-generated method stub
		return false;
	}
	public void switchJoueur() {
		Jeu jeu = this.notCurrent;
		this.notCurrent=this.current;
		this.current=jeu;
	}

	@Override
	public Couleur getColorCurrentPlayer() {
		return this.current.getColor();
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
		return this.current.toString()+'\n'+this.notCurrent.toString();
		
	}
	
	public List<PieceIHM> getPiecesIHM(){
		List<PieceIHM> result = new LinkedList<PieceIHM>();
		result.addAll(this.current.getPiecesIHM());
		result.addAll(this.notCurrent.getPiecesIHM());
		return result;
	}
	public static void main(String[] args) {
		Echiquier monEchiquier = new Echiquier();
		System.out.println(monEchiquier.getPiecesIHM());
	}
	
}
