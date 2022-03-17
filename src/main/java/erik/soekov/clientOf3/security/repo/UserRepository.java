package erik.soekov.clientOf3.security.repo;

import erik.soekov.clientOf3.security.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);
}
