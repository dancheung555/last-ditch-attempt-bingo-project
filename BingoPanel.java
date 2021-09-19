import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.*;



public class BingoPanel extends JPanel implements KeyListener, MouseListener, ActionListener {
	
	private int[][] card;
	private Graphics g = null;
	private static long seed = BingoCardTextFrame.seedUpdate();
	private static long numberOfCards = BingoCardTextFrame.numberOfCardsUpdate();
	private static long days = BingoCardTextFrame.daysUpdate();
	private static long numberOfWinners = BingoCardTextFrame.numberOfWinnersUpdate();
	
	private BufferedImage template;
	
	
	Random random = new Random();
	
	public BingoPanel() {
		super();
		
		
		BingoCard x = new BingoCard();
		card = x.getArr();
		
		try {
            template = ImageIO.read(BingoPanel.class.getResource("/BingoTemplate.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		setVisible(true);
		setLayout(null);
		setSize(1100, 900);
		addMouseListener(this);
	}
	
	public void keyTyped(KeyEvent e) {}
	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
	

	@Override
	public void paint(Graphics graphics) {
		graphics.drawImage(template, 0, 0, null);
		drawText(graphics);
		for(int row = 0; row < 5; row++) {
			for(int col = 0; col < 5; col++) {
				if(BingoCard.isCrossedOff(row, col) && !(row == 2 && col == 2)) {
//					System.out.println("GOT!");
					graphics.setColor(new Color(255, 0, 0));
					graphics.drawString(card[col][row]+"", row * 126 + 89, col * 129 + 227);
					graphics.setColor(new Color(0, 0, 255));
				} else {
					if(!(row == 2 && col == 2)) graphics.drawString(card[col][row]+"", row * 126 + 89, col * 129 + 227);
				}
			}
		}
		if(BingoCard.fiveInARow()) {
			System.out.println("NICE");
		}
		
	}
	
	
	
	private void drawText(Graphics numbers) {
		
		Font font = new Font("Comic Sans", Font.PLAIN, 40);
		numbers.setFont(font);
		numbers.setColor(new Color(0, 0, 255));
		for (int row = 0; row < 5; row++) {
			for (int col = 0; col < 5; col++) {
				if(!(row == 2 && col == 2)) numbers.drawString(card[col][row]+"", row * 126 + 89, col * 129 + 227);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
