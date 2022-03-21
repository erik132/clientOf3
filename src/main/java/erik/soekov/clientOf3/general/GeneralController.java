package erik.soekov.clientOf3.general;

import erik.soekov.clientOf3.general.constants.GeneralNames;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GeneralController {

    @RequestMapping("/")
    public String showIndex(Model model){
        model.addAttribute("title", GeneralNames.title);
        return "index";
    }


}
