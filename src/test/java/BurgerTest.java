
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class BurgerTest {

    @InjectMocks
    private Burger burger;

    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient, ingredient2, ingredient3;

    @BeforeEach
    public void createBurger() {
        burger = new Burger();
    }

    @Test
    public void setBunTest() {
        when(bun.getName()).thenReturn("Чизбургер");
        burger.setBuns(bun);
        assertEquals(bun.getName(), burger.bun.getName());
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        assertEquals(3, burger.ingredients.size());

        burger.removeIngredient(2);
        assertEquals(2, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);

        burger.moveIngredient(1, 2);

        assertEquals(ingredient2, burger.ingredients.get(2));
        assertEquals(ingredient3, burger.ingredients.get(1));
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);

        when(bun.getPrice()).thenReturn(20f);
        when(ingredient.getPrice()).thenReturn(10f);
        when(ingredient2.getPrice()).thenReturn(2f);

        float expected = (20f * 2) + 10f + 2f;

        assertEquals(expected, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {

        when(bun.getName()).thenReturn("Крестный отец");
        when(ingredient.getName()).thenReturn("Соус песто");
        when(ingredient2.getName()).thenReturn("Вяленные помидорчики");
        when(ingredient3.getName()).thenReturn("Котлета");
        when(bun.getPrice()).thenReturn(50f);
        when(ingredient.getPrice()).thenReturn(200f);
        when(ingredient2.getPrice()).thenReturn(200f);
        when(ingredient3.getPrice()).thenReturn(150f);
        when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient3.getType()).thenReturn(IngredientType.FILLING);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        String expectedReceipt = "(==== Крестный отец ====)\r\n" +
                "= sauce Соус песто =\r\n" +
                "= filling Вяленные помидорчики =\r\n" +
                "= filling Котлета =\r\n" +
                "(==== Крестный отец ====)\r\n" +
                "\r\nPrice: 650,000000\r\n";

        assertEquals(expectedReceipt, burger.getReceipt());
    }

}
