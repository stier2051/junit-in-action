package kz.mun.example.displayname;

import kz.mun.example.ch2.displayname.SUT;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Test class showing the @DisplayName annotation.")
class SUTTest {
    private final SUT systemUnderTest = new SUT();

    @Test
    @DisplayName("Our system under test says hello.")
    void hello() {
        assertEquals("Hello", systemUnderTest.hello());
    }

    @Test
    @DisplayName(":)")
    void bye() {
        assertEquals("Bye", systemUnderTest.bye());
    }
}