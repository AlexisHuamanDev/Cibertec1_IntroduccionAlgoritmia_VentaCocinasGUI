package sistemaVentasCocina;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class FrmPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenu mnMantenimiento;
	private JMenu mnVentas;
	public static JMenu mnConfiguracion;
	private JMenu mnAyuda;
	private JMenuItem mntmSalir;
	private JMenuItem mntmConsultarCocina;
	public static JMenuItem mntmModificarCocina;
	private JMenuItem mntmListarCocina;
	private JMenuItem mntmVender;
	private JMenuItem mntmGenerarReportes;
	public static JMenuItem mntmConfigurarDescuentos;
	public static JMenuItem mntmConfigurarObsequios;
	public static JMenuItem mntmConfigurarCantidad;
	public static JMenuItem mntmConfigurarCuota;
	private JMenuItem mntmAcercaTienda;
	
	//Variables globnales
	// Datos mínimos de la primera cocina
	public static String modelo0 = "Mabe EMP6120PG0";
	public static double precio0 = 949.0;
	public static double fondo0 = 58.6;
	public static double ancho0 = 60.0;
	public static double alto0 = 91.0;
	public static int quemadores0 = 4;
	public static int cantVentas0 = 0;
	public static int cantUnidadesVendidas0 = 0;
	public static double precioTotalVentas0 = 0.0;
	public static double cuotaDiaria0;
	// Datos mínimos de la segunda cocina
	public static String modelo1 = "Indurama Parma";
	public static double precio1 = 1089.0;
	public static double ancho1 = 80.0;
	public static double alto1 = 94.0;
	public static double fondo1 = 67.5;
	public static int quemadores1 = 6;
	public static int cantVentas1 = 0;
	public static int cantUnidadesVendidas1 = 0;
	public static double precioTotalVentas1 = 0.0;
	public static double cuotaDiaria1;
	// Datos mínimos de la tercera cocina
	public static String modelo2 = "Sole COSOL027";
	public static double precio2 = 850.0;
	public static double ancho2 = 60.0;
	public static double alto2 = 90.0;
	public static double fondo2 = 50.0;
	public static int quemadores2 = 4;
	public static int cantVentas2 = 0;
	public static int cantUnidadesVendidas2 = 0;
	public static double precioTotalVentas2 = 0.0;
	public static double cuotaDiaria2;
	// Datos mínimos de la cuarta cocina
	public static String modelo3 = "Coldex CX602";
	public static double precio3 = 629.0;
	public static double ancho3 = 61.6;
	public static double alto3 = 95.0;
	public static double fondo3 = 51.5;
	public static int quemadores3 = 5;
	public static int cantVentas3 = 0;
	public static int cantUnidadesVendidas3 = 0;
	public static double precioTotalVentas3 = 0.0;
	public static double cuotaDiaria3;
	// Datos mínimos de la quinta cocina
	public static String modelo4 = "Reco Dakota";
	public static double precio4 = 849.0;
	public static double ancho4 = 75.4;
	public static double alto4 = 94.5;
	public static double fondo4 = 66.0;
	public static int quemadores4 = 5;
	public static int cantVentas4 = 0;
	public static int cantUnidadesVendidas4 = 0;
	public static double precioTotalVentas4 = 0.0;
	public static double cuotaDiaria4;
	// Porcentajes de descuento
	public static double porcentaje1 = 7.5;
	public static double porcentaje2 = 10.0;
	public static double porcentaje3 = 12.5;
	public static double porcentaje4 = 15.0;
	// Obsequios
	public static String obsequio1 = "Cafetera";
	public static String obsequio2 = "Licuadora";
	public static String obsequio3 = "Extractor";
	// Cantidad óptima de unidades vendidas
	public static int cantidadOptima = 30;
	// Cuota diaria
	public static double cuotaDiaria = 75000;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal frame = new FrmPrincipal();
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
	public FrmPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmPrincipal.class.getResource("/img/miCocina1.png")));
		setTitle("MI COCINA SAC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 767, 524);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		mnArchivo.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/file.png")));
		mnArchivo.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmSalir(e);
			}
		});
		mnArchivo.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnMantenimiento.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/mantenimiento.png")));
		menuBar.add(mnMantenimiento);
		
		mntmConsultarCocina = new JMenuItem("Consultar cocina");
		mntmConsultarCocina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmConsultarCocina(e);
			}
		});
		mnMantenimiento.add(mntmConsultarCocina);
		
		mntmModificarCocina = new JMenuItem("Modificar cocina");
		mntmModificarCocina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmModificarCocina(e);
			}
		});
		mnMantenimiento.add(mntmModificarCocina);
		
		mntmListarCocina = new JMenuItem("Listar cocinas");
		mntmListarCocina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmListarCocina(e);
			}
		});
		mnMantenimiento.add(mntmListarCocina);
		
		mnVentas = new JMenu("Ventas");
		mnVentas.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/tienda.png")));
		mnVentas.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(mnVentas);
		
		mntmVender = new JMenuItem("Vender");
		mntmVender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmVender(e);
			}
		});
		mnVentas.add(mntmVender);
		
		mntmGenerarReportes = new JMenuItem("Generar reportes");
		mntmGenerarReportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmGenerarReportes(e);
			}
		});
		mnVentas.add(mntmGenerarReportes);
		
		mnConfiguracion = new JMenu("Configuración");
		mnConfiguracion.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnConfiguracion.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/configuracion.png")));
		menuBar.add(mnConfiguracion);
		
		mntmConfigurarDescuentos = new JMenuItem("Configurar descuentos");
		mntmConfigurarDescuentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmConfigurarDescuentos(e);
			}
		});
		mnConfiguracion.add(mntmConfigurarDescuentos);
		
		mntmConfigurarObsequios = new JMenuItem("Configurar obsequios");
		mntmConfigurarObsequios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmConfigurarObsequios(e);
			}
		});
		mnConfiguracion.add(mntmConfigurarObsequios);
		
		mntmConfigurarCantidad = new JMenuItem("Configurar cantidad óptima");
		mntmConfigurarCantidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmConfigurarCantidad(e);
			}
		});
		mnConfiguracion.add(mntmConfigurarCantidad);
		
		mntmConfigurarCuota = new JMenuItem("Configurar cuota diaria");
		mntmConfigurarCuota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionPerformedMntmConfigurarCuota(e);
			}
		});
		mnConfiguracion.add(mntmConfigurarCuota);
		
		mnAyuda = new JMenu("Ayuda");
		mnAyuda.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/ayuda.png")));
		mnAyuda.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(mnAyuda);
		
		mntmAcercaTienda = new JMenuItem("Acerca de tienda");
		mntmAcercaTienda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgAcercaDeTienda mod = new DlgAcercaDeTienda();
				mod.setVisible(true);
			}
		});
		mnAyuda.add(mntmAcercaTienda);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/fondoElectro.jpg")));
		lblNewLabel.setBounds(0, 0, 751, 431);
		contentPane.add(lblNewLabel);
	}
	protected void actionPerformedMntmSalir(ActionEvent e) {
		System.exit(0);
	}
	protected void actionPerformedMntmConsultarCocina(ActionEvent e) {
		DlgConsultarCocina con = new DlgConsultarCocina();
		con.setVisible(true);
		con.setLocationRelativeTo(this);
	}
	protected void actionPerformedMntmModificarCocina(ActionEvent e) {
		DlgModificarCocina mod = new DlgModificarCocina();
		mod.setVisible(true);
		mod.setLocationRelativeTo(this);
	}
	protected void actionPerformedMntmListarCocina(ActionEvent e) {
		DlgListarCocina list = new DlgListarCocina();
		list.setVisible(true);
		list.setLocationRelativeTo(this);
	}
	protected void actionPerformedMntmVender(ActionEvent e) {
		DlgVender vendr = new DlgVender();
		vendr.setVisible(true);
		vendr.setLocationRelativeTo(this);
	}
	protected void actionPerformedMntmGenerarReportes(ActionEvent e) {
		DlgGenerarReportes rep = new DlgGenerarReportes();
		rep.setVisible(true);
		rep.setLocationRelativeTo(this);
	}
	protected void actionPerformedMntmConfigurarDescuentos(ActionEvent e) {
		DlgConfigurarDescuentos dsct = new DlgConfigurarDescuentos();
		dsct.setVisible(true);
		dsct.setLocationRelativeTo(this);
	}
	protected void actionPerformedMntmConfigurarObsequios(ActionEvent e) {
		DlgConfigurarObsequios obs = new DlgConfigurarObsequios();
		obs.setVisible(true);
		obs.setLocationRelativeTo(this);
	}
	protected void actionPerformedMntmConfigurarCantidad(ActionEvent e) {
		DlgConfigurarCantidadOptima cantop = new DlgConfigurarCantidadOptima();
		cantop.setVisible(true);
		cantop.setLocationRelativeTo(this);
	}
	protected void actionPerformedMntmConfigurarCuota(ActionEvent e) {
		DlgConfigurarCuotaDiaria cuotdia = new DlgConfigurarCuotaDiaria();
		cuotdia.setVisible(true);
		cuotdia.setLocationRelativeTo(this);
	}
}