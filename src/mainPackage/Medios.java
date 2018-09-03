package mainPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

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
		btnIniciar.addActionListener(this);
		
		//Panel de salidas
		spSalida = new JScrollPane();
		spSalida.setBounds(345, 174, 613, 396);
		mainPanel.add(spSalida);
		spSalida.getViewport().setBackground(s.black);
		spSalida.setBorder(BorderFactory.createEmptyBorder(0,0, 0, 0));
		
		table = new JTable();
		table.setForeground(s.yell);
		table.setShowHorizontalLines(false);
		table.setBorder(null);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Iniciales", "Cuadrado", "Cuadrados Medios", "Normalizado"
			}
		));
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalTextPosition(DefaultTableCellRenderer.CENTER);
		
		spSalida.setViewportView(table);
		
		s.mdTable(table, s.black, s.yell);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnIniciar) {
			cuadradosMedios();
		}
		
	}
	
	
	public void cuadradosMedios() {
		DefaultTableModel mod = (DefaultTableModel) table.getModel();
		mod.setRowCount(0);
		int iniciales = Integer.parseInt(txtIniciales.getText());
		
		int tamañoInicial = txtIniciales.getText().length();
		
		for(int i = 0; i<=10;i++) {
			int inicialStatic = iniciales;
			long alCuadrado = (long)Math.pow(iniciales, 2);
			String strCuadrado = Long.toString(alCuadrado);
			int tamañoCuadrado = String.valueOf(alCuadrado).length();
			int primerCaracter = (tamañoCuadrado - tamañoInicial) /2;
			//String snum3 = strCuadrado.substring(primerCaracter,primerCaracter+tamañoCuadrado);
			String snum3 = strCuadrado.substring(primerCaracter,primerCaracter+4);
			iniciales = Integer.parseInt(snum3);
			
			float normalizados = (float) iniciales /10000;
			mod.addRow(new Object[] {
				inicialStatic,alCuadrado,iniciales,normalizados
			});
	
			
		}
		table.setModel(mod);
	}
	

	
	
}
