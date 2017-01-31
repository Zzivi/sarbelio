package controllers;

import play.mvc.*;
import views.html.*;
import play.data.Form;
import java.util.List;

import static play.libs.Json.toJson;

public class Ingredient extends Controller {

    public Result index() {
        return ok(index.render());
    }

    public Result addIngredient() {
        models.Ingredient ingredient = Form.form(models.Ingredient.class).bindFromRequest().get();
        ingredient.save();
        return redirect(routes.Ingredient.index());
    }

    public Result getIngredients() {
        List<models.Ingredient> ingredients = new play.db.ebean.Model.Finder(String.class, models.Ingredient.class).all();
        return ok(toJson(ingredients));
    }
}
