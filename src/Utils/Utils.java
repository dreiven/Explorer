package Utils;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 *
 *
 *@author Alberto Arranz
 *@version 2.1
 *@since 13-9-2016.
 *
 */

public class Utils {

	/**
	 * Proceso de escalado de imagenes.
	 * 
	 * @param ruta_nombre
	 *            Ruta interna del icono/imagen.
	 * @param tamaño
	 *            Valor entero que representa el tamaño a aplicar, definido en
	 *            constantes de clase.
	 * @return Imagen escalada.
	 */
	
	
	// CONJUNTO DE VALORES PARA LAS CONSTANTES DE CLASE
		public static final int _16X16 = 10;
		public static final int _24X24 = 20;
		public static final int _32X32 = 30;
		public static final int _48X48 = 40;
		public static final int _60X60 = 60;
		public static final int _256X256 = 50;
		
	public static ImageIcon escalar_Imagen(String ruta_nombre, int tamaño) {
		// OBTENEMOS LA IMAGEN A ESCALAR
		ImageIcon imagen_tratada = new ImageIcon(
				Utils.class.getResource(ruta_nombre));
		// ESTABLECEMOS LA ESCALA SEGUN NECESIDADES
		if (tamaño == _16X16) {
			imagen_tratada = new ImageIcon(imagen_tratada.getImage()
					.getScaledInstance(16, 16, Image.SCALE_SMOOTH));
		}
		if (tamaño == _24X24) {
			imagen_tratada = new ImageIcon(imagen_tratada.getImage()
					.getScaledInstance(24, 24, Image.SCALE_SMOOTH));
		}
		if (tamaño == _32X32) {
			imagen_tratada = new ImageIcon(imagen_tratada.getImage()
					.getScaledInstance(32, 32, Image.SCALE_SMOOTH));
		}
		if (tamaño == _48X48) {
			imagen_tratada = new ImageIcon(imagen_tratada.getImage()
					.getScaledInstance(48, 48, Image.SCALE_SMOOTH));
		}
		if (tamaño == _60X60) {
			imagen_tratada = new ImageIcon(imagen_tratada.getImage()
					.getScaledInstance(60, 60, Image.SCALE_SMOOTH));
		}
		if (tamaño == _256X256) {
			imagen_tratada = new ImageIcon(imagen_tratada.getImage()
					.getScaledInstance(256, 256, Image.SCALE_SMOOTH));
		}
		return imagen_tratada;
	}
	
	/**
	 * Proceso de escalado de imagenes a 24x24.<br/>
	 * Metodo de conveniencia para pasar menos parametros en la llamada al
	 * metodo.
	 * 
	 * @param ruta_nombre
	 *            Ruta interna del icono/imagen.
	 * @return Imagen escalada.
	 */
	public static ImageIcon escalar_Imagen(String ruta_nombre) {
		ImageIcon imagen_tratada = new ImageIcon(
				Utils.class.getResource(ruta_nombre));
		imagen_tratada = escalar_Imagen(ruta_nombre, _24X24);
		
		return imagen_tratada;
	}
	
	/**
	 * Proceso de escalado segun el tamaño concreto que se le indique en pixels.
	 * 
	 * @param ruta_nombre
	 *            Ruta y nombre del fichero de la imagen a escalar.
	 * @param ancho
	 *            Valor que indicara el tamaño a dar a la imagen a lo ancho,
	 * @param alto
	 *            Valor que indicara el tamaño a dar a la imagen a lo alto.
	 * 
	 * @return Imagen escalada.
	 */
	public static ImageIcon escalar_Imagen(String ruta_nombre, int ancho,
			int alto) {
		// OBTENEMOS LA IMAGEN A ESCALAR
		ImageIcon imagen_tratada = new ImageIcon(
				Utils.class.getResource(ruta_nombre));
		// ESTABLECEMOS LA ESCALA SEGUN NECESIDADES
		return new ImageIcon(imagen_tratada.getImage().getScaledInstance(ancho,
				alto, Image.SCALE_SMOOTH));
	}

	
	
	public static void estilo_nimbus() {

		// cargar el nuevo look and feel si se puede
		// RECOGEMOS TODOS LOS LOOK DISPONIBLES EN LA VERSION DE JDK
		LookAndFeelInfo tabla_laf[] = UIManager.getInstalledLookAndFeels();
		for (LookAndFeelInfo objeto_aparicencia : tabla_laf) {
			// COMPROBAMOS SI EXISTE NIMBUS
			if (objeto_aparicencia.getName().equals("Windows")) {
				// CARGAMOS NIMBUS CUANDO EXISTA SEGUN LA VERSION DE JDK
				// USADA
				try {
					UIManager.setLookAndFeel(objeto_aparicencia.getClassName());
					System.out.println("Cargando nimbus......");
				} catch (Exception e) {
					System.out.println("error en la carga de nimbus");
				}
			}
		}

	}

}
