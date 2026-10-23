package ar.edu.unlu.chatmvc.modelo;

public class Usuario {
    private static int ID = 0;
    private int id;
    private String nombre;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.id = Usuario.ID++;
    }

    public int getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
