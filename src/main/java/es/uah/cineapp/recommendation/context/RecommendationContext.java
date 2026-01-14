package es.uah.cineapp.recommendation.context;

import es.uah.cineapp.domain.Pelicula;
import es.uah.cineapp.recommendation.strategy.RecommendationStrategy;
import es.uah.cineapp.recommendation.template.RecommendationTemplate;

import java.util.List;

public class RecommendationContext {
    private RecommendationStrategy strategy;

    // Constructor para inyectar la estrategia
    public RecommendationContext(RecommendationStrategy strategy) {
        this.strategy = strategy;
    }

    // Método para obtener las recomendaciones usando el Template Method
    public List<Pelicula> getRecommendations(List<Pelicula> peliculas) {
        RecommendationTemplate template = new RecommendationTemplate() {};  // Instancia abstracta
        return template.generateRecommendations(peliculas, strategy);
    }
}
