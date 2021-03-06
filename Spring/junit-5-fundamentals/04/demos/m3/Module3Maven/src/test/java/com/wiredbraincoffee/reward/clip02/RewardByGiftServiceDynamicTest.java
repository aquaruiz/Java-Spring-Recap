package com.wiredbraincoffee.reward.clip02;

import com.wiredbraincoffee.product.Product;
import com.wiredbraincoffee.reward.RewardByGiftService;
import com.wiredbraincoffee.reward.RewardInformation;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.ThrowingConsumer;

import java.util.*;
import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;
import static org.junit.jupiter.api.DynamicContainer.dynamicContainer;
import static org.junit.jupiter.api.DynamicTest.stream;

public class RewardByGiftServiceDynamicTest {
    private RewardByGiftService reward = null;

    @BeforeEach
    void setUp() {
        reward = new RewardByGiftService();
        reward.setNeededPoints(100);
        System.out.println("BeforeEach");
    }

//    @TestFactory
//    Collection<DynamicTest> dynamicTestsFromCollection() {
//        return Arrays.asList(
//                dynamicTest(
//                        "1st dynamic test",
//                        () -> assertEquals(11, 1)),
//                dynamicTest(
//                        "2nd dynamic test",
//                        () -> assertEquals(1, 1))
//        );
//    }

//    @TestFactory
//    Iterable<DynamicTest> dynamicTestsFromCollection() {
//        return Arrays.asList(
//                dynamicTest(
//                        "1st dynamic test",
//                        () -> assertEquals(1, 1)),
//                dynamicTest(
//                        "2nd dynamic test",
//                        () -> assertEquals(1, 1))
//        );
//    }

//    @TestFactory
//    Iterator<DynamicTest> dynamicTestsFromCollection() {
//        return Arrays.asList(
//                dynamicTest(
//                        "1st dynamic test",
//                        () -> assertEquals(1, 1)),
//                dynamicTest(
//                        "2nd dynamic test",
//                        () -> assertEquals(1, 1))
//        ).iterator();
//    }

//    @TestFactory
//    Stream<DynamicTest> giftProductNotInOrderRewardNotApplied() {
//        return getStreamOfRandomNumbers()
//                .limit(5)
//                .mapToObj(randomId ->
//                        dynamicTest(
//                                "Testing product ID " + randomId,
//                                () -> {
//                                    reward.setGiftProductId(randomId);
//                                    RewardInformation info = reward.applyReward(
//                                            getSampleOrder(), 200);
//
//                                    assertEquals(0, info.getDiscount());
//                                    assertEquals(0, info.getPointsRedeemed());
//                                }
//                        )
//                );
//    }

    @TestFactory
    Stream<DynamicTest> giftProductNotInOrderRewardNotApplied() {
        Iterator<Long> inputGeneratorIterator = getStreamOfRandomNumbers().limit(5).iterator();

        Function<Long, String> displayNameGeneratorFunction = randomId -> "Testing product ID " + randomId;

        ThrowingConsumer<Long> testExecutorThrowingConsumer = randomId -> {
                reward.setGiftProductId(randomId);
                RewardInformation info = reward.applyReward(
                        getSampleOrder(), 200);

                assertEquals(0, info.getDiscount());
                assertEquals(0, info.getPointsRedeemed());
        };

        return stream(
                inputGeneratorIterator,
                displayNameGeneratorFunction,
                testExecutorThrowingConsumer
        );
    }

    @TestFactory
    Stream<DynamicContainer> dynamicTestsWithContainers() {
        return LongStream.range(1, 6)
                .mapToObj(productId -> dynamicContainer(
                        "Container for ID " + productId,
                        Stream.of(
                                dynamicTest("Valid Id", () -> assertTrue(productId > 0)),
                                dynamicContainer("Test", Stream.of(
                                    dynamicTest("Discount applied", () -> {
                                        reward.setGiftProductId(productId);
                                        RewardInformation info = reward.applyReward(
                                                getSampleOrder(), 200);

                                        assertTrue(info.getDiscount() > 0);
                                    })
                                ))
                        )
                ));
    }

    private LongStream getStreamOfRandomNumbers() {
        Random r = new Random();
        return r.longs(1000,2000);
    }

    private List<Product> getSampleOrder() {
        Product smallDecaf = new Product(1, "Small Decaf", 1.99);
        Product bigDecaf = new Product(2, "Big Decaf", 2.49);
        Product bigLatte = new Product(3, "Big Latte", 2.99);
        Product bigTea = new Product(4, "Big Tea", 2.99);
        Product espresso = new Product(5, "Espresso", 2.99);
        return Arrays.asList(
                smallDecaf, bigDecaf, bigLatte, bigTea, espresso);
    }
}
