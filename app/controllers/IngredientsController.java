package controllers;

import java.util.List;

import models.Ingredient;
import play.mvc.*;
import play.data.Form;
import views.html.ingredients.create;
import views.html.ingredients.edit;
import views.html.ingredients.index;
import views.html.ingredients.show;


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

    /**
     * Display a specific ingredient
     * @param id
     * @return
     */
    public Result show(Long id) {
        Ingredient ingredient = Ingredient.find.byId(id);
        return ok(show.render(ingredient));
    }


    /**
     * Return an HTML form for editing an ingredient
     * @param id
     * @return
     */
    public Result edit(Long id) {
        Ingredient ingredient = Ingredient.find.byId(id);
        Form<Ingredient> ingredientForm = Form.form(Ingredient.class).fill(ingredient);
        return ok(edit.render(id, ingredientForm));
    }

    /**
     * Update a specific ingredient
     * @param id
     * @return
     */
    public Result update(Long id) {
        Ingredient ingredientFromForm = Form.form(Ingredient.class).bindFromRequest().get();
        Ingredient ingredientFromDatabase = Ingredient.find.byId(id);

        ingredientFromDatabase.name = ingredientFromForm.name;
        ingredientFromDatabase.update();

        return redirect(routes.IngredientsController.show(id));
    }


    /**
     * Delete a specific ingredient
     * @param id
     * @return
     */
    public Result destroy(Long id) {
        Ingredient.find.ref(id).delete();
        return redirect(routes.IngredientsController.index());
    }
}
