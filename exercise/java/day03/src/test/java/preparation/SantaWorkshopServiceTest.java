package preparation;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SantaWorkshopServiceTest {
    private static final String RECOMMENDED_AGE = "recommendedAge";
    private final Faker faker = new Faker();

    private SantaWorkshopService service;

    @BeforeEach
    void setUp() {
        service = new SantaWorkshopService();
    }

    @Test
    void prepareGiftWithValidToyShouldInstantiateIt() {
        var giftName = faker.commerce().productName();
        double weight = faker.number().randomDouble(3, 0 ,5);
        var color = faker.color().name();
        var material = faker.options().option("Wood", "Metal", "Plastic");

        var gift = service.prepareGift(giftName, weight, color, material);

        assertThat(gift).isNotNull();
    }

    @Test
    void retrieveAttributeOnGift() {
        var giftName = faker.commerce().productName();
        double weight = faker.number().randomDouble(3, 0, 5);
        var color = faker.color().name();
        var material = faker.options().option("Plastic", "Wood", "Metal");

        var gift = service.prepareGift(giftName, weight, color, material);
        gift.addAttribute(RECOMMENDED_AGE, "3");

        assertThat(gift.getRecommendedAge())
                .isEqualTo(3);
    }

    @Test
    void failsForATooHeavyGift() {
        var giftName = "Dog-E";
        double weight = 6;
        var color = "White";
        var material = "Metal";

        assertThatThrownBy(() -> service.prepareGift(giftName, weight, color, material))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Gift is too heavy for Santa's sleigh");
    }
}
