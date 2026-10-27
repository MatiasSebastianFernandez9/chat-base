package ar.edu.unlu.chatmvc.observer;

public interface IObservable {
    public void agregarObservador(IObservador o);

    public void removerObservador(IObservador o);

    public void notificarObservador(Object e);
}
