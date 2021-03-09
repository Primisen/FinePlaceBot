package com.nadia.telegram_bot.fine_place_bot.controller;

import com.nadia.telegram_bot.fine_place_bot.model.Place;
import com.nadia.telegram_bot.fine_place_bot.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
public class CrudController {

    @Value("${server-message}")
    private String successfullyMessage;

    @Autowired
    private PlaceRepository placeRepository;

    @RequestMapping(value = "/place/", method = RequestMethod.GET)
    public Iterable<Place> getAllPlaces() {//!
        return placeRepository.findAll();
    }

    @RequestMapping(value = "/place/{id}/", method = RequestMethod.GET)
    @ResponseBody
    public Place getPlaceById(@PathVariable("id") int id) {
        return placeRepository.findById(id).get();
    }

    @RequestMapping(value = "/place", method = POST)
    public String addPlace(@RequestParam(value = "name") String name,
                         @RequestParam(value = "city") String city) {

        if (isPlaceNotExist(name)) {
            placeRepository.save(new Place(name, city));
        }

        return successfullyMessage;
    }

    @RequestMapping(value = "/place/{id}", method = PUT)
    @ResponseBody
    public String changePlace(@PathVariable("id") int id,
                            @RequestParam(value = "name") String name) {

        Place place = placeRepository.findById(id).get();
        place.setName(name);
        placeRepository.save(place);

        return successfullyMessage;
    }

    @RequestMapping(value = "/place/{id}", method = RequestMethod.DELETE)
    public String deletePlace(@PathVariable("id") int id) {
        placeRepository.deleteById(id);

        return successfullyMessage;
    }

    private boolean isPlaceNotExist(String name) {
        return placeRepository.findPlaceByName(name) == null;
    }
}
