package es.uah.cineapp.service;

import es.uah.cineapp.domain.Pelicula;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Override
    public void addMovie(Pelicula movie) {
        // Lógica para agregar película
    }

    @Override
    public void deleteMovie(Long id) {
        // Lógica para eliminar película
    }
}
