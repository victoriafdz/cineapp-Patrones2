SET SCHEMA cine;

-- =========================
-- USUARIOS
-- =========================
INSERT INTO usuarios (email, password_hash, role)
VALUES
    ('admin@cineapp.com', 'hash_admin', 'ADMIN'),
    ('user1@mail.com', 'hash_user1', 'VIEWER'),
    ('user2@mail.com', 'hash_user2', 'VIEWER');

-- =========================
-- PELICULAS
-- =========================
INSERT INTO peliculas (titulo, director, genero, anio_estreno, descripcion)
VALUES
    ('Peli1', 'Christopher Nolan', 'Sci-Fi', 2010, 'Sueños dentro de sueños'),
    ('peli2', 'Christopher Nolan', 'Sci-Fi', 2014, 'Viaje espacial'),
    ('pelicula3', 'Wachowski', 'Sci-Fi', 1999, 'Realidad simulada'),
    ('pruebapeli4', 'Ridley Scott', 'Drama', 2000, 'Roma y venganza');

-- =========================
-- PUNTUACIONES
-- =========================
INSERT INTO puntuaciones (usuario_id, pelicula_id, puntuacion)
VALUES
    (2, 1, 9),
    (2, 2, 8),
    (3, 1, 10),
    (3, 3, 9);
