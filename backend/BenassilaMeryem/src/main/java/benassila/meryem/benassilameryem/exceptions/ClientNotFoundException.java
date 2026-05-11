package benassila.meryem.benassilameryem.exceptions;

public class ClientNotFoundException extends Exception {
    public ClientNotFoundException(String clientNotFound) {
        super(clientNotFound);
    }
}
