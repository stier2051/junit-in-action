package kz.mun.example.assertions;

import kz.mun.example.ch1.assertions.Job;
import kz.mun.example.ch1.assertions.SUT;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AssertAllTest {

    private SUT systemUnderTest;

    @BeforeEach
    void setUp() {
        systemUnderTest = new SUT("Our system under test");
    }

    @Test
    @DisplayName(
            "SUT should default to not being under current verification")
    void testSystemNotVerified() {
//        SUT systemUnderTest = new SUT("Our system under test");

        assertAll("By default, SUT is not under current verification",
                () -> assertEquals("Our system under test",
                        systemUnderTest.getSystemName()),
                () -> assertFalse(systemUnderTest.isVerified()));
    }

    @Test
    @DisplayName("SUT should be under current verification")
    void testSystemUnderVerification() {
//        SUT systemUnderTest = new SUT("Our system under test");
        systemUnderTest.verify();
        assertAll("SUT under current verification",
                () -> assertEquals("Our system under test",
                        systemUnderTest.getSystemName()),
                () -> assertTrue(systemUnderTest.isVerified()));
    }

    @Test
    @DisplayName("SUT should be under current verification")
    void testSystemUnderCurrentVerification() {
//        SUT systemUnderTest = new SUT("Our system under test");
        systemUnderTest.verify();
        assertTrue(systemUnderTest.isVerified(),
                () -> "System should be under verification");
    }

    @Test
    @DisplayName("SUT should not be under current verification")
    void testSystemNotUnderVerification() {
        assertFalse(systemUnderTest.isVerified(),
                () -> "System should not be under verification");
    }

    @Test
    @DisplayName("SUT should have no current job")
    void testNoJob() {
        assertNull(systemUnderTest.getCurrentJob(),
                () -> "There should be no current job");
    }
}
