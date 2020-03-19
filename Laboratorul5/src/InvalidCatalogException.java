/// A class for handeling invalid catalog exception

public class InvalidCatalogException extends Exception {
    public InvalidCatalogException(Exception ex){
        super("Invalid catalog file.",ex);
    }
}
