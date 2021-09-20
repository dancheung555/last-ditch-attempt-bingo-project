import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*; 



public class BingoCreateMultiple extends JFrame {
	
	private static int winnerCount = 0;
	private static int cardCount = (int) BingoCardTextFrame.numberOfCardsUpdate();
	
	public BingoCreateMultiple(String framename) {
		super(framename);
		for(int i = 0; i < cardCount; i++) {
			BingoCard bc = new BingoCard();
			bc.setID(i);
			JPanel panel = new JPanel();
			
		}
		
	}

}

