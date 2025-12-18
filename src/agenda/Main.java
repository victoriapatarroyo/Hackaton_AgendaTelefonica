package agenda;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        // ===== MENÚ EN CONSOLA =====
        System.out.println("\n------------------------------------------");
        System.out.println("Mi Agenda Telefónica");
        System.out.println("Opciones:");
        System.out.println("1. Añadir contacto");
        System.out.println("2. Verificar contacto");
        System.out.println("3. Listar contactos");
        System.out.println("4. Buscar contacto");
        System.out.println("9. Salir");
        System.out.println("\nUse la ventana gráfica para seleccionar la opción.");
        System.out.println("------------------------------------------");

        // ===== TAMAÑO DE LA AGENDA =====
        int tamano = 10;

        String entrada = JOptionPane.showInputDialog(
                "¿Cuántos contactos desea que tenga la agenda?\n" +
                        "(Si no escribe nada será 10)"
        );

        if (entrada != null && !entrada.isEmpty())
        {
            try
            {
                tamano = Integer.parseInt(entrada);
            }

            catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Se usará 10 contactos.");
                tamano = 10;
            }
        }

        System.out.println("Agenda creada con " + tamano + " contactos máximo.");
        System.out.println("------------------------------------------");

        // ===== CREAR AGENDA Y GUI =====
        Agenda miAgenda = new Agenda(tamano);

        AgendaGUI gui = new AgendaGUI(miAgenda);
        gui.setVisible(true);
    }
}
