package ar.edu.unlu.chatmvc.modelo;

import ar.edu.unlu.chatmvc.observer.IObservable;
import ar.edu.unlu.chatmvc.observer.IObservador;
import ar.edu.unlu.chatmvc.observer.Observable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Chat extends Observable {
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
        notificarObservador(Eventos.CAMBIO_LISTA_USUARIOS);
        return u;
    }

    public void desconectarUsuario(int usuarioId) {
        Usuario usuario = this.usuarios.get(usuarioId);
        if (usuario != null) {
            this.usuarios.remove(usuarioId);
            this.enviarMensajeDelSistema("Usuario " + usuario.getNombre() + " desconectado");
            notificarObservador(Eventos.CAMBIO_LISTA_USUARIOS);
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
        //System.out.println("[" + usuario.getNombre() + "]: " + texto);
        this.notificarObservador(Eventos.NUEVO_MENSAJE);
    }

    public void enviarMensajeDelSistema(String texto) {
        this.mensajes.add(new Mensaje(texto));
        // ANTIPATRÓN: El modelo acoplado directamente a la salida por consola
        //System.out.println("[Sistema]: " + texto);
        this.notificarObservador(Eventos.NUEVO_MENSAJE);
    }
}


