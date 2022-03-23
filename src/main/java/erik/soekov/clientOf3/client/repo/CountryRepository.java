package erik.soekov.clientOf3.client.repo;

import erik.soekov.clientOf3.client.model.Country;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CountryRepository extends CrudRepository<Country, Integer> {

    List<Country> findAll();
}
