package agenda;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Agenda miAgenda = new Agenda(10);
        Scanner scanner = new Scanner(System.in);
        int opcion;
        System.out.println("\n------------------------------------------");
        System.out.println("Mi Agenda Telefónica");
        System.out.println("Opciones: ");

        do {
            System.out.println("1. Añadir contacto");
            System.out.println("2. Verificar contacto");
            System.out.println("3. Listar contactos");
            System.out.println("4. Buscar contacto");
            /*System.out.println("5. Eliminar contacto");
            System.out.println("6. Modificar teléfono");
            System.out.println("7. Espacio lleno en agenda");
            System.out.println("8. Espacio libre en agenda");*/
            System.out.println("9. Salir");
            System.out.println("Selecciona tu opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Ingresa el nombre del contacto: ");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingresa el apellido del usuario: ");
                    String apellido = scanner.nextLine();
                    System.out.println("Ingresa el número telefónico: ");
                    String telefono = scanner.nextLine();

                    Contacto c = new Contacto(nombre, apellido, telefono);
                    miAgenda.agregarContacto(c);
                    break;
                case 2:
                    System.out.println("Ingresa el nombre del contacto: ");
                    String nombre2 = scanner.nextLine();
                    System.out.println("Ingresa el apellido del usuario: ");
                    String apellido2 = scanner.nextLine();
                    System.out.println("Ingresa el número telefónico: ");
                    String telefono2 = scanner.nextLine();
                    Contacto contacto1 = new Contacto(nombre2, apellido2, telefono2);
                    miAgenda.existeContacto(contacto1);
                    break;
                case 3:
                    miAgenda.listarContactos();
                    break;
                case 4:
                    System.out.println("Ingresa el nombre del contacto: ");
                    String nombre1 = scanner.nextLine();
                    System.out.println("Ingresa el apellido del usuario: ");
                    String apellido1 = scanner.nextLine();

                    String nombreCompleto = nombre1 + " " + apellido1;
                    miAgenda.buscarContacto(nombreCompleto);
                    break;
                /*case 5:
                    eliminarContacto(Contacto c);
                    break;
                case 6:
                    modificarTelefono(nombre, apellido, nuevoTelefono);
                    break;
                case 7:
                    agendaLlena();
                    break;
                case 8:
                    espacioLibre();
                    break;*/
                case 9:
                    System.out.println("Saliendo de la agenda...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while(opcion != 9);

        scanner.close();
    }
}
