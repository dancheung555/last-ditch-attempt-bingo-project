import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

import java.awt.image.*;

public class BingoCreateMultiple extends JFrame {
	
	private static int winnerCount = 0;
	private static int cardCount = (int) BingoCardTextFrame.numberOfCardsUpdate();
	private static BufferedImage template;
	private BingoCard bc = new BingoCard();
	private int[][] arr;
	
	public BingoCreateMultiple(String framename) {
		super(framename);
		
		try {
            template = ImageIO.read(BingoPanel.class.getResource("/BingoTemplate.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		
//		System.out.println(cardCount);
		for(int i = 1; i <= cardCount; i++) {
			int randNum = bc.getSeed();
			Random rand = new Random(randNum);
			bc.setRandom(rand);
			bc.setID(i);
			BingoPanel bp = new BingoPanel();
			
			JFrame frame = new JFrame("Bingo Card #" + bc.getID());
			JPanel panel = new JPanel();
			System.out.println(bc.getID() + " " + randNum + " " + rand + " " + i);
			
			bc.generateBanks();
			bc.generateTiles();
			
			
			frame.setSize(1100, 900);
			
			
			frame.setVisible(true);
			panel.setVisible(true);
			
			arr = bc.getArr();
			for(int a = 0; a < 5; a++) {
				for(int b = 0; b < 5; b++) {
					System.out.print(arr[a][b] + " ");
				}
				System.out.println();
			}
			System.out.println();
		}
		
	}
	public static BufferedImage getTemplate() {
		return template;
	}
	
	public void paint(Graphics graphics) {
//		graphics.setColor(new Color(123, 234, 123));
		
		graphics.drawImage(template, 0, 0, null);
		Font font = new Font("Comic Sans", Font.PLAIN, 40);
		graphics.setFont(font);
		graphics.setColor(new Color(200, 0, 0));
		graphics.drawString("ID: "+bc.getID(), 750, 100);
		drawText(graphics);
		
		for(int row = 0; row < 5; row++) {
			for(int col = 0; col < 5; col++) {
				if(bc.isCrossedOff(row, col) && !(row == 2 && col == 2)) {
//					System.out.println("GOT!");
					graphics.setColor(new Color(255, 0, 0));
					graphics.drawString(arr[col][row]+"", row * 126 + 89, col * 129 + 227);
					graphics.setColor(new Color(0, 0, 255));
				} else {
					if(!(row == 2 && col == 2)) graphics.drawString(arr[col][row]+"", row * 126 + 89, col * 129 + 227);
				}
			}
		}
		if(bc.fiveInARow()) {
			System.out.println("NICE");
		}
		
	}
	
	
	
	public void drawText(Graphics numbers) {
		numbers.setColor(new Color(68, 96, 221));
		numbers.fillRect(780, 170, 290, 80);
		numbers.setColor(new Color(123, 234, 123));
		Font font = new Font("Comic Sans", Font.PLAIN, 30);
		numbers.setFont(font);
		numbers.drawString("Click anywhere", 800, 200);
		numbers.drawString("to get a Bingo Ball", 800, 230);
		
		font = new Font("Comic Sans", Font.PLAIN, 40);
		numbers.setFont(font);
		numbers.setColor(new Color(0, 0, 255));
		for (int row = 0; row < 5; row++) {
			for (int col = 0; col < 5; col++) {
				if(!(row == 2 && col == 2)) numbers.drawString(arr[col][row]+"", row * 126 + 89, col * 129 + 227);
			}
		}
	}

}