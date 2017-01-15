package db;

import db.entities.Definition;
import db.entities.Lection;
import db.entities.Term;
import db.entities.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

/**
 * Created by kazac on 15.01.2017.
 */

public class MonDAOImpl implements MonDAO {
    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public void saveText(Text text) {
        mongoOperations.save(text);
    }

    @Override
    public void saveTerm(Term term) {
        mongoOperations.save(term);
    }

    @Override
    public void saveDefinition(Definition def) {
        mongoOperations.save(def);
    }

    @Override
    public void saveLection(Lection lection) {
        mongoOperations.save(lection);
    }
}
