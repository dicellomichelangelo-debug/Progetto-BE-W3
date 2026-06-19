Il diagramma per la gestione dei prestiti bibliotecari è diviso in tre parti principali:

Catalogo: La tabella principale Catalogo contiene le informazioni comuni a tutti gli articoli (ISBN, Titolo, Anno, Pagine).
Da questa si estendono due tabelle più specifiche: Libri (con Genere e Autore) e Riviste (con la Periodicità) entrambe ovviamente con una relazione onetoone per garantire il collegamento nel database.

Utente: Registra l'anagrafica delle persone iscritte e il loro numero di tessera.

Prestito: Fa da ponte tra l'utente e l'elemento del catalogo. Registra chi ha preso cosa, memorizzando la data di inizio, la data di restituzione prevista e quella effettiva. Quest'ultimo ha infatti una 
relazione onetomany sia con catalogo che con utenti 
