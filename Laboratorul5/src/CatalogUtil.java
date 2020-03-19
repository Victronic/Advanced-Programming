import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

// Class responsible with external operations

public class CatalogUtil {

    // I use object serialization to perform the save and load methods
    // as described in the lab and course slides

    public static void save(Catalog catalog)
    /* trow the IOException if the specified file has no associated application
        or the associated application fails to be launched */
            throws IOException {
                try(var oos = new ObjectOutputStream(new FileOutputStream(catalog.getPath()))) {
                    oos.writeObject(catalog);
                }
    }

    public static Catalog load(String path)
    // trow 3 expections each for it's respective problem: invalid Id, no associated app, class not found
            throws InvalidCatalogException, IOException, ClassNotFoundException {
        try(var ois = new ObjectInputStream(new FileInputStream(path))) {
            return (Catalog) ois.readObject();
        }
    }

    // I use a URI for browse method
    public static void view(Document doc) throws IOException, URISyntaxException {
        Desktop desktop = Desktop.getDesktop();
        URI unifyResIde = new URI(doc.getLocation());
        desktop.browse(unifyResIde);
    }
}
