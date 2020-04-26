package esi.atl.g43335.sokoban.model;

/**
 *
 * @author franc
 */
public interface Subject {

    void registerObserver(Observer obs);

    void remove(Observer obs);

    void notifyObservers();

}
