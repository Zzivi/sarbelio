package controllers;

import java.util.List;

import models.Ingredient;
import play.mvc.*;
import play.data.Form;
import views.html.ingredients.index;
import views.html.ingredients.create;


public class IngredientsController extends Controller {

    /**
     * Display list of ingredients
     * @return
     */
    public Result index() {
        List<Ingredient> ingredients = new play.db.ebean.Model.Finder(String.class, Ingredient.class).all();
        return ok(index.render(ingredients));
    }

    /**
     * Return an HTML form for creating a new ingredient
     * @return
     */
    public Result create() {
        Form<Ingredient> ingredientForm = Form.form(Ingredient.class);
        return ok(create.render(ingredientForm));
    }
    /**
     * Save a new ingredient
     * @return
     */
    public Result save() {
        Ingredient ingredient = Form.form(Ingredient.class).bindFromRequest().get();
        ingredient.save();
        return redirect(routes.IngredientsController.index());
    }



}
