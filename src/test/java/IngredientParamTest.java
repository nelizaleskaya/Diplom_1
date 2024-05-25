import TestData.BurgerTestData;
import org.example.Ingredient;
import org.example.IngredientType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.example.IngredientType.FILLING;
import static org.example.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientParamTest {
    Ingredient ingredient;
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientParamTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Test data by ingredients: {0} {1} {2}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {SAUCE, BurgerTestData.SAUCE_NAME, BurgerTestData.SAUCE_PRICE},
                {FILLING, BurgerTestData.FILLING_NAME, BurgerTestData.FILLING_PRICE},
        };
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void getPriceByTestData() {

        Assert.assertEquals("getPrice Ingredients didn't return value", price, ingredient.getPrice(), 0.0f);
    }

    @Test
    public void getNameByTestData() {

        Assert.assertEquals("getName Ingredients didn't return value", name, ingredient.getName());
    }

    @Test
    public void getTypeByTestData() {
        Assert.assertEquals("getType Ingredients didn't return value", type, ingredient.getType());

    }
}
