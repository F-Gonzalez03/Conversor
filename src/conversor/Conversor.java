package conversor;

import javax.swing.JOptionPane;

/**
 * Conversor es la clase padre del proyecto, es abstracta y la idea es marcar un molde hacia las clases hijas que 
 * se van a lanzar un poco más en lo especifico de cada una
 * 
 * @version 1.0
 * @author Facundo Gonzalez
 */
public abstract class Conversor {
	
	/**
	 * Convertir es un metodo abstracto que se adapta en cada unos de los conversores hijos.
	 * 
	 * @param valor, recibe un valor (que suele ser el ingresado en el metodo obtenerMonto)
	 * @return y retorna el valor convertido de lo que fue ingresado por el usuario
	 */
	
    public abstract double convertir(double valor);

    /**
     * mostrarMenu tiene la funcion de lanzar un menu de inicio en el cual el usuario va a poder seleccionar
     * un tipo de conversor a gusto.
     * 
     * @return seleccion, lo cual permite saber que tipo de conversor eligio el usuario.
     */
    
    public static String mostrarMenu() {
        Object[] options = {"Conversor de Monedas", "Conversor de Temperatura", "Conversor de Longitud", "Conversor Astronomico"};
        String mensaje = "Seleccione una opción de conversión";
        String titulo = "Menu principal";
        int tipoMensaje = JOptionPane.PLAIN_MESSAGE;

        String seleccion = (String) JOptionPane.showInputDialog(null, mensaje, titulo, tipoMensaje, null, options, options[0]);
        		
        if (seleccion == null) {
        	 JOptionPane.showMessageDialog(null, "Finalizando Programa!", "Cerrando", JOptionPane.INFORMATION_MESSAGE);
        	 System.exit(0); 
        }
        
        return seleccion;
    }

    /**
     * obtenerMonto se encarga de lanzar un input donde el usuario pueda colocar un monto a convertir, ya sea de 
     * temperatura, de dinero, de unidades astronomicas o longitud, esto luego lo toma directamente
     * el launcher y se lo pasa a las clases hijas para que lo conviertan.
     * 
     * 
     * @param adaptable, el String adaptable lo que hace es personalizar el mensaje en base a lo que se este
     * pidiendo en el input.
     * @return monto, eso nos permite visualizar lo que el usuario ingreso en el input. 
     */
    
    public static double obtenerMonto(String adaptable) {
        double monto = 0;
        while (true) {
            String ingreso = JOptionPane.showInputDialog(null, adaptable, "Menu", JOptionPane.PLAIN_MESSAGE);
            // Verificar si el usuario ingresó un valor
            if (ingreso != null && !ingreso.isEmpty()) {
                try {
                    // Convertir el valor ingresado a un número
                    monto = Double.parseDouble(ingreso);
                    break; // Salir del bucle si el valor es un número válido
                } catch (NumberFormatException e) {
                    // Si el valor ingresado no es un número válido, mostrar un mensaje de error
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese solo números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                // Si el usuario cancela el cuadro de diálogo o no ingresa nada, mostrar un mensaje de despedida. 
                JOptionPane.showMessageDialog(null, "Se ha cancelado el ingreso.", "Adiós", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        }
        return monto;
    }
}