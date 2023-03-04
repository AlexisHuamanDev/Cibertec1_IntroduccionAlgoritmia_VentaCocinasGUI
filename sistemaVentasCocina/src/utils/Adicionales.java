package utils;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Adicionales {
	
	static JTextArea txtS = new JTextArea();

	//Controlar decimales
	public static DecimalFormat df = new DecimalFormat("0.00");
	
	//método mensaje para mostrar cuadro de diálogo
	public static void mensaje(String msj) {
		JOptionPane.showMessageDialog(null, msj, "Error!", 0);
	}


	public static void sistema(String msj) {

		JOptionPane.showConfirmDialog(null, msj, "Sistema", JOptionPane.CLOSED_OPTION);
	
	}
	
	public static void yesNo(String msj) {
	JOptionPane.showConfirmDialog(null, msj, "Sistema", JOptionPane.YES_NO_OPTION);
}
	
}