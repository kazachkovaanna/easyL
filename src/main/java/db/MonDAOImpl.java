package db;

import db.entities.Definition;
import db.entities.Lection;
import db.entities.Term;
import db.entities.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;
import org.springframework.stereotype.Repository;

import java.util.*;

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

    @Override
    public Map<Term, Integer> getImportant() {
        Map<Term, Integer> map = new HashMap<>();
        return map;
    }

    @Override
    public Map<Term,Definition> getShortCourse() {
        List<Definition> list = new ArrayList<>();
        Query defs = new Query();
        defs.with(new Sort(Sort.Direction.ASC, "_id"));
        list = mongoOperations.find(defs,Definition.class);
        Map<Term, Definition> map = new LinkedHashMap<>();
        for(Definition d : list)
        {
            Query q = new Query();
            q.addCriteria(Criteria.where("_id").is(d.getTerm()));
            Term t = mongoOperations.findOne(q,Term.class);
            map.put(t, d);
        }
        return map;
    }

    @Override
    public Map<String, List<Text>> findTerms() {
        //step 1 - get list of all terms
        List<Term> terms= mongoOperations.findAll(Term.class);
        Map<String, List<Text>> map = new HashMap<>();
        //step 2 - do a full text search for each term
        for(Term t : terms){
            TextCriteria criteria = TextCriteria.forDefaultLanguage().matchingPhrase(t.getName());
            Query query = TextQuery.queryText(criteria);
            query.with(new Sort(Sort.Direction.ASC, "_id"));
            List<Text> res = mongoOperations.find(query,Text.class);
            t.setOccureness(res.size());
            mongoOperations.save(t);
            map.put(t.getId(), res);
        }
        return map;
    }

    @Override
    public List<Term> findTopTerms(int top) {
        Query query = new Query().with(new Sort(Sort.Direction.DESC, "occureness")).limit(top);
        List<Term> list = mongoOperations.find(query, Term.class);
        return list;
    }
}
