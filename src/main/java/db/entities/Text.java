package db.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by kazac on 15.01.2017.
 */
@Document(collection = "text")
public class Text {
    @Id
    private String id;

    private String title;
    @TextIndexed private String contents;

    public Text() {
    }

    public Text(String id, String title, String contents) {
        this.id = id;
        this.title = title;
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

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
