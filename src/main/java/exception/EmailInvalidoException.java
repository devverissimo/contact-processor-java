package exception;

public class EmailInvalidoException extends RuntimeException{
    public EmailInvalidoException(String email) {
        super("Email inválido: " + email);
    }
}
