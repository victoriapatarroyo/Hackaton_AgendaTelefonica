package agenda;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
            System.out.println("5. Eliminar contacto");
            System.out.println("6. Modificar teléfono");
            System.out.println("7. Espacio lleno en agenda");
            System.out.println("8. Espacio libre en agenda");
            System.out.println("9. Salir");
            System.out.println("Selecciona tu opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingresa el nombre del contacto: ");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingresa el apellido del usuario: ");
                    String apellido = scanner.nextLine();
                    System.out.println("Ingresa el número telefónico: ");
                    String telefono = scanner.nextLine();

                    //Contacto c = new Contacto(nombre, apellido, telefono);
                    //agregarContacto(Contacto c);
                    break;
                /*case 2:
                    existeContacto(Contacto c);
                    break;
                case 3:
                    listarContactos();
                    break;
                case 4:
                    buscarContacto(String nombre);
                    break;
                case 5:
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
    }
}
