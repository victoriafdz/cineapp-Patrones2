package es.uah.cineapp.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String loginForm() {
        return "login";  // Esto busca el archivo login.html en templates
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam String email, HttpSession session) {
        session.setAttribute("email", email);  // Guarda el email en la sesión
        session.setAttribute("role", email.equalsIgnoreCase("admin@cineapp.com") ? "ADMIN" : "USER");
        return "redirect:/movies";  // Redirige a la lista de películas
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();  // Borra la sesión del usuario
        return "redirect:/";  // Redirige al inicio
    }
}
