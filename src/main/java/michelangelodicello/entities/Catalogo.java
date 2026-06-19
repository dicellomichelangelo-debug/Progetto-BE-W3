package michelangelodicello.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;


@Entity
@Table(name = "Catalogo")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Catalogo {
    @Id
    @GeneratedValue
    @Column(name = "ID_Elemento", updatable = false, nullable = false)
    private UUID idElemento;

    @Column(name = "ISBN", nullable = false)
    private String isbn;

    @Column(name = "Titolo", nullable = false)
    private String titolo;

    @Column(name = "Anno_pubblicazione")
    private LocalDate annoPubblicazione;

    @Column(name = "Numero_pagine")
    private Integer numeroPagine;

    public Catalogo() {
    }

    public Catalogo(String isbn, String titolo, LocalDate annoPubblicazione, Integer numeroPagine) {
        this.isbn = isbn;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public UUID getIdElemento() {
        return idElemento;
    }

    public void setIdElemento(UUID idElemento) {
        this.idElemento = idElemento;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(LocalDate annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public Integer getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(Integer numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    @Override
    public String toString() {
        return "Catalogo{" +
                "idElemento=" + idElemento +
                ", isbn='" + isbn + '\'' +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }
}
