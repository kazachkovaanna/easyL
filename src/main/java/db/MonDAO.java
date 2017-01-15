package db;

import db.entities.*;
import org.springframework.stereotype.Repository;

/**
 * Created by kazac on 15.01.2017.
 */
@Repository
public interface MonDAO {
    public void saveText(Text text);
    public void saveTerm(Term term);
    public void saveDefinition(Definition def);
    public void saveLection(Lection lection);
}
