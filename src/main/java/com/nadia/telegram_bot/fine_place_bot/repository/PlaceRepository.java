package com.nadia.telegram_bot.fine_place_bot.repository;

import com.nadia.telegram_bot.fine_place_bot.model.Place;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends CrudRepository<Place, Integer> {

    Place findPlaceByName(String name);

    @Query(value = "select place_name from place where place.city = ?1", nativeQuery = true)
    List<String> getPlacesNamesByCity(String city);
}
