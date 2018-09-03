package mainPackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Colas extends JFrame {

	private JPanel contentPane;
	Style s = new Style();
	MdHeader pnHeader;
	MdTextField txtNombre,txtEspacio;
	MdButton btnAgregar,btnEliminar;
	JLabel lblNombre;
	List<Elementos> listaElementos = new ArrayList<Elementos>();
	private JTable table;
	public Colas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 999, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 1002, 498);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		s.mdPanel(mainPanel, s.black);
		
		pnHeader = new MdHeader(s.yell,s.black);
		pnHeader.setBounds(0, 0, 992, 104);
		pnHeader.lblTitle.setText("Colas");
		pnHeader.lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
		pnHeader.lblTitle.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 30));
		mainPanel.add(pnHeader);
		
		JPanel pnSegmentos = new JPanel();
		pnSegmentos.setBounds(509, 103, 472, 395);
		mainPanel.add(pnSegmentos);
		pnSegmentos.setOpaque(true);
		pnSegmentos.setBackground(null);
		pnSegmentos.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 134, 379, 79);
		pnSegmentos.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel pnFormulario = new JPanel();
		pnFormulario.setLayout(null);
		pnFormulario.setOpaque(true);
		pnFormulario.setBackground((Color) null);
		pnFormulario.setBounds(0, 103, 505, 395);
		mainPanel.add(pnFormulario);
				
		
		
		txtNombre = new MdTextField(Color.WHITE,"---",s.black,s.yell);
		txtNombre.lbl.setText("Nombre");
		txtNombre.setBounds(143,93,200,50);
		txtNombre.setLblBounds();
		pnFormulario.add(txtNombre.lbl);
		pnFormulario.add(txtNombre);
		

		btnAgregar = new MdButton(s.yell,s.black,"Agregar");
		btnAgregar.setBounds(143,175,200,40);
		pnFormulario.add(btnAgregar);
		
		btnEliminar= new MdButton(Color.decode("#fb6542"),s.black,"Eliminar");
		btnEliminar.setBounds(143,225,200,40);		
		pnFormulario.add(btnEliminar);
		
		
	
		
	}
//	
//	public void agregarFifo(String nombre) {
//		Elementos e = new Elementos(txtNombre.getText());
//	}
	
}
