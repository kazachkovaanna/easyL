package easyL;


import db.MonDAO;
import db.entities.DataReader;
import db.entities.Definition;
import db.entities.Term;
import db.entities.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.file.remote.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.xml.sax.SAXException;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by kazac on 14.01.2017.
 */
@Controller
public class MainController {
    @Autowired
    private MonDAO monDAO;
    private SAXParser parser;
    @Autowired
    private DataReader reader;
    @RequestMapping(value = "/")
    public ModelAndView loadL(){
        ModelAndView upl = new ModelAndView("index");
        return upl;
    }

    @RequestMapping(value = "/upload/", method = RequestMethod.GET)
    public ModelAndView upload(){
        ModelAndView model = new ModelAndView("upload");
        return model;
    }

    @RequestMapping(value = "/upload/", method = RequestMethod.POST)
    public ModelAndView uploadpost(@RequestParam("lecture") MultipartFile file){
        ModelAndView model = new ModelAndView("upload");
        String res="Успешно!";
         try {
            parser = SAXParserFactory.newInstance().newSAXParser();

            parser.parse(file.getInputStream(), reader);
        } catch (ParserConfigurationException e) {
            //e.printStackTrace();
            res = "Что-то пошло не так, попробуйте еще раз...";
        } catch (SAXException e) {
             res = e.getMessage();
            //e.printStackTrace();
        } catch (IOException e) {
             res = "Что-то пошло не так, попробуйте еще раз...";
             //e.printStackTrace();
         }
        model.addObject("res");
        return model;
    }

    @RequestMapping(value = "/important/")
    public ModelAndView important(){
        ModelAndView model = new ModelAndView("important");
        return model;
    }

    @RequestMapping(value = "/short/")
    public ModelAndView shortcourse(){
        ModelAndView model = new ModelAndView("short");
        Map<Term,Definition> map = monDAO.getShortCourse();
        model.addObject("map", map);
        return model;
    }

    @RequestMapping(value = "/topterms/")
    public ModelAndView topterms(@RequestParam(value = "top" , required = false, defaultValue = "10") int top, HttpServletRequest request){
        ModelAndView model = new ModelAndView("topterms");
        Map<String, List<Text>> map = monDAO.findTerms();
        request.getSession().setAttribute("tmap", map);
        List<Term> toplist = monDAO.findTopTerms(top);
        request.getSession().setAttribute("toplist", toplist);
        model.addObject("tmap", map);
        model.addObject("toplist",toplist);
        return model;
    }

    @RequestMapping(value = "/topterms/{term}")
    public ModelAndView term(@PathVariable("term") int id, HttpServletRequest request, @RequestParam(value = "in" , required = false, defaultValue = "0") int in){
        List<Term> list = (List<Term>)request.getSession().getAttribute("toplist");
        Map<String, List<Text>> map = ( Map<String, List<Text>>) request.getSession().getAttribute("tmap");
        ModelAndView model = new ModelAndView("term");
        model.addObject("term" , list.get(id));
        List<Text> tl = map.get(list.get(id).getId());
        Text tx = tl.get(in);
        model.addObject("ocs", tx);
        return model;
    }

}
