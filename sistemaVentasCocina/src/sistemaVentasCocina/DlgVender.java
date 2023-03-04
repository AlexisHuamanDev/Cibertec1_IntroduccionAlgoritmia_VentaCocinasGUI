package sistemaVentasCocina;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import utils.Adicionales;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings({ "serial", "unused" })
public class DlgVender extends JDialog {

	
	private final JPanel contentPanel = new JPanel();
	private JTextField txtPrecio;
	private JTextField txtCantidad;
	private JComboBox<?> cboModelo;
	private JTextArea txtS;
	
	//Contadores y acumuladores

	private int cantVentas = 0;
	private double importeTotal = 0;
	private double impCuotaDiaria = 0;
	
	LocalDateTime locaDate = LocalDateTime.now();
	int hours  = locaDate.getHour();
	int minutes = locaDate.getMinute();
	int seconds = locaDate.getSecond();
	
	int año = locaDate.getYear();
    int mes = locaDate.getMonthValue();
    int dia = locaDate.getDayOfMonth();
    private JLabel lblFormaPago;
    @SuppressWarnings("rawtypes")
	private JComboBox cboPago;
    private JScrollPane scrollPane;
	
	/*
	private int cant_ventas_Prod0;
	private int cant_total_Prod0;
	
	private int cant_ventas_Prod1;
	private int cant_total_Prod1;
	
	private int cant_ventas_Prod2;
	private int cant_total_Prod2;
	
	private int cant_ventas_Prod3;
	private int cant_total_Prod3;
	
	private int cant_ventas_Prod4;
	private int cant_total_Prod4;
	*/
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgVender dialog = new DlgVender();
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
	public DlgVender() {
		setTitle("Vender");
		setBounds(100, 100, 450, 516);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblModelo = new JLabel("Modelo");
			lblModelo.setBounds(61, 11, 62, 14);
			contentPanel.add(lblModelo);
		}
		{
			//JComboBox cboModelo = new JComboBox();
			cboModelo = new JComboBox();
			cboModelo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedCboModelo(e);
				}
			});
		
			cboModelo.setModel(new DefaultComboBoxModel(new String[] {"Mabe EMP6120PG0", "Indurama Parma", "Sole COSOL027", "Coldex CX602", "Reco Dakota"}));
			cboModelo.setBounds(146, 7, 142, 22);
			contentPanel.add(cboModelo);
		}
		{
			JLabel lblPrecio = new JLabel("Precio (S/.)");
			lblPrecio.setBounds(61, 43, 62, 14);
			contentPanel.add(lblPrecio);
		}
		{
			txtPrecio = new JTextField();
			txtPrecio.setEditable(false);
			txtPrecio.setBounds(146, 40, 142, 20);
			contentPanel.add(txtPrecio);
			txtPrecio.setColumns(10);
		}
		{
			JLabel lblCantidad = new JLabel("Cantidad");
			lblCantidad.setBounds(61, 74, 62, 14);
			contentPanel.add(lblCantidad);
		}
		{
			txtCantidad = new JTextField();
			txtCantidad.setBounds(146, 71, 142, 20);
			contentPanel.add(txtCantidad);
			txtCantidad.setColumns(10);
		}
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 139, 414, 327);
		contentPanel.add(scrollPane);
		{
			txtS = new JTextArea();
			scrollPane.setViewportView(txtS);
		}
		{
			JButton btnVender = new JButton("Vender");
			btnVender.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnVender(e);
				}
			});
			btnVender.setBounds(335, 7, 89, 23);
			contentPanel.add(btnVender);
		}
		{
			JButton btnCerrar = new JButton("Cerrar");
			btnCerrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnCerrar(e);
				}
			});
			btnCerrar.setBounds(335, 39, 89, 23);
			contentPanel.add(btnCerrar);
		}
		
		lblFormaPago = new JLabel("Forma Pago");
		lblFormaPago.setBounds(61, 106, 76, 14);
		contentPanel.add(lblFormaPago);
		
		cboPago = new JComboBox();
		cboPago.setModel(new DefaultComboBoxModel(new String[] {"Efectivo", "Tarjeta Crédito", "Transferencia Bancaria", "Yape", "Plin"}));
		cboPago.setBounds(146, 102, 142, 22);
		contentPanel.add(cboPago);
		cargarDatos();
	}
		
	private void cargarDatos() {
		int modelo = getModelo();
		double precio = getPrecio(modelo);
		txtPrecio.setText(precio+"");
	}

	
	protected void actionPerformedBtnVender(ActionEvent e) {
		//Declaración de variables
		int modelo,cant;
		double precio,impCompra,impDscto,impPagar;
		String obs;
		//Entrada de datos
		modelo = getModelo();
		precio = getPrecio(modelo);
		modelo = getModelo();
		//Ventana de confirmación
		Adicionales.yesNo("Seguro de realizar la venta?");  
		try {
			cant = getCantidad();
			//Validación de datos
			if(cant <= 0) {
				Adicionales.mensaje("Ingresar valores mayores a 0");
				actionPerformedBtnCerrar(e);
				return;
				
			}
		} catch (NumberFormatException e1) {
			Adicionales.mensaje("Ingresar valores numéricos");
			actionPerformedBtnCerrar(e);
			return;
		}
		//Proceso de cálculo 
		impCompra = calcIMporteCompra(modelo,cant);
		impDscto = calcImporteDscto(cant, impCompra);
		impPagar = calImportePagar(impCompra, impDscto);
		obs = calcObsequio(cant);
		//Salida de resultados
		calcularResultado(impPagar);
		calcVentasContadores(impPagar);
		mostrarResultado(precio, cant, impCompra, impDscto, impPagar, obs);
	}

	

	private void calcPorcentajeCuotaDiaria() {
		impCuotaDiaria = (importeTotal/ FrmPrincipal.cuotaDiaria)*100;		
	}

	private void calcVentasContadores(double totalaPagar) {
		
		int modelo = cboModelo.getSelectedIndex();
		
		switch (modelo) {
		case 0:
			FrmPrincipal.cantVentas0 ++ ;
			FrmPrincipal.precioTotalVentas0 += totalaPagar;
			FrmPrincipal.cantUnidadesVendidas0 += Integer.parseInt(txtCantidad.getText());
			FrmPrincipal.cuotaDiaria0 = FrmPrincipal.precioTotalVentas0 * 100 / FrmPrincipal.cuotaDiaria;
			
			break;
		case 1:
			FrmPrincipal.cantVentas1 ++ ;
			FrmPrincipal.precioTotalVentas1 += totalaPagar;
			FrmPrincipal.cantUnidadesVendidas1 += Integer.parseInt(txtCantidad.getText());
			FrmPrincipal.cuotaDiaria1 = FrmPrincipal.precioTotalVentas1 * 100 / FrmPrincipal.cuotaDiaria;
			break;
		case 2:
			FrmPrincipal.cantVentas2 ++ ;
			FrmPrincipal.precioTotalVentas2 += totalaPagar;
			FrmPrincipal.cantUnidadesVendidas2 += Integer.parseInt(txtCantidad.getText());
			FrmPrincipal.cuotaDiaria2 = FrmPrincipal.precioTotalVentas2 * 100 / FrmPrincipal.cuotaDiaria;
			break;
		case 3:
			FrmPrincipal.cantVentas3 ++ ;
			FrmPrincipal.precioTotalVentas3 += totalaPagar;
			FrmPrincipal.cantUnidadesVendidas3 += Integer.parseInt(txtCantidad.getText());
			FrmPrincipal.cuotaDiaria3 = FrmPrincipal.precioTotalVentas3 * 100 / FrmPrincipal.cuotaDiaria;
			break;
		case 4:
			FrmPrincipal.cantVentas4 ++ ;
			FrmPrincipal.precioTotalVentas4 += totalaPagar;
			FrmPrincipal.cantUnidadesVendidas4 += Integer.parseInt(txtCantidad.getText());
			FrmPrincipal.cuotaDiaria4 = FrmPrincipal.precioTotalVentas4 * 100 / FrmPrincipal.cuotaDiaria;
			break;
		}

	}
	
	private void mostrarResultadoCbo() {
		int modelo = getModelo();
		txtPrecio.setText(getPrecio(modelo)+"");
	}
	
	private void mostrarResultado(double precio, int cant, double impCompra, double impDscto, double impPagar, String obs) {
		txtS.setText("BOLETA DE VENTA\n\n");
		imprimir("Modelo	 	:  "  +  cboModelo.getSelectedItem());
		imprimir("Precio	 	:  S/."  +  precio);
		imprimir("Cantidad	 	:  "   +  cant);
		imprimir("Importe compra     	: S/."  +  Adicionales.df.format(impCompra));
		imprimir("Importe descuento  	: S/."  +  Adicionales.df.format(impDscto));
		imprimir("Importe pagar      	: S/."  +  Adicionales.df.format(impPagar));
		imprimir("Obsequio	 	: " + obs);
		
		txtS.setText(""+"\n");
		imprimir("	    	Mi Cocina SAC"+"\n");
		imprimir("	                         RUC 20607040544");
		imprimir("	    VENTA DE COCINAS PARA EL HOGAR \n");
		imprimir("	       BOLETA DE VENTA ELECTRÓNICA\n");
		imprimir("                  ------------------------------------------------------------------------------- ");
		imprimir("                  Fecha       	 : " + dia  + " / "+ mes +" / "+ año);
		imprimir("                  Hora 	    	: " + hours  + ":"+ minutes ); 
		imprimir("                  Venta		 : Nº "+ (cantVentas));
		imprimir("                  Forma de Pago	 : "  +  cboPago.getSelectedItem());
		imprimir("                  ------------------------------------------------------------------------------- \n");
		imprimir("                  Modelo	:  "  +  cboModelo.getSelectedItem());
		imprimir("                  Precio	:  S/."  +  precio);
		imprimir("                  Cantidad	:  "   +  cant);
		imprimir("                  Importe de compra	: S/.  "  +  Adicionales.df.format(impCompra));
		imprimir("                  Importe de descuento	: S/. "  +  Adicionales.df.format(impDscto));
		imprimir("                  Importe a pagar	: S/. "  +  Adicionales.df.format(impPagar)+"\n");
		imprimir("                  ------------------------------------------------------------------------------- \n");
		imprimir("                  	                     Obsequio:  " + obs+"\n");
		imprimir("                  ------------------------------------------------------------------------------- \n");
		imprimir(" 	         ▄▄▄▄▄▄▄  ▄ ▄▄ ▄▄▄▄▄▄▄               ");
		imprimir(" 	         █   ▄▄▄    █ █ ▀      █   ▄▄▄    █                ");
		imprimir(" 	         █   ███    █ ▄▀ ▀  █   ███    █ ");
		imprimir(" 	         █▄▄▄▄▄█ █ ▄▀  █▄▄▄▄▄█ ");
		imprimir(" 	         ▄▄ ▄  ▄▄▀██▀▀   ▄▄▄ ▄▄   ");
		imprimir(" 	         ▀ ▀ ▄▀▀▀█ ▄▄ ▀█▀██▀█  ");
		imprimir(" 	         ▄████▄▄▄ █▄▀▄ ▀    ▄▀  ");
		imprimir(" 	         ▄▄▄▄▄▄▄ ███▀ ▄ █▄█▄▄   ");
		imprimir(" 	         █    ▄▄▄   █   ▄▄█▀█▄  ▀  ▄▄   ");
		imprimir(" 	         █    ███   █ ▀█▀▀▄  ██▄ ▀█   ");
		imprimir(" 	         █▄▄▄▄▄█ ██▄▄▄▀▀▄ ▄ ▄    \n");
		imprimir("                  	                     www.micocina.com  \n");
		imprimir("                  	             GRACIAS POR TU COMPRA  \n");
		
		
		txtS.setCaretPosition(0);
}
		
			
	
	private void calcularResultado(double impPagar) {
		//Ventas > 5 sale ventana emergente
		cantVentas ++;
		importeTotal += impPagar;
		calcPorcentajeCuotaDiaria();
		if(cantVentas%5 == 0) {
			String textDialog = "Venta #" + cantVentas + "\n";
			textDialog += "Importe total generado: S/. " + Adicionales.df.format(importeTotal) + "\n";
			textDialog += "Porcentaje de la cuota diaria: " +  Adicionales.df.format(impCuotaDiaria)+" %";
			Adicionales.sistema(textDialog);
		}
	}
	
	private void imprimir(String cad) {
		txtS.append(cad + "\n");
	}

	private String calcObsequio(int cant) {
		if(cant >= 1 && cant < 2)
			return  FrmPrincipal.obsequio1;
		else if(cant >= 2 && cant < 5 )
			return  FrmPrincipal.obsequio2;
		else
			return FrmPrincipal.obsequio3;
	}
	
	private double calImportePagar(double impCompra, double impDscto) {
		return impCompra - impDscto;
	}

	private double calcImporteDscto(int cant, double impCompra) {
		if (cant >= 1 && cant <= 5) 
			return impCompra * (FrmPrincipal.porcentaje1/100);
		else if (cant >= 6 && cant <= 10)
			return impCompra * (FrmPrincipal.porcentaje2/100);
		else if (cant >= 11 && cant <= 15)
			return impCompra * (FrmPrincipal.porcentaje3/100);
		else
			return impCompra * (FrmPrincipal.porcentaje4/100);				
	}

	private double calcIMporteCompra(int modelo, int cant) {
		Double precio = getPrecio(modelo);
		switch (modelo) {
		case 0:
			return cant * precio;
		case 1:
			return cant * precio;
		case 2:
			return cant * precio;
		case 3:
			return cant * precio;
		default:
			return cant * precio;
		}
		
	}

	private int getCantidad() {
		return Integer.parseInt(txtCantidad.getText());
	}
	
	private int getModelo() {
		return cboModelo.getSelectedIndex();
	}
	
	private double getPrecio(int modelo) {
		switch (modelo) {
		case 0: 
			return FrmPrincipal.precio0;
		case 1:
			return FrmPrincipal.precio1;
		case 2:
			return FrmPrincipal.precio2;
		case 3:
			return FrmPrincipal.precio3;
		default:
			return FrmPrincipal.precio4;
		}
	}
	
	protected void actionPerformedCboModelo(ActionEvent e) {
		mostrarResultadoCbo();
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
}
