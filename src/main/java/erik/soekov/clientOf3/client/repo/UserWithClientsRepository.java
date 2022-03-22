package erik.soekov.clientOf3.client.repo;

import erik.soekov.clientOf3.client.model.UserWithClients;
import org.springframework.data.repository.CrudRepository;

public interface UserWithClientsRepository extends CrudRepository<UserWithClients, Integer> {

    UserWithClients findByUsername(String username);
}
