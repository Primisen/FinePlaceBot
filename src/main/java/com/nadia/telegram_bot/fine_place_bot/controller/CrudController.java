package com.nadia.telegram_bot.fine_place_bot.controller;

import com.nadia.telegram_bot.fine_place_bot.model.Place;
import com.nadia.telegram_bot.fine_place_bot.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
public class CrudController {

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
    public void addPlace(@RequestParam(value = "name") String name,
                         @RequestParam(value = "city") String city) {

        placeRepository.save(new Place(name, city));
    }

    @RequestMapping(value = "/place/{id}", method = PUT)
    @ResponseBody
    public void changePlace(@PathVariable("id") int id,
                            @RequestParam (value = "name") String name){

        Place place = placeRepository.findById(id).get();//?
        place.setName(name);
        placeRepository.save(place);
    }

    @RequestMapping(value = "/place/{id}", method = RequestMethod.DELETE)
    public void deletePlace(@PathVariable("id") int id){
        placeRepository.deleteById(id);
    }
}
