package mainPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Medios extends JFrame implements ActionListener {

	private JPanel contentPane;
	Style s = new Style();
		
			
			
	MdHeader pnHeader;
	PaneButton pbInventarios,pbEconomicos,pbEstados,pbColas,pbInversion,pbMedios;
	MdButton btnIniciar;
	private JLabel label;
	private JScrollPane spSalida;
	private JTable table;
	private JPanel pnEntradas;
	MdTextField txtIniciales;
	
	public Medios() {
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
		pnHeader.lblTitle.setText("Cuadrados Medios");
		pnHeader.lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
		pnHeader.lblTitle.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 30));
		mainPanel.add(pnHeader);
		
		//Panel de entradas

		pnEntradas = new JPanel();
		pnEntradas.setBounds(0, 105, 341, 530);
		mainPanel.add(pnEntradas);
		pnEntradas.setLayout(null);
		s.mdPanel(pnEntradas, s.black);

		
		txtIniciales= new MdTextField(Color.WHITE,"---",s.black,s.yell);
		txtIniciales.lbl.setText("Numeros iniciales");
		txtIniciales.setBounds(23, 190, 274, 39);
		txtIniciales.setLblBounds();
		pnEntradas.add(txtIniciales.lbl);
		pnEntradas.add(txtIniciales);
		
		btnIniciar = new MdButton(s.yell,s.black,"Iniciar");
		btnIniciar.setBounds(23,300,274,39);
		pnEntradas.add(btnIniciar);
		//Panel de salidas
		spSalida = new JScrollPane();
		spSalida.setBounds(337, 105, 655, 530);
		mainPanel.add(spSalida);
		spSalida.getViewport().setBackground(s.black);
		spSalida.setOpaque(true);

		table = new JTable();
		spSalida.setViewportView(table);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnIniciar) {
			
		}
		
	}
	
	
	public void cuadradosMedios() {
		int iniciales = Integer.parseInt(txtIniciales.getText());
		int tamañoInicial = txtIniciales.getText().length();
		for(int i = 0; i<=10;i++) {
			long alCuadrado = (long)Math.pow(iniciales, 2);
			int tamañoCuadrado = String.valueOf(alCuadrado).length();
			int primerCaracter = (tamañoCuadrado - tamañoInicial) /2;
			String snum3 = 
			
		}
	}
	
	
	
}
