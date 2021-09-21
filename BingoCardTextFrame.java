import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;

public class BingoCardTextFrame extends JFrame implements ActionListener {
	
	private JLabel label1, label2, label3, label4;
	private JButton button;
	private JTextField textField1, textField2, textField3, textField4;
	private Container win;
	private static int seed, numberOfCards, days, numberOfWinners;
	
	public BingoCardTextFrame(String framename) {
		super(framename);
		win = getContentPane();
		win.setLayout(null);
		
		
		label1 = new JLabel("Submit Seed:");
		label1.setSize(150, 20);
		label1.setLocation(20, 20);
		win.add(label1);
		
		label2 = new JLabel("Number of bingo cards:");
		label2.setSize(150, 20);
		label2.setLocation(20, 60);
		win.add(label2);
		
		label3 = new JLabel("Number of days:");
		label3.setSize(150, 20);
		label3.setLocation(20, 100);
		win.add(label3);
		
		label4 = new JLabel("Number of winners:");
		label4.setSize(150, 20);
		label4.setLocation(20, 140);
		win.add(label4);
		
		
		textField1 = new JTextField("", 10);
		textField1.setSize(150, 20);
		textField1.setLocation(20, 40);
		win.add(textField1);
		
		textField2 = new JTextField("", 10);
		textField2.setSize(150, 20);
		textField2.setLocation(20, 80);
		win.add(textField2);
		
		textField3 = new JTextField("", 10);
		textField3.setSize(150, 20);
		textField3.setLocation(20, 120);
		win.add(textField3);
		
		textField4 = new JTextField("", 10);
		textField4.setSize(150, 20);
		textField4.setLocation(20, 160);
		win.add(textField4);
		
		
		button = new JButton("Print Seed");
		button.setSize(150, 20);
		button.setLocation(240, 200);
		button.addActionListener(this);
		win.add(button);
		
		setSize(600, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public static int getSeed() {
		return seed;
	}
	public static long numberOfCardsUpdate() {
		return numberOfCards;
	}
	public static long daysUpdate() {
		return days;
	}
	public static long numberOfWinnersUpdate() {
		return numberOfWinners;
	}
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		String w = textField1.getText();
		String x = textField2.getText();
		String y = textField3.getText();
		String z = textField4.getText();
		
		
		try {
			seed = Integer.parseInt(w);
			numberOfCards = Integer.parseInt(x);
			days = Integer.parseInt(y);
			numberOfWinners = Integer.parseInt(z);
			
			BingoCardPanelFrame output = new BingoCardPanelFrame("Bingo Table");
			dispose();
			
		} catch (NumberFormatException ee) {
			System.out.println("Input is not string");
		}
		
//		System.out.println(w + " " + x + " " + y + " " + z);
	}
	
	
	
}