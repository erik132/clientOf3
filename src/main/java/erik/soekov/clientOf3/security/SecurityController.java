package erik.soekov.clientOf3.security;

import erik.soekov.clientOf3.general.constants.GeneralNames;
import erik.soekov.clientOf3.security.dto.UserDTO;
import erik.soekov.clientOf3.security.exception.PasswordMismatchException;
import erik.soekov.clientOf3.security.exception.UsernameExistsException;
import erik.soekov.clientOf3.security.service.RedTapeAirlinesUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/security")
public class SecurityController {

    @Autowired
    private RedTapeAirlinesUserService userService;

    @RequestMapping("login")
    public String showLogin(Model model){
        model.addAttribute("title", GeneralNames.title);
        return "security/login";
    }

    @RequestMapping(method = RequestMethod.GET, value = "registration")
    public String showRegistration(Model model){
        model.addAttribute("title", GeneralNames.title);
        model.addAttribute("user", new UserDTO());
        return "security/registration";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/registration")
    public String registerUser(@Validated UserDTO userDTO, Model model) {

        if (!this.isRegistrationError(userDTO, model)) {
            model.addAttribute("announcement", "Registration Success");
        }
        model.addAttribute("user", userDTO);
        return "security/registration";
    }

    private boolean isRegistrationError(UserDTO userDTO, Model model){
        try{
            this.userService.registerUser(userDTO);
        }catch (PasswordMismatchException pme){
            model.addAttribute("error", "Password mismatch");
            return true;
        }catch (UsernameExistsException uee){
            model.addAttribute("error", "Username already exists");
            return true;
        }
        return false;
    }
}
