package mainPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainMenu extends JFrame {

	private JPanel contentPane;
	Style s = new Style();
	Color yell = Color.decode("#FFEA00");
	Color back = Color.decode("#424242");
	public MainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 668, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 674, 481);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		s.mdPanel(mainPanel, back);
		
		
		//Inventarios
		PaneButton pbInventarios = new PaneButton("Inventarios","views/storage.png",yell,back);
		pbInventarios.setBounds(24, 156, 155, 180);
		mainPanel.add(pbInventarios);
	}
}
