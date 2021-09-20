import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

import java.awt.image.*;

public class BingoCreateMultiple extends JFrame {
	
	private static int winnerCount = 0;
	private static int cardCount = (int) BingoCardTextFrame.numberOfCardsUpdate();
	
	public BingoCreateMultiple(String framename) {
		super(framename);
		System.out.println(cardCount);
		for(int i = 1; i <= cardCount; i++) {
			BingoCard bc = new BingoCard();
			bc.setID(i);
			System.out.println(bc.getID());
			JPanel panel = new JPanel();
		}
		
	}

}
