package tourist_guide_by_cities_bot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "place")
public class Place {

    @Id
    @Column(name = "place_id")
    private int id;

    @Column(name = "place_name")
    private String name;

    @Column(name = "place_description")
    private String description;

    @Column(name= "city")//необходимо ли это здесь?
    private String city;

    public Place(){}

    public Place(int id, String name, String description, String city) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
