package conversor;

import javax.swing.JOptionPane;

public class ConversorLongitud extends Conversor {
    private double tasaCambio;
    private String nombreInicial;
    private String nombreFinal;
  
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
                nombreInicial = " Metros equivalen a ";
                nombreFinal = " Kilometros";
                break;
            case "Metro a Milla":
                tasaCambio = 0.000621371;
                nombreInicial = " Metros equivalen a ";
                nombreFinal = " Millas";
                break;
            case "Kilometro a Metro":
            	tasaCambio = 1000;
            	nombreInicial = " Kilometros equivalen a ";
            	nombreFinal = " Metros";
            	break;
            case "Kilometro a Milla":
            	tasaCambio = 0.621371;
            	nombreInicial = " Kilometros equivalen a ";
            	nombreFinal = " Millas";
            	break;
            case "Milla a Kilometro":
            	tasaCambio = 1.60934;
            	nombreInicial = " Millas equivalen a ";
            	nombreFinal = " Kilometros";
            	break;
            case "Milla a Metro":
                tasaCambio = 1609.34;
                nombreInicial = " Millas equivalen a ";
                nombreFinal = " Metros";
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
    
    public ConversorLongitud() {
        tasaCambio = opciones();
    }

    @Override
    public double convertir(double valor) {
        return valor * tasaCambio;
    }
}