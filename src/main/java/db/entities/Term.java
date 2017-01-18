package db.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by kazac on 15.01.2017.
 */
@Document(collection = "term")
public class Term {
    @Id
    private String id;
    private String name;
    private Integer occureness;

    public Term() {
        occureness = 0;
    }

    public Term(String id, String name) {
        this.id = id;
        this.name = name;
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

    public Integer getOccureness() {
        return occureness;
    }

    public void setOccureness(Integer occureness) {
        this.occureness = occureness;
    }
}
