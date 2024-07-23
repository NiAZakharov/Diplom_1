import org.junit.jupiter.api.Test;
import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DatabaseTest {
    @Test
    public void availableBunTest() {
        Database database = new Database();
        List<Bun> buns = database.availableBuns();
        assertEquals(3, buns.size());
        assertEquals("black bun", buns.get(0).getName());
        assertEquals("white bun", buns.get(1).getName());
        assertEquals("red bun", buns.get(2).getName());
    }

    @Test
    public void availableIngredientTest() {
        Database database = new Database();
        List<Ingredient> ingredients = database.availableIngredients();
        assertEquals(6, ingredients.size());
        assertEquals("hot sauce", ingredients.get(0).getName());
        assertEquals("cutlet", ingredients.get(3).getName());
    }
}
