package es.uah.cineapp.controller;

import es.uah.cineapp.recommendation.context.RecommendationContext;
import es.uah.cineapp.recommendation.strategy.WeightedStrategy;
import es.uah.cineapp.repository.PeliculaRepository;
import es.uah.cineapp.domain.Pelicula;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RecommendationController {

    private final PeliculaRepository peliculaRepository;

    public RecommendationController(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    @GetMapping("/recommendations")
    public String getRecommendations(Model model) {
        List<Pelicula> peliculas = peliculaRepository.findAll();
        RecommendationContext context = new RecommendationContext(new WeightedStrategy());
        List<Pelicula> recomendaciones = context.getRecommendations(peliculas);
        model.addAttribute("recommendations", recomendaciones);
        return "recommendations";  // Esto buscará el archivo recommendations.html en templates
    }
}
