package es.uah.cineapp.recommendation.strategy;

import es.uah.cineapp.domain.Pelicula;
import java.util.List;
import java.util.stream.Collectors;

public class WeightedStrategy implements RecommendationStrategy {
    @Override
    public List<Pelicula> recommend(List<Pelicula> peliculas) {
        // Ordena las películas por la longitud de su título (puedes cambiar esta lógica)
        return peliculas.stream()
                .sorted((p1, p2) -> Integer.compare(p2.getTitulo().length(), p1.getTitulo().length()))  // Ejemplo: por longitud del título
                .collect(Collectors.toList());
    }
}
