package es.uah.cineapp.recommendation.template;

import es.uah.cineapp.domain.Pelicula;
import es.uah.cineapp.recommendation.strategy.RecommendationStrategy;

import java.util.List;

public abstract class RecommendationTemplate {

    public List<Pelicula> generateRecommendations(List<Pelicula> peliculas, RecommendationStrategy strategy) {
        // Paso común: obtener todas las películas (puedes añadir más lógica aquí si lo necesitas)
        List<Pelicula> peliculasRecomendadas = strategy.recommend(peliculas);

        // Paso común: ordenar o filtrar las recomendaciones (se puede añadir más lógica aquí)
        return peliculasRecomendadas;
    }
}
