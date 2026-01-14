package es.uah.cineapp.service;

import es.uah.cineapp.domain.Puntuacion;
import es.uah.cineapp.recommendation.observer.Observer;
import es.uah.cineapp.recommendation.observer.Subject;
import es.uah.cineapp.repository.PuntuacionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RatingService implements Subject {

    private final PuntuacionRepository puntuacionRepository;
    private final List<Observer> observers = new ArrayList<>();

    public RatingService(PuntuacionRepository puntuacionRepository) {
        this.puntuacionRepository = puntuacionRepository;
    }

    public void addRating(Puntuacion puntuacion) {
        puntuacionRepository.save(puntuacion);
        notifyObservers(puntuacion.getUsuario().getId());
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(Long usuarioId) {
        for (Observer o : observers) {
            o.update(usuarioId);
        }
    }
}
