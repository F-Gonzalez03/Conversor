package conversor;

import javax.swing.JOptionPane;

public class ConversorMonedas extends Conversor {
    private double tasaCambio;
    private String nombreInicial;
    private String nombreFinal;
  
    public double opciones() {
        Object[] opciones = {"De Pesos a Dólar", "De Pesos a Euro", "De Pesos a Libra", "De Pesos a Yen",
                "De Pesos a Won Coreano", "De Dólar a Pesos", "De Euro a Pesos", "De Libra a Pesos",
                "De Yen a Pesos", "De Won Coreano a Pesos"};
        String mensaje = "Elija la moneda a la que deseas convertir tu dinero";
        String titulo = "Monedas";
        int tipoMensaje = JOptionPane.PLAIN_MESSAGE;
        String seleccion = (String) JOptionPane.showInputDialog(null, mensaje, titulo, tipoMensaje, null, opciones, opciones[0]);
        
        if (seleccion == null) {
       	 JOptionPane.showMessageDialog(null, "Finalizando Programa!", "Cerrando", JOptionPane.INFORMATION_MESSAGE);
       	 System.exit(0); 
       }
        switch (seleccion) {
            case "De Pesos a Dólar":
                tasaCambio = 1.0 / 525.0; // Usamos 1.0 para asegurar que se realice la división como double
                nombreInicial = " Pesos equivalen a ";
                nombreFinal = " Dolares";
                break;
            case "De Pesos a Euro":
                tasaCambio = 1 / 300;
                nombreInicial = " Pesos equivalen a ";
                nombreFinal = " Euros";
                break;
            case "De Pesos a Libra":
            	tasaCambio = 1 / 347;
            	nombreInicial = " Pesos equivalen a ";
            	nombreFinal = " Libras";
            	break;
            case "De Pesos a Yen":
            	tasaCambio = 1/ 2;
            	nombreInicial = " Pesos equivalen a ";
            	nombreFinal = " Yenes";
            	break;
            case "De Pesos a Won Coreano":
            	tasaCambio = 4.71;
            	nombreInicial = " Pesos equivalen a ";
            	nombreFinal = " Won Coreanos";
            	break;
            case "De Dólar a Pesos":
                tasaCambio = 525.0;
                nombreInicial = " Dolares equivalen a ";
                nombreFinal = " Pesos";
                break;
            case "De Euro a Pesos":
            	tasaCambio = 300;
            	nombreInicial = " Euros equivalen a ";
            	nombreFinal = " Pesos";
            	break;
            case "De Libra a Pesos":
            	tasaCambio = 347;
            	nombreInicial = " Euros equivalen a ";
            	nombreFinal = " Pesos";
            	break;
            case "De Yen a Pesos":
            	tasaCambio = 2;
            	nombreInicial = " Yenes equivalen a ";
            	nombreFinal = " Pesos";
            	break;
            case "De Won Coreano a Pesos":
            	tasaCambio = 1 / 4.71;
            	nombreInicial = " Yenes equivalen a ";
            	nombreFinal = " Pesos";
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
    
    public ConversorMonedas() {
        tasaCambio = opciones();
    }

    @Override
    public double convertir(double valor) {
        return valor * tasaCambio;
    }
}