import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Document  implements Serializable {
    private String id;
    private String name;
    private String location;
    private Map<String,Object> tags =new HashMap<>();

    // I used HashMap for storing information as recommended in the lab slides

    public void addTag(String key, Object obj){
        tags.put(key,obj);
    }

    // Constructor with id,name,and a path to the location
    public Document(String id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    // Getters and setters
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
