package conversor;

import javax.swing.JOptionPane;

public abstract class Conversor {
	
    public abstract double convertir(double valor);

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

    public double obtenerMonto() {
        double monto = 0;
        while (true) {
            String ingreso = JOptionPane.showInputDialog(null, "Ingrese el monto", "Menu", JOptionPane.PLAIN_MESSAGE);
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
                // Si el usuario cancela el cuadro de diálogo o no ingresa nada, mostrar un mensaje y repetir el bucle
                JOptionPane.showMessageDialog(null, "Se ha cancelado el ingreso.", "Adiós", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        }
        return monto;
    }
}