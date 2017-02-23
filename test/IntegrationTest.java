import org.junit.*;

import static play.test.Helpers.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


public class IntegrationTest {

    /**
     * add your integration test here
     * in this example we just check if the welcome page is being shown
     */
    @Test
    public void test() {
        running(testServer(), HTMLUNIT, browser -> {
            browser.goTo("/ingredients");
            assertThat(browser.pageSource(), containsString("New ingredient"));
        });
    }

}
