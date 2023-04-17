package med.voll.api.exceptions;

public class RecordNotFoundException extends RuntimeException {
    public RecordNotFoundException(Long id) {
        super("Não foi possível encontrar o recurso " + id);
    }
}
