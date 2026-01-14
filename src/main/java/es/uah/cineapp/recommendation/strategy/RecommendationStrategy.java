package es.uah.cineapp.recommendation.strategy;

import es.uah.cineapp.domain.Pelicula;

import java.util.List;

public interface RecommendationStrategy {
    // Este método será implementado por diferentes estrategias
    List<Pelicula> recommend(List<Pelicula> peliculas);
}
