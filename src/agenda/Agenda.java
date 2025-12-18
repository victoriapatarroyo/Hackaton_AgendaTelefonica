package agenda;
import java.util.HashMap;
import java.util.Map;

public class Agenda {
    private Map<String, String> agenda = new HashMap<>();
    private int tamanoMaximo = 10;

    public Agenda(int tamanoMaximo) {
        this.tamanoMaximo = tamanoMaximo;
    }

    public void agregarContacto(Contacto c) {
        if (agenda.size() >= tamanoMaximo) {
            System.out.println("No tienes espacio en tu agenda");
            return;
        }

        if (c.getNombre().trim().isEmpty() || c.getApellido().trim().isEmpty()) {
            System.out.println("Los campos de nombre y apellido tienen que estar diligenciados.");
            return;
        }

        // ^ indica inicio, [0-9]+ indica uno o más dígitos, $ indica fin
        boolean esNumerico = c.getTelefono().matches("^[0-9]+$");

        if(esNumerico == false) {
            System.out.println("El número telefónico solo debe contener números");
            return;
        }

        String nombreCompleto = c.nombre + " " + c.apellido;

        if (buscarContacto(nombreCompleto)) {
            System.out.println("El contacto ya existe.");
        } else {
            agenda.put(nombreCompleto, c.getTelefono());
            System.out.println("Contacto agregado: " + nombreCompleto);
            listarContactos();
        }
    }

    public boolean buscarContacto(String nombreCompleto) {
        return agenda.containsKey(nombreCompleto.toUpperCase());
    }

    public void existeContacto(Contacto c) {
        String nombreBuscar = (c.getNombre() + " " + c.getApellido()).toUpperCase();
        if(buscarContacto(nombreBuscar) == true) {
            System.out.println("El contacto " + nombreBuscar + " está en la agenda");
        } else {
            System.out.println("El contacto " + nombreBuscar + " no está en la agenda");
        }
    }

    public void listarContactos() {
        if (agenda.isEmpty()) {
            System.out.println("La agenda está vacía.");
        } else {
            System.out.println("\n-----AGENDA-------");
            System.out.println(agenda);
        }
    }

    public void eliminarContacto(Contacto c) {

        String contactoAgenda = (c.getNombre() + " " + c.getApellido()).toUpperCase();

        if (buscarContacto(contactoAgenda) == true) {

            String telefonoEliminado = agenda.get(contactoAgenda);
            agenda.remove(contactoAgenda);

            System.out.println("Contacto eliminado.");
            System.out.println("Nombre: " + contactoAgenda);
            System.out.println("Teléfono: " + telefonoEliminado);
            System.out.println(agenda);

        } else {
            System.out.println("El contacto no se encuentra en tu lista.");
        }
    }

    public void modificarTelefono(String nombre, String apellido, String nuevoTelefono) {
        String contactoAgenda = (nombre + " " + apellido).toUpperCase();

        if (buscarContacto(contactoAgenda) == true) {

            agenda.replace(contactoAgenda, nuevoTelefono);
            System.out.println("Teléfono modificado.");
            System.out.println("Nombre: " + contactoAgenda);
            System.out.println("Nuevo teléfono: " + nuevoTelefono);
            System.out.println(agenda);

        } else {
            System.out.println("El contacto no se encuentra en tu lista.");
        }
    }

}
