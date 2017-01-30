package models;

import javax.persistence.*;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public String id;

    public String name;
}
