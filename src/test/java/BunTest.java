import TestData.BurgerTestData;
import org.example.Bun;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {
    Bun bun;

    @Before
    public void setUp() {
        bun = new Bun(BurgerTestData.BUN_NAME, BurgerTestData.BUN_PRICE);
    }

    @Test
    public void getNameReturnName() {
        Assert.assertEquals("getName did not return string name",BurgerTestData.BUN_NAME, bun.getName());
    }

    @Test
    public void getPriceReturnPrice() {
        Assert.assertEquals("getPrice did not return price",BurgerTestData.BUN_PRICE, bun.getPrice(), 0);
    }

}
