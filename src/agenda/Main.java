package agenda;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

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
