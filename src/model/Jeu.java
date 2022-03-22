package model;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import tools.ChessPiecesFactory;

public class Jeu {
	private List<Pieces> liste;
	private Couleur couleur;
	public Jeu(Couleur couleur){
		liste = ChessPiecesFactory.newPieces(couleur);
		this.couleur = couleur;
	}
	
	private Pieces findPiece(int x, int y) {
		Pieces result = null;
		ListIterator<Pieces> it = liste.listIterator();
		while(it.hasNext()) {
			Pieces piece = it.next();
			if(piece.getX()==x && piece.getY()==y) {
				result = piece;
			}
		}
		return result;
	}
	public boolean isPieceHere(int x, int y) {
		boolean result = false;
		if(this.findPiece(x, y)!=null) {
			result = true;
		}
		return result;		
	}
	public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal) {
		boolean result = false;
		Pieces piece = this.findPiece(xFinal, yFinal);
		if(this.isPieceHere(xInit, yInit) && piece.isMoveOk(xFinal, yFinal)) {
			result = true;
		}
		return result;
	}
	
	public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
		boolean result = false;
		if(this.isMoveOk(xInit, yInit, xFinal, yFinal)) {
			Pieces piece = this.findPiece(xInit, yInit);
			result=piece.move(xFinal, yFinal);
		}
		return result;
	}
	
	public void setPossibleCapture() {
		
	}
	
	public boolean capture(int xCatch, int yCatch) {
		return false;
	}
	
	public String toString() {
		return this.liste.toString();
	}
	
	public Couleur getPieceColor(int x, int y) {
		Couleur result = null;
		if(this.isPieceHere(x, y)) {
			Pieces piece = this.findPiece(x, y);
			result = piece.getCouleur();	
		}
		return result;
	}
	
	public Couleur getColor() {
		return this.couleur;
	}
	
	/**
	 * @return une vue de la liste des pièces en cours
	 * ne donnant que des accès en lecture sur des PieceIHM
	 * (type piece + couleur + liste de coordonnées)
	 */
	public List<PieceIHM> getPiecesIHM(){
		 PieceIHM newPieceIHM = null;
		 List<PieceIHM> list = new LinkedList<PieceIHM>();
	
		 for (Pieces piece : liste){
			 boolean existe = false;
		 // si le type de piece existe déjà dans la liste de PieceIHM
		 // ajout des coordonnées de la pièce dans la liste de Coord de ce type
		 // si elle est toujours en jeu (x et y != -1)
			 for ( PieceIHM pieceIHM : list){
				 	if ((pieceIHM.getTypePiece()).equals(piece.getClass().getSimpleName())){
				 		existe = true;
				 		if (piece.getX() != -1){
				 			pieceIHM.add(new Coord(piece.getX(), piece.getY()));
				 		}
				 	}
			 }
		 // sinon, création d'une nouvelle PieceIHM si la pièce est toujours en jeu
			 if (! existe) {
				 if (piece.getX() != -1){
					 newPieceIHM = new PieceIHM(piece.getClass().getSimpleName(),
					 piece.getCouleur());
					 newPieceIHM.add(new Coord(piece.getX(), piece.getY()));
					 list.add(newPieceIHM);
				 	}
			 }
		 }
		 return list;
	 } 
	
	public static void main(String[] args) {
		Jeu monJeu = new Jeu(Couleur.BLANC);
		Pieces piece = monJeu.findPiece(0, 7);
		boolean move = monJeu.isMoveOk(0,7,5,6);
		System.out.println(monJeu.getPiecesIHM());
		
	}
}
