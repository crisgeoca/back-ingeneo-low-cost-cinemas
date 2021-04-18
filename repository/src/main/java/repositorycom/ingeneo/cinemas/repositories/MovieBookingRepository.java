package repositorycom.ingeneo.cinemas.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ingeneo.cinemas.entities.MovieBooking;

public interface MovieBookingRepository extends CrudRepository<MovieBooking, Long>{

}
