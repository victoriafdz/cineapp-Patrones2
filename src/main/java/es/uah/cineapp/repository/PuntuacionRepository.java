package es.uah.cineapp.repository;

import es.uah.cineapp.domain.Puntuacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PuntuacionRepository extends JpaRepository<Puntuacion, Long> {
}
