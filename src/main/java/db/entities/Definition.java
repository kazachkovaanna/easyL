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
    private String title;
    private String term;
    private String contents;

    public Definition() {
    }

    public Definition(String id, String term, String contents) {
        this.id = id;
        this.term = term;
        this.contents = contents;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getContentsents() {
        return contents;
    }

    public void setContetns(String contents) {
        this.contents = contents;
    }
}
