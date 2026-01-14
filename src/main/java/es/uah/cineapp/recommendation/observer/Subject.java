package es.uah.cineapp.recommendation.observer;

public interface Subject {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers(Long usuarioId);
}
