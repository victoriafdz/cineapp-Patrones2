package es.uah.cineapp.service;

import es.uah.cineapp.domain.Pelicula;

public interface AdminService {
    void addMovie(Pelicula movie);
    void deleteMovie(Long id);
}
