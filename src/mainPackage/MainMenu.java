package mainPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MainMenu extends JFrame implements ActionListener{

	private JPanel contentPane;
	Style s = new Style();
	Colas c = new Colas();
	Medios m = new Medios();	
			
			
	MdHeader pnHeader;
	PaneButton pbInventarios,pbEconomicos,pbEstados,pbColas,pbInversion,pbMedios;
	private JLabel label;
	public MainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 999, 677);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 1002, 657);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		s.mdPanel(mainPanel, s.black);
		
		//Header
		pnHeader = new MdHeader(s.yell,s.black);
		pnHeader.setBounds(0, 0, 992, 104);
		pnHeader.btnBack.setVisible(false);
		pnHeader.btnNext.setVisible(false);
		pnHeader.lblTitle.setText("Simulación");
		pnHeader.lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
		pnHeader.lblTitle.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 30));
		mainPanel.add(pnHeader);
		//Opciones Menus
		
		
		//Colas
		c.pnHeader.btnBack.addActionListener(this);
		
		
		pbColas = new PaneButton("Colas","views/stack.png",s.yell,s.black);
		pbColas.setBounds(23, 203, 155, 180);
		mainPanel.add(pbColas);
		pbColas.btn.addActionListener(this);
		
		
		
		pbInventarios = new PaneButton("Inventarios", "views/storage.png", new Color(255, 234, 0), new Color(66, 66, 66));
		pbInventarios.setBounds(213, 203, 155, 180);
		mainPanel.add(pbInventarios);
		
		pbInversion = new PaneButton("Inventarios", "views/profits.png", new Color(255, 234, 0), new Color(66, 66, 66));
		pbInversion.setBounds(408, 203, 155, 180);
		mainPanel.add(pbInversion);
		
		pbEconomicos = new PaneButton("Inventarios", "views/wallet.png", new Color(255, 234, 0), new Color(66, 66, 66));
		pbEconomicos.setBounds(601, 203, 155, 180);
		mainPanel.add(pbEconomicos);
		
		pbEstados = new PaneButton("Inventarios", "views/budget.png", new Color(255, 234, 0), new Color(66, 66, 66));
		pbEstados.setBounds(800, 203, 155, 180);
		mainPanel.add(pbEstados);
		
		// Cuadrados Medios
		pbMedios = new PaneButton("Cuadrados Medios", "views/square.png", new Color(255, 234, 0), new Color(66, 66, 66));
		pbMedios.setBounds(23, 424, 155, 180);
		mainPanel.add(pbMedios);
		pbMedios.btn.addActionListener(this);
		m.pnHeader.btnBack.addActionListener(this);
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == pbColas.btn) {
			c.setVisible(true);
			this.setVisible(false);
		}else if(e.getSource() == c.pnHeader.btnBack) {
			this.setVisible(true);
			c.setVisible(false);
		}else if(e.getSource() == pbMedios.btn) {
				m.setVisible(true);
				this.setVisible(false);
		}else if(e.getSource() == m.pnHeader.btnBack) {
			this.setVisible(true);
			m.setVisible(false);
		}
		
	}
}
