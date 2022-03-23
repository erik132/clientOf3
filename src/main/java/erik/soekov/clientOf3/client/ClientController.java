package erik.soekov.clientOf3.client;

import erik.soekov.clientOf3.client.dto.ClientDto;
import erik.soekov.clientOf3.client.dto.FullClientDto;
import erik.soekov.clientOf3.client.service.ClientService;
import erik.soekov.clientOf3.general.constants.GeneralNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @RequestMapping("/clientList")
    public String showClientList(Authentication authentication, Model model){
        model.addAttribute("title", GeneralNames.title);
        model.addAttribute("clients", clientService.getClients(authentication.getName()));
        return "client/clientList";
    }

    @RequestMapping(method = RequestMethod.GET, value= "/addClient")
    public String showAddClient(Model model){
        System.out.println("Getting Client");
        model.addAttribute("title", GeneralNames.title);
        model.addAttribute("countries", clientService.getCountries());
        model.addAttribute("client", new FullClientDto());
        return "client/addClient";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addClient")
    public String addClient(@Validated FullClientDto client, Authentication authentication, Model model){
        System.out.println("Posting Client");
        clientService.saveClient(client, authentication.getName());
        model.addAttribute("title", GeneralNames.title);
        model.addAttribute("countries", clientService.getCountries());
        model.addAttribute("client", client);

        return "client/addClient";
    }
}
