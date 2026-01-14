package es.uah.cineapp.controller;

import es.uah.cineapp.repository.PeliculaRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MovieController {

    private final PeliculaRepository peliculaRepository;

    // Constructor para inyectar el repositorio de películas
    public MovieController(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    @GetMapping("/movies")
    public String movies(Model model, HttpSession session) {
        // Si no hay usuario logueado, redirige al login
        Object email = session.getAttribute("email");
        if (email == null) return "redirect:/login";

        // Añade las películas al modelo para que Thymeleaf las muestre
        model.addAttribute("peliculas", peliculaRepository.findAll());
        return "movies";  // Esto buscará el archivo movies.html en templates
    }
}
