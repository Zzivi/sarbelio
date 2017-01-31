import org.junit.Test;
import play.mvc.Result;
import play.test.WithApplication;

import static play.test.Helpers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;



/**
*
* Simple (JUnit) tests that can call all parts of a play app.
* If you are interested in mocking a whole application, see the wiki for more details.
*
*/
public class IngredientTest extends WithApplication {

    @Test
    public void testIndex() {
        Result result = new controllers.Ingredient().index();
        assertEquals(OK, result.status());
        assertEquals("text/html", result.contentType().get());
        assertEquals("utf-8", result.charset().get());
        assertTrue(contentAsString(result).contains("Add Ingredient"));
    }
}
