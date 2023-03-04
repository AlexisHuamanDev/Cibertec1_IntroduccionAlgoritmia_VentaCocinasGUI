package sistemaVentasCocina;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgConsultarCocina extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblModelo;
	private JComboBox<?> cboModelo;
	private JLabel lblPrecio;
	private JTextField txtPrecio;
	private JLabel lblAncho;
	private JTextField txtAncho;
	private JLabel lblAlto;
	private JTextField txtAlto;
	private JLabel lblFondo;
	private JTextField txtFondo;
	private JLabel lblQuemadores;
	private JTextField txtQuemadores;
	private JButton btnCerrar;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			
			DlgConsultarCocina dialog = new DlgConsultarCocina();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DlgConsultarCocina() {
		setTitle("Consultar cocina");
		setBounds(100, 100, 450, 248);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(21, 18, 66, 14);
		contentPanel.add(lblModelo);
		
		cboModelo = new JComboBox();
		cboModelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedCboModelo(e);
			}
		});
		cboModelo.setModel(new DefaultComboBoxModel(new String[] {"Mabe EMP6120PG0", "Indurama Parma", "Sole COSOL027", "Coldex CX602", "Reco Dakota"}));
		cboModelo.setBounds(114, 11, 131, 22);
		contentPanel.add(cboModelo);
		
		lblPrecio = new JLabel("Precio (S/)");
		lblPrecio.setBounds(21, 50, 66, 14);
		contentPanel.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setEnabled(false);
		txtPrecio.setBounds(114, 44, 131, 20);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		lblAncho = new JLabel("Ancho (cm)");
		lblAncho.setBounds(21, 81, 66, 14);
		contentPanel.add(lblAncho);
		
		txtAncho = new JTextField();
		txtAncho.setEnabled(false);
		txtAncho.setBounds(114, 75, 131, 20);
		contentPanel.add(txtAncho);
		txtAncho.setColumns(10);
		
		lblAlto = new JLabel("Alto (cm)");
		lblAlto.setBounds(21, 112, 58, 14);
		contentPanel.add(lblAlto);
		
		txtAlto = new JTextField();
		txtAlto.setEnabled(false);
		txtAlto.setBounds(114, 106, 131, 20);
		contentPanel.add(txtAlto);
		txtAlto.setColumns(10);
		
		lblFondo = new JLabel("Fondo (cm)");
		lblFondo.setBounds(21, 144, 66, 14);
		contentPanel.add(lblFondo);
		
		txtFondo = new JTextField();
		txtFondo.setEnabled(false);
		txtFondo.setBounds(114, 138, 131, 20);
		contentPanel.add(txtFondo);
		txtFondo.setColumns(10);
		
		lblQuemadores = new JLabel("Quemadores");
		lblQuemadores.setBounds(21, 175, 83, 14);
		contentPanel.add(lblQuemadores);
		
		txtQuemadores = new JTextField();
		txtQuemadores.setEnabled(false);
		txtQuemadores.setBounds(114, 169, 131, 20);
		contentPanel.add(txtQuemadores);
		txtQuemadores.setColumns(10);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnCerrar(e);
			}
		});
		btnCerrar.setBounds(335, 11, 89, 23);
		contentPanel.add(btnCerrar);
		//Cargar datos
			cargarDatos();
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	protected void actionPerformedCboModelo(ActionEvent e) {
		//Declaración de variables
		int modelo;
		//Entrada de datos
		modelo = getModelo();
		//Proceso de cálculo -- no hay
		//Salida de resultados
		mostrarResultado(modelo);
		
	}

	private void mostrarResultado(int modelo) {
		switch(modelo) {
		case 0://Mabe EMP6120PG0

			txtPrecio.setText(FrmPrincipal.precio0 +"");
			txtAncho.setText(FrmPrincipal.ancho0 +"");
			txtAlto.setText(FrmPrincipal.alto0 +"");
			txtFondo.setText(FrmPrincipal.fondo0 +"");
			txtQuemadores.setText(FrmPrincipal.quemadores0 +"");
			break;
		case 1://Indurama Parma
			txtPrecio.setText(FrmPrincipal.precio1 +"");
			txtAncho.setText(FrmPrincipal.ancho1 +"");
			txtAlto.setText(FrmPrincipal.alto1 +"");
			txtFondo.setText(FrmPrincipal.fondo1 +"");
			txtQuemadores.setText(FrmPrincipal.quemadores1 +"");
			break;
		case 2://Sole COSOL027
			txtPrecio.setText(FrmPrincipal.precio2 +"");
			txtAncho.setText(FrmPrincipal.ancho2 +"");
			txtAlto.setText(FrmPrincipal.alto2 +"");
			txtFondo.setText(FrmPrincipal.fondo2 +"");
			txtQuemadores.setText(FrmPrincipal.quemadores2 +"");
			break;
		case 3://Coldex CX602
			txtPrecio.setText(FrmPrincipal.precio3 +"");
			txtAncho.setText(FrmPrincipal.ancho3 +"");
			txtAlto.setText(FrmPrincipal.alto3 +"");
			txtFondo.setText(FrmPrincipal.fondo3 +"");
			txtQuemadores.setText(FrmPrincipal.quemadores3 +"");
			break;
		case 4://Reco Dakota
			txtPrecio.setText(FrmPrincipal.precio4 +"");
			txtAncho.setText(FrmPrincipal.ancho4 +"");
			txtAlto.setText(FrmPrincipal.alto4 +"");
			txtFondo.setText(FrmPrincipal.fondo4 +"");
			txtQuemadores.setText(FrmPrincipal.quemadores4 +"");
			break;
		}
		
	}

	private int getModelo() {
		return cboModelo.getSelectedIndex();
	}
	//Cargar datos desde la ejecución
	private void cargarDatos() {
		txtPrecio.setText(FrmPrincipal.precio0 +"");
		txtAncho.setText(FrmPrincipal.ancho0 +"");
		txtAlto.setText(FrmPrincipal.alto0 +"");
		txtFondo.setText(FrmPrincipal.fondo0 +"");
		txtQuemadores.setText(FrmPrincipal.quemadores0 +"");
	}
}
