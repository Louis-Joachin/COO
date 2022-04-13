package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import model.Coord;
import model.Couleur;
import model.Jeu;
import model.PieceIHM;
import model.observable.ChessGame;
import tools.ChessImageProvider;
import tools.ChessPiecePos;

public class ChessGameGUI extends JFrame implements MouseListener, MouseMotionListener, Observer {
  private JLayeredPane layeredPane;
  private JPanel chessBoard;
  private JLabel chessPiece;
  private int xAdjustment;
  private int yAdjustment;
 
  public ChessGameGUI(){
	  Dimension boardSize = new Dimension(600, 600);
 
	  //  Use a Layered Pane for this this application
	  layeredPane = new JLayeredPane();
	  getContentPane().add(layeredPane);
	  layeredPane.setPreferredSize(boardSize);
	  layeredPane.addMouseListener(this);
	  layeredPane.addMouseMotionListener(this);
	
	  //Add a chess board to the Layered Pane 
	 
	  chessBoard = new JPanel();
	  layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
	  chessBoard.setLayout( new GridLayout(8, 8) );
	  chessBoard.setPreferredSize( boardSize );
	  chessBoard.setBounds(0, 0, boardSize.width, boardSize.height);
	 
	  for (int i = 0; i < 64; i++) {
		  JPanel square = new JPanel( new BorderLayout() );
		  chessBoard.add( square );
	 
	  int row = (i / 8) % 2;
	  if (row == 0)
		  square.setBackground( i % 2 == 0 ? Color.black : Color.white );
	  else
		  square.setBackground( i % 2 == 0 ? Color.white : Color.black );
	  }
	  
	  //Add a few pieces to the board
	  
	  for (int i = 0; i < ChessPiecePos.values().length; i++) {
		  for(int j=0; j< ChessPiecePos.values()[i].coords.length;j++) {
			  int k = conversion(ChessPiecePos.values()[i].coords[j].x,ChessPiecePos.values()[i].coords[j].y);
			  JLabel piece = new JLabel( new ImageIcon(ChessImageProvider.getImageFile(ChessPiecePos.values()[i].nom,ChessPiecePos.values()[i].couleur)) );
			  JPanel panel = (JPanel)chessBoard.getComponent(k);
			  panel.add(piece);
		  }
	  }
  }
 
  public void mousePressed(MouseEvent e){
	  chessPiece = null;
	  Component c =  chessBoard.findComponentAt(e.getX(), e.getY());
	 
	  if (c instanceof JPanel) 
		  return;
	 
	  Point parentLocation = c.getParent().getLocation();
	  xAdjustment = parentLocation.x - e.getX();
	  yAdjustment = parentLocation.y - e.getY();
	  chessPiece = (JLabel)c;
	  chessPiece.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
	  chessPiece.setSize(chessPiece.getWidth(), chessPiece.getHeight());
	  layeredPane.add(chessPiece, JLayeredPane.DRAG_LAYER);
  }
 
  //Move the chess piece around
  
  public void mouseDragged(MouseEvent me) {
  if (chessPiece == null) return;
  chessPiece.setLocation(me.getX() + xAdjustment, me.getY() + yAdjustment);
  }
 
  //Drop the chess piece back onto the chess board
 
  public void mouseReleased(MouseEvent e) {
	  if(chessPiece == null) return;
 
	  chessPiece.setVisible(false);
	  Component c =  chessBoard.findComponentAt(e.getX(), e.getY());
	 
	  if (c instanceof JLabel){
		  Container parent = c.getParent();
		  parent.remove(0);
		  parent.add( chessPiece );
	  }
	  else {
		  Container parent = (Container)c;
		  parent.add( chessPiece );
	  }
	 
	  chessPiece.setVisible(true);
  }
  
  private int conversion(int x, int y) {
		return y*8+x;
	}
  
  public void mouseClicked(MouseEvent e) {
  
  }
  public void mouseMoved(MouseEvent e) {
 }
  public void mouseEntered(MouseEvent e){
  
  }
  public void mouseExited(MouseEvent e) {
  
  }
 
  public static void main(String[] args) {
	  ChessGameGUI chessGameGUI = new ChessGameGUI();
	  
	  chessGameGUI.setDefaultCloseOperation(DISPOSE_ON_CLOSE );
	  chessGameGUI.pack();
	  chessGameGUI.setResizable(true);
	  chessGameGUI.setLocationRelativeTo( null );
	  chessGameGUI.setVisible(true);
	  
	  ChessGame chessGame = new ChessGame();
	  chessGame.addObserver(chessGameGUI);
 }

@SuppressWarnings("unchecked")
@Override
public void update(Observable o, Object arg) {
	Iterator<PieceIHM> it = ((List<PieceIHM>) arg).listIterator();
	PieceIHM element = it.next();
	while(it.hasNext()){
		List<Coord> coords =  element.getList();
		
		
	}
}
}