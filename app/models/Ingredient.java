package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints;

@Entity
public class Ingredient extends Model{

    @Id
	public String id;

    @Constraints.Required
    public String name;
}
