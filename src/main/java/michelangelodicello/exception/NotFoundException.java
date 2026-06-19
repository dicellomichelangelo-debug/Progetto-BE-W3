package michelangelodicello.exception;

import michelangelodicello.entities.Catalogo;

public class NotFoundException extends RuntimeException {
    public NotFoundException(Catalogo message) {
        super(String.valueOf(message));
    }
}
