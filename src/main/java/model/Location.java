package model;

import javax.persistence.*;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @OneToOne(mappedBy = "location")
    Restaurant restaurant;
    String latitude;
    String longitude;
}
