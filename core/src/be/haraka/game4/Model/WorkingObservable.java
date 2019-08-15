package be.haraka.game4.Model;

import java.util.Observable;

/**
 * Simple override on {@link Observable#notifyObservers()}.
 * The method will first call hasChanged, then call {@link Observable#notifyObservers()}
 */
public class WorkingObservable extends Observable {

    @Override
    public void notifyObservers(Object arg) {
        setChanged();
        super.notifyObservers(arg);
    }
}
