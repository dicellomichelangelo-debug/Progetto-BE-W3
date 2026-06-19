package michelangelodicello.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "Libri")
@PrimaryKeyJoinColumn(name = "ID_Elemento")
public class Libro extends Catalogo {
    @Column(name = "Genere")
    private String genere;

    @Column(name = "Autore")
    private String autore;

    public Libro() {
        super();
    }

    public Libro(String isbn, String titolo, LocalDate annoPubblicazione, Integer numeroPagine, String genere, String autore) {
        super(isbn, titolo, annoPubblicazione, numeroPagine);
        this.genere = genere;
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "genere='" + genere + '\'' +
                ", autore='" + autore + '\'' +
                '}';
    }
}
