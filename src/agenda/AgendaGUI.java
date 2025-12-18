package agenda;

import javax.swing.*;

public class AgendaGUI extends JFrame
{

    private Agenda miAgenda;

    JTextField txtNombre;
    JTextField txtApellido;
    JTextField txtTelefono;
    JTextArea areaSalida;

    public AgendaGUI(Agenda agenda)
    {
        this.miAgenda = agenda;

        setTitle("Agenda Telefonica");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);


        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20, 20, 80, 25);
        panel.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(100, 20, 250, 25);
        panel.add(txtNombre);

        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setBounds(20, 50, 80, 25);
        panel.add(lblApellido);

        txtApellido = new JTextField();
        txtApellido.setBounds(100, 50, 250, 25);
        panel.add(txtApellido);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setBounds(20, 80, 80, 25);
        panel.add(lblTelefono);

        txtTelefono = new JTextField();
        txtTelefono.setBounds(100, 80, 250, 25);
        panel.add(txtTelefono);


        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(20, 120, 100, 30);
        panel.add(btnAgregar);

        JButton btnVerificar = new JButton("Verificar");
        btnVerificar.setBounds(130, 120, 100, 30);
        panel.add(btnVerificar);

        JButton btnListar = new JButton("Listar");
        btnListar.setBounds(240, 120, 100, 30);
        panel.add(btnListar);


        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(75, 160, 100, 30);
        panel.add(btnEliminar);

        JButton btnModificar = new JButton("Modificar");
        btnModificar.setBounds(185, 160, 100, 30);
        panel.add(btnModificar);

        // Area de salida
        areaSalida = new JTextArea();
        areaSalida.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaSalida);
        scroll.setBounds(20, 210, 400, 130);
        panel.add(scroll);

        add(panel);


        btnAgregar.addActionListener(e ->
        {
            Contacto c = new Contacto(
                    txtNombre.getText(),
                    txtApellido.getText(),
                    txtTelefono.getText()
            );

            if(miAgenda.agendaLlena() == true) {
                areaSalida.setText("La agenda está llena. No puedes agregar más contactos.");
                return;
            }

            miAgenda.agregarContacto(c);
            int espacio = miAgenda.espacioLibre();
            areaSalida.setText("Contacto agregado.\nEspacios disponibles: " + espacio);
        });

        btnVerificar.addActionListener(e ->
        {
            Contacto c = new Contacto(
                    txtNombre.getText(),
                    txtApellido.getText(),
                    txtTelefono.getText()
            );
            miAgenda.existeContacto(c);
            areaSalida.setText("Verificación realizada. Revisa la consola.\n");
        });

        btnListar.addActionListener(e ->
        {
            miAgenda.listarContactos();
            areaSalida.setText("Contactos listados en consola.\n");
        });

        btnEliminar.addActionListener(e ->
        {
            Contacto c = new Contacto(
                    txtNombre.getText(),
                    txtApellido.getText(),
                    txtTelefono.getText()
            );
            miAgenda.eliminarContacto(c);
            areaSalida.setText("Operación realizada. Revisa la consola.\n");
        });

        btnModificar.addActionListener(e ->
        {
            String nombre = txtNombre.getText();
            String apellido = txtApellido.getText();
            String nuevoTelefono = txtTelefono.getText();
            miAgenda.modificarTelefono(nombre, apellido, nuevoTelefono);
            areaSalida.setText("Operación realizada. Revisa la consola.\n");
        });
    }
}