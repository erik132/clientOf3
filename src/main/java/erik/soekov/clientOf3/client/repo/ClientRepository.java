package erik.soekov.clientOf3.client.repo;

import erik.soekov.clientOf3.client.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Integer> {
}
