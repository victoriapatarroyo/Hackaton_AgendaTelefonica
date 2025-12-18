package agenda;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

//Clase Agenda que maneja la información de los contactos telefónicos ingresados
//a través de los objetos instaciados en la clase Contacto
//Atributo tamanoMaximo: número del tamaño de la agenda
public class Agenda {
    private Map<String, String> agenda = new HashMap<>();
    private int tamanoMaximo = 10;

    //Clase constructora
    public Agenda(int tamanoMaximo) {
        this.tamanoMaximo = tamanoMaximo;
    }

    //Metodo agregarContacto
    //Parametro: Objeto de tipo Contacto
    //Ingresa un contacto a la agenda verificando:
    // 1. Si el contacto ya existe
    // 2. La información de nombre, apellido y teléfono no puede estar vacía
    // 3. La información del teléfono debe ser numérica
    // 4. Verifica el tamaño disponible de la agenda
    // 5. Visualiza el tamaño disponible de la agenda
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

        if(c.getTelefono().length() < 7) {
            System.out.println("El número de dígitos del teléfono debe ser mayor a 7");
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

    //Metodo buscarContacto
    //Parametro: String con el nombre y apellido del contacto
    //Establece si el contacto enviado como parámetro ya está en la agenda
    public boolean buscarContacto(String nombreCompleto) {
        return agenda.containsKey(nombreCompleto.toUpperCase());
    }

    //Metodo existeContacto
    //Parametro: Objeto de tipo Contacto
    //Informa al usuario si el contacto enviado está o no en la agenda
    public void existeContacto(Contacto c) {
        String nombreBuscar = (c.getNombre() + " " + c.getApellido()).toUpperCase();
        if(buscarContacto(nombreBuscar) == true) {
            System.out.println("El contacto " + nombreBuscar + " está en la agenda");
        } else {
            System.out.println("El contacto " + nombreBuscar + " no está en la agenda");
        }
    }

    //Metodo listarContactos
    //Parametro: Vacío
    //Lista la agenda de contactos en orden alfabético
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

    //Metodo eliminarContacto
    //Parametro: Objeto de tipo Contacto
    //Elimina un contacto de la agenda verificando si el contacto existe
    public void eliminarContacto(Contacto c) {
        String contactoAgenda = (c.getNombre() + " " + c.getApellido()).toUpperCase();

        if (buscarContacto(contactoAgenda) == true) {
            agenda.remove(contactoAgenda);
            System.out.println("Contacto eliminado.");
            System.out.println("Nombre: " + contactoAgenda);
            listarContactos();
        } else {
            System.out.println("El contacto no se encuentra en tu lista.");
        }
    }

    //Metodo modificarTelefono
    //Parametros:
    // 1. String con nombre del contacto
    // 2. String con apellido del contacto
    // 3. String con el nuevo teléfono del contacto
    //Modifica el teléfono de un contacto verificando que este exista y el nuevo teléfono
    //sea numérico
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
            listarContactos();
        } else {
            System.out.println("El contacto no se encuentra en tu lista.");
        }
    }

    //Metodo verificarTelefono
    //Parametros:
    // 1. String con el teléfono del contacto
    //Establece si el formato de la cadena con el número de teléfono es numérico
    public boolean verificarTelefono(String nuevoTelefono) {
        boolean esNumerico = nuevoTelefono.matches("^[0-9]+$");
        return esNumerico;
    }

    //Metodo agendaLlena
    //Parametros: Vacío
    //Establece si se ha llegado al tamaño máximo de la agenda
    public boolean agendaLlena() {
        if (agenda.size() >= tamanoMaximo) {
            return true;
        } else {
            return false;
        }
    }

    //Metodo espacioLibre
    //Parametros: Vacío
    //Retorna el espacio disponible de la agenda comparado con su tamaño establecido
    public int espacioLibre() {
        int tamanoDisponible = tamanoMaximo - agenda.size();
        return tamanoDisponible;
    }
}
