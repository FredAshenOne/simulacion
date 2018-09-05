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

public class ProductosMedios extends JFrame implements ActionListener {

	private JPanel contentPane;
	Style s = new Style();
		
			
			
	MdHeader pnHeader;
	PaneButton pbInventarios,pbEconomicos,pbEstados,pbColas,pbInversion,pbMedios;
	MdButton btnIniciar;
	private JLabel label;
	private JScrollPane spSalida;
	JTable table;
	private JPanel pnEntradas;
	MdTextField txtInicialesA,txtInicialesB;
	JLabel lblWarning;
	String snum3; 
	
	public ProductosMedios() {
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
		pnHeader.lblTitle.setText("Productos Medios");
		pnHeader.lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
		pnHeader.lblTitle.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 30));
		mainPanel.add(pnHeader);
		
		//Panel de entradas

		pnEntradas = new JPanel();
		pnEntradas.setBounds(0, 105, 341, 530);
		mainPanel.add(pnEntradas);
		pnEntradas.setLayout(null);
		s.mdPanel(pnEntradas, s.black);

		
		txtInicialesA= new MdTextField(Color.WHITE,"---",s.black,s.yell);
		txtInicialesA.lbl.setText("Numeros iniciales");
		txtInicialesA.setBounds(23, 136, 274, 39);
		txtInicialesA.setLblBounds();
		pnEntradas.add(txtInicialesA.lbl);
		pnEntradas.add(txtInicialesA);
		
		btnIniciar = new MdButton(s.yell,s.black,"Iniciar");
		btnIniciar.setBounds(23,300,274,39);
		pnEntradas.add(btnIniciar);	
		btnIniciar.addActionListener(this);
		
		lblWarning = new JLabel("");
		lblWarning.setHorizontalAlignment(SwingConstants.CENTER);
		lblWarning.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		lblWarning.setBounds(23, 467, 274, 27);
		lblWarning.setForeground(s.yell);
		pnEntradas.add(lblWarning);
		
		txtInicialesB = new MdTextField(Color.WHITE, "---", new Color(66, 66, 66), new Color(255, 234, 0));
		txtInicialesB.setBounds(23, 206, 274, 39);
		pnEntradas.add(txtInicialesB);
		
		
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
				"A","B","Producto","Producto Medio", "Normalizado"
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
		if(s.isNumeric(txtInicialesA.getText()) && s.isNumeric(txtInicialesB.getText())) {
			int numeroA = Integer.parseInt(txtInicialesA.getText());
			int numeroB = Integer.parseInt(txtInicialesB.getText());
			int iniciales = numeroA*numeroB;
			String ceros = "";
			String staticIniciales = "";
			
			for(int i = 0; i<=10;i++) {
				int tamañoInicial = String.valueOf(iniciales).length();
				
				if(tamañoInicial>5) {
					snum3 = String.valueOf(iniciales).substring(1,3);
					staticIniciales = String.valueOf(iniciales);
				}else if(tamañoInicial == 5){
					snum3 = String.valueOf(iniciales).substring(1,3);
					staticIniciales = String.valueOf(iniciales);
				}else if(tamañoInicial == 4 ){					
					snum3 = String.valueOf(iniciales).substring(1,3);
					staticIniciales = String.valueOf(iniciales);
				}else if(tamañoInicial <= 3){
					ceros = String.format("%04d", iniciales);
					snum3 = ceros.substring(1,3);
					staticIniciales = ceros;
				}
				
				
				
				float normalizados = Float.parseFloat(snum3) /100;
				
				iniciales = Integer.parseInt(snum3);
				mod.addRow(new Object[] {
					numeroA,numeroB,staticIniciales,snum3,normalizados
				});
				lblWarning.setText("");
				numeroA = numeroB;
				numeroB = Integer.parseInt(snum3);
				iniciales = numeroA * numeroB;
			}
			
		}else {
			lblWarning.setText("El valor ingresado no es valido");
		}
		table.setModel(mod);
	}
}
