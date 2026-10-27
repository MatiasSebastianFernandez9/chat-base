package ar.edu.unlu.chatmvc.modelo;

import java.time.LocalDateTime;

public class Mensaje implements IMensaje {
    private LocalDateTime fecha;
    private IUsuario usuario;
    private String texto;

    public Mensaje(String texto, IUsuario usuario) {
        this.fecha = LocalDateTime.now();
        this.usuario = usuario;
        this.texto = texto;
    }

    public Mensaje(String texto) {
        this(texto, null);
    }

    @Override
    public LocalDateTime getFecha() {
        return this.fecha;
    }

    @Override
    public IUsuario getUsuario() {
        return this.usuario;
    }

    @Override
    public String getTexto() {
        return this.texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public boolean isMensajeDelSistema() {
        return this.usuario == null;
    }
}
