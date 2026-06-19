package michelangelodicello.entities;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "Utente")
public class Utente {
    @Id
    @GeneratedValue
    @Column(name = "ID_Utente", updatable = false, nullable = false)
    private UUID idUtente;

    @Column(name = "Numero_tessera", unique = true, nullable = false)
    private String numeroTessera;

    @Column(name = "Nome")
    private String nome;

    @Column(name = "Cognome")
    private String cognome;

    @Column(name = "Data_nascita")
    private LocalDate dataNascita;

    public Utente() {
    }

    public Utente(String numeroTessera, String nome, String cognome, LocalDate dataNascita) {
        this.numeroTessera = numeroTessera;
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
    }

    public UUID getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(UUID idUtente) {
        this.idUtente = idUtente;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getNumeroTessera() {
        return numeroTessera;
    }

    public void setNumeroTessera(String numeroTessera) {
        this.numeroTessera = numeroTessera;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "idUtente=" + idUtente +
                ", numeroTessera='" + numeroTessera + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataNascita=" + dataNascita +
                '}';
    }
}
