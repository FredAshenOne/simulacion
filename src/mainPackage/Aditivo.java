package mainPackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Aditivo extends JFrame {

	Style s = new Style();
	MdHeader pnHeader;
	
	
	private JPanel contentPane;
	
	public Aditivo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 999, 677);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 11, 1002, 657);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		s.mdPanel(mainPanel, s.black);
		
		//Header
		pnHeader = new MdHeader(s.yell,s.black); 
		pnHeader.setBounds(0, 0, 992, 104);
		pnHeader.btnBack.setVisible(false);
		pnHeader.btnNext.setVisible(false);
		pnHeader.lblTitle.setText("Congruencial Aditivo");
		pnHeader.lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
		pnHeader.lblTitle.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 30));
		mainPanel.add(pnHeader);
		//Opciones Menus
	}

}
