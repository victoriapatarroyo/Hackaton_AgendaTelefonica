package agenda;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Agenda {
    private Map<String, String> agenda = new HashMap<>();
    private int tamanoMaximo = 10;

    public Agenda(int tamanoMaximo) {
        this.tamanoMaximo = tamanoMaximo;
    }

    public void agregarContacto(Contacto c) {
        if(agendaLlena() == true) {
            System.out.println("El tamaño de la agenda está llena");
            return;
        }

        if (c.getNombre().trim().isEmpty() || c.getApellido().trim().isEmpty()) {
            System.out.println("Los campos de nombre y apellido tienen que estar diligenciados.");
            return;
        }

        if(!verificarTelefono(c.getTelefono())) {
            System.out.println("El formato del teléfono no es numérico");
            return;
        }

        String nombreCompleto = (c.nombre + " " + c.apellido).toUpperCase();

        if (buscarContacto(nombreCompleto)) {
            System.out.println("El contacto ya existe.");
        } else {
            agenda.put(nombreCompleto, c.getTelefono());
            System.out.println("Contacto agregado: " + nombreCompleto);
            listarContactos();
            int tamanoAgenda = espacioLibre();
            System.out.println("Espacio disponible en agenda: " + tamanoAgenda);
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
            // Crear un TreeMap a partir del HashMap
            Map<String, String> agendaOrdenada = new TreeMap<>(agenda);
            System.out.println("\n----- MI AGENDA-------");
            System.out.println(agendaOrdenada);
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

        if(!verificarTelefono(nuevoTelefono)) {
            System.out.println("El formato del teléfono no es numérico");
            return;
        }

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

    public boolean verificarTelefono(String nuevoTelefono) {
        boolean esNumerico = nuevoTelefono.matches("^[0-9]+$");
        return esNumerico;
    }

    public boolean agendaLlena() {
        if (agenda.size() >= tamanoMaximo) {
            return true;
        } else {
            return false;
        }
    }

    public int espacioLibre() {
        int tamanoDisponible = tamanoMaximo - agenda.size();
        return tamanoDisponible;
    }
}
