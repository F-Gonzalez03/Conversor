package Launcher;

import java.net.MalformedURLException;
import java.util.EventObject;

import javax.swing.JOptionPane;

import conversor.*;
/**
 * 
 * Esto es el launcher, es un ejecutable donde se encuentran todas las clases hijas, y lo que se exporta luego
 * para que el usuario ejecute.
 * Aqui se puede ver la acción de cada una de las clases
 * @author Facundo Gonzalez
 *
 */


public class Launcher {

	/**
	 * Esto es un metodo main normal, se utiliza para ejecutar funciones o metodos.
	 * @param args
	 */
	
	public static void main(String[] args)  {
		/**
		 * Este while provoca que el codigo se ejecute infinitamente mientras el usuario coloque "Si" en la
		 * pregunta final de "Quiere realizar otra acción?"
		 */
		while (true) {
			
		/**
		 * seleccion aloja lo que el usuario eligio cuando se muestra el primer menu de todos.
		 */
		String seleccion = Conversor.mostrarMenu();
        
		/**
		 * Este condicional "if" se encarga de verificar cual de las opciones a elegir selecciono el usuario.
		 */
		
        if (seleccion.equals("Conversor de Monedas")) {
        	
        	/**
        	 * Aqui lo que hacemos es crear un conversor del tipo ConversorMonedas, obtenemos el monto
        	 * a travez de su clase padre "Conversor" y luego lo convertimos con el metodo que hay dentro
        	 * de ConversorMonedas, luego mostramos la conversion realizada.
        	 * Este metodo es repetido en los otros if.
        	 */
        	
            ConversorMonedas conversor1 = new ConversorMonedas();
            boolean actualizador = conversor1.actualizador();
            double monto = conversor1.obtenerMonto("Ingrese la cantidad a convertir");
            double montoConvertido = conversor1.convertir(monto);
            JOptionPane.showMessageDialog(null, monto + conversor1.getnombreInicial() + " Equivalen a " + 
            		montoConvertido + conversor1.getnombreFinal(), "Conversion Realizada", JOptionPane.PLAIN_MESSAGE);
   
            
        } else if (seleccion.equals("Conversor de Temperatura")) {
        	
        	ConversorTemperatura conversor2 = new ConversorTemperatura();
        	double monto = conversor2.obtenerMonto("Ingrese la cantidad a convertir");
        	double montoConvertido = conversor2.convertir(monto);
        	JOptionPane.showMessageDialog(null, monto + "°" + conversor2.getnombreInicial() + " Equivalen a " + 
            		montoConvertido + "°" + conversor2.getnombreFinal(), "Conversion Realizada", JOptionPane.PLAIN_MESSAGE);
        	
        	
        } else if (seleccion.equals("Conversor de Longitud")) {
        	
            ConversorLongitud conversor3 = new ConversorLongitud();
            double monto = conversor3.obtenerMonto("Ingrese la cantidad a convertir");
            double montoConvertido = conversor3.convertir(monto);
            JOptionPane.showMessageDialog(null, monto + conversor3.getnombreInicial() + " Equivalen a " + 
            		montoConvertido + conversor3.getnombreFinal(), "Conversion Realizada", JOptionPane.PLAIN_MESSAGE);
            
            
        } else if (seleccion.equals("Conversor Astronomico"))   {
        	
        	ConversorAstronomico conversor4 = new ConversorAstronomico();
        	double monto = conversor4.obtenerMonto("Ingrese la cantidad a convertir");
        	double montoConvertido = conversor4.convertir(monto);
        	JOptionPane.showMessageDialog(null, monto + conversor4.getnombreInicial() + " Equivalen a " + 
            		montoConvertido + conversor4.getnombreFinal(), "Conversion Realizada", JOptionPane.PLAIN_MESSAGE);
        	
        } else {
        	JOptionPane.showMessageDialog(null, "Opción no válida.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        /**
         * Aqui creamos una matriz con 3 opciones, "Si", "No" y "Cancelar", en caso que el usuario elija "Si"
         * int es igual a 0, en ese caso el while se vuelve a ejecutar, si coloca "No" o "Cancelar" el int
         * "seleccion2" seria igual a 1 o 2, por lo cual se lanzaria el mensaje y a continuación el 
         * System.exit(0);
         */
        
        Object[] opciones = {"Si", "No", "Cancelar"};
        int seleccion2 = (int) JOptionPane.showOptionDialog(null,"Desea realizar otra acción?","Menu",
        		JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,opciones,opciones[0]);
        if (seleccion2 == 1 || seleccion2 == 2) {
        	JOptionPane.showMessageDialog(null, "Finalizando programa!", "Adios", JOptionPane.INFORMATION_MESSAGE);
        	System.exit(0);
        }
        }
    }
}