package erik.soekov.clientOf3.general;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GeneralController {

    @RequestMapping("/")
    public String landingPage(){
        return "landingPage";
    }

    @RequestMapping("/dashboard")
    public String dashboard(){
        return "dashboard";
    }
}
