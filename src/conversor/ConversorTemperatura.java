package conversor;

import javax.swing.JOptionPane;

public class ConversorTemperatura extends Conversor {

	private String seleccion;
	private String nombreInicial;
	private String nombreFinal;
	private double tasaCambio;
	
	
	public double opciones() {
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
        	tasaCambio = 274.15;
        	nombreInicial = " Celsius equivalen a ";
            nombreFinal = " Kelvin";
            break;
        case "Celsius a Fahrenheit":
        	tasaCambio = 33.8;
        	nombreInicial = " Celsius equivalen a ";
            nombreFinal = " Fahrenheit";
            break;  
        case "Fahrenheit a Celsius":
        	tasaCambio = -17.2222;
        	nombreInicial = " Fahrenheit equivalen a ";
            nombreFinal = " Celsius";
            break;  
        case "Fahrenheit a Kelvin":
        	tasaCambio = 255.93;
        	nombreInicial = " Fahrenheit equivalen a ";
            nombreFinal = " Kelvin";
            break;  
        case "Kelvin a Celsius":
        	tasaCambio = -272.15;
        	nombreInicial = " Kelvin equivalen a ";
            nombreFinal = " Celsius";
            break;  
        case "Kelvin a Fahrenheit":
        	tasaCambio = -457.87;
        	nombreInicial = " Kelvin equivalen a ";
            nombreFinal = " Fahrenheit";
            break;  
        default:
            JOptionPane.showMessageDialog(null, "Opción no válida.", "Error", JOptionPane.ERROR_MESSAGE);
            break;  
        }
        return tasaCambio;
	}	
	
	public String getnombreFinal() {
		return nombreFinal;
	}
    
    public String getnombreInicial() {
		return nombreInicial;
	}
    
    public ConversorTemperatura() {
        tasaCambio = opciones();
    }
	@Override
	public double convertir(double valor) {
		return valor * tasaCambio;
	}

}