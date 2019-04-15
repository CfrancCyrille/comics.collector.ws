package comics.collector.ws.service;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import comics.collector.ws.domain.Personne;

@Repository
public interface PersonneRepository extends PagingAndSortingRepository<Personne, Integer>{

}
