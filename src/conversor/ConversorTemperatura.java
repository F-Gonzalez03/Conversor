package conversor;

import javax.swing.JOptionPane;

/**
 * 
 * ConversorTemperatura es la clase hija que indiscutiblemente más cambios padece dentro de su codigo 
 * en comparación con las otras 3 clases hijas, ya que sus calculos son bastante más especificos.
 * 
 * @version 1.0
 * @author Facundo Gonzalez
 *
 */


public class ConversorTemperatura extends Conversor {

	private String nombreInicial;
	private String nombreFinal;
	private double tasaCambio;
	private int indicador;
	
	/**
	 * En este caso a diferencia de los otros metodos opciones(), le asignamos un valor de indicador para luego según
	 * el indicador hacer un calculo personalizado al tipo de cambio que se debe hacer.
	 */
	
	public ConversorTemperatura(){
		indicador = opciones();
		
	}
	
	public int opciones() {
        Object[] opciones = {"Celsius a Kelvin", "Celsius a Fahrenheit","Fahrenheit a Celsius", "Fahrenheit a Kelvin",
        		"Kelvin a Celsius", "Kelvin a Fahrenheit"};
        String mensaje = "Elija la temperatura a convertir";
        String titulo = "Temperatura";
        int tipoMensaje = JOptionPane.PLAIN_MESSAGE;
        String seleccion = (String) JOptionPane.showInputDialog(null, mensaje, titulo, tipoMensaje, null, opciones, opciones[0]);
        
        if (seleccion == null) {
          	 JOptionPane.showMessageDialog(null, "Finalizando Programa!", "Cerrando", JOptionPane.INFORMATION_MESSAGE);
          	 System.exit(0); 
          }
		
        switch (seleccion) {
        
        case "Celsius a Kelvin":
        	indicador = 1;
        	nombreInicial = " Celsius";
            nombreFinal = " Kelvin";
            break;
        case "Celsius a Fahrenheit":
        	indicador = 2;
        	nombreInicial = " Celsius";
            nombreFinal = " Fahrenheit";
            break;  
        case "Fahrenheit a Celsius":
        	indicador = 3;
        	nombreInicial = " Fahrenheit";
            nombreFinal = " Celsius";
            break;  
        case "Fahrenheit a Kelvin":
        	indicador = 4;
        	nombreInicial = " Fahrenheit";
            nombreFinal = " Kelvin";
            break;  
        case "Kelvin a Celsius":
        	indicador = 5;
        	nombreInicial = " Kelvin";
            nombreFinal = " Celsius";
            break;  
        case "Kelvin a Fahrenheit":
        	indicador = 6;
        	nombreInicial = " Kelvin";
            nombreFinal = " Fahrenheit";
            break;  
        default:
            JOptionPane.showMessageDialog(null, "Opción no válida.", "Error", JOptionPane.ERROR_MESSAGE);
            break;  
        }
        return indicador;
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
     * El metodo convertir en este caso recibe un indicador con la selección del usuario, ya que 
     * cada conversión de temperatura tiene un calculo independiente y personalizado, de esta manera es como 
     * lo calcule.
     */
	@Override
	
	public double convertir(double valor) {
		System.out.println(indicador);
		switch(indicador) {
		
		case 1:
			tasaCambio = valor + 273.15;
			break;
		case 2:
			tasaCambio = (valor *9/5) + 32;
			break;
		case 3:
			tasaCambio = (valor - 32) * 5/9;
			break;
		case 4:
			tasaCambio = (valor - 32) * 5/9 + 273.15;
			break;
		case 5:
			tasaCambio = valor - 273.15;
			break;
		case 6:
			tasaCambio = (valor - 273.15) * 9/5 + 32;
			break;
		}
		return tasaCambio;
	}
	
}