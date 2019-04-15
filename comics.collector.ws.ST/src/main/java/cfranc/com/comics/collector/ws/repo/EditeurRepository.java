package cfranc.com.comics.collector.ws.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import cfranc.com.comics.collector.ws.model.Editeur;

@Repository
public interface EditeurRepository extends PagingAndSortingRepository<Editeur, Integer>{

}
