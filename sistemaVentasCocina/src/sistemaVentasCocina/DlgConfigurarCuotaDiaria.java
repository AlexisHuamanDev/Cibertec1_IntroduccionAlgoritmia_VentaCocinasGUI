package sistemaVentasCocina;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import utils.Adicionales;

@SuppressWarnings("serial")
public class DlgConfigurarCuotaDiaria extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCuotaDiaria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgConfigurarCuotaDiaria dialog = new DlgConfigurarCuotaDiaria();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgConfigurarCuotaDiaria() {
		setTitle("Configurar cuota diaria");
		setBounds(100, 100, 536, 160);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblCuotaDiaria = new JLabel("Cuota diaria esperada (S/.)");
			lblCuotaDiaria.setBounds(10, 24, 158, 14);
			contentPanel.add(lblCuotaDiaria);
		}
		{
			txtCuotaDiaria = new JTextField();
			txtCuotaDiaria.setBounds(190, 21, 113, 20);
			contentPanel.add(txtCuotaDiaria);
			txtCuotaDiaria.setColumns(10);
		}
		{
			JButton btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnAceptar(e);
				}
			});
			btnAceptar.setBounds(403, 20, 89, 23);
			contentPanel.add(btnAceptar);
		}
		{
			JButton btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnCancelar(e);
				}
			});
			btnCancelar.setBounds(403, 54, 89, 23);
			contentPanel.add(btnCancelar);
			//Cargar datos
			cargarDatos();
		}
	}

	  private void cargarDatos() {
		 txtCuotaDiaria.setText(FrmPrincipal.cuotaDiaria + "");
		
	}

	protected void actionPerformedBtnAceptar(ActionEvent e) {
		//Declaración de variables
		int opcion;
		
		opcion = JOptionPane.showConfirmDialog(this, "¿Esta seguro de realizar los cambios?", "Sistema", JOptionPane.YES_NO_OPTION);
		System.out.println("Opcion -> " + opcion);
		dispose();
				
		try {
			if(opcion == 0) {
				FrmPrincipal.cuotaDiaria = Integer.parseInt(txtCuotaDiaria.getText());
}
		} catch (NumberFormatException e1) {
			Adicionales.mensaje("Ingresar valores numéricos");
			dispose();
			return;
		}
		
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		dispose();
	}
}
