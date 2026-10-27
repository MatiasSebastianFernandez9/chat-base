package ar.edu.unlu.chatmvc.vista;

import ar.edu.unlu.chatmvc.modelo.Chat;
import ar.edu.unlu.chatmvc.modelo.Eventos;
import ar.edu.unlu.chatmvc.modelo.IUsuario;
import ar.edu.unlu.chatmvc.observer.IObservable;
import ar.edu.unlu.chatmvc.observer.IObservador;

public class Controlador implements IObservador {
    private IVista vista;
    private final Chat chat;
    private IUsuario usuario;

    public Controlador(Chat chat) {
        if(chat == null)
            throw new IllegalArgumentException("!!");

        this.chat = chat;
        this.chat.agregarObservador(this);
    }

    @Override
    public void actualizar(IObservable o, Object e) {
        Eventos evento = (Eventos)e;

        switch (evento){
            case NUEVO_MENSAJE:
                this.vista.mostrarChat(this.chat.getMensajes());
                break;
            case CAMBIO_LISTA_USUARIOS:
                this.vista.mostrarListaUsuarios(chat.getUsuarios());
                break;

        }
    }

    public void setVista(IVista vista) {
        this.vista = vista;
    }

    public IUsuario conectarUsuario(String nombre){
        this.usuario = this.chat.conectarUsuario(nombre);

        return this.chat.conectarUsuario(nombre);
    }

    public void desconectarUsuario(){
        this.chat.desconectarUsuario(usuario.getId());
        this.usuario = null;
    }

    public void enviarMensaje(String s){
        this.chat.enviarMensaje(s, usuario);
    }
}
