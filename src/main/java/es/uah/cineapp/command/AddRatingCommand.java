package es.uah.cineapp.command;

import es.uah.cineapp.domain.Puntuacion;
import es.uah.cineapp.service.RatingService;

public class AddRatingCommand implements Command {

    private final RatingService ratingService;
    private final Puntuacion puntuacion;

    public AddRatingCommand(RatingService ratingService, Puntuacion puntuacion) {
        this.ratingService = ratingService;
        this.puntuacion = puntuacion;
    }

    @Override
    public void execute() {
        ratingService.addRating(puntuacion);
    }
}
