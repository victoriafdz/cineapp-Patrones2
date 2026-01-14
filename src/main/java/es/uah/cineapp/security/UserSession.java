package es.uah.cineapp.security;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;

@Component
public class UserSession {

    private final HttpSession session;

    public UserSession(HttpSession session) {
        this.session = session;
    }

    public String getEmail() {
        Object email = session.getAttribute("email");
        return email == null ? null : email.toString();
    }

    public boolean isAdmin() {
        Object role = session.getAttribute("role");
        return role != null && role.toString().equalsIgnoreCase("ADMIN");
    }

    public void setRole(String role) {
        session.setAttribute("role", role);
    }
}
