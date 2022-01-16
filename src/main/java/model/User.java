package model;

import javafx.scene.Group;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import utils.Roles;

import javax.persistence.Entity;
import javax.persistence.Id;

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
}
