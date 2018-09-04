package mainPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class Inventarios extends JFrame implements ActionListener {
	private JPanel contentPane;
	Style s = new Style();
		
			
	Conexion c = new Conexion();
	MdHeader pnHeader;
	MdButton btnIniciar;
	String snum3; 
	JTable tbProductos, tbRecibos;
	JLabel lblCantidad,lblCantidadRes;
	JTextField txtNombre,txtCosto;
	JButton btnAgregar,btnVender,btnMinus,btnPlus,btnMenos,btnMas,btnResurtir;
	int cantidad = 0;
	int cantidadRes = 0;
	public Inventarios() {
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
		pnHeader.lblTitle.setText("Inventarios");
		pnHeader.lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
		pnHeader.lblTitle.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 30));
		mainPanel.add(pnHeader);
		
		//panel de productos
		JPanel pnProductos = new JPanel();
		pnProductos.setBounds(0, 104, 981, 255);
		mainPanel.add(pnProductos);
		pnProductos.setLayout(null);
		s.mdPanel(pnProductos, s.black);
		
		JScrollPane spProductos = new JScrollPane();
		spProductos.setBounds(50, 34, 887, 167);
		pnProductos.add(spProductos);
		spProductos.setBorder(BorderFactory.createEmptyBorder(0,0, 0, 0));
		tbProductos = new JTable();
		tbProductos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id","Producto", "En stock", "Costo"
			}
		));
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		tbProductos.setDefaultRenderer(String.class, centerRenderer);
		tbProductos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbProductos.setForeground(s.yell);
		spProductos.setViewportView(tbProductos);
		s.mdTable(tbProductos, s.black, s.yell);
		spProductos.getViewport().setBackground(s.black);
		
		//panel de ventas
		JPanel pnVentas = new JPanel();
		pnVentas.setBounds(0, 360, 229, 286);
		mainPanel.add(pnVentas);
		pnVentas.setLayout(null);
		s.mdPanel(pnVentas, s.black);
		
		JLabel lblVenta = new JLabel("Venta");
		lblVenta.setHorizontalAlignment(SwingConstants.CENTER);
		lblVenta.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblVenta.setBounds(32, 11, 165, 24);
		pnVentas.add(lblVenta);
		lblVenta.setForeground(s.yell);
		
		lblCantidad = new JLabel(String.valueOf(cantidad));
		lblCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidad.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 27));
		lblCantidad.setBounds(32, 78, 165, 47);
		pnVentas.add(lblCantidad);
		lblCantidad.setForeground(s.yell);
		
		btnMinus = new JButton("");
		btnMinus.setBounds(32, 136, 64, 64);
		pnVentas.add(btnMinus);
		btnMinus.addActionListener(this);
		s.btnIcon(btnMinus, "views/substract.png");
		
		btnPlus = new JButton("");
		btnPlus.setBounds(133, 136, 64, 64);
		pnVentas.add(btnPlus);
		btnPlus.addActionListener(this);
		s.btnIcon(btnPlus, "views/add.png");
		
		btnVender = new MdButton(s.yell,s.black, "Vender");
		btnVender.setFont(new Font("Yu Gothic Light", Font.PLAIN, 14));
		btnVender.setBounds(32, 226, 165, 35);
		pnVentas.add(btnVender);
		btnVender.addActionListener(this);
		
		//panel de recibos
		JPanel pnRecibos = new JPanel();
		pnRecibos.setBounds(246, 360, 229, 286);
		mainPanel.add(pnRecibos);
		pnRecibos.setLayout(null);
		
		s.mdPanel(pnRecibos, s.black);
		JScrollPane spRecibos = new JScrollPane();
		spRecibos.setBounds(10, 34, 209, 241);
		pnRecibos.add(spRecibos);		
		spRecibos.setBorder(BorderFactory.createEmptyBorder(0,0, 0, 0));	
		tbRecibos = new JTable();
		tbRecibos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Venta", "Producto", "Total"
			}
		));
		tbRecibos.setForeground(s.yell);
		tbRecibos.setShowHorizontalLines(false);
		spRecibos.setViewportView(tbRecibos);
		spRecibos.getViewport().setBackground(s.black);
		s.mdTable(tbRecibos, s.black, s.yell);
		
		JLabel lblRecibos = new JLabel("Recibos");
		lblRecibos.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecibos.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblRecibos.setBounds(10, 11, 209, 24);
		pnRecibos.add(lblRecibos);
		lblRecibos.setForeground(s.yell);
		
		//panel de resurtido
		JPanel pnResurtido = new JPanel();
		pnResurtido.setBounds(502, 360, 229, 286);
		mainPanel.add(pnResurtido);
		pnResurtido.setLayout(null);
		s.mdPanel(pnResurtido, s.black);
		
		JLabel lblResurtir = new JLabel("Resurtir");
		lblResurtir.setHorizontalAlignment(SwingConstants.CENTER);
		lblResurtir.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblResurtir.setBounds(31, 11, 165, 24);
		pnResurtido.add(lblResurtir);
		lblResurtir.setForeground(s.yell);
		
		btnMenos = new JButton("");
		btnMenos.setBounds(31, 133, 64, 64);
		pnResurtido.add(btnMenos);
		btnMenos.addActionListener(this);
		s.btnIcon(btnMenos, "views/substract.png");
		
		lblCantidadRes = new JLabel(String.valueOf(cantidadRes));
		lblCantidadRes.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidadRes.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 27));
		lblCantidadRes.setBounds(31, 75, 165, 47);
		pnResurtido.add(lblCantidadRes);		
		lblCantidadRes.setForeground(s.yell);
		
		btnMas = new JButton("");
		btnMas.setBounds(132, 133, 64, 64);
		pnResurtido.add(btnMas);
		btnMas.addActionListener(this);
		s.btnIcon(btnMas, "views/add.png");
		
		btnResurtir = new MdButton(s.yell,s.black,"Resurtir");
		btnResurtir.setFont(new Font("Yu Gothic Light", Font.PLAIN, 14));
		btnResurtir.setBounds(31, 228, 165, 35);
		pnResurtido.add(btnResurtir);
		btnResurtir.addActionListener(this);
		//panel de nuevo producto
		
		JPanel pnNuevoProducto = new JPanel();
		pnNuevoProducto.setBounds(752, 360, 229, 286);
		mainPanel.add(pnNuevoProducto);
		pnNuevoProducto.setLayout(null);
		s.mdPanel(pnNuevoProducto, s.black);
		
		txtNombre = new JTextField();
		txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombre.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		txtNombre.setBounds(10, 75, 209, 43);
		pnNuevoProducto.add(txtNombre);
		txtNombre.setColumns(10);
		txtNombre.setBackground(s.black);
		txtNombre.setForeground(Color.white);
		txtNombre.setCaretColor(Color.WHITE);
		txtNombre.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, s.yell));
		
		JLabel lblAgregarProducto = new JLabel("Agregar Producto");
		lblAgregarProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregarProducto.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblAgregarProducto.setBounds(28, 11, 165, 24);
		pnNuevoProducto.add(lblAgregarProducto);
		lblAgregarProducto.setForeground(s.yell);
		
		txtCosto = new JTextField();
		txtCosto.setHorizontalAlignment(SwingConstants.CENTER);
		txtCosto.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		txtCosto.setColumns(10);
		txtCosto.setBounds(10, 140, 209, 43);
		pnNuevoProducto.add(txtCosto);
		txtCosto.setBackground(s.black);
		txtCosto.setForeground(Color.WHITE);
		txtCosto.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, s.yell));
		txtCosto.setCaretColor(Color.WHITE);
		
		btnAgregar = new MdButton(s.yell,s.black,"Agregar");
		btnAgregar.setFont(new Font("Yu Gothic Light", Font.PLAIN, 14));
		btnAgregar.setBounds(10, 219, 209, 35);
		pnNuevoProducto.add(btnAgregar);
		btnAgregar.addActionListener(this);
		
		
	
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAgregar) {
			agregarProducto();
		}else if(e.getSource() == btnVender) {
			venderProducto();
			llenarRecibos();
			llenarProductos();
		}else if(e.getSource() == btnMinus) {
			System.out.println(cantidad);
			cantidad--;
			lblCantidad.setText(String.valueOf(cantidad));
		}else if(e.getSource() == btnPlus) {
			cantidad++;
			lblCantidad.setText(String.valueOf(cantidad));
		}else if(e.getSource() == btnResurtir) {
			resurtirProducto();
		}else if(e.getSource() == btnMenos) {
			System.out.println(cantidadRes);
			cantidadRes--;
			lblCantidadRes.setText(String.valueOf(cantidadRes));
		}else if(e.getSource() == btnMas) {
			cantidadRes++;
			lblCantidadRes.setText(String.valueOf(cantidadRes));
		}
	}
	
	
	public void llenarProductos() {
		ResultSet rs;
		DefaultTableModel mod = (DefaultTableModel) tbProductos.getModel();
		mod.setRowCount(0);
		try {
			rs = c.query("SELECT * FROM productos");
			while (rs.next()) {

				mod.addRow(new Object[] {
						rs.getString("id"),rs.getString("descripcion"),rs.getString("stock"),rs.getString("costo")
				});
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		tbProductos.setModel(mod);
	}
	
	public void agregarProducto() {
		if(txtNombre.getText().length()>0 && txtCosto.getText().length()>0) {
			c.update("INSERT INTO productos (descripcion,stock,costo) VALUES ('"+txtNombre.getText()+"', 0,"+Integer.parseInt(txtCosto.getText())+")");
			llenarProductos();
		}else {
			
		}
	}
	
	public void venderProducto() {
		try {
//			if() {
				int index = tbProductos.getSelectedRow();
				int idProducto = Integer.parseInt(tbProductos.getModel().getValueAt(index, 0).toString());
				int costoProducto = Integer.parseInt(tbProductos.getModel().getValueAt(index, 3).toString());
				c.update("INSERT INTO ventas (producto,cantidad) VALUES ("+idProducto+","+Integer.parseInt(lblCantidad.getText())*costoProducto+")");
				c.update("UPDATE productos SET stock  = stock-"+Integer.parseInt(lblCantidad.getText())+" WHERE id = "+idProducto+";");
				cantidad = 0;
				lblCantidad.setText(String.valueOf(cantidad));
//			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void llenarRecibos() {
		ResultSet rs;
		DefaultTableModel mod = (DefaultTableModel) tbRecibos.getModel();
		mod.setRowCount(0);
		try {
			rs = c.query("SELECT * FROM ventas");
			while (rs.next()) {

				mod.addRow(new Object[] {
						rs.getString("id"),rs.getString("producto"),rs.getString("cantidad")
				});
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		tbRecibos.setModel(mod);
	}
	
	public void resurtirProducto() {
		try {
			int index = tbProductos.getSelectedRow();
			int idProducto = Integer.parseInt(tbProductos.getModel().getValueAt(index, 0).toString());
			c.update("UPDATE productos SET stock = stock+"+Integer.parseInt(lblCantidadRes.getText())+" WHERE id="+idProducto+"");
			llenarProductos();
			cantidadRes = 0;
			lblCantidadRes.setText(String.valueOf(cantidadRes));
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
