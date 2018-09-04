package mainPackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JRadioButton;

public class Colas extends JFrame implements ActionListener {

	private JPanel contentPane;
	Style s = new Style();
	MdHeader pnHeader;
	MdTextField txtNombre,txtEspacio;
	MdButton btnAgregar,btnEliminar;
	JLabel lblNombre,lblWarning;
	List<Elementos> listaElementos = new ArrayList<Elementos>();
	JTable table;
	JRadioButton rdFifo,rdLifo;
	LinkedList<String> cola = new LinkedList();
	JScrollPane scrollPane;
	
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
		
		
		//header 
		pnHeader = new MdHeader(s.yell,s.black);
		pnHeader.setBounds(0, 0, 992, 104);
		pnHeader.lblTitle.setText("Colas");
		pnHeader.lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
		pnHeader.lblTitle.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 30));
		mainPanel.add(pnHeader);
		
		pnHeader.btnNext.setVisible(false);
		
		//panel de entradas

		JPanel pnFormulario = new JPanel();
		pnFormulario.setLayout(null);
		pnFormulario.setOpaque(true);
		pnFormulario.setBackground((Color) null);
		pnFormulario.setBounds(0, 103, 261, 395);
		mainPanel.add(pnFormulario);
				
		
		
		txtNombre = new MdTextField(Color.WHITE,"---",s.black,s.yell);
		txtNombre.lbl.setText("Nombre");
		txtNombre.setBounds(30,132,200,50);
		txtNombre.setLblBounds();
		pnFormulario.add(txtNombre.lbl);
		pnFormulario.add(txtNombre);
		

		btnAgregar = new MdButton(s.yell,s.black,"Agregar");
		btnAgregar.setBounds(30,214,200,40);
		pnFormulario.add(btnAgregar);
		btnAgregar.addActionListener(this);
		
		lblWarning = new JLabel("");
		lblWarning.setBounds(10, 310, 251, 14);
		pnFormulario.add(lblWarning);
		lblWarning.setForeground(Color.WHITE);
		lblWarning.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		
		rdFifo = new JRadioButton("Fifo");
		rdFifo.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		rdFifo.setBounds(35, 37, 87, 23);
		pnFormulario.add(rdFifo);
		rdFifo.setSelected(true);
		rdFifo.setBackground(s.black);
		rdFifo.setForeground(s.yell);
		
		rdLifo = new JRadioButton("Lifo");
		rdLifo.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		rdLifo.setBounds(146, 37, 77, 23);
		pnFormulario.add(rdLifo);
		rdLifo.setBackground(s.black);
		rdLifo.setForeground(s.yell);
		
		ButtonGroup order = new ButtonGroup();
		order.add(rdFifo);
		order.add(rdLifo);
		
		
		//panel de salidas

		JPanel pnSegmentos = new JPanel();
		pnSegmentos.setBounds(271, 103, 710, 395);
		mainPanel.add(pnSegmentos);
		pnSegmentos.setOpaque(true);
		pnSegmentos.setBackground(null);
		pnSegmentos.setLayout(null);

		 scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 103, 663, 79);
		pnSegmentos.add(scrollPane);
		
		table = new JTable();	
		scrollPane.setViewportView(table);
		table.setForeground(s.yell);
		table.setShowHorizontalLines(false);
		scrollPane.setBorder(BorderFactory.createEmptyBorder(0,0, 0, 0));	
		scrollPane.getViewport().setBackground(s.black);
		table.setTableHeader(new JTableHeader(table.getColumnModel()) {
			  @Override public Dimension getPreferredSize() {
			    Dimension d = super.getPreferredSize();
			    d.height = 50;
			    return d;
			  }
			});
		scrollPane.setVisible(false);
			
		s.mdTable(table, s.black, s.yell);
		
		
		JLabel lblSalida = new JLabel("Salida");
		lblSalida.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSalida.setForeground(Color.WHITE);
		lblSalida.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblSalida.setBounds(529, 181, 144, 14);
		pnSegmentos.add(lblSalida);
		
		JLabel lblEntrada = new JLabel("Entrada");
		lblEntrada.setHorizontalAlignment(SwingConstants.LEADING);
		lblEntrada.setForeground(Color.WHITE);
		lblEntrada.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblEntrada.setBounds(10, 183, 144, 14);
		pnSegmentos.add(lblEntrada);
		
	
		
	}
	
	public void addFifo() {
		if(txtNombre.getText().length()>0) {
			cola.addFirst(txtNombre.getText());
			txtNombre.setText("");
		}else {
			lblWarning.setText("No se ha ingresado un nombre");
		}
	}
	
	public void addLifo() {
		if(txtNombre.getText().length()>0) {
			cola.addLast(txtNombre.getText());
			txtNombre.setText("");
		}else {
			lblWarning.setText("No se ha ingresado un nombre");
		}
	}
	
	
	public void pintarTabla() {
		DefaultTableModel mod = (DefaultTableModel) table.getModel();
			mod.setColumnCount(0);
			Iterator<String> iter = cola.iterator();
			lblWarning.setText("");
			while(iter.hasNext()) {
				String name = iter.next();
				mod.addColumn(name);
			}
			table.setModel(mod);
					
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAgregar) {
			if(rdFifo.isSelected()) {
				addFifo();
			}else {
				addLifo();
			}
			pintarTabla();
			scrollPane.setVisible(true);
		}
	}
}
