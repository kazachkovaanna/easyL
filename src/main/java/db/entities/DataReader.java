package db.entities;

import db.MonDAO;
import db.MonDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


/**
 * Created by kazac on 15.01.2017.
 */
@Component
public class DataReader extends DefaultHandler {
    @Autowired
    private MonDAO monDAO;
    private Lection lection;
    private Text text;
    private Term term;
    private Definition definition;
    private boolean termParsingFlag;
    private boolean textParsingFlag;
    private boolean definitionParsingFlag;
    private boolean contentParsingFlag;
    private StringBuilder textBuilder;
    private StringBuilder contentBuilder;



    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        textBuilder = new StringBuilder();
        contentBuilder = new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if ("lecture".equalsIgnoreCase(qName)) {
            if (null == lection) {
                lection = new Lection();
                lection.setName(attributes.getValue("name"));
                lection.setTitle(attributes.getValue("title"));
            } else {
                throw new SAXException("File can content only one lecture");
            }
        } else if ("content".equalsIgnoreCase(qName)) {
            contentParsingFlag = true;
        } else if ("text".equalsIgnoreCase(qName)) {
            textParsingFlag = true;
            text = new Text();
            text.setTitle(attributes.getValue("title"));
        } else if("definition".equalsIgnoreCase(qName)) {
            definitionParsingFlag = true;
            definition = new Definition();
            definition.setTitle(attributes.getValue("titile"));
        } else if ("term".equalsIgnoreCase(qName)) {
            termParsingFlag = true;
            term = new Term();
        } else {
            throw new SAXException("Unknown tag: " + qName);
        }
    }

   public void endElement(String uri, String localName,String qName) throws SAXException{
        super.endElement(uri, localName, qName);
        if(contentParsingFlag){
           contentParsingFlag = false;
        }
        else if(termParsingFlag){
            termParsingFlag = false;
            monDAO.saveTerm(term);
            definition.setTerm(term.getId());
        }
        else if(textParsingFlag){
            textParsingFlag = false;
            text.setContents(textBuilder.toString());
            monDAO.saveText(text);
            textBuilder.setLength(0);
            lection.addContent(text.getId());
        }
        else if(definitionParsingFlag){
            definitionParsingFlag = false;
            definition.setContetns(contentBuilder.toString());
            contentBuilder.setLength(0);
            monDAO.saveDefinition(definition);
            lection.addContent(definition.getId());
        }


   }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        monDAO.saveLection(lection);
    }

    @Override
    public void characters(char[] c, int start, int length) throws SAXException {
        super.characters(c, start,  length);
        if(textParsingFlag){
            textBuilder.append(c, start, length);
        }
        if(contentParsingFlag){
            contentBuilder.append(c, start, length);
        }
        if(termParsingFlag){
            term.setName(new String(c, start, length).replace("\n", "").replace("\t", ""));
        }
    }
}
