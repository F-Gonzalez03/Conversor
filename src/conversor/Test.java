package conversor;

import javax.swing.JOptionPane;

public class Test {

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
        } else if (seleccion.equals("Conversor de Presion")) {
            // Lógica para el conversor de presión
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
	
	

