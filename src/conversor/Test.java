package conversor;

import javax.swing.JOptionPane;

public class Test {

	public static void main(String[] args) {
    
		String seleccion = Conversor.mostrarMenu();
        while (true) {
        if (seleccion.equals("Conversor de Monedas")) {
            ConversorMonedas conversorMonedas1 = new ConversorMonedas();
            double monto = conversorMonedas1.obtenerMonto();
            double montoConvertido = conversorMonedas1.convertir(monto);
            JOptionPane.showMessageDialog(null, monto + conversorMonedas1.getMonedaInicial() + montoConvertido
            		+ conversorMonedas1.getMoneda(), "Conversion Realizada", JOptionPane.PLAIN_MESSAGE);
   
        } else if (seleccion.equals("Conversor de Temperatura")) {
            // Lógica para el conversor de temperatura
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
	
	

