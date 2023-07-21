package conversor;

import javax.swing.JOptionPane;

public class Conversor {

	public static void main(String[] args) {
		
		Object[] options = {"Conversor de Monedas", "Conversor de Temperatura", "Conversor de Presion"};
		
		String mensaje = "Seleccione una opción de conversión";
		String titulo = "Menu principal";
		int tipoMensaje = JOptionPane.PLAIN_MESSAGE;
		
		String seleccion = (String) JOptionPane.showInputDialog(null, mensaje, titulo, tipoMensaje,null,options,options[0]);
		
		if (seleccion != null) {
            // El usuario seleccionó una opción
            System.out.println("Seleccionaste: " + seleccion);
        } else {
            // El usuario cerró el cuadro de diálogo sin seleccionar una opción
            System.out.println("Cerraste el cuadro de diálogo sin seleccionar una opción.");
        }
	}
	
	//showXxxDialogshowInputDialogObjectObjectStringshowInputDialog
}

