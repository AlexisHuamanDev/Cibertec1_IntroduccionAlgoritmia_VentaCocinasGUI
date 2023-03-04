package sistemaVentasCocina;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

@SuppressWarnings("serial")
public class DlgAcercaDeTienda extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgAcercaDeTienda dialog = new DlgAcercaDeTienda();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgAcercaDeTienda() {
		setTitle("Acerca de Tienda");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mi Cocina SAC");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(144, 22, 152, 39);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Autores");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(183, 72, 83, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Angela del Pilar Castro Noriega");
		lblNewLabel_2.setBounds(135, 100, 236, 14);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Alexander Díaz Ambrosio");
		lblNewLabel_2_1.setBounds(135, 150, 236, 14);
		contentPanel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Alexis Gianpier Huaman Aguilar");
		lblNewLabel_2_2.setBounds(135, 125, 236, 14);
		contentPanel.add(lblNewLabel_2_2);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCerrar.setBounds(166, 186, 89, 23);
		contentPanel.add(btnCerrar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(21, 58, 386, 3);
		contentPanel.add(separator);
	}

}
