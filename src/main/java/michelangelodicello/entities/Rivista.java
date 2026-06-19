package michelangelodicello.entities;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Riviste")
@PrimaryKeyJoinColumn(name = "ID_Elemento")
public class Rivista extends Catalogo {
    @Enumerated(EnumType.STRING)
    @Column(name = "Periodicita")
    private Periodicita periodicita;

    public Rivista() {
        super();
    }

    public Rivista(String isbn, String titolo, LocalDate annoPubblicazione, Integer numeroPagine, Periodicita periodicita) {
        super(isbn, titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "periodicita=" + periodicita +
                '}';
    }
}
