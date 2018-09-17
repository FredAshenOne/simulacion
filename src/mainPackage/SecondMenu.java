package mainPackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class SecondMenu extends JFrame implements ActionListener{
	Style s = new Style();
	Distribucion dis = new Distribucion(); 
	private JPanel contentPane;
	MdHeader pnHeader;
	PaneButton pbDistribucion;
	
	public SecondMenu() {
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
		pnHeader.btnNext.setVisible(false);
		
		pnHeader.lblTitle.setText("Simulación");
		pnHeader.lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
		pnHeader.lblTitle.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 30));
		mainPanel.add(pnHeader);
		//Opciones Menus
		
		pbDistribucion = new PaneButton("Distribucion","views/distribucion.png",s.yell,s.black);
		pbDistribucion.setBounds(23, 203, 155, 180);
		mainPanel.add(pbDistribucion);
		pbDistribucion.btn.addActionListener(this);
		dis.pnHeader.btnBack.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == pbDistribucion.btn) {
			dis.setVisible(true);
			this.setVisible(false);
		}else if(e.getSource() == dis.pnHeader.btnBack) {
			this.setVisible(true);
			dis.setVisible(false);
		}
		
	}
}
