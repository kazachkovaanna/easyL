package db.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kazac on 15.01.2017.
 */
@Document(collection = "lection")
public class Lection {
    @Id
    private String id;
    private String name;
    private String title;
    private List<String> contents;

    public Lection() {
        contents = new ArrayList<>();
    }

    public Lection(String id, String name, List<String> contents) {
        this.id = id;
        this.name = name;
        this.contents = contents;
        contents = new ArrayList<>();
    }

    public void addContent(String contid){
        contents.add(contid);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getContents() {
        return contents;
    }

    public void setContents(List<String> contents) {
        this.contents = contents;
    }
}
