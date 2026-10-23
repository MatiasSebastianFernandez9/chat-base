package ar.edu.unlu.chatmvc.modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class Chat {
    private HashMap<Integer, Usuario> usuarios;
    private ArrayList<Mensaje> mensajes;

    public Chat() {
        this.usuarios = new HashMap<>();
        this.mensajes = new ArrayList<>();
    }

    public Usuario conectarUsuario(String nombre) {
        Usuario u = new Usuario(nombre);
        this.usuarios.put(u.getId(), u);
        this.enviarMensajeDelSistema("Usuario " + nombre + " conectado");
        return u;
    }

    public void desconectarUsuario(int usuarioId) {
        Usuario usuario = this.usuarios.get(usuarioId);
        if (usuario != null) {
            this.usuarios.remove(usuarioId);
            this.enviarMensajeDelSistema("Usuario " + usuario.getNombre() + " desconectado");
        }
    }

    public Mensaje[] getMensajes() {
        Mensaje[] resultado = new Mensaje[this.mensajes.size()];
        return this.mensajes.toArray(resultado);
    }

    public Usuario[] getUsuarios() {
        Usuario[] resultado = new Usuario[this.usuarios.size()];
        return this.usuarios.values().toArray(resultado);
    }

    public void enviarMensaje(String texto, Usuario usuario) {
        this.mensajes.add(new Mensaje(texto, usuario));
        // ANTIPATRÓN: El modelo acoplado directamente a la salida por consola
        System.out.println("[" + usuario.getNombre() + "]: " + texto);
    }

    public void enviarMensajeDelSistema(String texto) {
        this.mensajes.add(new Mensaje(texto));
        // ANTIPATRÓN: El modelo acoplado directamente a la salida por consola
        System.out.println("[Sistema]: " + texto);
    }
}
