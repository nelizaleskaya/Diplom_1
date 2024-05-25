import TestData.BurgerTestData;
import org.example.Bun;
import org.example.Burger;
import org.example.Ingredient;
import org.example.IngredientType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger;

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredientSauce;
    @Mock
    Ingredient ingredientFilling;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void addIngredientFillingInList() {
        List<Ingredient> expectedIngredient = new ArrayList<>();
        expectedIngredient.add(ingredientFilling);
        burger.addIngredient(ingredientFilling);
        Assert.assertEquals("Ingredient List don't have added filling",
                expectedIngredient.size(),
                burger.ingredients.size()
        );
        expectedIngredient.clear();

    }

    @Test
    public void removeIngredientSauceInList() {
        burger.addIngredient(ingredientSauce);
        burger.removeIngredient(0);
        Assert.assertTrue("An entry has not been deleted from the Ingredient list",
                burger.ingredients.isEmpty()
        );
    }

    @Test
    public void moveIngredientChangePositionByIngredient() {
        List<Ingredient> expectedOrder = new ArrayList<>(2);
        expectedOrder.add(ingredientSauce);
        expectedOrder.add(ingredientFilling);

        burger.addIngredient(ingredientFilling);
        burger.addIngredient(ingredientSauce);
        burger.moveIngredient(0, 1);
        Assert.assertEquals("Ingredients didn't move position", expectedOrder, burger.ingredients);
        expectedOrder.clear();
    }

    @Test
    public void getPriceThreeItems() {
        Mockito.when(bun.getPrice()).thenReturn(BurgerTestData.BUN_PRICE);
        Mockito.when(ingredientSauce.getPrice()).thenReturn(BurgerTestData.SAUCE_PRICE);
        Mockito.when(ingredientFilling.getPrice()).thenReturn(BurgerTestData.FILLING_PRICE);

        burger.setBuns(bun);
        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredientFilling);

        Assert.assertEquals("getPrice burger by three items didn't have correct price",
                BurgerTestData.EXPECTED_BURGER_PRICE,
                burger.getPrice(),
                0);
    }

    @Test
    public void getReceiptThreeItemsReceiptIsCorrect() {
        String expectedReceipt = String.format("(==== %s ====)\n= %s %s =\n= %s %s =\n" + "(==== %s ====)\n\nPrice: %s",
                BurgerTestData.BUN_NAME,
                IngredientType.FILLING.toString().toLowerCase(), BurgerTestData.FILLING_NAME,
                IngredientType.SAUCE.toString().toLowerCase(), BurgerTestData.SAUCE_NAME,
                BurgerTestData.BUN_NAME,
                String.format("%f%n", BurgerTestData.EXPECTED_BURGER_PRICE));

        Mockito.when(bun.getName()).thenReturn(BurgerTestData.BUN_NAME);
        Mockito.when(ingredientFilling.getName()).thenReturn(BurgerTestData.FILLING_NAME);
        Mockito.when(ingredientSauce.getName()).thenReturn(BurgerTestData.SAUCE_NAME);
        Mockito.when(bun.getPrice()).thenReturn(BurgerTestData.BUN_PRICE);
        Mockito.when(ingredientFilling.getPrice()).thenReturn(BurgerTestData.FILLING_PRICE);
        Mockito.when(ingredientSauce.getPrice()).thenReturn(BurgerTestData.SAUCE_PRICE);
        Mockito.when(ingredientFilling.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredientSauce.getType()).thenReturn(IngredientType.SAUCE);

        burger.setBuns(bun);
        burger.addIngredient(ingredientFilling);
        burger.addIngredient(ingredientSauce);
        assertEquals(expectedReceipt, burger.getReceipt());
}
}
