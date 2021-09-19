import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.*;


public class BingoCardPanelFrame extends JFrame implements MouseListener {
	private JLabel label1;
	private JButton button;
	private JTextField textField1;
	private Container win;
	private int[][] bingoArr = new int[5][5];
	
	private BallGenerator gen;
	
	public BingoCardPanelFrame(String framename) {
		super(framename);
		win = getContentPane();
		JPanel panel = new JPanel();
		win.setLayout(null);
		
		gen = new BallGenerator();
		
		BingoPanel screen2 = new BingoPanel();
		screen2.setSize(715, 863);
		win.add(screen2);
		
		JButton generator = new JButton("Generate");
		generator.setSize(200, 100);
		generator.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		generator.setLocation(800, 200);
		generator.addMouseListener(this);
		generator.setVisible(true);
		
		
		
		
		win.add(generator);
		
		BingoCard x = new BingoCard();
		
		setSize(1100, 900);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {
		System.out.println("Hello");
		
		bingoArr = BingoCard.getBingoNumbers();
		
		int num = gen.getNextRandomNumber();
		System.out.println(num);
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(bingoArr[i][j] == num) {
					BingoCard.setCrossedOff(i, j);
				}
				
			}
		}
		if(BingoCard.fiveInARow()) {
			System.out.println(BingoCard.fiveInARow());
		}
	}
	
}
