import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    private String name;
    private String path;

    // I used an ArrayList to store documents as recommended in the lab slides

    private List<Document> documents = new ArrayList<>();

    // Constructor with nane and path
    public Catalog(String name, String path) {
        this.name = name;
        this.path = path;
    }

    // the add and finById methods as descriebed in the lab slides
    public void add(Document doc){
        documents.add(doc);
    }
    public Document findById(String id){
        for(Document doc : documents){
            if(doc.getId().equals(id)){
                return doc;
            }
        }
        return null;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
