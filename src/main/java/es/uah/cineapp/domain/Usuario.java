package es.uah.cineapp.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

    @Entity
    @Table(name = "usuarios", schema = "cine")
    public class Usuario {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false, unique = true, length = 120)
        private String email;

        @Column(nullable = false, length = 120)
        private String nombre;

        @Column(name = "password_hash", nullable = false, length = 255)
        private String passwordHash;

        @Column(nullable = false, length = 20)
        private String role; // ADMIN / VIEWER

        @Column(name = "created_at", nullable = false)
        private LocalDateTime createdAt;

        // getters/setters
        public Long getId() { return id; }
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        public String getNombre() { return nombre; }
        public void setNombre(String nombre) { this.nombre = nombre; }
        public String getPasswordHash() { return passwordHash; }
        public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }
        public String getRole() { return role; }
        public void setRole(String role) { this.role = role; }
        public LocalDateTime getCreatedAt() { return createdAt; }
        public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    }
