package conversor;

import javax.swing.JOptionPane;

/**
 * 
 * ConversorMonedas es una de las clases hijas de Conversor, su trabajo es principalmente el de convertir un monto
 * obtenido en el deseado por el usuario.
 * Por el momento tiene valores obsoletos o mejor dicho desactualizados, pendiente por agregar una api que los
 * actualice automaticamente al dia de la fecha.
 * 
 * @version 1.0
 * @author Facundo Gonzalez
 *
 */
public class ConversorMonedas extends Conversor {
    private double tasaCambio;
    private String nombreInicial;
    private String nombreFinal;
    
    
    /**
     * opciones() se encarga de lanzar un menu con las opciones de monedas seleccionables, ademas de eso 
     * en base a la moneda que elegiste va a lanzar una tasa de cambio hacia el metodo convertir()
     * @return
     */
    public double opciones()  {
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
                tasaCambio = 1.0 / 555.0; // Uso 1.0 para asegurarme que se realice la división como double
                nombreInicial = " Pesos";
                nombreFinal = " Dolares";
                break;
            case "De Pesos a Euro":
                tasaCambio = 1.0 / 300.0;
                nombreInicial = " Pesos";
                nombreFinal = " Euros";
                break;
            case "De Pesos a Libra":
            	tasaCambio = 1.0 / 347.0;
            	nombreInicial = " Pesos";
            	nombreFinal = " Libras";
            	break;
            case "De Pesos a Yen":
            	tasaCambio = 1.0 / 2.0;
            	nombreInicial = " Pesos";
            	nombreFinal = " Yenes";
            	break;
            case "De Pesos a Won Coreano":
            	tasaCambio = 4.71;
            	nombreInicial = " Pesos";
            	nombreFinal = " Won Coreanos";
            	break;
            case "De Dólar a Pesos":
                tasaCambio = 555;
                nombreInicial = " Dolares";
                nombreFinal = " Pesos";
                break;
            case "De Euro a Pesos":
            	tasaCambio = 300;
            	nombreInicial = " Euros";
            	nombreFinal = " Pesos";
            	break;
            case "De Libra a Pesos":
            	tasaCambio = 347;
            	nombreInicial = " Euros";
            	nombreFinal = " Pesos";
            	break;
            case "De Yen a Pesos":
            	tasaCambio = 2;
            	nombreInicial = " Yenes";
            	nombreFinal = " Pesos";
            	break;
            case "De Won Coreano a Pesos":
            	tasaCambio = 1.0 / 4.71;
            	nombreInicial = " Yenes";
            	nombreFinal = " Pesos";
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
    public ConversorMonedas()  {
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
    
    /**
     * actualizador, se encarga de informarle al usuario el valor de tasa de cambio que tiene ingresado el sistema, de esta manera
     * el usuario puede utilizar el programa en cualquier momento, esta es una medida provisoria mientras no esta implementado la 
     * api que actualizara los precios en tiempo real.
     * @return
     */
    
    public boolean actualizador() {
    	Object[] opciones = {"Si", "No"};
        int seleccion = (int) JOptionPane.showOptionDialog(null,"El valor de los" + getnombreInicial() + 
        		" es de " + tasaCambio + getnombreFinal() + " desea actualizar el valor de la moneda?","Menu",
        		JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,opciones,opciones[0]);
        if (seleccion == 0 ) {
        	double tasaNueva = Conversor.obtenerMonto("Ingrese el nuevo valor de la moneda!");
        	tasaCambio = tasaNueva;
        	JOptionPane.showMessageDialog(null, "Valores Cambiados!", "Menu", JOptionPane.INFORMATION_MESSAGE);
        	return true;
        }else {
        	JOptionPane.showMessageDialog(null, "Excelente, los valores se mantienen", "Menu", JOptionPane.INFORMATION_MESSAGE);
        	return false;
        }
    }

    
    
}