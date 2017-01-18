package db;

import db.entities.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by kazac on 15.01.2017.
 */
@Repository
public interface MonDAO {
    public void saveText(Text text);
    public void saveTerm(Term term);
    public void saveDefinition(Definition def);
    public void saveLection(Lection lection);
    public Map<Term, Integer> getImportant();
    public Map<Term,Definition> getShortCourse();
    public Map<String, List<Text>> findTerms();
    public List<Term> findTopTerms(int top);
}
