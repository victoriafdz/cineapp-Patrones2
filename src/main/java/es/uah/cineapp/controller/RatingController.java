package es.uah.cineapp.controller;

import es.uah.cineapp.command.AddRatingCommand;
import es.uah.cineapp.command.CommandInvoker;
import es.uah.cineapp.domain.Pelicula;
import es.uah.cineapp.domain.Puntuacion;
import es.uah.cineapp.repository.PeliculaRepository;
import es.uah.cineapp.repository.UsuarioRepository;
import es.uah.cineapp.security.UserSession;
import es.uah.cineapp.service.RatingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
public class RatingController {

    private final PeliculaRepository peliculaRepository;
    private final UsuarioRepository usuarioRepository;
    private final RatingService ratingService;
    private final UserSession userSession;
    private final CommandInvoker invoker;

    public RatingController(PeliculaRepository peliculaRepository,
                            UsuarioRepository usuarioRepository,
                            RatingService ratingService,
                            UserSession userSession,
                            CommandInvoker invoker) {
        this.peliculaRepository = peliculaRepository;
        this.usuarioRepository = usuarioRepository;
        this.ratingService = ratingService;
        this.userSession = userSession;
        this.invoker = invoker;
    }

    @PostMapping("/movies/rate")
    public String rate(@RequestParam Long peliculaId,
                       @RequestParam Integer puntuacion) {

        String email = userSession.getEmail();
        if (email == null) return "redirect:/login";

        Pelicula pelicula = peliculaRepository.findById(peliculaId).orElseThrow();
        var usuario = usuarioRepository.findByEmail(email).orElseThrow();

        Puntuacion p = new Puntuacion();
        p.setUsuario(usuario);
        p.setPelicula(pelicula);
        p.setPuntuacion(puntuacion);
        p.setRatedAt(LocalDateTime.now());

        // COMMAND: encapsula la acción de puntuar
        invoker.setCommand(new AddRatingCommand(ratingService, p));
        invoker.executeCommand();

        return "redirect:/recommendations";
    }
}
