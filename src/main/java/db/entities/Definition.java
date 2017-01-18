package db.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by kazac on 15.01.2017.
 */
@Document(collection = "definition")
public class Definition {
    @Id
    private String id;

    private String term;
    private String contetns;
    private String title;

    public Definition() {
    }

    public Definition(String id, String term, String contetns) {
        this.id = id;
        this.term = term;
        this.contetns = contetns;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getContetns() {
        return contetns;
    }

    public void setContetns(String contetns) {
        this.contetns = contetns;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
