package Launcher;

import javax.swing.JOptionPane;

import conversor.*;

public class Launcher {

	public static void main(String[] args) {
		while (true) {
		String seleccion = Conversor.mostrarMenu();
        
        if (seleccion.equals("Conversor de Monedas")) {
            ConversorMonedas conversor1 = new ConversorMonedas();
            double monto = conversor1.obtenerMonto();
            double montoConvertido = conversor1.convertir(monto);
            JOptionPane.showMessageDialog(null, monto + conversor1.getnombreInicial() + montoConvertido
            		+ conversor1.getnombreFinal(), "Conversion Realizada", JOptionPane.PLAIN_MESSAGE);
   
        } else if (seleccion.equals("Conversor de Temperatura")) {
        	ConversorTemperatura conversor2 = new ConversorTemperatura();
        	double monto = conversor2.obtenerMonto();
        	double montoConvertido = conversor2.convertir(monto);
        	JOptionPane.showMessageDialog(null, monto + conversor2.getnombreInicial() + montoConvertido
            		+ conversor2.getnombreFinal(), "Conversion Realizada", JOptionPane.PLAIN_MESSAGE);
        } else if (seleccion.equals("Conversor de Longitud")) {
        	
            ConversorLongitud conversor3 = new ConversorLongitud();
            double monto = conversor3.obtenerMonto();
            double montoConvertido = conversor3.convertir(monto);
            JOptionPane.showMessageDialog(null, monto + conversor3.getnombreInicial() + montoConvertido
            		+ conversor3.getnombreFinal(), "Conversion Realizada", JOptionPane.PLAIN_MESSAGE);
        } else if (seleccion.equals("Conversor Astronomico"))   {
        	
        	ConversorAstronomico conversor4 = new ConversorAstronomico();
        	double monto = conversor4.obtenerMonto();
        	double montoConvertido = conversor4.convertir(monto);
        	JOptionPane.showMessageDialog(null, monto + conversor4.getnombreInicial() + montoConvertido
            		+ conversor4.getnombreFinal(), "Conversion Realizada", JOptionPane.PLAIN_MESSAGE);
        	
        } else {
        	JOptionPane.showMessageDialog(null, "Opción no válida.", "Error", JOptionPane.ERROR_MESSAGE);
        }
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
	
	

