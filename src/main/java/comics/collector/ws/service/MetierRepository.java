package comics.collector.ws.service;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import comics.collector.ws.domain.Metier;

@Repository
public interface MetierRepository extends PagingAndSortingRepository<Metier, Integer>{

}
