SET SCHEMA cine;

-- =========================
-- USUARIOS
-- =========================
INSERT INTO usuarios (email, nombre, password_hash, role)
VALUES
    ('admin@cineapp.com', 'Administrador', 'hash_admin', 'ADMIN'),
    ('user1@mail.com', 'Usuario Uno', 'hash_user1', 'VIEWER'),
    ('user2@mail.com', 'Usuario Dos', 'hash_user2', 'VIEWER');

-- =========================
-- PELICULAS
-- =========================
INSERT INTO peliculas (
    titulo, director, genero, anio_estreno,
    duracion_min, pais_produccion, sinopsis,
    valoracion_media, imagen_portada
)
VALUES
    ('Inception', 'Christopher Nolan', 'Sci-Fi', 2010,
     148, 'USA', 'Sueños dentro de sueños.', 8.8,
     'https://example.com/posters/inception.jpg'),

    ('Interstellar', 'Christopher Nolan', 'Sci-Fi', 2014,
     169, 'USA', 'Viaje espacial y relatividad.', 8.6,
     'https://example.com/posters/interstellar.jpg'),

    ('The Matrix', 'Wachowski', 'Sci-Fi', 1999,
     136, 'USA', 'Realidad simulada y rebelión.', 8.7,
     'https://example.com/posters/matrix.jpg'),

    ('Gladiator', 'Ridley Scott', 'Drama', 2000,
     155, 'USA', 'Roma y venganza.', 8.5,
     'https://example.com/posters/gladiator.jpg');

-- =========================
-- PUNTUACIONES
-- =========================
INSERT INTO puntuaciones (usuario_id, pelicula_id, puntuacion)
VALUES
    (2, 1, 9),
    (2, 2, 8),
    (3, 1, 10),
    (3, 3, 9);
