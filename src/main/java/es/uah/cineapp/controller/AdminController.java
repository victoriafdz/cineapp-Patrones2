package es.uah.cineapp.controller;

import es.uah.cineapp.domain.Pelicula;
import es.uah.cineapp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(@Qualifier("adminServiceProxy") AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/add-movie")
    public String addMovie(@RequestBody Pelicula movie) {
        adminService.addMovie(movie);  // Llama al Proxy para agregar la película
        return "Película añadida correctamente";
    }

    @DeleteMapping("/delete-movie/{id}")
    public String deleteMovie(@PathVariable Long id) {
        adminService.deleteMovie(id);  // Llama al Proxy para eliminar la película
        return "Película eliminada correctamente";
    }
}
