import org.example.IngredientType;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class IngredientTypeTest {

    @Test
    public void testFillingNotNull() {
        assertNotNull("Ingredients list don't have filling", IngredientType.valueOf("FILLING"));
    }
    @Test
    public void testSauceNotNull() {
        assertNotNull("Ingredients list don't have sauce", IngredientType.valueOf("SAUCE"));
    }
}
