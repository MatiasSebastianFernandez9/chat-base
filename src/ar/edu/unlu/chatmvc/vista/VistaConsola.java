package ar.edu.unlu.chatmvc.vista;

import ar.edu.unlu.chatmvc.modelo.IMensaje;
import ar.edu.unlu.chatmvc.modelo.IUsuario;

public class VistaConsola implements IVista{
    public final Controlador controlador;

    public VistaConsola(Controlador unControlador){
        if(unControlador == null)
            throw new IllegalArgumentException("No existe el controlador");

        this.controlador = unControlador;
        this.controlador.setVista(this);
    }

    @Override
    public void mostrarListaUsuarios(IUsuario[] usuarios) {
        System.out.println("Lista de usuarios:");
        for (IUsuario u : usuarios){
            System.out.println(" -" + u.getNombre() + "- ID: " + u.getId());
        }
        System.out.println("\n final lista.--");
    }

    @Override
    public void mostrarChat(IMensaje[] mensajes) {
        System.out.println("CHAT:");
        for (IMensaje m : mensajes){
            if(m.isMensajeDelSistema()){
                System.out.println("[SISTEMA]" + " :" + m.getTexto());
            }
            System.out.println("[" + m.getUsuario().getNombre() + "]"+ " :" + m.getTexto());
        }
        System.out.println("\n final lista.--");

    }

    @Override
    public void iniciar() {

    }
}
