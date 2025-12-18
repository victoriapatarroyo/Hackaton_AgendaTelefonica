package agenda;

import java.util.HashMap;
import java.util.Map;


public class Contacto {

    String nombre;
    String apellido;
    String telefono;

    private Map<String, String> agenda = new HashMap<>();

    private int tamanoMaximo = 10;


    public Contacto(String nombre, String apellido, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int TamanoMaximo() {
        return tamanoMaximo;
    }

    public void agregarContacto(Contacto c) {

        if (agenda.size() >= tamanoMaximo) {
            System.out.println("No tienes espacio en tu agenda");
            return;
        }

        if (c.nombre.trim().isEmpty() || c.apellido.trim().isEmpty()) {
            System.out.println("Los campos de tu nombre y apellido tienen que estar diligenciados.");
            return;
        }

        String contactoAgenda = (c.nombre + " " + c.apellido).toUpperCase();

        if (buscarContacto(contactoAgenda) == true) {
            System.out.println("El contacto ya existe.");
        } else {
            agenda.put(contactoAgenda, telefono);
            System.out.println("Contacto Agregado.");
            System.out.println(agenda);
        }
    }

    public boolean buscarContacto (String contactoAgenda) {
        return agenda.containsKey(contactoAgenda);
    }
}