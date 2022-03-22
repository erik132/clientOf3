package erik.soekov.clientOf3.client.service;

import erik.soekov.clientOf3.client.dto.ClientDto;
import erik.soekov.clientOf3.client.repo.ClientRepository;
import erik.soekov.clientOf3.client.repo.UserWithClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private UserWithClientsRepository userWithClientsRepository;

    @Override
    public List<ClientDto> getClients(Integer userId) {
        return userWithClientsRepository.findById(userId).get().getClients()
                .stream().map(ClientDto::new).collect(Collectors.toList());
    }

    @Override
    public List<ClientDto> getClients(String username) {
        return userWithClientsRepository.findByUsername(username).getClients()
                .stream().map(ClientDto::new).collect(Collectors.toList());
    }

    @Override
    public ClientDto getClient(Integer id){
        return new ClientDto(clientRepository.findById(id).get());
    }
}
