package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints;

@Entity
public class Ingredient extends Model{

    @Id
	public Long id;

    @Constraints.Required
    public String name;

    /**
     * Generic query helper for entity Computer with id Long
     */
    public static Finder<Long,Ingredient> find = new Finder<Long,Ingredient>(Long.class, Ingredient.class);
}
