import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import praktikum.Bun;

import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BunTest {
    private static final RandomStringUtils randomStringUtils = new RandomStringUtils();
    private static final Random random = new Random();

    public static Stream<Arguments> getParameters() {
        return Stream.of(
                Arguments.of(RandomStringUtils.randomAlphabetic(5), random.nextFloat()),
                Arguments.of(RandomStringUtils.randomAlphabetic(5), 0.0f),
                Arguments.of(RandomStringUtils.randomAlphabetic(5), 100.0f),
                Arguments.of(RandomStringUtils.randomAlphabetic(5), -100.0f),
                Arguments.of(RandomStringUtils.randomAlphabetic(5), 123.456789f),
                Arguments.of(RandomStringUtils.randomAlphabetic(5), 12345.9999f),
                Arguments.of(RandomStringUtils.randomAlphabetic(5), -123.456789f)
        );
    }

    @ParameterizedTest
    @MethodSource("getParameters")
    public void getNameTest(String name, float price) {
        Bun bun = new Bun(name, price);
        assertEquals(name, bun.getName());
    }

    @ParameterizedTest
    @MethodSource("getParameters")
    public void getPriceTest(String name, float price) {
        Bun bun = new Bun(name, price);
        assertEquals(price, bun.getPrice(), 0);
    }
}
