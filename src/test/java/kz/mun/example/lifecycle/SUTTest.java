package kz.mun.example.lifecycle;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SUTTest {
    private static ResourceForAllTests resourceForAllTests;
    private SUT systemUnderTest;

    @BeforeAll
    static void setUpClass() {
        resourceForAllTests = new ResourceForAllTests("Our resource for all tests");
    }

    @AfterAll
    static void tearDownClass() {
        resourceForAllTests.close();
    }

    @BeforeEach
    void setUp() {
        systemUnderTest = new SUT("Our system under test");
    }

    @Test
    void testRegularWork() {
        boolean canReceiveRegularWork = systemUnderTest.canReceiveRegularWork();
        assertTrue(canReceiveRegularWork);
    }

    @Test
    void testAdditionalWork() {
        boolean canReceiveAdditionalWork = systemUnderTest.canReceiveAdditionalWork();
        assertFalse(canReceiveAdditionalWork);
    }
}