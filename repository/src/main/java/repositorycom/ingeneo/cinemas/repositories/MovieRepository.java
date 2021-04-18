package repositorycom.ingeneo.cinemas.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ingeneo.cinemas.entities.Movie;

public interface MovieRepository extends CrudRepository<Movie, Long>{

}
