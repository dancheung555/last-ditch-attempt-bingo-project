import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

import java.awt.image.*;

public class BingoCreateMultiple extends JFrame {
	
	private static int winnerCount = 0;
	private static int cardCount = (int) BingoCardTextFrame.numberOfCardsUpdate();
	Graphics graphics;
	BufferedImage template;
	
	public BingoCreateMultiple(String framename) {
		super(framename);
		
		try {
            template = ImageIO.read(BingoPanel.class.getResource("/BingoTemplate.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		
//		System.out.println(cardCount);
		for(int i = 1; i <= cardCount; i++) {
			BingoCard bc = new BingoCard();
			int randNum = bc.getSeed();
			Random rand = new Random(randNum);
			bc.setRandom(rand);
			bc.setID(i);
			BingoPanel bp = new BingoPanel();
			bp.paint(graphics);
			
			JFrame frame = new JFrame("Bingo Card #" + bc.getID());
			JPanel panel = new JPanel();
			System.out.println(bc.getID() + " " + randNum + " " + rand + " " + i);
			
			bc.generateBanks();
			bc.generateTiles();
			
			
			frame.setSize(1100, 900);
			
			
			frame.setVisible(true);
			panel.setVisible(true);
			
			int[][] arr = bc.getArr();
			for(int a = 0; a < 5; a++) {
				for(int b = 0; b < 5; b++) {
					System.out.print(arr[a][b] + " ");
				}
				System.out.println();
			}
			System.out.println();
		}
		
	}
	public BufferedImage getTemplate() {
		return template;
	}
	
	public void paint(Graphics g) {
		g.drawImage(getTemplate(), 0, 0, null);

	}

}