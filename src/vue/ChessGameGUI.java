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
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import model.Coord;
import model.Couleur;
import tools.ChessImageProvider;

public class ChessGameGUI extends JFrame implements MouseListener, MouseMotionListener, Observer {
  JLayeredPane layeredPane;
  JPanel chessBoard;
  JLabel chessPiece;
  int xAdjustment;
  int yAdjustment;
 
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
	  int j=0;
	  while(j<64) {
		  if(j==0||j==7) {
			  JLabel piece = new JLabel( new ImageIcon(ChessImageProvider.getImageFile("Tour",Couleur.BLANC)) );
			  JPanel panel = (JPanel)chessBoard.getComponent(j);
			  panel.add(piece);
		  }
		  if(j==1||j==6) {
			  JLabel piece = new JLabel( new ImageIcon(ChessImageProvider.getImageFile("Cavalier",Couleur.BLANC)) );
			  JPanel panel = (JPanel)chessBoard.getComponent(j);
			  panel.add(piece);
		  }
		  if(j==2||j==5) {
			  JLabel piece = new JLabel( new ImageIcon(ChessImageProvider.getImageFile("Fou",Couleur.BLANC)) );
			  JPanel panel = (JPanel)chessBoard.getComponent(j);
			  panel.add(piece);
		  }
		  if(j==3) {
			  JLabel piece = new JLabel( new ImageIcon(ChessImageProvider.getImageFile("Reine",Couleur.BLANC)) );
			  JPanel panel = (JPanel)chessBoard.getComponent(j);
			  panel.add(piece);
		  }
		  if(j==4) {
			  JLabel piece = new JLabel( new ImageIcon(ChessImageProvider.getImageFile("Roi",Couleur.BLANC)) );
			  JPanel panel = (JPanel)chessBoard.getComponent(j);
			  panel.add(piece);
		  }
		  if(j>7&&j<16) {
			  JLabel piece = new JLabel( new ImageIcon(ChessImageProvider.getImageFile("Pion",Couleur.BLANC)) );
			  JPanel panel = (JPanel)chessBoard.getComponent(j);
			  panel.add(piece);
		  }
		  
		  
		  if(j>=48&&j<56) {
			  JLabel piece = new JLabel( new ImageIcon(ChessImageProvider.getImageFile("Pion",Couleur.NOIR)) );
			  JPanel panel = (JPanel)chessBoard.getComponent(j);
			  panel.add(piece);
		  }
		  if(j==56||j==63) {
			  JLabel piece = new JLabel( new ImageIcon(ChessImageProvider.getImageFile("Tour",Couleur.NOIR)) );
			  JPanel panel = (JPanel)chessBoard.getComponent(j);
			  panel.add(piece);
		  }
		  if(j==57||j==62) {
			  JLabel piece = new JLabel( new ImageIcon(ChessImageProvider.getImageFile("Cavalier",Couleur.NOIR)) );
			  JPanel panel = (JPanel)chessBoard.getComponent(j);
			  panel.add(piece);
		  }
		  if(j==58||j==61) {
			  JLabel piece = new JLabel( new ImageIcon(ChessImageProvider.getImageFile("Fou",Couleur.NOIR)) );
			  JPanel panel = (JPanel)chessBoard.getComponent(j);
			  panel.add(piece);
		  }
		  if(j==59) {
			  JLabel piece = new JLabel( new ImageIcon(ChessImageProvider.getImageFile("Roi",Couleur.NOIR)) );
			  JPanel panel = (JPanel)chessBoard.getComponent(j);
			  panel.add(piece);
		  }
		  if(j==60) {
			  JLabel piece = new JLabel( new ImageIcon(ChessImageProvider.getImageFile("Reine",Couleur.NOIR)) );
			  JPanel panel = (JPanel)chessBoard.getComponent(j);
			  panel.add(piece);
		  }
		  j++;
	  }
	  
	  
	  /**
	  JLabel piece = new JLabel(new ImageIcon("C:\\Users\\louis\\eclipse-workspace\\COO\\images\\pionBlancS.png") );
	  JPanel panel = (JPanel)chessBoard.getComponent(15);
	  panel.add(piece);
	  piece = new JLabel(new ImageIcon("C:\\Users\\louis\\eclipse-workspace\\COO\\images\\roiBlancS.png"));
	  panel = (JPanel)chessBoard.getComponent(16);
	  panel.add(piece);
	  piece = new JLabel(new ImageIcon("C:\\Users\\louis\\eclipse-workspace\\COO\\images\\cavalierBlancS.png"));
	  panel = (JPanel)chessBoard.getComponent(20);
	  panel.add(piece);
	  **/

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
 
  public void mouseClicked(MouseEvent e) {
  
  }
  public void mouseMoved(MouseEvent e) {
 }
  public void mouseEntered(MouseEvent e){
  
  }
  public void mouseExited(MouseEvent e) {
  
  }
 
  public static void main(String[] args) {
	  JFrame frame = new ChessGameGUI();
	  frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE );
	  frame.pack();
	  frame.setResizable(true);
	  frame.setLocationRelativeTo( null );
	  frame.setVisible(true);
 }

@Override
public void update(Observable o, Object arg) {
	// TODO Auto-generated method stub
	
}
}