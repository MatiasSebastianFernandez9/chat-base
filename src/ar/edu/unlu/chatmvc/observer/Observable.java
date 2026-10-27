package ar.edu.unlu.chatmvc.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable implements IObservable{
    private final List<IObservador> observadores = new ArrayList<>();

    @Override
    public void agregarObservador(IObservador o) {
        this.observadores.add(o);
    }

    @Override
    public void removerObservador(IObservador o) {
        this.observadores.remove(o);
    }


    @Override
    public void notificarObservador(Object evento) {
        for( IObservador o : observadores ){
            o.actualizar(this, evento);
        }
    }
}

