package ar.edu.unlu.chatmvc.pruebas;

import ar.edu.unlu.chatmvc.modelo.Chat;
import ar.edu.unlu.chatmvc.modelo.Usuario;

public class Prueba {

    public static void main(String[] args) {
        Chat chat = new Chat();

        Usuario ana = chat.conectarUsuario("Ana");
        Usuario juan = chat.conectarUsuario("Juan");

        chat.enviarMensaje("¡Hola a todos!", ana);
        chat.enviarMensaje("¡Hola Ana! ¿Todo bien?", juan);

        chat.desconectarUsuario(juan.getId());
    }
}
