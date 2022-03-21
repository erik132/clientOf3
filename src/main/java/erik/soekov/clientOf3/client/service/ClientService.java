package erik.soekov.clientOf3.client.service;

import erik.soekov.clientOf3.client.dto.ClientDto;

import java.util.List;

public interface ClientService {

    List<ClientDto> getClients(Integer user_id);
    ClientDto getClient(Integer id);
}
