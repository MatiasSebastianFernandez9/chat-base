package ar.edu.unlu.chatmvc.modelo;

import ar.edu.unlu.chatmvc.observer.Observable;

import java.util.ArrayList;
import java.util.HashMap;

public class Chat extends Observable {
    private HashMap<Integer, IUsuario> usuarios;
    private ArrayList<IMensaje> IMensajes;

    public Chat() {
        this.usuarios = new HashMap<>();
        this.IMensajes = new ArrayList<>();
    }

    public Usuario conectarUsuario(String nombre) {
        Usuario u = new Usuario(nombre);
        this.usuarios.put(u.getId(), u);
        this.enviarMensajeDelSistema("Usuario " + nombre + " conectado");
        notificarObservador(Eventos.CAMBIO_LISTA_USUARIOS);
        return u;
    }

    public void desconectarUsuario(int usuarioId) {
        IUsuario usuario = this.usuarios.get(usuarioId);
        if (usuario != null) {
            this.usuarios.remove(usuarioId);
            this.enviarMensajeDelSistema("Usuario " + usuario.getNombre() + " desconectado");
            notificarObservador(Eventos.CAMBIO_LISTA_USUARIOS);
        }
    }

    public IMensaje[] getMensajes() {
        IMensaje[] resultado = new IMensaje[this.IMensajes.size()];
        return this.IMensajes.toArray(resultado);
    }

    public IUsuario[] getUsuarios() {
        IUsuario[] resultado = new Usuario[this.usuarios.size()];
        return this.usuarios.values().toArray(resultado);
    }

    public void enviarMensaje(String texto, IUsuario usuario) {
        this.IMensajes.add(new Mensaje(texto, usuario));
        // ANTIPATRÓN: El modelo acoplado directamente a la salida por consola
        //System.out.println("[" + usuario.getNombre() + "]: " + texto);
        this.notificarObservador(Eventos.NUEVO_MENSAJE);
    }

    public void enviarMensajeDelSistema(String texto) {
        this.IMensajes.add(new Mensaje(texto));
        // ANTIPATRÓN: El modelo acoplado directamente a la salida por consola
        //System.out.println("[Sistema]: " + texto);
        this.notificarObservador(Eventos.NUEVO_MENSAJE);
    }
}


