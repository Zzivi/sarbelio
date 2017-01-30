package controllers;

import models.Ingredient;
import play.mvc.*;
import play.db.jpa.*;
import views.html.*;
import play.data.Form;
import java.util.List;

import static play.libs.Json.*;

public class Application extends Controller {

    public Result index() {
        return ok(index.render());
    }

    @Transactional
    public Result addIngredient() {
        Ingredient ingredient = Form.form(Ingredient.class).bindFromRequest().get();
        JPA.em().persist(ingredient);
        return redirect(routes.Application.index());
    }

    @Transactional(readOnly = true)
    public Result getIngredients() {
        List<Ingredient> ingredients = (List<Ingredient>) JPA.em().createQuery("select p from Ingredient p").getResultList();
        return ok(toJson(ingredients));
    }
}
