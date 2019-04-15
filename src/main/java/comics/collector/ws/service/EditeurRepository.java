package comics.collector.ws.service;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import comics.collector.ws.domain.Editeur;

@Repository
public interface EditeurRepository extends PagingAndSortingRepository<Editeur, Integer>{

}
