import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class BingoCardPanelFrame extends JFrame implements ActionListener {
	private JLabel label1;
	private JButton button;
	private JTextField textField1;
	private Container win;
	
	public BingoCardPanelFrame(String framename) {
		super(framename);
		win = getContentPane();
		win.setLayout(null);
		
		BingoPanel screen2 = new BingoPanel();
		screen2.setSize(715, 863);
		win.add(screen2);
		
		JButton generator = new JButton("Generate");
		generator.setSize(200, 100);
		generator.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		generator.setLocation(800, 200);
		generator.addActionListener(this);
		generator.setVisible(true);
		win.add(generator);
		
		BingoCard x = new BingoCard();
		
		setSize(1100, 900);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
