package es.uah.cineapp.config;

import es.uah.cineapp.recommendation.observer.Observer;
import es.uah.cineapp.service.RatingService;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;
import java.util.List;

@Configuration
public class ObserverConfig {

    private final RatingService ratingService;
    private final List<Observer> observers;

    public ObserverConfig(RatingService ratingService, List<Observer> observers) {
        this.ratingService = ratingService;
        this.observers = observers;
    }

    @PostConstruct
    public void wireObservers() {
        observers.forEach(ratingService::addObserver);
    }
}
