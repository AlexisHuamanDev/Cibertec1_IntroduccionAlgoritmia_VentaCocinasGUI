package sistemaVentasCocina;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utils.Adicionales;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings("unused")
public class DlgGenerarReportes extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JComboBox<?> cboTipoReporte;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */

		
	public static void main(String[] args) {
		try {
			DlgGenerarReportes dialog = new DlgGenerarReportes();
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
	public DlgGenerarReportes() {
		setTitle("Generar Reportes");
		setBounds(100, 100, 655, 585);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblTipoReporte = new JLabel("Tipo de reporte");
			lblTipoReporte.setBounds(10, 11, 106, 14);
			contentPanel.add(lblTipoReporte);
		}
		{
			cboTipoReporte = new JComboBox();
			cboTipoReporte.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedCboTipoReporte(e);
				}
			});
			cboTipoReporte.setModel(new DefaultComboBoxModel(new String[] {"Ventas por modelo", "Ventas en relación a la venta óptima", "Precios en relación al precio promedio", "Promedios, menores y mayores"}));
			cboTipoReporte.setBounds(129, 7, 295, 22);
			contentPanel.add(cboTipoReporte);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			scrollPane.setBounds(10, 36, 600, 499);
			contentPanel.add(scrollPane);
			{
				txtS = new JTextArea();
				scrollPane.setViewportView(txtS);
			}
		}
		{
			JButton btnCerrar = new JButton("Cerrar");
			btnCerrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnCerrar(e);
				}
			});
			btnCerrar.setBounds(521, 7, 89, 23);
			contentPanel.add(btnCerrar);
			
			//Obtener tipo reporte
			obtenerTipoReporte();
		}
	}

	private void obtenerTipoReporte() {
		int reporte = cboTipoReporte.getSelectedIndex();
		//txtS.setText(null);
		switch (reporte) {
		case 0 : 
			ventasPorModelo();
			break;
		case 1 : 
			ventasOptimas();
			break;
		case 2 : 
			precioPromedio();
			break;
		default: 
			menoresMayores();
			break;
		}
	}
	
	private void ventasPorModelo() {
		
		// TODO Auto-generated method stub
		txtS.setText("		VENTAS POR MODELO \n\n");
		imprimir("Modelo			: " + FrmPrincipal.modelo0);
		imprimir("Cantidad de ventas		: " + FrmPrincipal.cantVentas0);
		imprimir("Cantidad de unidades vendidas		: " + FrmPrincipal.cantUnidadesVendidas0);
		imprimir("Importe total vendido		: " + FrmPrincipal.precioTotalVentas0);
		imprimir("Aporte de cuota diaria:		: " + Adicionales.df.format(FrmPrincipal.cuotaDiaria0) +" % " +"\n");
		
		imprimir("Modelo			: " + FrmPrincipal.modelo1);
		imprimir("Cantidad de ventas		: " + FrmPrincipal.cantVentas1);
		imprimir("Cantidad de unidades vendidas		: " + FrmPrincipal.cantUnidadesVendidas1);
		imprimir("Importe total vendido		: " + FrmPrincipal.precioTotalVentas1);
		imprimir("Aporte de cuota diaria		: " + Adicionales.df.format(FrmPrincipal.cuotaDiaria1) +" % " +"\n");
		
		imprimir("Modelo			: " + FrmPrincipal.modelo2);
		imprimir("Cantidad de ventas		: " + FrmPrincipal.cantVentas2);
		imprimir("Cantidad de unidades vendidas		: " + FrmPrincipal.cantUnidadesVendidas2);
		imprimir("Importe total vendido		: " + FrmPrincipal.precioTotalVentas2);
		imprimir("Aporte de cuota diaria		: " + Adicionales.df.format(FrmPrincipal.cuotaDiaria2) +" % " +"\n");
		
		imprimir("Modelo			: " + FrmPrincipal.modelo3);
		imprimir("Cantidad de ventas		: " + FrmPrincipal.cantVentas3);
		imprimir("Cantidad de unidades vendidas		: " + FrmPrincipal.cantUnidadesVendidas3);
		imprimir("Importe total vendido		: " + FrmPrincipal.precioTotalVentas3);
		imprimir("Aporte de cuota diaria		: " + Adicionales.df.format(FrmPrincipal.cuotaDiaria3) +" % " +"\n");
		
		imprimir("Modelo			: " + FrmPrincipal.modelo4);
		imprimir("Cantidad de ventas		: " + FrmPrincipal.cantVentas4);
		imprimir("Cantidad de unidades vendidas		: " + FrmPrincipal.cantUnidadesVendidas4);
		imprimir("Importe total vendido		: " + FrmPrincipal.precioTotalVentas4);
		imprimir("Aporte de cuota diaria		: " + Adicionales.df.format(FrmPrincipal.cuotaDiaria4) +" % " +"\n");
		
	}

	private void ventasOptimas() {
		// TODO Auto-generated method stub
		txtS.setText("		VENTAS EN RELACIÓN A LA VENTA ÓPTIMA \n\n");
		imprimir("Modelo			:" + FrmPrincipal.modelo0);
		imprimir("Precio			:" + "S/. " + FrmPrincipal.precio0 +"\n");

		imprimir("Modelo			:" + FrmPrincipal.modelo1);
		imprimir("Precio			:" + "S/. " + FrmPrincipal.precio1 +"\n");

		imprimir("Modelo			:" + FrmPrincipal.modelo2);
		imprimir("Precio			:" + "S/. " +FrmPrincipal.precio2 +"\n");

		imprimir("Modelo			:" + FrmPrincipal.modelo3);
		imprimir("Precio			:" + "S/. " + FrmPrincipal.precio3 +"\n");

		imprimir("Modelo			:" + FrmPrincipal.modelo4);
		imprimir("Precio			:" + "S/. " + FrmPrincipal.precio4 +"\n");
	}

	private void precioPromedio() {
		//Declaración de variables
		String textoPrecio0,textoPrecio1,textoPrecio2,textoPrecio3,textoPrecio4;
		double promedioVentas;
		//Entrada de Datos
		promedioVentas = calcularPromedioVentas();
		
		textoPrecio0 = calcularEnBasePromedio(promedioVentas, FrmPrincipal.precio0);
		textoPrecio1 = calcularEnBasePromedio(promedioVentas, FrmPrincipal.precio1);
		textoPrecio2 = calcularEnBasePromedio(promedioVentas, FrmPrincipal.precio2);
		textoPrecio3 = calcularEnBasePromedio(promedioVentas, FrmPrincipal.precio3);
		textoPrecio4 = calcularEnBasePromedio(promedioVentas, FrmPrincipal.precio4);
		// Mostrar resultados precio promedio
		txtS.setText("		PRECIOS EN RELACIÓN AL PRECIO PROMEDIO \n\n");
		imprimir("Modelo			:" + FrmPrincipal.modelo0);
		imprimir("Precio			:" + textoPrecio0 + "\n");
		imprimir("Modelo			:" + FrmPrincipal.modelo0);
		imprimir("Precio			:" + textoPrecio1 + "\n");
		imprimir("Modelo			:" + FrmPrincipal.modelo0);
		imprimir("Precio			:" + textoPrecio2 + "\n");
		imprimir("Modelo			:" + FrmPrincipal.modelo0);
		imprimir("Precio			:" + textoPrecio3 + "\n");
		imprimir("Modelo			:" + FrmPrincipal.modelo0);
		imprimir("Precio			:" + textoPrecio4 + "\n");
		
	}
	
	private String calcularEnBasePromedio(double promedioVentas, double precio) {
	
		if(promedioVentas > precio) {
			return "S/. " + precio + "Menor al promedio";
		}else {
			return "S/. " + precio + "Mayor al promedio";
		}
	}

	private double calcularPromedioVentas(){
		double promedio;
		promedio = ((FrmPrincipal.precio0 + FrmPrincipal.precio1 + FrmPrincipal.precio2 + FrmPrincipal.precio3 + FrmPrincipal.precio4)/5);
		return promedio;
	}
	
	private double calcularPromedioAncho(){
		double promedio;
		promedio = ((FrmPrincipal.ancho0 + FrmPrincipal.ancho1 + FrmPrincipal.ancho2 + FrmPrincipal.ancho3 + FrmPrincipal.ancho4 )/5);
		return promedio;
	}

	private void menoresMayores() {
		
		double promedioVentas, precioMenor, precioMayor, promedioAncho, anchoMenor, anchoMayor ;
		
		
		promedioVentas = calcularPromedioVentas();
		precioMenor = calcularPrecioMayoroMenor("menor");
		precioMayor = calcularPrecioMayoroMenor("mayor");
		
		promedioAncho = calcularPromedioAncho();
		anchoMenor = calcularAnchoMayoroMenor("menor");
		anchoMayor = calcularAnchoMayoroMenor("mayor");
		
		
		// TODO Auto-generated method stub
		txtS.setText("PROMEDIOS, MENORES Y MAYORES \n\n");
		imprimir("Precio promedio			: S/ " + promedioVentas);
		imprimir("Precio menor				: S/ " + precioMenor);
		imprimir("Precio mayor				: S/ " + precioMayor + "\n");
		
		imprimir("Ancho promedio			: S/ " + promedioAncho);
		imprimir("Ancho menor				: S/ " + anchoMenor);
		imprimir("Ancho mayor				: S/ " + anchoMayor);
	}

	
	private double calcularPrecioMayoroMenor(String tipo) {
		// TODO Auto-generated method stub
		
		double precio0, precio1, precio2, precio3, precio4, precioMayorMenor = 0;
		precio0 = FrmPrincipal.precio0;
		precio1 = FrmPrincipal.precio1;
		precio2 = FrmPrincipal.precio2;
		precio3 = FrmPrincipal.precio3;
		precio4 = FrmPrincipal.precio4;
		
	    List<Double> list = new ArrayList<>(Arrays.asList(precio0, precio1, precio2, precio3, precio4));

		switch (tipo) {
			case "menor": {
				precioMayorMenor = Collections.min(list);
				break;
			}
			case "mayor": {
				precioMayorMenor = Collections.max(list);
				break;
			}
		}
		
		return precioMayorMenor;
		
	}

	private double calcularAnchoMayoroMenor(String tipo) {
		// TODO Auto-generated method stub
		
		double ancho0, ancho1, ancho2, ancho3, ancho4, anchoMayorMenor = 0;
		ancho0 = FrmPrincipal.ancho0;
		ancho1 = FrmPrincipal.ancho1;
		ancho2 = FrmPrincipal.ancho2;
		ancho3 = FrmPrincipal.ancho3;
		ancho4 = FrmPrincipal.ancho4;
		
	    List<Double> list = new ArrayList<>(Arrays.asList(ancho0, ancho1, ancho2, ancho3, ancho4));

		switch (tipo) {
			case "menor": {
				anchoMayorMenor = Collections.min(list);	
				break;
			}
			case "mayor": {
				anchoMayorMenor = Collections.max(list);
				break;
			}
		}
		
		return anchoMayorMenor;
		
	}

	private double calcularPrecioMenor() {
		// TODO Auto-generated method stub
		return 0;
	}

	private void imprimir(String cad) {
		txtS.append(cad + "\n");
	}
	
	protected void actionPerformedCboTipoReporte(ActionEvent e) {
		//Declaración de variables
				int tipoReporte;
		//Entrada de datos
				tipoReporte = getTipoReporte();
		//Salida de resultados
				obtenerTipoReporte();
	}

	private int getTipoReporte() {
		return cboTipoReporte.getSelectedIndex();
	}		
		
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
}
		

