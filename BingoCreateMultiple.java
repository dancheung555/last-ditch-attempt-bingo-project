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
//		System.out.println(cardCount);
		for(int i = 1; i <= cardCount; i++) {
			BingoCard bc = new BingoCard();
			int randNum = bc.getSeed();
			Random rand = new Random(randNum);
			bc.setRandom(rand);
			bc.setID(i);
			System.out.println(bc.getID() + " " + randNum + " " + rand);
			
			BingoCardPanelFrame bcpf = new BingoCardPanelFrame("Bingo Card #" + bc.getID());
			
			
			
			
			int[][] arr = bc.getArr();
			for(int a = 0; a < 5; a++) {
				for(int b = 0; b < 5; b++) {
					System.out.print(arr[a][b] + " ");
				}
				System.out.println();
			}
			
			JPanel panel = new JPanel();
			
		}
		
	}

}