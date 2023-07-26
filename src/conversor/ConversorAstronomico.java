package conversor;

import javax.swing.JOptionPane;

public class ConversorAstronomico extends Conversor {
    private double tasaCambio;
    private String nombreInicial;
    private String nombreFinal;
  
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
                nombreInicial = " Años luz equivalen a ";
                nombreFinal = " Minutos luz";
                break;
            case "Año Luz a Segundo Luz":
                tasaCambio = 31557610;
                nombreInicial = " Años luz equivalen a ";
                nombreFinal = " Segundos Luz";
                break;
            case "Minuto Luz a Año Luz":
            	tasaCambio = 1.9013e-6;
            	nombreInicial = " Minutos luz equivalen a ";
            	nombreFinal = " Años luz";
            	break;
            case "Minuto Luz a Segundo Luz":
            	tasaCambio = 60;
            	nombreInicial = " Minutos luz equivalen a ";
            	nombreFinal = " Segundos luz";
            	break;
            case "Segundo luz a Año Luz":
            	tasaCambio = 3.1688077858*10e-8;
            	nombreInicial = " Segundos luz a ";
            	nombreFinal = " Años luz";
            	break;
            case "Segundo luz a Minuto Luz":
                tasaCambio = 0.0166666687;
                nombreInicial = " Segundos luz equivalen a ";
                nombreFinal = " Minuto luz";
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
    
    public ConversorAstronomico() {
        tasaCambio = opciones();
    }

    @Override
    public double convertir(double valor) {
        return valor * tasaCambio;
    }
}