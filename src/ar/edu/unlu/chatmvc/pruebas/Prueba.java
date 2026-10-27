package ar.edu.unlu.chatmvc.pruebas;

import ar.edu.unlu.chatmvc.modelo.Chat;
import ar.edu.unlu.chatmvc.modelo.IUsuario;
import ar.edu.unlu.chatmvc.modelo.Usuario;
import ar.edu.unlu.chatmvc.vista.Controlador;
import ar.edu.unlu.chatmvc.vista.IVista;
import ar.edu.unlu.chatmvc.vista.VistaConsola;

public class Prueba {

    public static void main(String[] args) {
        Chat chat = new Chat();

        Controlador controladorUsuario1 = new Controlador(chat);
        IVista vistaUsuario1 = new VistaConsola(controladorUsuario1);
        Controlador controladorUsuario2 = new Controlador(chat);
        IVista vistaUsuario2 = new VistaConsola(controladorUsuario2);

        controladorUsuario1.conectarUsuario("Ana");
        controladorUsuario2.conectarUsuario("Juan");

        controladorUsuario1.enviarMensaje("¡Hola a todos!");
        controladorUsuario2.enviarMensaje("¡Hola Ana! ¿Todo bien?");

        controladorUsuario1.desconectarUsuario();
    }
}
