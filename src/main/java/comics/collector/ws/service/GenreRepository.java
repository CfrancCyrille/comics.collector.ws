package comics.collector.ws.service;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import comics.collector.ws.domain.Genre;

@Repository
public interface GenreRepository extends PagingAndSortingRepository<Genre, Integer>{

}
