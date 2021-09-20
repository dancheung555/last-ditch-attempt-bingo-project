import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.*;


public class BingoCardPanelFrame extends JFrame {
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
		add(screen2);
		
		JButton generatorButton = new JButton("Generate");
		generatorButton.setLocation(800, 200);
		generatorButton.setSize(200, 100);
		generatorButton.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		generatorButton.addActionListener(e -> {
			System.out.println("AAAAAAAHHHHHHHHHHHHH");
		});
		
//		pack();
		
		setSize(1100, 900);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	

	
	
}
