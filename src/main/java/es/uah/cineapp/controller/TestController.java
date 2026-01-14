package es.uah.cineapp.controller;

import es.uah.cineapp.security.UserSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final UserSession userSession;

    public TestController(UserSession userSession) {
        this.userSession = userSession;
    }

    @GetMapping("/whoami")
    public String whoami() {
        return "email=" + userSession.getEmail() + " admin=" + userSession.isAdmin();
    }
}
