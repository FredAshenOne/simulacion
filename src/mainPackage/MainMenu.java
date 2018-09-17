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
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MainMenu extends JFrame implements ActionListener{

	private JPanel contentPane;
	Style s = new Style();
	Colas c = new Colas();
	Medios m = new Medios();
	ProductosMedios pmed = new ProductosMedios();
	Inventarios inv = new Inventarios();
	Aditivo ad = new Aditivo();
	SecondMenu sm = new SecondMenu();
	
	MdHeader pnHeader;
	PaneButton pbInventarios,pbEconomicos,pbEstados,pbColas,pbInversion,pbMedios,pbProdMedios,pbAditivo,pbMulti,pbMixto;
	private JLabel label;
	public MainMenu() {
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
		pnHeader.lblTitle.setText("Simulación");
		pnHeader.lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
		pnHeader.lblTitle.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 30));
		mainPanel.add(pnHeader);
		pnHeader.btnNext.addActionListener(this);
		//Opciones Menus
		
		
		//Colas
		c.pnHeader.btnBack.addActionListener(this);
		
		
		pbColas = new PaneButton("Colas","views/stack.png",s.yell,s.black);
		pbColas.setBounds(23, 203, 155, 180);
		mainPanel.add(pbColas);
		pbColas.btn.addActionListener(this);
		
		
		//Inventarios
		pbInventarios = new PaneButton("Inventarios", "views/storage.png", new Color(255, 234, 0), new Color(66, 66, 66));
		pbInventarios.setBounds(213, 203, 155, 180);
		mainPanel.add(pbInventarios);
		pbInventarios.btn.addActionListener(this);
		inv.pnHeader.btnBack.addActionListener(this);
		
		//Inversion
		pbInversion = new PaneButton("Inversion", "views/profits.png", new Color(255, 234, 0), new Color(66, 66, 66));
		pbInversion.setBounds(408, 203, 155, 180);
		mainPanel.add(pbInversion);
		
		//Economicos
		pbEconomicos = new PaneButton("Economicos", "views/wallet.png", new Color(255, 234, 0), new Color(66, 66, 66));
		pbEconomicos.setBounds(601, 203, 155, 180);
		mainPanel.add(pbEconomicos);		
		
		//Estados
		pbEstados = new PaneButton("Financieros", "views/budget.png", new Color(255, 234, 0), new Color(66, 66, 66));
		pbEstados.setBounds(800, 203, 155, 180);
		mainPanel.add(pbEstados);
		
		// Cuadrados Medios
		pbMedios = new PaneButton("Cuadrados Medios", "views/square.png", new Color(255, 234, 0), new Color(66, 66, 66));
		pbMedios.setBounds(23, 424, 155, 180);
		mainPanel.add(pbMedios);
		pbMedios.btn.addActionListener(this);
		m.pnHeader.btnBack.addActionListener(this);
		//productos medios
		pbProdMedios = new PaneButton("Productos Medios", "views/division.png", new Color(255, 234, 0), new Color(66, 66, 66));
		pbProdMedios.setBounds(213, 424, 155, 180);
		mainPanel.add(pbProdMedios);
		pbProdMedios.btn.addActionListener(this);
		pmed.pnHeader.btnBack.addActionListener(this);
		//Congruencial aditivo
		pbAditivo = new PaneButton("Congruencial Aditivo", "views/suma.png", new Color(255, 234, 0), new Color(66, 66, 66));
		pbAditivo.setBounds(408, 424, 155, 180);
		mainPanel.add(pbAditivo);
		pbAditivo.btn.addActionListener(this);
		ad.pnHeader.btnBack.addActionListener(this);
		
		//congruencial multiplicativo
		pbMulti = new PaneButton("<html><body>Congruencial<br>Multiplicativo</body></html>", "views/multi.png", new Color(255, 234, 0), new Color(66, 66, 66));
		pbMulti.setBounds(601, 424, 155, 180);
		mainPanel.add(pbMulti);
		
		//congruencial mixto
		pbMixto = new PaneButton("Congruencial Mixto", "views/mixto.png", new Color(255, 234, 0), new Color(66, 66, 66));
		pbMixto.setBounds(800, 424, 155, 180);
		mainPanel.add(pbMixto);
		ad.pnHeader.btnBack.addActionListener(this);
		
		
		//second 
		sm.pnHeader.btnBack.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == pnHeader.btnNext) {
			sm.setVisible(true);
			this.setVisible(false);
		}else if(e.getSource() == sm.pnHeader.btnBack) {
			this.setVisible(true);
			sm.setVisible(false);
		}else if(e.getSource() == pbColas.btn) {
			c.setVisible(true);
			this.setVisible(false);
		}else if(e.getSource() == c.pnHeader.btnBack) {
			this.setVisible(true);
			c.setVisible(false);
			c.cola.clear();
			c.scrollPane.setVisible(false);
		}else if(e.getSource() == pbMedios.btn) {
				m.setVisible(true);
				this.setVisible(false);
		}else if(e.getSource() == m.pnHeader.btnBack) {
			this.setVisible(true);
			m.setVisible(false);
			
		}else if(e.getSource() == pbInventarios.btn) {
			inv.setVisible(true);
			this.setVisible(false);
			inv.llenarProductos();
			inv.llenarRecibos();
		}else if(e.getSource() == inv.pnHeader.btnBack) {
			this.setVisible(true);
			inv.setVisible(false);
		}else if(e.getSource() == pbProdMedios.btn) {
			pmed.setVisible(true);
			this.setVisible(false);
		}else if(e.getSource() == pmed.pnHeader.btnBack) {
			this.setVisible(true);
			pmed.setVisible(false);
			DefaultTableModel mod = (DefaultTableModel) pmed.table.getModel();
			mod.setRowCount(0);
			pmed.table.setModel(mod);
			pmed.txtInicialesA.setText("");
			pmed.txtInicialesB.setText("");
		}else if(e.getSource() == ad.pnHeader.btnBack ) {
			this.setVisible(true);
			ad.setVisible(false);
		}else if(e.getSource() == pbAditivo.btn) {
			ad.setVisible(true);
			this.setVisible(false);			
		}
		
	}
}
