package erik.soekov.clientOf3.client;

import erik.soekov.clientOf3.client.dto.ClientDto;
import erik.soekov.clientOf3.client.service.ClientService;
import erik.soekov.clientOf3.general.constants.GeneralNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @RequestMapping("/clientList")
    public String showClientList(Model model){
        model.addAttribute("title", GeneralNames.title);
        List<ClientDto> clients = new ArrayList<>();
        clients.add(clientService.getClient(1));
        model.addAttribute("clients", clients);
        return "client/clientList";
    }

    @RequestMapping("/addClient")
    public String showAddClient(Model model){
        model.addAttribute("title", GeneralNames.title);
        return "client/addClient";
    }
}
