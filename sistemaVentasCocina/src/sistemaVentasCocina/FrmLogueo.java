package sistemaVentasCocina;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utils.Adicionales;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Toolkit;

@SuppressWarnings({ "serial", "unused" })
public class FrmLogueo extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblUsuario;
	private JTextField txtUsuario;
	private JLabel lblContraseña;
	private JPasswordField jPasClave;
	private JButton btnIngresar;
	private JButton btnCerrar;
	
	//usuario publicos
	public static String user1 = "admin";
	public static String clave1 = "123";
	
	public static String user2 = "user";
	public static String clave2 = "123";
	
	
	private JLabel lblLogo;
	private JLabel lblNewLabel;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLogueo frame = new FrmLogueo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmLogueo() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmLogueo.class.getResource("/img/miCocina1.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 443, 558);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblUsuario = new JLabel("");
		lblUsuario.setIcon(new ImageIcon(FrmLogueo.class.getResource("/img/usuario.png")));
		lblUsuario.setBounds(58, 309, 48, 48);
		contentPane.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(128, 320, 186, 32);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		lblContraseña = new JLabel("");
		lblContraseña.setIcon(new ImageIcon(FrmLogueo.class.getResource("/img/password.png")));
		lblContraseña.setBounds(58, 367, 48, 50);
		contentPane.add(lblContraseña);
		
		jPasClave = new JPasswordField();
		jPasClave.setBounds(128, 379, 186, 32);
		contentPane.add(jPasClave);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnIngresar.setBounds(90, 440, 118, 37);
		btnIngresar.addActionListener(this);
		contentPane.add(btnIngresar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCerrar.setBounds(227, 439, 118, 39);
		contentPane.add(btnCerrar);
		
		lblLogo = new JLabel("");
		lblLogo.setBounds(68, 28, 299, 320);
		lblLogo.setIcon(new ImageIcon(FrmLogueo.class.getResource("/img/miCocina1.png")));
		contentPane.add(lblLogo);
		
		lblNewLabel = new JLabel("Mi Cocina");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(57, 11, 299, 37);
		contentPane.add(lblNewLabel);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(e);
		}
	}
	protected void actionPerformedBtnIngresar(ActionEvent e) {
		
		//Declaracion de variables
		String user,clave;
		//Entrada de datos
		user = getUsuario();
		clave = getClave();
		//Validar
		if(user.equals(user1)&& clave.equals(clave1)) {
			cargarVentanaPrincipal();
			
			this.dispose();
		}
		

		else if(user.equals(user2)&& clave.equals(clave2)) {
			cargarVentanaPrincipal();
			FrmPrincipal.mntmModificarCocina.setEnabled(false);
			FrmPrincipal.mnConfiguracion.setEnabled(false);
			this.dispose();
		}

		else {
			Adicionales.mensaje("Usuario y/o password incorrecto");
			txtUsuario.requestFocus();
		}
		
	}

	private void cargarVentanaPrincipal() {
			FrmPrincipal print = new FrmPrincipal();
			print.setVisible(true);
			print.setLocationRelativeTo(this);
			
	}

	private String getClave() {
		return String.valueOf(jPasClave.getPassword());
	}

	private String getUsuario() {
		return txtUsuario.getText().trim();
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
}
