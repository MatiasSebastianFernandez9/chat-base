package ar.edu.unlu.chatmvc.modelo;

import java.time.LocalDateTime;

public class Mensaje {
    private LocalDateTime fecha;
    private Usuario usuario;
    private String texto;

    public Mensaje(String texto, Usuario usuario) {
        this.fecha = LocalDateTime.now();
        this.usuario = usuario;
        this.texto = texto;
    }

    public Mensaje(String texto) {
        this(texto, null);
    }

    public LocalDateTime getFecha() {
        return this.fecha;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public String getTexto() {
        return this.texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public boolean isMensajeDelSistema() {
        return this.usuario == null;
    }
}
