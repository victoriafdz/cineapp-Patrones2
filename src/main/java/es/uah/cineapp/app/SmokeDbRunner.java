//********************************************************************
//***Clase de prueba para las bases de datos y su conexion con java***
//********************************************************************
package es.uah.cineapp.app;

import es.uah.cineapp.repository.PeliculaRepository;
import es.uah.cineapp.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SmokeDbRunner implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final PeliculaRepository peliculaRepository;

    public SmokeDbRunner(UsuarioRepository usuarioRepository,
                         PeliculaRepository peliculaRepository) {
        this.usuarioRepository = usuarioRepository;
        this.peliculaRepository = peliculaRepository;
    }

    @Override
    public void run(String... args) {
        System.out.println("=== PRUEBA JPA ===");
        System.out.println("Usuarios en BD: " + usuarioRepository.count());
        System.out.println("Peliculas en BD: " + peliculaRepository.count());

        peliculaRepository.findAll()
                .forEach(p -> System.out.println("Pelicula: " + p.getTitulo()));
    }
}

