package conversor;

import javax.swing.JOptionPane;

public class Conversor {

	public static void main(String[] args) {
		
		Object[] options = {"Conversor de Monedas", "Conversor de Temperatura", "Conversor de Presion"};
		
		String mensaje = "Seleccione una opción de conversión";
		String titulo = "Menu principal";
		String ingreso = "0";
		double monto = 0;
		int tipoMensaje = JOptionPane.PLAIN_MESSAGE;
		
		String seleccion = (String) JOptionPane.showInputDialog(null, mensaje, titulo, tipoMensaje,null,options,options[0]);
		
		
		if (seleccion == options[0]) {
		    // El usuario seleccionó una opción
			while (true) {
	            ingreso = JOptionPane.showInputDialog(null, "Ingrese el monto", "Título del Cuadro de Diálogo", JOptionPane.PLAIN_MESSAGE);
	            // Verificar si el usuario ingresó un valor
	            if (ingreso != null && !ingreso.isEmpty()) {
	                try {
	                    // Convertir el valor ingresado a un número
	                    monto = (double) Double.parseDouble(ingreso);
	                    
	                    break; // Salir del bucle si el valor es un número válido
	                } catch (NumberFormatException e) {
	                    // Si el valor ingresado no es un número válido, mostrar un mensaje de error
	                    JOptionPane.showMessageDialog(null, "Por favor, ingrese solo números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
	                }
	            } else {
	                // Si el usuario cancela el cuadro de diálogo o no ingresa nada, mostrar un mensaje y repetir el bucle
	            	JOptionPane.showMessageDialog(null, "Se ha cancelado el ingreso.", "Adiós", JOptionPane.INFORMATION_MESSAGE);
	                System.exit(0);
	            }
	            	
	        }
		} else {
		    // El usuario cerró el cuadro de diálogo sin seleccionar una opción
			JOptionPane.showMessageDialog(null, "Elegiste otra opcion que no es conversor de monedas, esta aplicación esta en desarrollo aún", 
					"Adiós", JOptionPane.INFORMATION_MESSAGE);
		}
	
		
		System.out.println(monto);
	}
	
	//showXxxDialogshowInputDialogObjectObjectStringshowInputDialog
}



