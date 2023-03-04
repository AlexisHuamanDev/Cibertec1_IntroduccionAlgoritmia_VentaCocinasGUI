package sistemaVentasCocina;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class DlgListarCocina extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextArea txtS;
	private JScrollPane scrollPane;
	private JButton btnListar;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgListarCocina dialog = new DlgListarCocina();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgListarCocina() {
		setTitle("Listar Cocinas");
		setBounds(100, 100, 569, 547);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 11, 521, 452);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		scrollPane.setViewportView(txtS);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnListar(e);
			}
		});
		btnListar.setBounds(303, 474, 89, 23);
		contentPanel.add(btnListar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedBtnCerrar(e);
			}
		});
		btnCerrar.setBounds(163, 474, 89, 23);
		contentPanel.add(btnCerrar);
	}
	protected void actionPerformedBtnListar(ActionEvent e) {
		//Declaración de variables
			getLista();
			txtS.setCaretPosition(0);
	}

	private void getLista() {
		txtS.setText("		LISTA DE COCINAS\n\n");
		
		txtS.append("Modelo	:  " + FrmPrincipal.modelo0 + "\n");
		txtS.append("Precio	:  S/. " +  FrmPrincipal.precio0  + "\n");
		txtS.append("Profundidad	:  "+ FrmPrincipal.fondo0 + " cm " + "\n");
		txtS.append("Ancho	:  "+ FrmPrincipal.ancho0 + " cm " + "\n");
		txtS.append("Alto	:  "+ FrmPrincipal.alto0 + " cm "+ "\n");
		txtS.append("Quemadores	:  "+ FrmPrincipal.quemadores0 + "\n\n");
		
		txtS.append("Modelo	:  " + FrmPrincipal.modelo1 + "\n");
		txtS.append("Precio	:  S/. " +  FrmPrincipal.precio1  + "\n");
		txtS.append("Profundidad	:  "+ FrmPrincipal.fondo1 + " cm " + "\n");
		txtS.append("Ancho	:  "+ FrmPrincipal.ancho1 + " cm " + "\n");
		txtS.append("Alto	:  "+ FrmPrincipal.alto1 + " cm "+ "\n");
		txtS.append("Quemadores	:  "+ FrmPrincipal.quemadores1 + "\n\n");
		
		txtS.append("Modelo	:  " + FrmPrincipal.modelo2 + "\n");
		txtS.append("Precio	:  S/. " +  FrmPrincipal.precio2  + "\n");
		txtS.append("Profundidad	:  "+ FrmPrincipal.fondo2 + " cm " + "\n");
		txtS.append("Ancho	:  "+ FrmPrincipal.ancho2 + " cm " + "\n");
		txtS.append("Alto	:  "+ FrmPrincipal.alto2 + " cm "+ "\n");
		txtS.append("Quemadores	:  "+ FrmPrincipal.quemadores2 + "\n\n");
	
		txtS.append("Modelo	:  " + FrmPrincipal.modelo3 + "\n");
		txtS.append("Precio	:  S/. " +  FrmPrincipal.precio3  + "\n");
		txtS.append("Profundidad	:  "+ FrmPrincipal.fondo3 + " cm " + "\n");
		txtS.append("Ancho	:  "+ FrmPrincipal.ancho3 + " cm " + "\n");
		txtS.append("Alto	:  "+ FrmPrincipal.alto3 + " cm "+ "\n");
		txtS.append("Quemadores	:  "+ FrmPrincipal.quemadores3 + "\n\n");
		
		txtS.append("Modelo	:  " + FrmPrincipal.modelo4 + "\n");
		txtS.append("Precio	:  S/. " +  FrmPrincipal.precio4  + "\n");
		txtS.append("Profundidad	:  "+ FrmPrincipal.fondo4 + " cm " + "\n");
		txtS.append("Ancho	:  "+ FrmPrincipal.ancho4 + " cm " + "\n");
		txtS.append("Alto	:  "+ FrmPrincipal.alto4 + " cm "+ "\n");
		txtS.append("Quemadores	:  "+ FrmPrincipal.quemadores4 + "\n\n");

	}
	
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
}