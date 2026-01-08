package es.uah.cineapp.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "peliculas", schema = "cine")
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String titulo;

    @Column(length = 120)
    private String director;

    @Column(length = 60)
    private String genero;

    @Column(name = "anio_estreno")
    private Integer anioEstreno;

    @Column(name = "duracion_min")
    private Integer duracionMin;

    @Column(name = "pais_produccion", length = 80)
    private String paisProduccion;

    @Column(length = 1000)
    private String sinopsis;

    @Column(name = "valoracion_media", precision = 3, scale = 1)
    private BigDecimal valoracionMedia;

    @Column(name = "imagen_portada", length = 500)
    private String imagenPortada;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    // getters/setters
    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }
    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
    public Integer getAnioEstreno() { return anioEstreno; }
    public void setAnioEstreno(Integer anioEstreno) { this.anioEstreno = anioEstreno; }
    public Integer getDuracionMin() { return duracionMin; }
    public void setDuracionMin(Integer duracionMin) { this.duracionMin = duracionMin; }
    public String getPaisProduccion() { return paisProduccion; }
    public void setPaisProduccion(String paisProduccion) { this.paisProduccion = paisProduccion; }
    public String getSinopsis() { return sinopsis; }
    public void setSinopsis(String sinopsis) { this.sinopsis = sinopsis; }
    public BigDecimal getValoracionMedia() { return valoracionMedia; }
    public void setValoracionMedia(BigDecimal valoracionMedia) { this.valoracionMedia = valoracionMedia; }
    public String getImagenPortada() { return imagenPortada; }
    public void setImagenPortada(String imagenPortada) { this.imagenPortada = imagenPortada; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}

