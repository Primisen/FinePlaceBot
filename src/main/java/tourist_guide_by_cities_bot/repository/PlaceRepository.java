package tourist_guide_by_cities_bot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tourist_guide_by_cities_bot.model.Place;

@Repository
public interface PlaceRepository extends CrudRepository<Place, Integer> {

    Place findByCity(String city);
}
