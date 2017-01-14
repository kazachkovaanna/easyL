package easyL;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by kazac on 14.01.2017.
 */
@Controller
public class MainController {
    @RequestMapping(value = "/")
    public ModelAndView loadL(){
        ModelAndView upl = new ModelAndView();
        upl.setViewName("index");
        return upl;
    }
}
