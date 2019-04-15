package cfranc.com.comics.collector.ws.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import cfranc.com.comics.collector.ws.model.Personne;

@Repository
public interface PersonneRepository extends PagingAndSortingRepository<Personne, Integer>{

}
