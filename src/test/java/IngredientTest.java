import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IngredientTest {

    private Ingredient ingredient;

    private static final Random random = new Random();

    public static Stream<Arguments> createIngredient() {
        return Stream.of(
                Arguments.of(IngredientType.FILLING, RandomStringUtils.randomAlphabetic(5), random.nextFloat()),
                Arguments.of(IngredientType.SAUCE, RandomStringUtils.randomAlphabetic(5), random.nextFloat())
        );
    }


    @ParameterizedTest
    @MethodSource("createIngredient")
    public void getIngredientTypeTest(IngredientType ingredientType, String name, float price) {
        ingredient = new Ingredient(ingredientType, name, price);
        assertEquals(ingredientType, ingredient.getType());
    }

    @ParameterizedTest
    @MethodSource("createIngredient")
    public void getNameTest(IngredientType ingredientType, String name, float price) {
        ingredient = new Ingredient(ingredientType, name, price);
        assertEquals(name, ingredient.getName());
    }

    @ParameterizedTest
    @MethodSource("createIngredient")
    public void getPriceTest(IngredientType ingredientType, String name, float price) {
        ingredient = new Ingredient(ingredientType, name, price);
        assertEquals(price, ingredient.getPrice(), 0);
    }

}
