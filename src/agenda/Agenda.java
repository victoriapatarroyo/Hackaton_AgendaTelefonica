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


}
