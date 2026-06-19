package michelangelodicello.entities;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "Prestito")
public class Prestito {
    @Id
    @GeneratedValue
    @Column(name = "ID_Prestito", updatable = false, nullable = false)
    private UUID idPrestito;

    @Column(name = "Data_inizio", nullable = false)
    private LocalDate dataInizio;

    @Column(name = "Data_restituzione_prevista")
    private LocalDate dataRestituzionePrevista;

    @Column(name = "Data_restituzione_effettiva")
    private LocalDate dataRestituzioneEffettiva;

    @ManyToOne
    @JoinColumn(name = "id_elemento", nullable = false)
    private Catalogo catalogo;

    @ManyToOne
    @JoinColumn(name = "id_utente", nullable = false)
    private Utente utente;

    public Prestito() {
    }

    public Prestito(LocalDate dataInizio, LocalDate dataRestituzionePrevista, Catalogo catalogo, Utente utente) {
        this.dataInizio = dataInizio;
        this.dataRestituzionePrevista = dataRestituzionePrevista;
        this.catalogo = catalogo;
        this.utente = utente;
        this.dataRestituzioneEffettiva = null;
    }

    public UUID getIdPrestito() {
        return idPrestito;
    }

    public void setIdPrestito(UUID idPrestito) {
        this.idPrestito = idPrestito;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Catalogo getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

    public LocalDate getDataRestituzioneEffettiva() {
        return dataRestituzioneEffettiva;
    }

    public void setDataRestituzioneEffettiva(LocalDate dataRestituzioneEffettiva) {
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

    public LocalDate getDataRestituzionePrevista() {
        return dataRestituzionePrevista;
    }

    public void setDataRestituzionePrevista(LocalDate dataRestituzionePrevista) {
        this.dataRestituzionePrevista = dataRestituzionePrevista;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "idPrestito=" + idPrestito +
                ", dataInizio=" + dataInizio +
                ", dataRestituzionePrevista=" + dataRestituzionePrevista +
                ", dataRestituzioneEffettiva=" + dataRestituzioneEffettiva +
                ", catalogo=" + catalogo +
                ", utente=" + utente +
                '}';
    }
}
