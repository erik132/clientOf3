package erik.soekov.clientOf3.client.service;

import erik.soekov.clientOf3.client.dto.ClientDto;
import erik.soekov.clientOf3.client.dto.FullClientDto;
import erik.soekov.clientOf3.client.error.AddClientErrors;
import erik.soekov.clientOf3.client.model.Client;
import erik.soekov.clientOf3.client.model.Country;
import erik.soekov.clientOf3.client.model.UserWithClients;
import erik.soekov.clientOf3.client.repo.ClientRepository;
import erik.soekov.clientOf3.client.repo.CountryRepository;
import erik.soekov.clientOf3.client.repo.UserWithClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private UserWithClientsRepository userWithClientsRepository;

    @Autowired
    private CountryRepository countryRepository;

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
    public FullClientDto getClient(Integer id){
        return new FullClientDto(clientRepository.findById(id).get());
    }

    @Override
    public List<Country> getCountries() {
        return countryRepository.findAll();
    }

    @Override
    public AddClientErrors saveClient(FullClientDto clientDto, String username) {
        UserWithClients handler = userWithClientsRepository.findByUsername(username);
        Country country = countryRepository.findById(clientDto.getCountryId()).get();
        Client client = new Client(clientDto, Arrays.asList(handler),country);
        clientRepository.save(client);
        return null;
    }
}
