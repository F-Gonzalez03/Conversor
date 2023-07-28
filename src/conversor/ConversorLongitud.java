package conversor;

import javax.swing.JOptionPane;

/**
 * 
 * ConversorLongitud es otra de las clases hijas de Conversor, esta en especifico se encarga de transformar
 * una medida de distancia en otra.
 * 
 * @author Facundo Gonzalez
 *
 */


public class ConversorLongitud extends Conversor {
    private double tasaCambio;
    private String nombreInicial;
    private String nombreFinal;
  
    /**
     * el metodo opciones, al igual que en las otras clases de conversion hijas, se encarga de lanzar
     * un menu con las opciones disponibles a convertir, ademas de eso tasa un valor en el cual luego
     * convertir() se va a basar para hacer el calculo.
     * @return
     */
    
    public double opciones() {
        Object[] opciones = {"Metro a Kilometro", "Metro a Milla", "Kilometro a Metro", "Kilometro a Milla", 
        		"Milla a Kilometro", "Milla a Metro"};
        String mensaje = "Seleccione la longitud que quisieras convertir";
        String titulo = "Longitud";
        int tipoMensaje = JOptionPane.PLAIN_MESSAGE;
        String seleccion = (String) JOptionPane.showInputDialog(null, mensaje, titulo, tipoMensaje, null, opciones, opciones[0]);
        
        if (seleccion == null) {
       	 JOptionPane.showMessageDialog(null, "Finalizando Programa!", "Cerrando", JOptionPane.INFORMATION_MESSAGE);
       	 System.exit(0); 
       }
        switch (seleccion) {
            case "Metro a Kilometro":
                tasaCambio = 0.001; // Usamos 1.0 para asegurar que se realice la división como double
                nombreInicial = " Metros";
                nombreFinal = " Kilometros";
                break;
            case "Metro a Milla":
                tasaCambio = 0.000621371;
                nombreInicial = " Metros";
                nombreFinal = " Millas";
                break;
            case "Kilometro a Metro":
            	tasaCambio = 1000;
            	nombreInicial = " Kilometros";
            	nombreFinal = " Metros";
            	break;
            case "Kilometro a Milla":
            	tasaCambio = 0.621371;
            	nombreInicial = " Kilometros";
            	nombreFinal = " Millas";
            	break;
            case "Milla a Kilometro":
            	tasaCambio = 1.60934;
            	nombreInicial = " Millas";
            	nombreFinal = " Kilometros";
            	break;
            case "Milla a Metro":
                tasaCambio = 1609.34;
                nombreInicial = " Millas";
                nombreFinal = " Metros";
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
    
    public ConversorLongitud() {
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