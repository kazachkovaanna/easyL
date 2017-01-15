package easyL;


import db.MonDAO;
import db.entities.Term;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by kazac on 14.01.2017.
 */
@Controller
public class MainController {
    @Autowired
    private MonDAO monDAO;
    @RequestMapping(value = "/")
    public ModelAndView loadL(){
        Term t = new Term();
        t.setName("Test");
       // monDAO.saveTerm(t);
        ModelAndView upl = new ModelAndView("index");
        upl.addObject("t", t);
        return upl;
    }

    @RequestMapping(value = "/upload/", method = RequestMethod.POST)
    public ModelAndView upload(@RequestParam("lecture") MultipartFile file){
        ModelAndView model = new ModelAndView("upload");
        model.addObject("res");
        return model;
    }
}
