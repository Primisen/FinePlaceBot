package tourist_guide_by_cities_bot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tourist_guide_by_cities_bot.model.Place;
import tourist_guide_by_cities_bot.repository.PlaceRepository;

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

    @RequestMapping(value = "/place/", method = PUT)
    public void addPlace(@RequestParam(value = "placeName") String placeName,
                         @RequestParam(value = "placeDescription") String placeDescription,
                         @RequestParam(value = "placeCity") String placeCity) {

        placeRepository.save(new Place(placeName, placeDescription, placeCity));
    }

    @RequestMapping(value = "/place/{id}", method = POST)
    @ResponseBody
    public void changePlace(@PathVariable("id") int id,
                            @RequestParam (value = "description") String description){

        Place place = placeRepository.findById(id).get();//?
        place.setDescription(description);
        placeRepository.save(place);
    }

    @RequestMapping(value = "/place/{id}", method = RequestMethod.DELETE)
    public void deletePlace(@PathVariable("id") int id){
        placeRepository.deleteById(id);
    }
}
