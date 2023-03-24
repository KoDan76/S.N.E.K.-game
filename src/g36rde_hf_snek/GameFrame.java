package g36rde_hf_snek;

import java.awt.*;
import javax.swing.*;
import javax.swing.JPanel;

public  class GameFrame extends JFrame {
	private JPanel mainPanel;
	private OptionsPanel optPanel = new OptionsPanel();
	
	GameFrame(){		
		mainPanel = new JPanel();
		mainPanel.setPreferredSize(new Dimension(900, 600));
		JButton bPlay = new JButton("PLAY");
		mainPanel.add(bPlay);
		JButton bOpt = new JButton("OPTIONS");
		mainPanel.add(bOpt);
		JButton bExit = new JButton("EXIT");
		mainPanel.add(bExit);
		add(mainPanel);
		
		add(new GamePanel(new SnekOptions()));
		setTitle("S.N.E.K.");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
	}
}