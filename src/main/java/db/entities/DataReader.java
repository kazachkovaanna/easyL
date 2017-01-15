package db.entities;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by kazac on 15.01.2017.
 */
public class DataReader extends DefaultHandler {
    private Lection lection;
    private boolean lectureParsingFlag;
    private boolean textParsingFlag;
    private boolean definitionParsingFlag;


    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
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
            //TODO: начало контента
        } else if ("text".equalsIgnoreCase(qName)) {
            Text text = new Text();
            text.setTitle(attributes.getValue("title"));
        } else if("definition".equalsIgnoreCase(qName)) {
            //TODO: определение
        } else if ("term".equalsIgnoreCase(qName)) {
            //TODO: термин
        } else {
            throw new SAXException("Unknown tag: " + qName);
        }
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }

    @Override
    public void characters(char[] c, int start, int length) throws SAXException {
        super.characters(c, start,  length);
    }
}
