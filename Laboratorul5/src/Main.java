import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String args[]) throws IOException, InvalidCatalogException, ClassNotFoundException, URISyntaxException {
       // Creating a new Main obj and calling save load and view via 2 new methods implemented in this class
        Main app=new Main();
        app.testCreateSave();
        app.testLoadView();
    }


    private void testCreateSave() throws IOException {
        // Creates a catalog with a name and a path to the a location
        Catalog catalog= new Catalog("Java Resources","C:/Users/Platon/Desktop/catalog.txt");

        // Creates a new documen with an id name and a location
        Document doc = new Document("java1","Java Course 1","https://profs.info.uaic.ro/~acf/java/slides/en/intro_slide_en.pdf");

        // we give a key and an obj so we can access it easier from the hashMap
        doc.addTag("type","Slides");

        // We are adding the new document to the catalog and save
        catalog.add(doc);
        CatalogUtil.save(catalog);
    }

    private void testLoadView() throws InvalidCatalogException, IOException, ClassNotFoundException, URISyntaxException {
       // Loading the catalog from the memory using it's path
        Catalog catalog = CatalogUtil.load("C:/Users/Platon/Desktop/catalog.txt");

        // Finding the document we want via its ID
        Document doc = catalog.findById("java1");

        // View the document
        CatalogUtil.view(doc);
    }
}
