package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import utils.Roles;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
public class User {
    @Id
    Long id;
    String username;
    String password;
    Roles role;

    @OneToMany(mappedBy = "user")
    List<Order> orderList;

    @OneToMany(mappedBy = "user")
    List<Favorite> favorites;

    @OneToMany(mappedBy = "user")
    List<Review> reviews;

}
