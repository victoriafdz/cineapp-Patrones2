package es.uah.cineapp.service;

import es.uah.cineapp.domain.Pelicula;
import es.uah.cineapp.security.UnauthorizedException;
import es.uah.cineapp.security.UserSession;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceProxy implements AdminService {

    private final AdminServiceImpl adminService;
    private final UserSession userSession;

    public AdminServiceProxy(AdminServiceImpl adminService, UserSession userSession) {
        this.adminService = adminService;
        this.userSession = userSession;
    }

    @Override
    public void addMovie(Pelicula movie) {
        if (userSession.isAdmin()) {
            adminService.addMovie(movie);
            return;
        }
        throw new UnauthorizedException("No tienes permisos para añadir películas");
    }

    @Override
    public void deleteMovie(Long id) {
        if (userSession.isAdmin()) {
            adminService.deleteMovie(id);
            return;
        }
        throw new UnauthorizedException("No tienes permisos para eliminar películas");
    }
}
