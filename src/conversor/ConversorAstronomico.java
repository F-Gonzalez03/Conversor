package conversor;

import javax.swing.JOptionPane;

/**
 * 
 * ConversorAstronomico es una clase hija de Conversor, esta se encarga de transformar medidas astronomicas,
 * por el momento solo disponibles Años Luz, Minutos luz y Segundos luz
 * 
 * @version 1.0
 * @author Facundo Gonzalez
 *
 */


public class ConversorAstronomico extends Conversor {
    private double tasaCambio;
    private String nombreInicial;
    private String nombreFinal;
  
    /**
     * Opciones al igual que en las otras clases hijas se encargar de lanzar el menu para que puedas seleccionar
     * la medida correspondiente que quisieras convertir.
     * @return
     */
    
    
    public double opciones() {
        Object[] opciones = {"Año Luz a Minuto Luz", "Año Luz a Segundo Luz","Minuto Luz a Año Luz", 
        		"Minuto Luz a Segundo Luz", "Segundo luz a Año Luz", "Segundo luz a Minuto Luz"};
        String mensaje = "Seleccione la longitud que quisieras convertir";
        String titulo = "Longitud";
        int tipoMensaje = JOptionPane.PLAIN_MESSAGE;
        String seleccion = (String) JOptionPane.showInputDialog(null, mensaje, titulo, tipoMensaje, null, opciones, opciones[0]);
        
        if (seleccion == null) {
       	 JOptionPane.showMessageDialog(null, "Finalizando Programa!", "Cerrando", JOptionPane.INFORMATION_MESSAGE);
       	 System.exit(0); 
       }
        switch (seleccion) {
            case "Año Luz a Minuto Luz":
                tasaCambio = 525960; // Usamos 1.0 para asegurar que se realice la división como double
                nombreInicial = " Años luz";
                nombreFinal = " Minutos luz";
                break;
            case "Año Luz a Segundo Luz":
                tasaCambio = 31557610;
                nombreInicial = " Años luz";
                nombreFinal = " Segundos Luz";
                break;
            case "Minuto Luz a Año Luz":
            	tasaCambio = 1.9013e-6;
            	nombreInicial = " Minutos luz";
            	nombreFinal = " Años luz";
            	break;
            case "Minuto Luz a Segundo Luz":
            	tasaCambio = 60;
            	nombreInicial = " Minutos luz";
            	nombreFinal = " Segundos luz";
            	break;
            case "Segundo luz a Año Luz":
            	tasaCambio = 3.1688077858*10e-8;
            	nombreInicial = " Segundos luz";
            	nombreFinal = " Años luz";
            	break;
            case "Segundo luz a Minuto Luz":
                tasaCambio = 0.0166666687;
                nombreInicial = " Segundos luz";
                nombreFinal = " Minuto luz";
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida.", "Error", JOptionPane.ERROR_MESSAGE);
                break;
        }
        return tasaCambio;
    }

    
  //esto es una refaccion provisoria para determinar el tipo de moneda y facilitar la nomenclatura
    public String getnombreFinal() {
		return nombreFinal;
	}
    
    
  //esto es una refaccion provisoria para determinar el tipo de moneda y facilitar la nomenclatura
    public String getnombreInicial() {
		return nombreInicial;
	}
    /**
     * Esto es un constructor, que lo que provoca es que se arroje antes el menu de seleccion que el input de
     * obtenerMonto()
     */
    public ConversorAstronomico() {
        tasaCambio = opciones();
    }

    
    /**
     * el metodo convertir obtiene el valor ingresado en el input de obtenerMonto() en la clase padre 
     * y lo multiplica por la tasa de cambio obtenida en el switch de opciones() 
     * 
     */
    
    @Override
    public double convertir(double valor) {
        return valor * tasaCambio;
    }
}