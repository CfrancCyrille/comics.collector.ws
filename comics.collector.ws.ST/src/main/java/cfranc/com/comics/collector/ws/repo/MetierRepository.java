package cfranc.com.comics.collector.ws.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import cfranc.com.comics.collector.ws.model.Metier;

@Repository
public interface MetierRepository extends PagingAndSortingRepository<Metier, Integer>{

}
