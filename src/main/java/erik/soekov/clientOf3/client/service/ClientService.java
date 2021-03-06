package erik.soekov.clientOf3.client.service;

import erik.soekov.clientOf3.client.dto.ClientDto;
import erik.soekov.clientOf3.client.dto.FullClientDto;
import erik.soekov.clientOf3.client.error.AddClientErrors;
import erik.soekov.clientOf3.client.model.Country;

import java.util.List;

public interface ClientService {

    List<ClientDto> getClients(Integer user_id);
    List<ClientDto> getClients(String username);
    FullClientDto getClient(Integer id);
    List<Country> getCountries();

    /**
     *
     * @param client info about the client
     * @param username username of the client handler from authentication
     */
    AddClientErrors saveClient(FullClientDto client, String username);
}
